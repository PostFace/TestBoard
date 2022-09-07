<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="color.jsp"%>    
<%@ include file="../common/common.jsp"%>
boardContent.jsp<br>

<form name="myform">
	<table width="500" border="1" cellspacing="0" cellpadding="0"  
      bgcolor="<%=bodyback_c%>" align="center">  
  <tr height="30">
    <td align="center" width="125" bgcolor="<%=value_c%>">글번호</td>
    <td align="center" width="125"> ${article.num}</td>
    <td align="center" width="125" bgcolor="<%=value_c%>">조회수</td>
    <td align="center" width="125"> ${article.readcount}</td>
  </tr>
  <tr height="40">
    <td align="center" width="125" bgcolor="<%=value_c%>">작성자</td>
    <td align="center" width="125"> ${article.writer}</td>
    <td align="center" width="125" bgcolor="<%=value_c%>" >작성일</td>
    <td align="center" width="125"> <fmt:parseDate var="formattedDay" value="${article.reg_date }" pattern="yyyy-MM-dd"/>
				<fmt:formatDate var="newformattedDay" value="${formattedDay }" pattern="yyyy-MM-dd"/>
				${newformattedDay }</td>
  </tr>
  <tr height="30">
    <td align="center" width="125" bgcolor="<%=value_c%>">글제목</td>
    <td align="center" width="375" colspan="3"> ${article.subject}</td>
  </tr>
  <tr height="40">
    <td align="center" width="125" bgcolor="<%=value_c%>">글내용</td>
    <td align="left" width="375" colspan="3"><pre>${article.content}</pre></td>
  </tr> 
  <tr>
  	<td colspan="4" align="center" height="30">
  		<input type="button" value="글수정" onclick="location.href='update.brd?num=${article.num}&pageNumber=${pageNumber}'">  
  		<input type="button" value="글삭제" onclick="location.href='delete.brd?num=${article.num}&pageNumber=${pageNumber}'">  
  		<input type="button" value="답글쓰기" 
  		onclick="location.href='reply.brd?ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}&pageNumber=${pageNumber}'">  
  		<input type="button" value="글목록" onclick="location.href='list.brd?pageNum=${pageNumber}'">  
  </tr>
</table>  
</form>