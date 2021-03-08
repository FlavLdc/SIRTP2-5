package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(name="insertBDD",
urlPatterns={"/InsertBDD"})
public class InsertBDD extends HttpServlet{
	 public void doPost(HttpServletRequest request,HttpServletResponse response)
		     throws ServletException, IOException
			 {
				 response.setContentType("text/html");
			     PrintWriter out = response.getWriter();
				 final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
				 final String DB_URL="jdbc:mysql://localhost:3306/base_sirtp2";
				 final String USER = "root";
				 final String PASS = "";
			     String id = request.getParameter("id");
			     String name = request.getParameter("name");
			      try{
			         
			         Class.forName(JDBC_DRIVER);	        
			         Connection con = DriverManager.getConnection(DB_URL,USER,PASS);	         
			         String sql;
			         sql = "INSERT INTO utilisateur(id,name) values(?,?)";
			         PreparedStatement pstmt = con.prepareStatement(sql);
			         pstmt.setString(1,id);
			         pstmt.setString(2,name);
			         ResultSet rs = pstmt.executeQuery(sql);
			         rs.close();
			         pstmt.close();
			         con.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }catch(Exception e){	     
			         e.printStackTrace();
			      }
			      
		}


}
