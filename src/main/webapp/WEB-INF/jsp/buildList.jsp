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
	<div class=>
	<script type="text/javascript">
		
		var data = "${data.items[0].address}";
		console.log("data: ", data);
	</script>
	<tag:paginate items="${data}"/>
</body>
</html>