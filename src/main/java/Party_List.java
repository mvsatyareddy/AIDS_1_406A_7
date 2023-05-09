import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Base64;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.Session;


@WebServlet("/Party_List")
@MultipartConfig
public class Party_List  extends HttpServlet 
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out=res.getWriter();
		Part imagePart = req.getPart("bookimg");
		byte[] imageData = imagePart.getInputStream().readAllBytes();
		String encodedImage = Base64.getEncoder().encodeToString(imageData);
		int id=Integer.parseInt(req.getParameter("uid"));
		String bookname= (String)req.getParameter("bookname");

		String price=(String)req.getParameter("bookprice");
		try {
			Driver dob =new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(dob);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
			 PreparedStatement pstmt=con.prepareStatement("insert into books values(?,?,?,?)");
		    pstmt.setInt(1, id);
		    pstmt.setString(2,bookname);
		    pstmt.setString(3,price);
		    pstmt.setString(4,encodedImage);
		    pstmt.execute();
		    out.println("YOU HAVE SUCCESSFULLY ADDED A BOOK FOR SELLING");
		    con.close();
		    
		}
		catch(Exception e)
		{
			
		}
	}
}