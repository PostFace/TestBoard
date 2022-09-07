<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="color.jsp"%>
    <style type="text/css">
	body{
		text-align: center;
	}
	table{
		margin: auto;
	}
</style> 
replyForm.jsp<br>

<body bgcolor="<%=bodyback_c%>">
		<b>답글쓰기</b> <br>
		<form method="post" name="article" action="reply.brd">
		<input type="hidden" name="pageNumber" value="${pageNumber}"> 		
		<input type="hidden" name="ref" value="${ref}"> 
		<input type="hidden" name="re_step" value="${re_step}"> 
		<input type="hidden" name="re_level" value="${re_level}"> 		
			<table width="430" border="1" cellspacing="0" cellpadding="0"
				bgcolor="<%=bodyback_c%>" align="center">
				<tr>
					<td align="right" colspan="2" bgcolor="<%=value_c%>">
						<a href="list.brd?pageNumber=${pageNumber }"> 글목록</a>
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">이 름</td>
					<td width="330" align="left">
					<input type="text" size="30" maxlength="10"	name="writer" 
							value="홍길동"></td>
				</tr>
				
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">제 목</td>
					<td width="330" align="left">					
						<input type="text" size="50" maxlength="50" name="subject" 
								value="[답글]어떤글">
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">Email</td>
					<td width="330" align="left">
					<input type="text" size="50" maxlength="30"	name="email" 
							value="aa@xx.com"></td>
				</tr>
				
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">내 용</td>
					<td width="330" align="left">
						<textarea name="content" id="abc" rows="13" cols="50">호호호</textarea>
					</td>
				</tr>
				<tr>
					<td width="100" bgcolor="<%=value_c%>" align="center">비밀번호</td>
					<td width="330" align="left">
						<input type="password" size="10" maxlength="12"	name="passwd"  
								value="1234">
					</td>
				</tr>
				<tr>
					<td colspan=2 bgcolor="<%=value_c%>" align="center" height="30">
						<input	type="submit" value="답글쓰기"> 
						<input type="reset"	value="다시작성"> 
						<input type="button" value="목록보기"	
								OnClick="window.location='list.brd'">
					</td>
				</tr>
			</table>	
		</form>
				