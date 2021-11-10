<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>
<style>
  
  .nav{
    width: 100%;
    height: 10vh;
    background-color:white;
  }
  .nav-menu-bar{
    width: 800px;
    height: 100%;
    margin-left: 15vw;
  }
  .menu{
    font-size: 20px;
    font-weight:bold;
    color: grey;
    margin-top:25px;
    margin-right: 60px;
  }
  .menu:hover{
   color: red;
   transition: 1s;
  }
  .icon{
    width: 100px;
    height: 100%;
    margin-left: 25vw;
    position: relative; 
  }
  .icon a{
    font-size: 20px;
    font-weight: bold;
    text-align: center;
    position: absolute;
    color:gray;
    top:35%;
    left:20%;
  }
  .icon a:hover{
    color: red;
    transition:1s;
  }
  
  .title-box{
    margin-top: 10vh;
    position: relative;
  }
  .title{
   font-size: 75px;
   color:white;
   font-weight: bold;
   text-align: center;
   position: absolute;
   left: 20%;
  }
  
  
  
</style>
  <div class="nav row">
    <div class="nav-menu-bar cell">
      <div>
        <a class="menu cell" href="#">공지게시판</a>
      </div>
      <div>
        <a class="menu cell" href="#">자유게시판</a>
      </div>
    </div>
    <div class="icon cell">
      <a href="/usr/member/login">로그인</a>
    </div>
  </div>
  <div class="title-box">
    <h1 class="title">Think More<br>And Do It<br>Then you'll know the result.</h1>
  </div>
<%@ include file = "../common/footer.jspf"%>