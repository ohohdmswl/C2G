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

<h2>그룹그룹</h2>

<!-- 검색영역 //-->
<div class = "">
	<div>
		<input type="text" id="searchKeyword" name="searchKeyword" value="" placeholder="스터디그룹 이름을 입력해주세요"  onKeyDown="if(event.key === 'Enter') { ; }">
		<a href="javascript:fncGetData('');" ><img alt="검색" src=""  /></a>
	</div>
</div>
<!-- // 검색영역 -->



<!-- 게시판 목록영역 //-->
<div>
    	<div>
    		<table>
    			<thead>
    				<tr>
    					<th>-</th>
    					<th>번호</th>
    					<th>스터디코드</th>
    					<th>스터디그룹명</th>
    					<th>참여인원/모집인원</th>
    					<th>유지여부</th>
    					<th>삭제</th>
    			</thead>
		        <tbody id="data-container2"></tbody>
    		</table>
    	</div>
    <section>
        <div id="pagination2"></div>
    </section>
    <a href="javascript:fncDelArr('');" >삭제</a>
</div>
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