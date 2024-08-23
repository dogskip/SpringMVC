<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <title>도서 등록</title>
</head>
<body>
<nav class="navbar navbar-expand  navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="./home">Home</a>
        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">도서 등록</h1>
    </div>
</div>

<div class="container">

    <!-- form:form 태그는 폼을 생성하고, modelAttribute 속성은 폼 데이터를 바인딩할 모델 객체를 지정합니다. -->
    <%--@elvariable id="book" type=""--%>
    <%--@elvariable id="NewBook" type=""--%>
    <form:form modelAttribute="NewBook" class="form-horizontal">
        <fieldset>
            <legend>${addTitle}</legend>

            <!-- 도서 ID 입력 필드 -->
            <div class="form-group row">
                <label class="col-sm-2 control-label">도서 ID</label>
                <div class="col-sm-3">
                    <!-- form:input 태그는 텍스트 입력 필드를 생성하고, path 속성은 모델 객체의 필드를 지정합니다. -->
                    <form:input path="bookId" class="form-control"/>
                </div>
            </div>

            <!-- 도서명 입력 필드 -->
            <div class="form-group row">
                <label class="col-sm-2 control-label">도서명</label>
                <div class="col-sm-3">
                    <form:input path="name" class="form-control"/>
                </div>
            </div>

            <!-- 가격 입력 필드 -->
            <div class="form-group row">
                <label class="col-sm-2 control-label">가격</label>
                <div class="col-sm-3">
                    <form:input path="unitPrice" class="form-control"/>
                </div>
            </div>

            <!-- 저자 입력 필드 -->
            <div class="form-group row">
                <label class="col-sm-2 control-label">저자</label>
                <div class="col-sm-3">
                    <form:input path="author" class="form-control"/>
                </div>
            </div>

            <!-- 상세정보 입력 필드 -->
            <div class="form-group row">
                <label class="col-sm-2 control-label">상세정보</label>
                <div class="col-sm-5">
                    <!-- form:textarea 태그는 텍스트 영역을 생성합니다. -->
                    <form:textarea path="description" cols="50" rows="2" class="form-control"/>
                </div>
            </div>

            <!-- 출판사 입력 필드 -->
            <div class="form-group row">
                <label class="col-sm-2 control-label">출판사</label>
                <div class="col-sm-3">
                    <form:input path="publisher" class="form-control"/>
                </div>
            </div>

            <!-- 분야 입력 필드 -->
            <div class="form-group row">
                <label class="col-sm-2 control-label">분야</label>
                <div class="col-sm-3">
                    <form:input path="category" class="form-control"/>
                </div>
            </div>

            <!-- 재고수 입력 필드 -->
            <div class="form-group row">
                <label class="col-sm-2 control-label">재고수</label>
                <div class="col-sm-3">
                    <form:input path="unitsInStock" class="form-control"/>
                </div>
            </div>

            <!-- 출판일 입력 필드 -->
            <div class="form-group row">
                <label class="col-sm-2 control-label">출판일</label>
                <div class="col-sm-3">
                    <form:input path="releaseDate" class="form-control"/>
                </div>
            </div>

            <!-- 상태 선택 라디오 버튼 -->
            <div class="form-group row">
                <label class="col-sm-2 control-label">상태</label>
                <div class="col-sm-3">
                    <!-- form:radiobutton 태그는 라디오 버튼을 생성합니다. -->
                    <form:radiobutton path="condition" value="New" /> New
                    <form:radiobutton path="condition" value="Old" /> Old
                    <form:radiobutton path="condition" value="E-Book" />E-Book
                </div>
            </div>

            <!-- 제출 버튼 -->
            <div class="form-group row">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-primary" value="등록"/>
                </div>
            </div>
        </fieldset>
    </form:form>
    <hr>
    <footer>
        <p>&copy; BookMarket</p>
    </footer>
</div>
</body>
</html>