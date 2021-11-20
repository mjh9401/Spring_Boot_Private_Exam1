<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>

<section class="mt-5 container mx-auto px-3">
  <div> 
   <table class="table">
    <colgroup>
     <col width="200" />
    </colgroup>
    <tbody>
     <tr>
      <th>번호</th>
      <td>
       <div class="badge badge-primary">${article.id}</div>
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
      <td>${article.body}</td>
     </tr>
     <tr>
      <th>수정</th>
      <td>
        <a class="btn btn-primary" href="../article/showModify?id=${article.id}">수정</a>
        <button class="btn btn-primary" type="button" onclick="history.back();">뒤로가기</button>      
      </td>
     </tr>
    </tbody>
   </table>
  </div>
</section>
     
  
 
 
<%@ include file = "../common/footer.jspf"%>