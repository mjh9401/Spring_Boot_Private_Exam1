<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>

<section class="mt-5 position-origin">
 <div class="position-center table">
  <form method="get" action="../article/dowrite">
   <input type="hidden" name="boardId" value="${boardId}"/>
   <input type="hidden" name="memberId" value="${loginInformation.getLoginedMember().getId()}"/>
   <table class="table-outline">
    <colgroup>
      <col width="200" />
    </colgroup>
    <tbody>
      <tr class="table-outline">
        <th>작성자</th>
        <td>${loginInformation.getLoginedMember().getNickname()}</td>
      </tr>  
      <tr class="table-outline">
         <th>제목</th>
         <td>
           <input required="required" name="title" class="w-96" type="text" placeholder="제목" />
         </td>
       </tr>
       <tr class="table-outline">
         <th>내용</th>
         <td>
           <textarea required="required" name ="body" class="w-full" rows="10" placeholder="내용을 적어주세요"></textarea> 
          </td>
       </tr>
       <tr class="table-outline">
         <th>제출</th>
        <td>
          <input type="submit" value="작성" />
          <button type="button" onclick="history.back();">뒤로가기</button>
        </td>
      </tr>
     </tbody>
    </table>
    </form>
   </div>  
</section>
     
 
 
 
<%@ include file = "../common/footer.jspf"%>