<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>
<style>
  .cotainer{
    width: 600px;
    height: 400px;
    background-color: white;
    margin: 0 auto;
    margin-top: 150px;
    border-radius: 10px;
    box-sizing: border-box;
    padding-top: 80px;
    border: 2px solid black;
  }
  .box{
    margin-left: 100px;
  }
  .inputLabel{
    width: 300px;
    height: 30px;
    margin: 0 auto;
    margin-top:20px;
    margin-left: 50px;
    margin-bottom:20px;
    font-size: 20px;
    border-radius: 10px;
    border: 1px solid black;
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
     <form action="../member/doCkPassword" method="post">
       <table class="box">
        <input type="hidden" name="id" value="${loginInformation.getLoginedMember().getId()}" /> 
         <tbody>
            <tr>
              <td><span>아이디</span></td>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${loginInformation.getLoginedMember().getLoginId()}</td>
            </tr>
            <tr>
               <td><span>비밀번호</span></td>
               <td><input required="required" class="inputLabel" name="password" type="password" placeholder="비밀번호를 입력해주세요"/></td>
            </tr>
         </tbody>
       </table>   
       <input class="btn1" type="submit" value="확인"/>
    </form>
</div>
  
 
<%@ include file = "../common/footer.jspf"%>