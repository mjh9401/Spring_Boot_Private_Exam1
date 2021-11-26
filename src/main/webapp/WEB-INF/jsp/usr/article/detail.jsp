<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>

<section class="mt-24 container mx-auto px-3">
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
        <a class="btn btn-primary" href="../article/delete?id=${article.id}">삭제</a>
        <button class="btn btn-primary" type="button" onclick="history.back();">뒤로가기</button>      
      </td>
     </tr>
    </tbody>
   </table>
  </div>
   
  <div class="mt-9">
   <form method="get" action="../reply/dowrite">
   <input type="hidden"  name ="articleId"  value="${article.id}"/>
   <input type="hidden"  name ="boardId"  value="${boardId}"/>
   <table>
    <tbody>
      <tr>
        <th>${loginInformation.getLoginedMember().getNickname()}</th>
        <td>
           <textarea name ="body" class="w-96 h-5 ml-5" rows="10" placeholder="댓글을 적어주세요"></textarea> 
        </td>
        <td>
          <input type="submit" class="ml-5" value="작성" />
        </td>
      </tr>  
     </tbody>
    </table>
    </form>
    
   <table>
    <tbody>
     <c:forEach var="reply" items="${replies}">
      <tr>
       <td><b class="mr-5">${reply.nickName}</b></td>
       <td>${reply.body}</td>
       <td><a class="btn btn-primary ml-3" href="../reply/showModify?id=${reply.articleId}">수정</a></td>
       <td><a class="btn btn-primary ml-2" href="../reply/delete?id=${reply.id}">삭제</a></td>
      </tr>
     </c:forEach>  
    </tbody>
   </table>
   
  </div>  
 
</section>
     
  
 
 
<%@ include file = "../common/footer.jspf"%>