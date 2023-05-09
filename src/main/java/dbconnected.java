import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class dbconnected {

	public static void main(String[] args) throws Exception
	{
		try
		{
			Driver dob =new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(dob);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
			if(con!=null)
			{
				System.out.println("Connected");
			}
			else
			{
				System.out.println("DB Not Connected");
			}
		}
		catch(Exception e)
		{
			
		}

	}

}
