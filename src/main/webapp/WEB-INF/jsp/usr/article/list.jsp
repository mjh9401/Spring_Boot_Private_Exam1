<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>

<div class="mt-3">
   <table class="table table-fixed w-full">
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
       <td>${article.id}</td>
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

<div class="page-menu mt-4">
  <div class="btn-group justify-center">
     <c:set var="pageMenuArmLen" value="4"/>
     <c:set var="startPage" value="${page - pageMenuArmLen >= 1 ? page - pageMenuArmLen : 1}"/>
     <c:set var="endPage" value="${page + pageMenuArmLen <= pagesCount ? page + pageMenuArmLen : pagesCount}"/>
  
     <a class="btn" href="?page=1">처음으로</a>
     <c:forEach begin="${startPage}" end="${endPage}" var="i">
       <a class="btn ${page == i ? 'btn-active': ''}" href="?page=${i}">${i}</a>
     </c:forEach>
     <a class="btn" href="?page=${pagesCount}">마지막</a>
  </div>
</div>  
 
<%@ include file = "../common/footer.jspf"%>