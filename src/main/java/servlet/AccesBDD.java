package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(name="accesBDD",
urlPatterns={"/AccesBDD"})
public class AccesBDD extends HttpServlet{

	 public void doPost(HttpServletRequest request,HttpServletResponse response)
     throws ServletException, IOException
	 {
		 response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
		 final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
		 final String DB_URL="jdbc:mysql://localhost:3306/base_sirtp2";
		 final String USER = "root";
		 final String PASS = "";
	     
	      String title = "Résultat :";
	      out.println("<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<h1 align=\"center\">" + title + "</h1>\n");
	      try{
	         
	         Class.forName(JDBC_DRIVER);	        
	         Connection con = DriverManager.getConnection(DB_URL,USER,PASS);	         
	         Statement stmt = con.createStatement();
	         String sql;
	         sql = "SELECT id, name FROM utilisateur";
	         ResultSet rs = stmt.executeQuery(sql);
	         while(rs.next()){
	             int id  = rs.getInt("id");
	             String name = rs.getString("name");	             
	             out.println("ID: " + id);
	             out.println("nom: " + name);
	          }
	         out.println("</body></html>");
	         rs.close();
	         stmt.close();
	         con.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }catch(Exception e){	     
	         e.printStackTrace();
	      }
	      }	 
}

