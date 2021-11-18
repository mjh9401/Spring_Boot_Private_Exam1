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
    margin-top:10px;
    margin-left: 50px;
    margin-bottom:2px;
    font-size: 20px;
    border-radius: 10px;
    border: 1px solid black;
  }  
  .btn1{
    width: 500px;
    height: 80px;
    margin-top:30px;
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
     <form action="../member/dojoin" method="post">
       <table class="box">
         <tbody>
            <tr>
               <td><span>아이디</span></td>
               <td><input required="required" class="inputLabel" name="loginId" type="text" placeholder="아이디를 입력해주세요"/></td>
            </tr>
            <tr>
              <td><span>새로운 비밀번호</span></td>
              <td><input required="required" class="inputLabel" name="password" type="password" placeholder="비밀번호를 입력해주세요"/></td>
            </tr>
            <tr>
               <td><span>비밀번호 확인</span></td>
               <td><input required="required" class="inputLabel" name="passwordConfirm" type="password" placeholder="비밀번호를 한번 더 입력해주세요"/></td>
            </tr>
            <tr>
               <td><span>이름</span></td>
               <td><input required="required" class="inputLabel" name="name" type="text" placeholder="이름을 입력해주세요" /></td>
            </tr>
            <tr>
               <td><span>닉네임</span></td>
               <td><input required="required" class="inputLabel" name="nickname" type="text" placeholder="닉네임을 입력해주세요" /></td>
            </tr>
            <tr>
               <td><span>전화번호</span></td>
               <td><input required="required" class="inputLabel" name="tel" type="tel" placeholder="휴대번호를 입력해주세요" /></td>
            </tr>
            <tr>
               <td><span>이메일</span></td>
               <td><input required="required" class="inputLabel" name="email" type="email" placeholder="이메일" /></td>
            </tr>  
         </tbody>
       </table>   
       <input class="btn1" type="submit" value="회원정보 입력완료"/>
    </form>
  </div>
  
 
<%@ include file = "../common/footer.jspf"%>