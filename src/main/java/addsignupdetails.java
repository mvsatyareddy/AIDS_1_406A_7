import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adddetails")
public class addsignupdetails  extends HttpServlet 
{
	

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int id=Integer.parseInt(req.getParameter("uid"));
		String email= (String)req.getParameter("email");
		String password=(String)req.getParameter("pswd");
		PrintWriter out=res.getWriter();
		try {
			Driver dob =new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(dob);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
			 PreparedStatement pstmt=con.prepareStatement("insert into users values(?,?,?)");
	        pstmt.setInt(1, id);
	        pstmt.setString(2, email);
	        pstmt.setString(3, password);
	        pstmt.execute();
			RequestDispatcher rd =req.getRequestDispatcher("login.html");
			rd.forward(req, res);
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}