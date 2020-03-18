package com.prac.angular.acode;

import org.junit.Test;

import kr.arcode.web.constants.ResultCodeConst;
import kr.arcode.web.model.Response;
import kr.arcode.web.util.Generator;
import kr.arcode.web.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArcodeTest {
	static final String HIPPEN = "=======================================";
	@Test
	public void test() {
		Generator gen = new Generator();//개인적 의견 <파일명 등 생성을 위하여 사용한다.>
		String genStr = gen.gen("hi", "ork");
		log.debug("genStr: "+ genStr); //hi1583298167663_00001ork
		log.debug(HIPPEN);
		
		ResponseUtil responseUtil = new ResponseUtil();
		Response response = responseUtil.getResponse(ResultCodeConst.OTHER_LOGIN_ERROR, "", new Object[] {"id"});
		log.debug("response: {}", response);
	}
}
