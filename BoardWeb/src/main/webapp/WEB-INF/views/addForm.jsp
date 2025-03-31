<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"/>
  <!-- addForm.jsp -->
  <form action = "addBoard.do" method="post">
    <table class="table">
      <tr>
        <th>글제목</th><td><input type="text" name="title" class="form-control"></td>
      </tr>
      <tr>
        <th>작성자</th><td><input type="text" name="writer" class="form-control"></td>
      </tr>
      <tr>
        <th>본문</th><td><textarea name="content" rows="3" cols="40" class="form-control"></textarea>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type ="submit" class="btn btn-primary">
          <input type="reset" class="btn btn-secondary">
        </td>
      </tr>
    </table>
  </form>
<jsp:include page="includes/footer.jsp"></jsp:include>