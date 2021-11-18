<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>
<style>
  .container{
    min-width: 1200px;
    min-height: 600px;
  }
  
  table{
    margin-left: auto;
    margin-right: auto;
    margin-top: 14vh;
    width: 1400px;
    height: 50px;
    border : 2px solid black;
    border-collapse : collapse;
  }
  
  
  td, th {
    border-collapse : collapse;
    border : 1px solid black;
    text-align: center;
  };
  
  
</style>

<div class="container">
   <table>
    <colgroup>
      <col width="120" />
      <col width="150" />
      <col width="150" />
      <col width="120" />
    </colgroup>
    <thead>
     <tr>
      <td>번호</td>
      <td>작성날짜</td>
      <td>수정날짜</td>
      <td>제목</td>
     </tr>
    </thead>
    <tbody>
     <c:forEach var="article" items="${articles}">
      <tr>
       <th>${article.id}</th>
       <td>${article.regDate}</td>
       <td>${article.updateDate}</td>
       <td>
         <a class="btn-text-link block w-full truncate" href="../article/detail?id=${article.id}">
           ${article.title}
         </a>
       </td>
      </tr>
     </c:forEach>  
    </tbody>
   </table>
</div>

<div class="page-menu mt-3">
  <div class="btn-group justify-center">
     <c:set var="pageMenuArmLen" value="4"/>
     <c:set var="startPage" value="${page - pageMenuArmLen >= 1 ? page - pageMenuArmLen : 1}"/>
     <c:set var="endPage" value="${page + pageMenuArmLen <= pagesCount ? page + pageMenuArmLen : pagesCount}"/>
  
     <c:forEach begin="1" end="${pagesCount}" var="i">
       <a class="btn ${page == i ? 'btn-active': ''}" href="?page=${i}">${i}</a>
     </c:forEach>
  </div>
</div>  
 
<%@ include file = "../common/footer.jspf"%>