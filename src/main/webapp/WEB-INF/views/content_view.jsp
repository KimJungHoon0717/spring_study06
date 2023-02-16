<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 내용 보기</title>
</head>
<body>
	<h2>게시글 내용 보기</h2>
	<hr>
	<table border="1" cellpadding="0" cellspacing="0" width="500">
	
	<tr>
			<th>글번호</th>
			<td>${contentDto.bid }</td>
		</tr>	
		<tr>
			<th>조회수</th>
			<td>${contentDto.bhit }</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td >${contentDto.bdate }</td>
		</tr>
		<tr>
			<th>이 름</th>
			<td>${contentDto.bname }</td>
		</tr>	
		<tr>
			<th>제 목</th>
			<td>${contentDto.btitle }</td>
		</tr>
		<tr>
			<th>내 용</th>
			<td height="100">${contentDto.bcontent }</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="글답변"onclick="javascript:window.location=''">
				<input type="button" value="글수정"onclick="javascript:window.location=''">
				<input type="button" value="글삭제"onclick="javascript:window.location=''">
				<input type="button" value="글목록" onclick="javascript:window.location='list'">  
			</td>
		</tr>
	
	</table>
</body>
</html>