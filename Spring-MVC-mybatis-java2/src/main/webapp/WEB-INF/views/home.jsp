<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<h3>SqlMapSessionFactory 방식(Java - XML Mapper - Spring 전용 버전)</h3>
<c:forEach items="${list }" var="val" >
    ${val.username} / 
    ${val.password} /
    ${val.enabled }<br>
</c:forEach>
<c:if test="${empty list }">
    ${"데이터가 존재하지않아요."}
</c:if>

</body>
</html>
