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
<script>var contextPath = "${pageContext.request.contextPath}";</script>
<title>SometingProject</title>


<style type="text/css">
div{
	border: 1px solid black;
}
</style>

</head>
<body>

<h2>게시판</h2>

<!-- 검색영역 //-->
<div class = "">
	<div>
		<input type="text" id="" name="" value="" placeholder="게시판 이름을 입력해주세요"  >
		<a><img alt="검색" src=""  /></a>
	</div>
</div>
<!-- // 검색영역 -->



<!-- 게시판 목록영역 //-->
<div>
    <section>
        <div id="data-container2"></div>
        <div id="pagination2"></div>
    </section>
</div>
<!-- // 게시판 목록영역 -->










<script>

// csrf 보안 토큰
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
	
	// onload
    $(function () {
    	
    	// paginationJS 객체에서 사용할 data 배열
    	var dataSource = [];
    	var dataSource2 ;
    	
    	// data 배열 가져오기 위한 ajax(모든 데이터 가져온 후 페이징 될 수 있도록 동기방식, async: false)
        $.ajax({
			url : contextPath + "/adm/board/boardAdSearchList",
			type: "POST",
			dataType: "json",
			async: false,
// 			data : {group_no : $("#group_no").val(), disease2 : $("#disease2").val()},
			beforeSend : function(xhr)
            {   // 스프링 시큐리티 -> csrf (POST 방식 경우 csrf 토큰 같이 넘겨야 정상 동장, 데이터 전송 전 헤더에 csrf 토큰 값 설정
                // var token = $("meta[name='_csrf']").attr("content");
                // var header = $("meta[name='_csrf_header']").attr("content");
				xhr.setRequestHeader("X-CSRF-TOKEN", token);
            },
			success : function(result){
				console.log("jsp내 ajax 확인 : ", result.searchList);
				console.log("jsp내 ajax 확인 : ", result.searchList2);

				// 받아온 데이터에서 cnt 값을 받아 dataSource에 넣기 위한 반복문
				var cntVal;
				for(var i=0; i<result.searchList2.length; i++){
					cntVal = result.searchList2[i].cnt;
					dataSource.push(cntVal);
				}
				
				dataSource2 = result.searchList2;
				
			},
			error : function(xhr, status, error) {
				console.log("error : ", error);
			}
		})
    	
        
    	// ----------------- paginationJS(페이징) --------------- //
        var pageNumber;
        var pageSize;
        var pageRange
        var container2
        
        var pagination;
        // paginationJS 페이징 생성
         container2 = $('#pagination2');
        container2.pagination({
        	// 페이지네이션 설정값 세팅(pagination객체 내)
        	pageSize: 10,								// 페이지당 데이터 항목 수 10
        	pageNumber: 1,								// 첫 페이지 번호 1
        	autoHidePrevious: true,						// 이전 버튼 자동설정
        	autoHideNext: true,							// 다음 버튼 자동설정
			dataSource : dataSource2,					// 데이터
            callback: function (data, pagination) {
            	fn_drawTb(data, pagination) 			// 콜백함수
        	}// 콜백함수 종료
    	})// container2.pagination 객체 end
    	// ----------------- paginationJS(페이징) --------------- //

    
    
    })// onload
    
    // paginationJS 테이블 생성 콜백함수
    function fn_drawTb(data, pagination){
    	var dataHtml = '<table>';
			dataHtml = '<tr>'  
							+ '<td>' + '체크' + '</td>'
							+ '<td>' + '번호' + '</td>'
							+ '<td>' + '게시판명' + '</td>'
							+ '<td>' + '답글' + '</td>'
							+ '<td>' + '덧글' + '</td>'
							+ '<td>' + '게시글수' + '</td>'
							+ '<td>' + '삭제' + '</td>'
						+ '</tr>';// 열제목 작성 필요
	    $.each(data, function (index, item) {
	        dataHtml += '<tr>';
	        dataHtml += '<td>' +  + '</td>';
	        dataHtml += '<td>' + item.cnt + '</td>';
	        dataHtml += '<td>' + item + '</td>';
	        dataHtml += '<td>' + item + '</td>';
	        dataHtml += '<td>' + item + '</td>';
	        dataHtml += '<td>' + item + '</td>';
	        dataHtml += '<td>' + item + '</td>';
	        dataHtml += '</tr>';
	    });
	    dataHtml += '</table>';
	    $("#data-container2").html(dataHtml);
   	}
    	
    	
    	
    
    
    	// ----------------- paginationJS sample ------------ //
    	// totalNumberLocator 
		// pageNumber(현재 페이지 번호 default : 1)
		// pageSize (페이지당 데이터 항목 수 default : 10)
		// pageRange (현재 페이지 범위 default : 2 / 모든페이지 : null)
		// callback
    	
		/* ------------- HTML ------------- 
		<div>
		    <section>
		        <div id="data-container"></div>
		        <div id="pagination"></div>
		    </section>
		</div>
		*/
       /* ------------- JS ------------- 
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
        })
        */
        // sample
    	// ----------------- paginationJS sample ------------ //
    
</script>



</body>
</html>