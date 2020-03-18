(function($) {

	if (!$.validator) $.error('$.validator is required.');

	//Initialize validator language pack
	if (window.__LOCALE__) {
		function url(lang) {
			return (window.__CONTEXT_PATH__ || '') + '/js/jquery/i18n/jquery.validate-{0}.js'.format(lang);
		}
		$.getScript(url(window.__LOCALE__)).fail(function() {
			if (window.__LOCALE__.length > 2) {
				$.getScript(url(window.__LOCALE__.substring(0, 2)));
			}
		});
	} else {
		console.log('__LOCALE__ is undefined, skip initialize validator language pack.');
	}


	$.validator.addMethod('equal', function(value, element, param) {
		return this.optional(element) || value == param;
	}, 'Please enter {0}.');

	$.validator.addMethod('phone', function(value, element) {
		return this.optional(element) || /^[\+\-\(\)0-9]{1,}$/i.test(value);
	}, 'Please enter the correct phone number format.');

	$.validator.addMethod('validPasswordContinuous', function(value, element, param) {
		var newPassword = $(element).val();

		var arrLayout = param.split("/")
		for (var i = 0; i <= newPassword.length - 3; i++) {
			var token = newPassword.substr(i, i + 3);
			for (var j = 0; j < arrLayout.length; j++) {
				if (arrLayout[j].indexOf(token) > -1) return false;
			}
		}
		return true;

	}, 'Continuous data cannot be entered.');


	$.validator.addMethod("validPasswordType", function(value, element, param) {
		var npassword = $(element).val();

		if (npassword.length > 0) {

			var isValidPasswordType = true;
			param.forEach(function(passwordQuality, index) {
				
				if (passwordQuality.name.includes('CONTAINS_CONTINUOUS')){
					var arrLayout = passwordQuality.note.split(" ");
					for (var i = 0; i <= npassword.length - 3; i++) {
						var token = npassword.substr(i, i + 3);
						var token2 = token.split("").reverse().join("");
						for (var j = 0; j < arrLayout.length; j++) {
							if (arrLayout[j].indexOf(token) > -1 || arrLayout[j].indexOf(token2) > -1) {
								isValidPasswordType = false;
								return;
							}
						}
					}
				}
				else if (passwordQuality.name.includes('CONTAINS_RECURSIVE')){
						var chr_pass_0;
						var chr_pass_1;
						var chr_pass_2;

						for (var i = 0; i < npassword.length-2; i++) {
							chr_pass_0 = npassword.charAt(i);
							chr_pass_1 = npassword.charAt(i + 1);
							chr_pass_2 = npassword.charAt(i + 2);

							/*동일 문자 검증*/
							if (chr_pass_0 == chr_pass_1 && chr_pass_1 == chr_pass_2) {
								isValidPasswordType = false;
								return;
							}
						}
				}
				else {
					var arrLayout = passwordQuality.note.split("//");
					for (var j = 0; j < arrLayout.length; j++) {
						if (    npassword.search(arrLayout[j] )< 0) {
							isValidPasswordType = false;
							return;
						}
					}
				}
				/*if (passwordQuality.name.includes('CONTAINS_NUMBER')) {
					var chk_num = npassword.search(/[0-9]/g);
					if (chk_num < 0) {
						isValidPasswordType = false;
						return;
					}
				}
				if (passwordQuality.name.includes('CONTAINS_CHAR')) {
					var chk_lowEng = npassword.search(/[a-z[A-Z]/g);
					var chk_upperEng = npassword.search(/[A-Z]/g);
					if (chk_lowEng < 0 && chk_upperEng < 0) {
						isValidPasswordType = false;
						return;
					}
				}
				if (passwordQuality.name.includes('CONTAINS_SPECIALCHAR')) {
					var sChar = "~\"`!@#$%^&*()_-+={}[]|;:\'<>,.?/\\";
					var sCharCnt = 0;
					for (var i = 0; i < npassword.length; i++) {
						if (sChar.indexOf(npassword.charAt(i)) != -1) {
							sCharCnt++;
						}
					}
					if (sCharCnt <= 0) {
						isValidPasswordType = false;
						return;
					}
				}
				if (passwordQuality.name.includes('CONTAINS_UPANDLOWCASE')) {
					var chk_lowEng = npassword.search(/[a-z[A-Z]/g);
					var chk_upperEng = npassword.search(/[A-Z]/g);
					if (chk_lowEng < 0 || chk_upperEng < 0) {
						isValidPasswordType = false;
						return;
					}
				}*/
			});
			return isValidPasswordType;
		}

		return false;
	}, 'Password is not secure enough.');

	$.validator.addMethod("validPasswordRecursive", function(value, element) {
		var npassword = $(element).val();

		if (npassword.length > 0) {


			var SamePass_0 = 0;
			var SamePass_1 = 0;
			var SamePass_2 = 0;

			var chr_pass_0;
			var chr_pass_1;
			var chr_pass_2;

			for (var i = 0; i < npassword.length; i++) {
				chr_pass_0 = npassword.charAt(i);
				chr_pass_1 = npassword.charAt(i + 1);
				chr_pass_2 = npassword.charAt(i + 2);

				/*동일 문자 검증*/
				if (chr_pass_0 == chr_pass_1 && chr_pass_1 == chr_pass_2) {
					SamePass_0 = SamePass_0 + 1;
				}
			}

			if (SamePass_0 >= 1) {
				return false;
			}
			return true;
		}

		return true;
	}, 'Password is not secure enough.');



	// Validator for password keyboard layout
	$.validator.addMethod('keyLayout', function(value, element, param) {
		var LAYOUT = [ "1234567890",
			"qwertyuiop",
			"asdfghjkl",
			"zxcvbnm",
			"0987654321",
			"poiuytrewq",
			"lkjhgfdsa",
			"mnbvcxz"
		];

		return this.optional(element) || value.length < param
			|| !(function() {
				for (var i = 0; i <= value.length - param; i++) {
					var token = value.substr(i, i + param);
					for (var j = 0; j < LAYOUT.length; j++) {
						if (LAYOUT[j].indexOf(token) > -1) return true;
					}
				}
				return false;
			})();
	}, 'Continuous {0} can not enter more characters.');


	//Validator for password keyboard layout
	$.validator.addMethod('newPasswordConfirm', function(value, element, param) {
		var newPassword = $(element).val();
		var confirmPassword = $(param).val();

		if (newPassword != confirmPassword) {
			return false;
		}

		return true;

	}, 'Please check the appropriate inputs are the same.');


	$.validator.addMethod("isPasswordTypeValid", function(value, element) {
		var npassword = $(element).val();

		if (npassword.length > 0) {
			var chk_num = npassword.search(/[0-9]/g);
			var chk_lowEng = npassword.search(/[a-z[A-Z]/g);
			var chk_upperEng = npassword.search(/[A-Z]/g);
			var sChar = "~\"`!@#$%^&*()_-+={}[]|;:\'<>,.?/\\";
			var sCharCnt = 0;
			var mixCnt = 0;

			for (var i = 0; i < npassword.length; i++) {
				if (sChar.indexOf(npassword.charAt(i)) != -1) {
					sCharCnt++;
				}
			}
			if (chk_num >= 0) {
				mixCnt++;
			}
			if (chk_lowEng >= 0) {
				mixCnt++;
			}
			//	if (chk_upperEng >= 0) {
			//		mixCnt++;
			//	}
			if (sCharCnt > 0) {
				mixCnt++;
			}

			//	if (mixCnt < 2) {
			if (mixCnt <= 2) {
				return false;
			//	} else if (mixCnt == 2 && npassword.length < 10) {
			//		return false;
			} else if (chk_num == -1) {
				return false;
			} else if (mixCnt > 2 && npassword.length < 8) {
				return false;
			}

			return true;
		}

		return true;
	}, 'Password is not secure enough.');


	$.validator.addMethod("isPasswordRepeatValid", function(value, element) {
		var npassword = $(element).val();

		if (npassword.length > 0) {


			var SamePass_0 = 0;
			var SamePass_1 = 0;
			var SamePass_2 = 0;

			var chr_pass_0;
			var chr_pass_1;
			var chr_pass_2;
			var chr_pass_3;

			for (var i = 0; i < npassword.length; i++) {
				chr_pass_0 = npassword.charAt(i);
				chr_pass_1 = npassword.charAt(i + 1);
				chr_pass_2 = npassword.charAt(i + 2);
				chr_pass_3 = npassword.charAt(i + 3);

				/*동일 문자 검증*/
				if (chr_pass_0 == chr_pass_1) {
					SamePass_0 = SamePass_0 + 1;
				}

				/*연속된 4자리 문자열 검증*/
				if (chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == 1 &&
					chr_pass_1.charCodeAt(0) - chr_pass_2.charCodeAt(0) == 1 &&
					chr_pass_2.charCodeAt(0) - chr_pass_3.charCodeAt(0) == 1) {
					SamePass_1 = SamePass_1 + 1;
				}

				if (chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == -1 &&
					chr_pass_1.charCodeAt(0) - chr_pass_2.charCodeAt(0) == -1 &&
					chr_pass_2.charCodeAt(0) - chr_pass_3.charCodeAt(0) == -1) {
					SamePass_2 = SamePass_2 + 1;
				}
			}

			if (SamePass_0 > 1) {
				return false;
			}
			if (SamePass_1 >= 1 || SamePass_2 >= 1) {
				return false;
			}

			return true;
		}

		return true;
	}, 'Password is not secure enough.');


	$.validator.addMethod('keyRepeat', function(value, element, param) {
		repeat = function() {
			var flag = true;
			for (var i = 0; i <= value.length - param; i++) {
				$.each(value.substr(i, i + param), function() {
					if (this != value[i])
						flag = false;
				});
				if (flag) return true;
			}
			return false;
		};

		return this.optional(element) || value.length < 4 || !repeat();
	}, '{0} characters or more characters, the same can not enter.');

	$.validator.addMethod('words', function(value, element) {
		return this.optional(element) || /^\w+$/.test(value);
	}, 'Please enter chracter(alphabet,number,_) in the format.');

	$.validator.addMethod('menuURL', function(value, element) {
		return this.optional(element) || /^[a-zA-Z*/]*$/.test(value);
	}, 'Please enter chracter(alphabet,/,*) in the format.');


	$.validator.addMethod('num', function(value, element) {
		return this.optional(element) || /^[0-9]*$/.test(value);
	}, 'Please enter in a number.');

	$.validator.addMethod('alphaOrNum', function(value, element) {
		return this.optional(element) || /^[a-zA-Z0-9]*$/.test(value);
	}, 'Please enter in alphabet or a number.');

	$.validator.addMethod('alphaOrNumOrSpace', function(value, element) {
		return this.optional(element) || /^[a-zA-Z0-9 .]*$/.test(value);
	}, 'Please enter in alphabet or a number or space.');


	$.validator.addMethod('hanOrAlphaOrNum', function(value, element) {
		return this.optional(element) || /^[a-zA-Z0-9가-힣 .]*$/.test(value);
	}, 'Please enter in alphabet or a number or Han.');

	$.validator.addMethod('alphaAndNum', function(value, element) {
		return this.optional(element) ||
			(/^[a-zA-Z0-9]*$/.test(value)
			&& /[a-zA-Z]{1,}/.test(value)
			&& /[0-9]{1,}/.test(value));
	}, 'Please enter the alpha-numeric mix.');

	$.validator.addMethod('startWithAlpha', function(value, element) {
		return this.optional(element) || /^[a-zA-Z]{1,}/.test(value);
	}, 'Please enter the first letter in alphabet.');

	$.validator.addMethod('hexa', function(value, element) {
		return this.optional(element) || /^[a-fA-F0-9]*$/.test(value);
	}, 'Please enter in hexa.');

	$.validator.addMethod('valueTrim', function(value, element) {
		return this.optional(element) || $(element).val($(element).val().trim());
	}, 'Please enter in hexa.');

	$.validator.addMethod('toUpperCase', function(value, element) {
		return this.optional(element) || $(element).val($(element).val().toUpperCase());
		;
	}, 'Please enter in hexa.');

	$.validator.addMethod('containsNum', function(value, element) {
		return this.optional(element) || /[0-9]{1,}/.test(value);
	}, 'It must contain numbers.');

	$.validator.addMethod("ipv4", function(value, element) {
		return this.optional(element) || /^[\*]$|^(25[0-5]|2[0-4]\d|[01]?\d\d?)\.(25[0-5]|2[0-4]\d|[01]?\d\d?)\.(25[0-5]|2[0-4]\d|[01]?\d\d?)\.(25[0-5]|2[0-4]\d|[01]?\d\d?)$/i.test(value);
	}, "Please enter a valid IP v4 address.");

	$.validator.addMethod("datepicker", function(value, element) {
		if (this.optional(element)) {
			return "dependency-mismatch";
		}

		var $element = $(element),
			inst = $.datepicker._getInst(element),
			dateFormat = $.datepicker._get(inst, 'dateFormat'),
			selectedDate;

		try {
			selectedDate = $.datepicker.parseDate(dateFormat, value, inst);
		} catch (e) {}
		if (!selectedDate) {
			return false;
		}
		selectedDate = selectedDate.today();

		var minDate = $element.datepicker('option', 'minDate');
		if (minDate && minDate.today().getTime() > selectedDate.getTime()) {
			return false;
		}

		var maxDate = $element.datepicker('option', 'maxDate');
		if (maxDate && maxDate.today().getTime() < selectedDate.getTime()) {
			return false;
		}

		if (!(/^(19|20)(\d){2}(\/|-|_)(0[1-9]|1[0-2])(\/|-|_)(0[1-9]|[1-2][0-9]|3[0-1])$/.test(value))) {
			return false;
		}

		/*if($element.attr('name') == 'effectiveDate'){
				var result = $element.val()+" 00:00:00";
				$element.val(result);
			}
			
			if($element.attr('name') == 'expirationDate'){
				var result = $element.val()+" 23:59:59";
				$element.val(result);
			}*/

		return true;
	}, 'The selected date range is incorrect.');

})(jQuery);