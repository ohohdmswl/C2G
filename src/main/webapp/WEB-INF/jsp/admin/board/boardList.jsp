<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/layout/taglib.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">


<!--  js  -->
<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/pagination.js"></script> 
    <link href="${pageContext.request.contextPath}/css/pagination.css" rel="stylesheet" type="text/css">

<title>SometingProject</title>
</head>
<body>


관리자 게시판 리스트 jsp


<div>
    <section>
        <div id="data-container"></div>
        <div id="pagination"></div>
    </section>
</div>


<div>
    <section>
        <div id="data-container2"></div>
        <div id="pagination2"></div>
    </section>
</div>










<script>
    $(function () {
        let container = $('#pagination');
        container.pagination({
            dataSource: [
                {name: "hello1"},
                {name: "hello2"},
                {name: "hello3"},
                {name: "hello4"},
                {name: "hello5"},
                {name: "hello6"},
                {name: "hello7"},
                {name: "hello8"},
                {name: "hello9"},
                {name: "hello10"},
                {name: "hello11"},
                {name: "hello12"},
                {name: "hello13"},
                {name: "hello14"},
                {name: "hello15"},
                {name: "hello16"},
                {name: "hello17"},
            ],
            callback: function (data, pagination) {
                var dataHtml = '<ul>';

                $.each(data, function (index, item) {
                    dataHtml += '<li>' + item.name + '</li>';
                });

                dataHtml += '</ul>';

                $("#data-container").html(dataHtml);
            }
        })// sample
        
        
        var container2 = $('#pagination2');
        console.log("모델값 확인 :  ${boardList}");
        container2.pagination({
            dataSource: [
                {name: "hello1"},
                {name: "hello2"},
                {name: "hello3"},
                {name: "hello4"},
                {name: "hello5"},
                {name: "hello6"},
                {name: "hello7"},
                {name: "hello8"},
                {name: "hello9"},
                {name: "hello10"},
                {name: "hello11"},
                {name: "hello12"},
                {name: "hello13"},
                {name: "hello14"},
                {name: "hello15"},
                {name: "hello16"},
                {name: "hello17"},
            ],
            callback: function (data, pagination) {
                var dataHtml = '<ul>';

                $.each(data, function (index, item) {
                    dataHtml += '<li>' + item.name + '</li>';
                });

                dataHtml += '</ul>';

                $("#data-container2").html(dataHtml);
            }
        })// 페이지네이션 표출 함수 종료
        
        
        
        
        
        
        
        
    })// onload
    
    
    
    
    
</script>




</body>
</html>