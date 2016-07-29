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
						<label for="notebook1_1">Подробно</label> 
						<input type="radio" name="notebook1" id="notebook1_2"> 
						<label for="notebook1_2">Редактирование и сохранение</label> 
						<div>
							<p>Подробности</p>
							<p>Для создание новой вкладки: сначала откройте каталог куда нужно сохранить вкладку,
								затем откройте вкладку редактирование и сохранение. После тщательно заполните все
								поля и нажмите кнопку сохранить</p>
							<p>Для редактирования существующей закладки: выберете закладку в списке и нажмите
								"ред" после чего во вкладке редактирование и сохрание измените нужные поля.</p>
						</div>
						<div>
							<cf:form method="POST" action="newBookmark" modelAttribute="bookmark">
								<cf:hidden path="bookmarkAddedDate" />
								<cf:hidden path="catalogAncestor" />
								<cf:hidden path="bookmarkId" />
								<cf:label class="label" path="bookmarkName">Имя</cf:label>
								<cf:input type="text" class="IncomOutcomForm" path="bookmarkName"/><br>
								<cf:errors path="bookmarkName" cssClass="error"/>
								<p></p>
								<cf:label class="label" path="bookmarkRef">Ссылка</cf:label>
								<cf:input type="text" class="IncomOutcomForm" path="bookmarkRef" /><br>
								<cf:errors path="bookmarkRef" cssClass="error"/>
								<p></p>
								<cf:label class="label" path="bookmarkDescription">Описание</cf:label>
								<cf:input type="text" class="IncomOutcomForm" path="bookmarkDescription" /><br>
								<cf:errors path="bookmarkDescription" cssClass="error"/>
								<p></p>
								<cf:label class="label" path="markAsRead">Прочитано</cf:label>
								<cf:input type="text" class="IncomOutcomForm" path="markAsRead" /><br>
								<cf:errors path="markAsRead" cssClass="error"/>
								<p></p>
								<cf:label class="label" path="markAsImportancy">Важность</cf:label>
								<cf:input type="text" class="IncomOutcomForm" path="markAsImportancy" /><br>
								<cf:errors path="markAsImportancy" cssClass="error"/>
								<p></p>
								<cf:label class="label" path="bookmarkLanguge">Язык</cf:label>
								<cf:input type="text" class="IncomOutcomForm" path="bookmarkLanguge" /><br>
								<cf:errors path="bookmarkLanguge" cssClass="error"/>
								<p></p>
								<input class="buttonAdd" type="submit" value="Save">
							</cf:form>
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
										<td id="eighth"><a class="buttonreductor" href="editBookmark?bookamrkId=${bookmark.bookmarkId}">ред.</a>
										<p></p>
										<a class="buttonreductor" href="delateBookmark?bookmarkId=${bookmark.bookmarkId}">del.</a>
										</td>
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
				<p>Для сохраниения нового каталога сначала выберете в каком каталоге его сохранить</p>
				<p>Для редактирование выберете каталог и нажмите "ред"</p>
				<cf:form method="POST" action="newCatalog" modelAttribute="catalog">
					<cf:hidden path="catalogId" />
					<cf:hidden path="catalogAncestor" />
					<cf:label class="catalogLabel" path="catalogName">Name</cf:label>
					<cf:input class="catalogEditor" path="catalogName"/>
					<cf:errors path="catalogName" cssClass="error"/>
					<p></p>
					<input type="submit" value="Save"/>
				</cf:form>
			</div>
		</aside>

	</div>
	<!-- .middle-->
	
</body>
</html>