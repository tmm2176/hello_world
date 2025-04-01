<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- modifyBoard.jsp -->
<jsp:include page="includes/header.jsp"/>
<h3>삭제화면(deleteBoard.jsp)</h3>
  <%
  BoardVO board = (BoardVO) request.getAttribute("board");
  %>
<form action="deleteBoard.do" method="POST">
  <input type="hidden" name="bno" value="<%=board.getBoardNo()%>">
  <table class="table">
    <tr>
      <th>글번호</th><td><%=board.getBoardNo()%></td>
      <th>작성자</th><td><%=board.getWriter()%></td>    
    </tr>
    <tr>
      <th>제 목</th>
      <td colspan="3"><input type="text" class="form=control" name="title" value="<%=board.getTitle()%>"></td>
    </tr>
    <tr>
      <th>내용</th>
      <td colspan="3">
       <textarea cols="30" rows="3" class="form=control" name="content"><%=board.getContent()%></textarea>
      </td>
    </tr>
    <tr>
      <th>작성일시</th>
      <td><%=board.getWriteDate()%></td>
    </tr>
    <tr>
      <td colspan="3" align="center">
        <button type="submit" class ="btn btn-danger">삭제</button>
      </td>
    </tr>
  </table>
  </form>

<jsp:include page="includes/footer.jsp"></jsp:include>