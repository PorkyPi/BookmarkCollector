<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="cf"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">
<title>Collector v0.01</title>
</head>
<body>
	<header class="header">
		<h1>Collector</h1>
	</header>
	<div class="middle">
		<!-- .middle-->

		<div class="container">
			<div class="content">

				<div class="uppermain">
					<!-- upper part -->

					<div class="notebook">
						<input type="radio" name="notebook1" id="notebook1_1" checked>
						<label for="notebook1_1">Подробно</label> <input type="radio"
							name="notebook1" id="notebook1_2"> <label
							for="notebook1_2">Редактирование</label> <input type="radio"
							name="notebook1" id="notebook1_3"> <label
							for="notebook1_3">Добавить новую закладку</label>


						<div>
							<p>Это перевая вкладка - подробно</p>
							<p>Здесь будет вся информация о вкладке</p>
						</div>
						<div>
							<form name="editor">
								<label class="label">id</label><input type="text"
									class="IncomOutcomForm"><br>
								<p></p>
								<label class="label">Имя</label><input type="text"
									class="IncomOutcomForm"><br>
								<p></p>
								<label class="label">Ссылка</label><input type="text"
									class="IncomOutcomForm"><br>
								<p></p>
								<label class="label">Описание</label><input type="text"
									class="IncomOutcomForm"><br>
								<p></p>
								<label class="label">Прочитано</label><input type="text"
									class="IncomOutcomForm"><br>
								<p></p>
								<label class="label">Важность</label><input type="text"
									class="IncomOutcomForm"><br>
								<p></p>
								<label class="label">Дата</label><input type="text"
									class="IncomOutcomForm"><br>
								<p></p>
								<label class="label">Язык</label><input type="text"
									class="IncomOutcomForm"><br>
							</form>
						</div>
						<div>
							<p>Это третья вкладка - добавить</p>
							<p>Здесь можно будет добавить новую закладку</p>
						</div>
					</div>

				</div>

				<div class="lowermain">
					<!-- lower part -->

					<h4>Закладки в выбранном каталоге</h4>

					<table class="bookmarks" id="bookmarks" name="bookmarks">
						<thead>
							<tr>
								<th id="first">Id</th>
								<th id="second">Name ref</th>
								<th id="third">Description</th>
								<th id="fourth">Read</th>
								<th id="fifth">Importancy</th>
								<th id="sixth">Date</th>
								<th id="seventh">language</th>
								<th id="eighth">edit</th>
								<th id="nineth">&nbsp;&nbsp;</th>
							</tr>
						</thead>
						<div id="tabledinamic">
							<tbody id="myTable" name="myTable">
								<c:forEach var="bookmark" items="${bookmarksList}">
									<tr>
										<td id="first"><c:out value="${bookmark.bookmarkId}" /></td>
										<td id="second"><a href="${bookmark.bookmarkRef}" target="_blank"><c:out value="${bookmark.bookmarkName}" /></a></td>
										<td id="third"><c:out value="${bookmark.bookmarkDescription}" /></td>
										<td id="fourth"><c:out value="${bookmark.markAsRead}" /></td>
										<td id="fifth"><c:out value="${bookmark.markAsImportancy}" /></td>
										<td id="sixth"><c:out value="${bookmark.bookmarkAddedDate}" /></td>
										<td id="seventh"><c:out value="${bookmark.bookmarkLanguge}" /></td>
										<td id="eighth">del</td>
									</tr>
								</c:forEach>
							</tbody>
						</div>
					</table>

				</div>

			</div>
		</div>

		<aside class="left-sidebar">
			<strong>Каталоги</strong>
			<div class="treeCatalogs">
				${catalogList}
				${catalogEditor}
				<cf:form>
				</cf:form>
			</div>
		</aside>

	</div>
	<!-- .middle-->
	<footer class="footer">
		<p>v0.01</p>
	</footer>
</body>
</html>