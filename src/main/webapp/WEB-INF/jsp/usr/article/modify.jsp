<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>

<section class="mt-5 container mx-auto px-3">
  <div>
   <form action="../article/modify" method="get">
   <table class="table">
    <colgroup>
     <col width="200" />
    </colgroup>
    <tbody>
     <tr>
      <th>번호</th>
      <td>
       <input readonly="readonly" name="id" type="text" value="${article.id}" />
      </td>
     </tr>
     <tr>
      <th>작성날짜</th>
      <td>${article.regDate}</td>
     </tr>
     <tr>
      <th>수정날짜</th>
      <td>${article.updateDate}</td>
     </tr>    
     <tr>
      <th>제목</th>
      <td>${article.title}</td>
     </tr>
     <tr>
      <th>내용</th>
      <td>
       <textarea required="required" name ="body" class="w-96 h-52">${article.body}</textarea> 
      </td>
     </tr>
     <tr>
      <th>수정</th>
      <td>
        <input type="submit"" class="btn btn-primary" value="수정" />
        <button class="btn btn-primary" type="button" onclick="history.back();">뒤로가기</button>      
      </td>
     </tr>
    </tbody>
   </table>
   </form>
  </div>
</section>
     
  
 
 
<%@ include file = "../common/footer.jspf"%>