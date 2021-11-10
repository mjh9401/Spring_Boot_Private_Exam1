<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>
<style>
  body{
    background-image: url("https://post-phinf.pstatic.net/MjAxODA2MjJfMTE1/MDAxNTI5NjU0NzkyNDQx.RnzgNCdU9nC3y8P9xxT7Knfp4bbWWhR0vH3BtMifXNAg.rQOWvZb2adrPcfgckthJ_pbKlMBDt0Et5KKlro9lFXYg.JPEG/%EC%82%AC%EC%A7%84%EC%8C%A4%EC%9A%B0%EC%93%B0%EB%9D%BC_06_%EC%9D%B8%ED%8A%B8%EB%A1%9C.jpg?type=w1200");
    background-repeat: no-repeat;
    background-size: cover;
  }
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
      <a href="#">로그인</a>
    </div>
  </div>
  <div class="title-box">
    <h1 class="title">Think More<br>And Do It<br>Then you'll know the result.</h1>
  </div>
<%@ include file = "../common/footer.jspf"%>