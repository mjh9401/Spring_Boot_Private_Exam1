<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ include file = "../common/header.jspf" %>
<style>
/*배경화면*/
body{
    background-image: url("https://post-phinf.pstatic.net/MjAxODA2MjJfMTE1/MDAxNTI5NjU0NzkyNDQx.RnzgNCdU9nC3y8P9xxT7Knfp4bbWWhR0vH3BtMifXNAg.rQOWvZb2adrPcfgckthJ_pbKlMBDt0Et5KKlro9lFXYg.JPEG/%EC%82%AC%EC%A7%84%EC%8C%A4%EC%9A%B0%EC%93%B0%EB%9D%BC_06_%EC%9D%B8%ED%8A%B8%EB%A1%9C.jpg?type=w1200");
    background-repeat: no-repeat;
    background-size: cover;
  }
.nav {
	width: 100%;
	height: 10vh;
	background-color: white;
}

.nav-menu-bar {
	width: 800px;
	height: 100%;
	margin-left: 15vw;
}

.menu {
	font-size: 20px;
	font-weight: bold;
	color: grey;
	margin-top: 25px;
	margin-right: 60px;
}

.menu:hover {
	color: red;
	transition: 1s;
}

.icon {
	width: 210px;
	height: 100%;
	margin-left: 25vw;
	box-sizing: border-box;
    padding-top: 25px;
}

.icon a {
	font-size: 20px;
	font-weight: bold;
	text-align: center;
	color: gray;
    margin-left: 10px;
    margin-right: 10px;
}

.icon a:hover {
	color: red;
	transition: 1s;
}

.title-box {
	margin-top: 10vh;
	position: relative;
}

.title {
	font-size: 75px;
	color: white;
	font-weight: bold;
	text-align: center;
	position: absolute;
	left: 20%;
}
</style>  

  <div class="nav row">
    <div class="nav-menu-bar cell">
      <div>
        <a class="menu cell" href="/usr/article/list?boardId=1">공지게시판</a>
      </div>
      <div>
        <a class="menu cell" href="/usr/article/list?boardId=2">자유게시판</a>
      </div>
    </div>
    <div class="icon cell">
      <ul>
        <li>
         <c:choose>
          <c:when test="${!loginInformation.isLogined()}">
            <a href="/usr/member/login">로그인</a>
          </c:when>
          <c:when test="${loginInformation.isLogined()}">
            <a href="/usr/member/dologout">로그아웃</a>
            <a href="/usr/member/ckPassword">개인정보</a>
          </c:when>
         </c:choose>
        </li>
      </ul>
    </div>
  </div>
  <div class="title-box">
    <h1 class="title">Think More<br>And Do It<br>Then you'll know the result.</h1>
  </div>
<%@ include file = "../common/footer.jspf"%>