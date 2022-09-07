<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
boardDeleteForm.jsp<br>
<b>글삭제</b>
<%@include file="color.jsp"%> 
<%
	String num=request.getParameter("num");
	String pageNum=request.getParameter("pageNum");
%>
<style type="text/css">
	body{
		text-align: center;
	}
	table{
		margin: auto;
	}
</style> 
<script type="text/javascript">
	function deleteCheck(){
		if(document.myform.passwd.value==""){
			alert('비밀번호를 입력하세요.');
			document.myform.passwd.focus();
			return false;			
		}
	}
</script>   
<form name="myform" method="post" action="delete.brd" onsubmit="return deleteCheck()">
	<input type="hidden" name="num" value="${num }">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<table width="360" border="1" cellspacing="0" cellpadding="0"  
      bgcolor="<%=bodyback_c%>" align="center">
		<tr>
			<td colspan='4' align="center"  height="40" bgcolor="<%=title_c%>"><b>비밀번호를 입력해 주세요.</b></td>
		</tr>
		<tr>
			<td colspan='4' align="center" height="50" bgcolor="<%=value_c%>">비밀번호 : <input type="password" name="passwd"></td>
		</tr>
		<tr>
			<td colspan='4' align="center" height="40" bgcolor="<%=title_c%>"><input type="submit" value="글삭제">
			<input type="button" value="글목록" onclick="location.href='list.brd?pageNum=<%=pageNum%>'"></td>
		</tr>
	</table>
</form>