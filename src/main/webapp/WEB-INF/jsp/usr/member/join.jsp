<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>

<div class="table mx-auto mt-20 ">
     <form action="../member/dojoin" method="post">     
       <table>
         <tbody>
            <tr>
               <th><span>아이디</span></th>
               <td>
                 <input required="required" class="input input-lg input-bordered w-96" name="loginId" type="text" placeholder="아이디를 입력해주세요" 
                 onkeyup = "checkIdDup(this);" autocomplete="off"/>
                 <div class="loginId-message"></div>
               </td>
            </tr>
            <tr>
              <th><span>새로운 비밀번호</span></th>
              <td><input required="required" class="input input-lg input-bordered w-96" name="password" type="password" placeholder="비밀번호를 입력해주세요"/></td>
            </tr>
            <tr>
               <th><span>비밀번호 확인</span></th>
               <td><input required="required" class="input input-lg input-bordered w-96" name="passwordConfirm" type="password" placeholder="비밀번호를 한번 더 입력해주세요"/></td>
            </tr>
            <tr>
               <th><span>이름</span></th>
               <td><input required="required" class="input input-lg input-bordered w-96" name="name" type="text" placeholder="이름을 입력해주세요" /></td>
            </tr>
            <tr>
               <th><span>닉네임</span></th>
               <td><input required="required" class="input input-lg input-bordered w-96" name="nickname" type="text" placeholder="닉네임을 입력해주세요" /></td>
            </tr>
            <tr>
               <th><span>전화번호</span></th>
               <td><input required="required" class="input input-lg input-bordered w-96" name="tel" type="tel" placeholder="휴대번호를 입력해주세요" /></td>
            </tr>
            <tr>
               <th><span>이메일</span></th>
               <td><input required="required" class="input input-lg input-bordered w-96" name="email" type="email" placeholder="이메일를 입력해주세요" /></td>
            </tr>  
         </tbody>
       </table>   
       <input class="btn btn-primary btn-block mb-3" type="submit" value="회원정보 입력완료"/>
    </form>
</div>
  
 
<%@ include file = "../common/footer.jspf"%>