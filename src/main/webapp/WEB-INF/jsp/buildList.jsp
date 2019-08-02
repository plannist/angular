<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	빌딩 리스트 인입
	<div style="height:80%">
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
		
		$(document).ready(function(){
			$(".link-page").click(function(){
				var page = $(this).attr('rel');
				console.log("page 123 :", page);
				$.ajax({
					type : "POST",
					dataType : "application/json",
					url : "/paginatedBuildList",
					data : {page : page},
					success: function(response){
						var data = response.building;
						var rowNum = response.rowNum;
						console.log("페이지 클릭 후 response data: ", data);
						var html = "";
						var page = "";
						for(var i=0; i<response.data.length; i++){
							html += "<tr style="cursor:pointer;height:30px;">";
							html += "<td>"+rowNum[i]+"</td>";
							html += "<td>"data[i].buildNo"</td>";
							html +="<td>"+data[i].address+"</td>";
							html +="<td>-</td>";
							html +="<td>-</td>";
							html +="<td>"+data[i].floor+"/"+data[i].wholeFloor+"</td>";
							html +="<td>"+data[i].buRdate+"</td>";
						}
						
					}
				});
			});
		});
		
	</script>
	<div id="pagiList">
		<tag:paginate items="${data.building}"/>
	</div>
</body>
</html>