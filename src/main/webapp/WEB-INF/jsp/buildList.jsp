<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="ptitle">
		<h2>매물 목록</h2>
		<div class="pnav">
			HOME
			<span class="bar">></span>
			매물목록
			<span class="bar">></span>
			<span class="here">매물조회 상세</span>
		</div>
	</div>
	
	<!--contents Start-->
	<form method="POST" action='<c:url value="buildingList"/>' class="search" onsubmit="return false">

		<!-- S:占싯삼옙占쏙옙占쏙옙 -->
		<div class="form_box mgt_28 mgb_8">
			<!-- S:Colgroup -->
			<div class="colgroup" style="width:44%">
				<span class="bar">|</span>
				<div class="rowgroup">
					<div class="tbl_inner">
						<table>
							<colgroup>
								<col width="30%" />
								<col width="70%" />
							</colgroup>
							<tbody>
							<tr>
	        					<th><label for="pro1">주소</label></th>
	        					<td class="input">
									<input type="text" name="crn" value='<c:out value="${param.crn}"/>' title='주소' 
										   maxlength="120" id="pro1" style="width:100%;" onkeydown="javascript:if(event.keyCode == 13){searchList();}"/>
										   
								</td>
							</tr>
							<tr>
	        					<th><label for="pro1">매물 종류</label></th>
	        					<td class="input">
	        						<select id="buildType" name="buildType" class="ui_sel" style="width:100%">
	        							<option value="A" <c:if test="${searchType.buildType == 'A'}" >selected</c:if>>전체</option>
	        							<option value="1" <c:if test="${searchType.buildType == '1'}" >selected</c:if>>매매</option>
	        							<option value="2" <c:if test="${searchType.buildType == '2'}" >selected</c:if>>전세</option>
	        							<option value="3" <c:if test="${searchType.buildType == '3'}" >selected</c:if>>월세</option>
	        							<option value="4" <c:if test="${searchType.buildType == '4'}" >selected</c:if>>반전세</option>
	        							<option value="5" <c:if test="${searchType.buildType == '5'}" >selected</c:if>>매매+전세</option>
	        							<option value="7" <c:if test="${searchType.buildType == '7'}" >selected</c:if>>전세+월세</option>
	        						</select>
	        					</td>
							</tr>
							</tbody>
						</table>
					</div>
				</div>					
				<span class="barr">|</span>
			</div>
			<div class="colgroup" style="width:44%">
				<span class="bar">|</span>
				<div class="rowgroup">
					<div class="tbl_inner">
						<table>
							<colgroup>
								<col width="30%" />
								<col width="70%" />
							</colgroup>
							<tbody>
							<tr>
	        					<th><label for="appLifecycleCode">가격</label></th>
	        					<td class="input">
									<select name="appLifecycleCode" title="전체" class="ui_sel" id="appLifecycleCode" style="width:100%;">
								    	<option value="all" >전체</option>
								    	<c:forEach var="appLifeCycleCode" items="${appLifeCycleCodes}">
						            		<option value="<c:out value="${appLifeCycleCode.code}"/>" ><c:out value="${appLifeCycleCode.description}" /></option>
					                	</c:forEach>
						        	</select>							
								</td>
							</tr>
							</tbody>
						</table>
					</div>
				</div>					
				<span class="barr">|</span>
			</div>
			<!-- E:Colgroup -->	
			<!-- S:BTN -->
			<div class="colgroup btn" style="width:12%">
				<span class="bar">|</span>			
				<a href="javascript:void(0);" onclick="javascript:searchList();" class="btn_black"><span>검색</span></a>
				<span class="barr">|</span>
			</div>
			<!-- E:BTN -->				
		</div>
		<!-- E:占싯삼옙占쏙옙占쏙옙 -->
	</form>
	<div style="height:60%">
		<table class="dtbl_col">
			<colgroup>
				<col width="5%">
				<col width="10%">
				<col width="45%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
			<tr style="height:50px">
				<th>No.</th>
				<th>매물번호</th>
				<th>주    소</th>
				<th>면적</th>
				<th>전용면적</th>
				<th>층수</th>
				<th>등록일시</th>
			</tr>
			</thead>
			<tbody id="buildingList">
				<c:choose>
					<c:when test="${empty data.building}">
						<tr>
							<td colspan=7>매물 데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="list" items="${data.building}" varStatus="status">
							<tr style="cursor:pointer;height:30px;">
								<td>${data.rowNum[status.index]}</td>
								<td>${list.buildNo}</td>
								<td>${list.address}</td>
								<td>-</td>
								<td>-</td>
								<td>${list.floor} / ${list.wholeFloor}</td>
								<td><fmt:formatDate value="${list.buRdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		var page = -1;
		
		$(document).ready(function(){
			$(".link-page").click(function(){
				page = $(this).attr('rel');
				console.log("page: ", page);
				makeList();
			});
		});
		
		function makeList(){
			
			
			$.ajax({
				type : "POST",
				dataType : "json",
				url : "paginatedBuildList",
				data : {page : page},
				success: function(response){
					$('#buildingList').empty();
					$('#pagiList').empty();
					
					var data = response.data;
					console.log("response 확인: ", data);
					var rowNum = response.rownum;
					var regDate = response.regDate;
					var html = "";
					var pageHtml = "<div class='paging'>";
					for(var i=0; i<data.items.length; i++){
						html += "<tr style='cursor:pointer;height:30px;'>";
						html += "<td>"+rowNum[i]+"</td>";
						html += "<td>"+data.items[i].buildNo+"</td>";
						html +="<td>"+data.items[i].address+"</td>";
						html +="<td>-</td>";
						html +="<td>-</td>";
						html +="<td>"+data.items[i].floor+"/"+data.items[i].wholeFloor+"</td>";
						html +="<td>"+regDate[i]+"</td>";
					}
					
					if(data.hasPrevUnit){
						pageHtml += "<a href='#' rel="+data.endPageOfPrevUnit+" class='link-page ico btn_page_frist'><i></i></a>";
					}
					pageHtml += "<span class='page_num'>";
					for(var i=data.beginPage; i<=data.endPage; i++){
						if(i == data.currentPage){
							pageHtml +="<a href='#' rel='0' class='link-page here'>"+i+"</a>";
						}else{
							pageHtml +="<a href='#' rel='"+i+"' class='link-page'>"+i+"</a>";
						}
					}
					pageHtml += "</span>";
					if(data.hasNextUnit){
						pageHtml += "<a href='#' rel='"+data.beginPageOfNextUnit+"' class='link-page ico btn_page_last'><i></i></a>";
					}
					$('#buildingList').html(html);
					$('#pagiList').html(pageHtml);
					console.log("인입확인", pageHtml);
					console.log("data.beginPage: ", data.beginPage,", data.endPage: ",data.endPage,", data.currentPage: ",data.currentPage,", page: ",page);
					
					$('.link-page').click(function(){
						page = $(this).attr('rel');
						makeList();
					});
				}
			});
		};
		
	</script>
	<div id="pagiList">
		<tag:paginate items="${data.building}"/>
	</div>
</body>
</html>