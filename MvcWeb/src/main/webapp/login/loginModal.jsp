<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal Dialog------------------------ -->
        <div class="modal" id="loginModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="text-primary" style="margin:auto">Login Page</h4>
                        <button class="close" data-dismiss="modal">&times;</button>
                    </div>
					<%-- cookie.키.value --%>
                    <!-- Modal Body -->
                    <div class="modal-body">
                        <form action="${pageContext.request.contextPath}/login.me" method="post">
                        <div class="form-group">
                            <label for="userid">User ID:</label>
                            <input type="text" autofocus="autofocus" 
                            class="form-control" name="userid" 
                            value="${cookie.uid.value}"
                            id="userid" placeholder="User ID">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Password:</label>
                            <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Password">
                        </div>
                        <div class="form-group form-check">
                            <label for="saveId" class="form-check-label">
                                <input type="checkbox" class="form-check-input" 
                                	<c:if test="${cookie.uid ne null}">
                                		checked
                                	</c:if>
                                name="saveId" id="saveId">아이디 저장
                            </label>
                        </div>
                        <div class="form-group text-right">
                            <button class="btn btn-primary">Login</button>
                            <button class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>

                        </form>
                    </div>

                    <!-- Modal Footer 
                    <div class="modal-footer">
                        <button class="btn btn-primary">Login</button>
                            <button class="btn btn-danger" data-dismiss="modal">Close</button>
                    </div>
                    -->
                </div>
            </div>
        </div>
        <!-- -------------------------------- -->