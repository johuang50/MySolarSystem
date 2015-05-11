<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="header.jsp" charEncoding="UTF-8"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="background:url(<c:url value="/resources/img/${nameOfPlanet}.jpg"/>)">


	<div style="margin: 0px auto; width: 1000px;">
	<form action="<c:url value="/card?planet=${nameOfPlanet}"/>" method="post">
			<label class="control-label" for="name" style="color:white">Название планеты</label>
			<div class="controls"><input type="text" name="name" id="name" placeholder="<c:out value="${card.name}" />"></div>
			<label class="control-label" for="distance" style="color:white">Расстояние от Земли</label>
			<div class="controls"><input type="text" name="distance" id="distance" placeholder="<c:out value="${card.distance}" />"></div>
			<label class="control-label" for="opener" style="color:white">Имя открывателя</label>
			<div class="controls"><input type="text" name="opener" id="opener" placeholder="<c:out value="${card.opener}" />"></div>
			<label class="control-label" for="diametr" style="color:white">Диаметр</label>
			<div class="controls"><input type="text" name="diametr" id="diametr" placeholder="<c:out value="${card.diametr}" />"></div>
			<label class="control-label" style="color:white">Наличие атмосферы</label>
			<div class="controls">
			<select name="atmosphere" id="category">
            <option value="yes">Есть</option>
            <option value="not">Нет</option>
	</select>
			</div>
			<button type="submit" class="btn">Сохранить</button>
			<a href="<c:url value="/"/>" class="btn btn-warning">Отменить</a>
			</form>
		
		
	</div>
</body>
</html>