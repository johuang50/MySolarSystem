<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<c:import url="header.jsp" charEncoding="UTF-8"></c:import>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	

	<div class="carousel slide" data-interval="false" id="myCarousel">
		<div class="carousel-inner">
			<div class="item active">
				<img alt="" src="<c:url value="/resources/img/sun.jpg"/>" />
				</p>
				<div class="description">
				<h2>Планеты солнечной системы</h2>
				</div>
			</div>
			<div class="item">
				<img alt="" src="<c:url value="/resources/img/mer.jpg"/>" />
				</p>
				<div class="description">
					<a href="<c:url value="/planet?name=mer"/>"><h2>Меркурий</h2></a>
				</div>
			</div>
			<div class="item">
				<img alt="" src="<c:url value="/resources/img/ven.jpg"/>" />
				</p>
				<div class="description">
					<a href="<c:url value="/planet?name=ven"/>"><h2>Венера</h2></a>
				</div>
			</div>
			<div class="item">
				<img alt="" src="<c:url value="/resources/img/zem.jpg"/>" />
				</p>
				<div class="description">
					<a href="<c:url value="/planet?name=zem"/>"><h2>Земля</h2></a>
				</div>
			</div>

			<div class="item">
				<img alt="" src="<c:url value="/resources/img/mar.jpg"/>" />
				</p>
				<div class="description">
					<a href="<c:url value="/planet?name=mar"/>"><h2>Марс</h2></a>
				</div>
			</div>

			<div class="item">
				<img alt="" src="<c:url value="/resources/img/jup.jpg"/>" />
				</p>
				<div class="description">
					<a href="<c:url value="/planet?name=jup"/>"><h2>Юпитер</h2></a>
				</div>
			</div>

			<div class="item">
				<img alt="" src="<c:url value="/resources/img/sat.jpg"/>" />
				</p>
				<div class="description">
					<a href="<c:url value="/planet?name=sat"/>"><h2>Сатурн</h2></a>
				</div>
			</div>

			<div class="item">
				<img alt="" src="<c:url value="/resources/img/ura.jpg"/>" />
				</p>
				<div class="description">
					<a href="<c:url value="/planet?name=ura"/>"><h2>Уран</h2></a>
				</div>
			</div>

			<div class="item">
				<img alt="" src="<c:url value="/resources/img/nep.jpg"/>" />
				</p>
				<div class="description">
					<a href="<c:url value="/planet?name=nep"/>"><h2>Нептун</h2></a>
				</div>
			</div>

			<div class="item">
				<img alt="" src="<c:url value="/resources/img/plu.jpg"/>" />
				</p>
				<div class="description">
					<a href="<c:url value="/planet?name=plu"/>"><h2>Плутон</h2></a>
				</div>
			</div>
			<c:forEach items="${list}" var="item">
			<div class="item">
				<img alt="" src="<c:url value="/image?index=${item.id}"/>" height="730"
						width="730">
				</p>
				<div class="description">
					<h2><c:out value="${item.name}" /></h2>
					<c:out value="${item.description}" />
				</div>
			</div>
				</c:forEach>
		</div>
		<p>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a><br />
			<a class="right carousel-control" href="#myCarousel"
				data-slide="next">›</a>
		</p>
	</div>

	<div class="modal hide fade" id="myModal" tabindex="-1" role="dialog">
		<c:url value="/add" var="url" />
		<form:form action="${url}" method="post" commandName="planets"
			enctype="multipart/form-data" modelAttribute="uploadform">

			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal">X</button>
				<h3 id="myModalLabel">Добавление планеты</h3>
			</div>
			<div class="modal-body">

				<h4>Название планеты</h4>
				<br> <input type="text" id="name" name="name"
					style="width: 100%" />
				<h4>Изображение</h4>
				<br> <input type="file" required="" id="image" name="files[0]">
				<h4>Описание</h4>
				<textarea name="description" id="description" rows="10"
					style="width: 100%"></textarea>

			</div>
			<div class="modal-footer">
				<input type="submit" class="btn btn-primary" value="Сохранить">
				<button class="btn" data-dismiss="modal">Отменить</button>
			</div>
		</form:form>
	</div>

	<a href="#myModal" data-toggle="modal" class="btn btn-success">Добавить
		планету</a>
	<a href="#" class="btn btn-warning">Удалить планету</a>


</body>
</html>
