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
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


@WebServlet("/logindetailsver")
public class userdetailsverification  extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int id=Integer.parseInt(req.getParameter("uid"));
		String email= (String)req.getParameter("email");
		String password=(String)req.getParameter("pswd");
		PrintWriter out=res.getWriter();
		HttpSession s = req.getSession();
		try {
			
		    Driver dob=new oracle.jdbc.driver.OracleDriver();
		    DriverManager.registerDriver(dob);
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
		    PreparedStatement pstmt=con.prepareStatement("select * from users where id=?");
		    
		    pstmt.setInt(1, id);

			ResultSet rs=pstmt.executeQuery();

			String mail="";
			String pass="";
				
			while(rs.next()) //return type is T/False
			{
				mail=(String)rs.getString("email");
				pass=(String)rs.getString("PASSWORD");
			}
			
			
			if(stringCompare(mail,email)==0 && stringCompare(pass,password)==0)
			{
				
				res.sendRedirect("sellorbuy.jsp?user_id="+id);
//				RequestDispatcher rd =req.getRequestDispatcher("queryanswering.jsp");
//				s.setAttribute("user_id",id);
//				res.sendRedirect("queryanswering.jsp");
//				rd.forward(req, res);
//				out.println("WELCOME");
			}
			else
			{
				out.println("YOU HAVE NOT SIGNEDUP");
			}
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static int stringCompare(String str1, String str2)
    {
  
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
  
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);
  
            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
  
        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (l1 != l2) {
            return l1 - l2;
        }
  
        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }
}