<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"/>
  <!-- webapp/WEB-INF/views/board.jsp -->
  <%
  BoardVO board = (BoardVO) request.getAttribute("board");
  %>
  <h3>상세페이지(board.jsp)</h3>
  <table class="table">
    <tr>
      <th>글번호</th><td><%=board.getBoardNo()%></td>
    </tr>
    <tr>
      <th>작성자</th><td><%=board.getWriter()%></td>
    </tr>
    <tr>    
      <th>제 목</th><td><%=board.getTitle()%></td>
    </tr>
    <tr>
      <th>내용</th>
      <td colspan="3"><textarea cols="30" rows="3" class="form=control" readonly><%=board.getContent()%></textarea></td>
    </tr>
      <th>작성일시</th><td><%=board.getWriteDate()%></td>
    <tr>
    </tr>
  </table>
<jsp:include page="includes/footer.jsp"></jsp:include>