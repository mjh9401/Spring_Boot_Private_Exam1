<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/header.jspf" %>

<section class="mt-5">
  <div class="container mx-auto px-3">
   <form class="table-box-type-1" method="post" action="../article/domodify">
    <input type="hidden" name = "articleId" value= "${article.id}" />
      <table class="table w-screen">
        <colgroup>
          <col width="200" />
        </colgroup>
        <tbody>
          <tr>
            <th>번호</th>
            <td>
              <div class = "badge badge-primary">${article.id}</div>
            </td>
          </tr>
          <tr>
            <th>작성날짜</th>
            <td>${article.regDate}</td>
          </tr>
          <tr>
            <th>수정날짜</th>
            <td>${article.updateDate}</td>
          </tr>
          <tr>
            <th>작성자</th>
            <td>${article.loginId}</td>
          </tr>
          <tr>
            <th>제목</th>
            <td>
               ${article.title}
            </td>
          </tr>
          <tr>
            <th>내용</th>
            <td>
              <textarea name="body" class="w-full" rows="10">${article.body}</textarea> 
            </td>
          </tr>
          <tr>
            <th>수정</th>
            <td>
              <input type="submit" value="수정" />
              <button type="button" onclick="history.back();">뒤로가기</button>
            </td>
          </tr>
        </tbody>
      </table>
     </form>
  </div>
</section>
 
<%@ include file = "../common/footer.jspf"%>