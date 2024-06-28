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
<script src="${pageContext.request.contextPath}/js/pagination.js"></script> 
    <link href="${pageContext.request.contextPath}/css/pagination.css" rel="stylesheet" type="text/css">

<title>SometingProject</title>
</head>
<body>


게시판 리스트 jsp


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


var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

    $(function () {
    	
    	
//     	var dataSource;
    	var dataSource = [];
    	
        $.ajax({
// 			url : ${pageContext.request.contextPath} +"/adm/board/boardAdSearchList",
			url : "/adm/board/boardAdSearchList",
			type: "POST",
// 			type: "GET",
			dataType: "json",
			 async: false,
// 			data : {group_no : $("#group_no").val(), disease2 : $("#disease2").val()},
			beforeSend : function(xhr)
            {   // 스프링 시큐리티 -> csrf (POST 방식 경우 csrf 토큰 같이 넘겨야 정상 동장, 데이터 전송 전 헤더에 csrf 토큰 값 설정
                var token = $("meta[name='_csrf']").attr("content");
                var header = $("meta[name='_csrf_header']").attr("content");
// 				xhr.setRequestHeader(header, token);
				xhr.setRequestHeader("X-CSRF-TOKEN", token);
            },
			success : function(result){
				
				 
// 				console.log("jsp내 ajax 석세스는 하냐");
				console.log("jsp내 ajax 확인 : ", result.searchList);
				console.log("jsp내 ajax 확인 : ", result.searchList2);
				console.log("jsp내 ajax 확인 : ", JSON.stringify(result));

// 				dataSource = result.searchList2;
				var cntVal;
				for(var i=0; i<result.searchList2.length; i++){
// 					cntVal = result.searchList2['cnt'];
					cntVal = result.searchList2[i].cnt;
					console.log("cntVal : ", cntVal);
// 					dataSource.push({name: + cntVal});
					dataSource.push(cntVal);
					console.log("dataSource : ", dataSource);
					
				}

			},
			error : function(xhr, status, error) {

				console.log("error : ", error);

			}
		})
    	
    	
    	
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
        
        
        
        
//         totalNumberLocator 
//         pageNumber(현재 페이지 번호 default : 1)
//         pageSize (페이지당 데이터 항목 수 default : 10)
//         pageRange (현재 페이지 범위 default : 2 / 모든페이지 : null)
//         callback
        
        // 변경이 되었나 메인으로
        
        
        
        var pageNumber;
        var pageSize;
        var pageRange
        
//         showPrevious / autoHidePrevious
//         showNext / autoHideNext
        
        var container2 = $('#pagination2');
        console.log("모델값 확인 :  ${boardList}");
        
//         var dataSource = [];
        // 여기서 ajax를 하고 리턴 값을 위에 선언한 데이터 소스에 넣자
        
        console.log("에이젝스 윗줄");
        console.log("dataSource 전역변수로 확인: ", dataSource);

        
        container2.pagination({
        	
        	// 페이지네이션 설정값 세팅(pagination객체 내)
        	pageSize: 10,						// 페이지당 데이터 항목 수 10
        	pageNumber: 1,						// 첫 페이지 번호 1
        	autoHidePrevious: true,				// 이전 버튼 자동설정
        	autoHideNext: true,					// 다음 버튼 자동설정
			dataSource : dataSource,
// 			dataSource : dataSource,
// 			locator: 'dataSource',
        	
        	
//             dataSource: [						// 데이터
//                 {name: "hello1"},
//                 {name: "hello2"},
//                 {name: "hello3"},
//                 {name: "hello4"},
//                 {name: "hello5"},
//                 {name: "hello6"},
//                 {name: "hello7"},
//                 {name: "hello8"},
//                 {name: "hello9"},
//                 {name: "hello10"},
//                 {name: "hello11"},
//                 {name: "hello12"},
//                 {name: "hello13"},
//                 {name: "hello14"},
//                 {name: "hello15"},
//                 {name: "hello16"},
//                 {name: "hello17"},
//             ],
            callback: function (data, pagination) {
                var dataHtml = '<ul>';

                $.each(data, function (index, item) {
                    dataHtml += '<li>' + item + '</li>';
                });

                dataHtml += '</ul>';

                $("#data-container2").html(dataHtml);
            }
        })// 페이지네이션 표출 함수 종료
        
        
        
        
        
        
        
        
    })// onload
    
    
    
    
    
</script>




</body>
</html>