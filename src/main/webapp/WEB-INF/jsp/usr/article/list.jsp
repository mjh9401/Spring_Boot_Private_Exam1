<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>

<div class="position mt-10">
  <a class="btn btn-primary" href="../article/showWrite">작성</a>
</div>

<div class="mt-3 mb-3">
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

<!-- 검색 창 -->
<div class="mt-10 ">
  <form class="flex justify-center">
    <input type="hidden" name="boardId" value="${param.boardId}" /> 
    <select id="typeCode" name="searchKeywordTypeCode" class="select select-bordered">
       <option disabled="disabled">검색타입</option>
       <option value="title">제목</option>
       <option value="body">내용</option>
       <option value="title,body">제목,내용</option>
    </select>
    
    <input type="text" name="searchKeyword" placeholder="검색어" class="ml-2 w-72 input input-bordered"/>
    <input type="submit" class="ml-2 btn btn-primary" value="검색"/> 
    
  </form>
</div>

<!-- 페이징 -->
<div class="page-menu mt-4">
  <div class="btn-group justify-center">
     <c:set var="pageMenuArmLen" value="4"/>
     <c:set var="startPage" value="${page - pageMenuArmLen >= 1 ? page - pageMenuArmLen : 1}"/>
     <c:set var="endPage" value="${page + pageMenuArmLen <= pagesCount ? page + pageMenuArmLen : 1}"/>
  
     <a class="btn" href="?boardId=${boardId}&page=1">처음으로</a>
     <c:forEach begin="${startPage}" end="${endPage}" var="i">
       <a class="btn ${page == i ? 'btn-active': ''}" href="?boardId=${boardId}&page=${i}">${i}</a>
     </c:forEach>
     <a class="btn" href="?boardId=${boardId}&page=${endPage}">마지막</a>
  </div>
</div>  
 
 
<%@ include file = "../common/footer.jspf"%>