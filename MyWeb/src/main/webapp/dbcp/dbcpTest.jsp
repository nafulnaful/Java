<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.naming.*,javax.sql.*,java.sql.*" %>
<jsp:include page="/top.jsp"  />

   <h1 class="text-center text-secondary">DBCP Test</h1>
   <%
   Context initContext = new InitialContext();
   Context envContext  = (Context)initContext.lookup("java:/comp/env");
   //Tomcat을 먼저 찾는다. 톰캣을 찾을 때는 java:/comp/env
   DataSource ds = (DataSource)envContext.lookup("myoracle/tis_shop");
   Connection conn = ds.getConnection();
   out.println("<h1>DBCP 룩업 성공: "+ds+" </h1>");
   out.println("<h2>con: "+conn+" </h2>");
   
   String sql="select * from tab";
   PreparedStatement ps=conn.prepareStatement(sql);
   ResultSet rs=ps.executeQuery();
   
   while(rs.next()){
	   String tname=rs.getString(1);
	   String type=rs.getString(2);
	   %>
	   <h3><%=tname %> : <%=type %></h3>
	   <%
   }
   
   conn.close();
   //DBCP는 con.close()를 호출하면 con을 끊는것이 아니라 풀에 반납을 한다.
   
   %>
<jsp:include page="/foot.jsp"  />