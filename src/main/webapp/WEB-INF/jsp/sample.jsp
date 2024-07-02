<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/layout/taglib.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>

<!--  js  -->
<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script>var contextPath = "${pageContext.request.contextPath}";</script>
<title>SometingProject</title>


<style type="text/css">
div{
	border: 1px solid black;
}
</style>

</head>
<body>

<h2>그룹 상세</h2>

<!-- 검색영역 //-->

<!-- // 검색영역 -->



<!-- 게시판 목록영역 //-->

<!-- // 게시판 목록영역 -->










<script>

// csrf 보안 토큰
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");


	// ---------- onload //----------
    $(function () {
    	
    	
    	
    })
	// ----------// onload ----------

</script>



</body>
</html>