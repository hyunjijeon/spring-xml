<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring-xml Board</title>
</head>
<body>
    <h2>spring-xml Board</h2>

    <div style="border:1px solid;display: flex;">
        <div style="width: 30%; border: 1px solid; padding:10px;">
            <h3>list 조회</h3>
            <table border="1">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                </tr>
                <!-- forEach 문은 리스트 객체 타입을 꺼낼때 많이 활용된다. -->
                <c:forEach var="row" items="${list}">
                <tr>
                    <!-- 컨트롤러에서 넘겨준 list 모델 객체를 쓰는 방법을 잘 익혀두자 -->
                    <td>${row.bNo}</td>
                    <td>${row.title}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <div style="width: 20%; border: 1px solid; padding:10px;">
            <h3>insert</h3>
            <form name="insertform" method="POST" action="${pageContext.request.contextPath}/board/insert">
                <div style="display: flex;">
                    <div style="width: 50%">
                        <label for="insert_bno">번호</label>
                        <input type="text" id="insert_bno" name="bNo">     
                    </div>
                    <div style="width: 50%">
                        <label for="insert_title">제목</label>
                        <input type="text" id="insert_title" name="title">
                    </div>
                </div>
                <button type="submit">Insert</button>
            </form>
        </div>
        <div style="width: 20%; border: 1px solid; padding:10px;">
            <h3>update</h3>
            <form name="updateform" method="POST" action="${pageContext.request.contextPath}/board/update">
                <div style="display: flex;">
                    <div style="width: 50%">
                        <label for="update_bno">번호</label>
                        <input type="text" id="update_bno" name="bNo">     
                    </div>
                    <div style="width: 50%">
                        <label for="update_title">제목</label>
                        <input type="text" id="update_title" name="title">
                    </div>
                </div>
                <button type="submit">Update</button>
            </form>
        </div>
        <div style="width: 20%; border: 1px solid; padding:10px;">
            <h3>delete</h3>
            <form name="deleteform" method="POST" action="${pageContext.request.contextPath}/board/delete">
                <label for="delete_bno">번호</label>
                <input type="text" id="delete_bno" name="bNo">     
                <button type="submit">Delete</button>
            </form>
        </div>
    </div>

</body>
</html>
