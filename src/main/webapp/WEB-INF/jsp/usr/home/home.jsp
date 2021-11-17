<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ include file = "../common/header.jspf" %>
<style>
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
        <a class="menu cell" href="#">공지게시판</a>
      </div>
      <div>
        <a class="menu cell" href="#">자유게시판</a>
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