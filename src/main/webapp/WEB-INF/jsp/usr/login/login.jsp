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
  }
  .inputLabel{
    width: 500px;
    height: 80px;
    margin: 0 auto;
    margin-top:30px;
    margin-left: 50px;
    font-size: 35px;
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
  <div class="cotainer">
     <form action="../member/doLogin" method="post">
       <input class="inputLabel" name="loginId" type="text" placeholder="아이디"/>
       <input class="inputLabel" name="loginPassword" type="password" placeholder="비밀번호"/>
       <input class="btn1" type="submit" value="로그인"/>
       <div class="SubInputBox">
         <a class="subInput " href="#">회원가입</a>
         <a class="subInput " href="#">아이디찾기</a>
         <a class="subInput " href="#">비밀번호찾기</a>
       </div>
     </form>
  </div>
  
 
<%@ include file = "../common/footer.jspf"%>