<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>
<style>
  .cotainer{
    width: 600px;
    height: 500px;
    background-color: white;
    margin: 0 auto;
    margin-top: 150px;
    border-radius: 10px;
    box-sizing: border-box;
    padding-top: 20px;
  }
  .box{
    margin-left: 60px;
  }
  .inputLabel{
    width: 300px;
    height: 30px;
    margin: 0 auto;
    margin-top:20px;
    margin-left: 50px;
    margin-bottom:2px;
    font-size: 20px;
    border-radius: 10px;
    border-color: gray;
  }  
  .btn1{
    width: 500px;
    height: 80px;
    margin-top:50px;
    margin-left: 50px;
    background-color: green;
    font-size: 25px;
    font-weight: bold;
    color: white;
    border-radius: 10px;
    border-color: white;  
  }
  .SubInputBox{
    margin-top: 50px;
    margin-left: 150px;
  }
  .subInput{
    margin-right: 30px;
  }
</style>

<div>
   <table>
    <colgroup>
      <col width="100" />
      <col width="100" />
      <col width="80" />
      <col width="80" />
      <col width="150" />
    </colgroup>
    <thead>
     <tr>
      <th>번호</th>
      <th>작성날짜</th>
      <th>수정날짜</th>
      <th>조회</th>
      <th>추천</th>
      <th>작성자</th>
      <th>제목</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach var="article" items="${articles}">
      <tr>
       <th>${article.id}</th>
       <td>${article.forPrintType1RegDate}</td>
       <td>${article.forPrintType1UpdateDate}</td>
       <td>${article.hitCount}</td>
       <td>${article.goodReactionPoint}</td>
       <td>${article.extra__WriterName}</td>
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
  
 
<%@ include file = "../common/footer.jspf"%>