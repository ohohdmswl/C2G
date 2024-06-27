<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/layout/taglib.jsp" %>

<!DOCTYPE html>
<html lang="ko">


    <title>Paginationjs example</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/pagination.js"></script> 
    
<!--     <link href="../dist/pagination.css" rel="stylesheet" type="text/css"> -->
    <link href="${pageContext.request.contextPath}/css/pagination.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        ul, li {
            list-style: none;
        }

        #wrapper {
            width: 900px;
            margin: 20px auto;
        }

        .data-container {
            margin-top: 20px;
        }

        .data-container ul {
            padding: 0;
            margin: 0;
        }

        .data-container li {
            margin-bottom: 5px;
            padding: 5px 10px;
            background: #eee;
            color: #666;
        }
    </style>
</head>
<body>

<div id="wrapper">
  <section>
    <div class="data-container"></div>
    <div id="pagination-demo1"></div>
    <div class="data-container"></div>
    <div id="pagination-demo2"></div>
    <div class="data-container"></div>
    <div id="pagination-demo3"></div>
  </section>
</div>

<!-- <script src="http://code.jquery.com/jquery-3.6.1.js"></script> -->
<!-- <script src="../src/pagination.js"></script> -->




<%
int rangeStart = 1; // 페이지 시작 번호
int rangeEnd = 10; // 페이지 끝 번호
int totalNumber = 100; // 총 아이템 수

// 실제로는 해당 값을 동적으로 설정해야 합니다. 
// 예: 데이터베이스 쿼리 결과나 다른 비즈니스 로직에 따라 설정
%>


<script>
$(function() {
  (function(name) {
    var container = $('#pagination-' + name);
    if (!container.length) return;
    var sources = function () {
      var result = [];

      for (var i = 1; i < 196; i++) {
        result.push(i);
      }

      return result;
    }();

    var options = {
      dataSource: sources,
      callback: function (response, pagination) {
        window.console && console.log(response, pagination);

        var dataHtml = '<ul>';

        $.each(response, function (index, item) {
          dataHtml += '<li>' + item + '</li>';
        });

        dataHtml += '</ul>';

        container.prev().html(dataHtml);
      }
    };

    //$.pagination(container, options);

    container.addHook('beforeInit', function () {
      window.console && console.log('beforeInit...');
    });
    container.pagination(options);

    container.addHook('beforePageOnClick', function () {
      window.console && console.log('beforePageOnClick...');
      //return false
    });
  })('demo1');

  (function(name) {
    var container = $('#pagination-' + name);
    if (!container.length) return;
    var sources = function () {
      var result = [];

      for (var i = 1; i < 196; i++) {
        result.push(i);
      }

      return result;
    }();

    var options = {
      dataSource: sources,
      pageSize: 10,
      showGoInput: true,
      showGoButton: true,
      showNavigator: true,
      showSizeChanger: true,
      formatNavigator: '<%= rangeStart %>-<%= rangeEnd %> of <%= totalNumber %> items',
      callback: function (response, pagination) {
        window.console && console.log(response, pagination);

        var dataHtml = '<ul>';

        $.each(response, function (index, item) {
          dataHtml += '<li>' + item + '</li>';
        });

        dataHtml += '</ul>';

        container.prev().html(dataHtml);
      }
    };

    //$.pagination(container, options);

    container.addHook('beforeInit', function () {
      window.console && console.log('beforeInit...');
    });
    container.pagination(options);

    container.addHook('beforePageOnClick', function () {
      window.console && console.log('beforePageOnClick...');
      //return false
    });
  })('demo2');

  (function(name) {
    var container = $('#pagination-' + name);
    if (!container.length) return;
    container.pagination({
      dataSource: 'https://api.flickr.com/services/feeds/photos_public.gne?tags=cat&tagmode=any&format=json&jsoncallback=?',
      locator: 'items',
      pageNumber: 2,
      totalNumber: 120,
      pageSize: 20,
      ajax: {
        beforeSend: function() {
          container.prev().html('Loading data from flickr.com ...');
        }
      },
      callback: function(response, pagination) {
        window.console && console.log(22, response, pagination);
        var dataHtml = '<ul>';

        $.each(response, function (index, item) {
          dataHtml += '<li>' + item.title + '</li>';
        });

        dataHtml += '</ul>';

        container.prev().html(dataHtml);
      }
    })
  })('demo3');
})
</script>
</body>
</html>