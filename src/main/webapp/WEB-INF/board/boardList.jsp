<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="color.jsp"%>    
<%@ include file="../common/common.jsp"%>    
    
<style type="text/css">
	body{
		text-align: center;
	}
	table{
		margin: auto;
	}
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>    
boardList.jsp<br>
<h1>게시판 목록보기</h1>
<b>글목록(전체 글 : ${totalCount })</b>

<c:if test="${fn:length(lists) > 0}">
<form action="list.brd" method="get">
		<select name="whatColumn">
			<option value="">전체 검색</option>
			<option value="subject">제목</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" name="keyword" >
		<input type="submit" value="검색"><br><br>
</form>
<table border="1" width="700">
	<tr>
		<td align="right" bgcolor="<%=value_c%>" colspan="6">
			<a href="write.brd">글쓰기</a>
		</td>
	</tr>
	<tr bgcolor="<%=value_c%>">
		<td align="center">번호</td>
		<td align="center">제목</td>
		<td align="center">작성자</td>
		<td align="center">작성일</td>
		<td align="center">조회</td>
		<td align="center">IP</td>
	</tr>
<c:forEach items="${lists }" var="write" varStatus="i">
<tr>
			<td align="right">${write.num}</td>
			<td >
				
			<c:if test="${write.re_level>0}">
				<img src="resources/images/level2.gif" width="${write.re_level*20}" height="15">
				<img src="resources/images/re2.gif" height="15">
			</c:if>	
			<a href="content.brd?num=${write.num }&pageNumber=${pageInfo.pageNumber}">${write.subject }</a>
			<c:if test="${write.readcount>10}">
			<img src="resources/images/hot2.gif" height="15" >
			</c:if>
			</td>
			<td align="center">${write.writer }</td>
			<td align="center">
			<fmt:parseDate var="formattedDay" value="${write.reg_date }" pattern="yyyy-MM-dd"/>
				<fmt:formatDate var="newformattedDay" value="${formattedDay }" pattern="yyyy-MM-dd"/>
				${newformattedDay }</td>
			<td align="right">${write.readcount }</td>
			<td align="center">${write.ip}</td>
		</tr>
</c:forEach>
</table>
${pageInfo.pagingHtml }	
</c:if>