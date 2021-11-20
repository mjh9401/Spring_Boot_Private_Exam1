<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>

<section class="mt-5">
 <div class="table">
  <form method="post" action="../article/write">
   <input type="hidden" value="${boardId}"/>
   <table class="table">
    <colgroup>
      <col width="200" />
    </colgroup>
    <tbody>
      <tr>
        <th>작성자</th>
        <td>${loginInformation.getLoginedMember().getNickname()}</td>
      </tr>  
      <tr>
         <th>제목</th>
         <td>
           <input required="required" name="title" class="w-96" type="text" placeholder="제목" />
         </td>
       </tr>
       <tr>
         <th>내용</th>
         <td>
           <textarea required="required" name ="body" class="w-full" rows="10" placeholder="내용을 적어주세요"></textarea> 
          </td>
       </tr>
       <tr>
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