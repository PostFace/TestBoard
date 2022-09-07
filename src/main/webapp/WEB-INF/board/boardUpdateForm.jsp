<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
content.jsp => updateForm.jsp
<br>
<%@include file="../common/common.jsp"%>
<%@include file="color.jsp"%>
<style type="text/css">
body {
	text-align: center;
}

table {
	margin: auto;
}
</style>
writeForm.jsp
<br>
<body bgcolor="<%=bodyback_c%>">
	<b>글수정</b>
	<br>
	<form:form commandName="article" method="post" name="writeform" action="update.brd">
		<input type="hidden" name="num" value="${article.num}">
		<input type="hidden" name="pageNumber" value="${pageNumber}">
		<table width="430" border="1" cellspacing="0" cellpadding="0"
			bgcolor="<%=bodyback_c%>" align="center">
			<tr>
				<td align="right" colspan="2" bgcolor="<%=value_c%>"><a
					href="list.brd?pageNumber=${pageNumber }"> 글목록</a></td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%=value_c%>" align="center">이 름</td>
				<td width="330" align="left"><input type="text" size="30"
					maxlength="10" name="writer" value="${article.writer}">
					<form:errors cssClass="err" path="writer"/></td>
			</tr>

			<tr>
				<td width="100" bgcolor="<%=value_c%>" align="center">제 목</td>
				<td width="330" align="left"><input type="text" size="50"
					maxlength="50" name="subject" value="${article.subject }">
					<form:errors cssClass="err" path="subject"/>
				</td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%=value_c%>" align="center">Email</td>
				<td width="330" align="left"><input type="text" size="50"
					maxlength="30" name="email" value="${article.email}">
					<form:errors cssClass="err" path="email"/></td>
			</tr>

			<tr>
				<td width="100" bgcolor="<%=value_c%>" align="center">내 용</td>
				<td width="330" align="left"><textarea name="content" id="abc"
						rows="13" cols="50">${article.content}</textarea>
					<form:errors cssClass="err" path="content"/></td>
			</tr>
			<tr>
				<td width="100" bgcolor="<%=value_c%>" align="center">비밀번호</td>
				<td width="330" align="left"><input type="password" size="10"
					maxlength="12" name="passwd" value="">
					<form:errors cssClass="err" path="passwd"/></td>
			</tr>
			<tr>
				<td colspan=2 bgcolor="<%=value_c%>" align="center" height="30">
					<input type="submit" value="수정하기"> <input type="reset"
					value="다시작성"> <input type="button" value="목록보기"
					OnClick="window.location='list.brd?pageNumber=${pageNumber}'">
				</td>
			</tr>
		</table>
	</form:form>