package dbConnection;

import java.sql.*;

public class CheckRecord {

	public static void main(String[] args) {

		Connection connect;
		String dbURL = "jdbc:mysql://127.0.0.1:3306/gadgetsgallery";
		String username = "root";
		String password = "";
		String driver = "com.mysql.jdbc.Driver";
		
		try 
		{
		
			Class.forName(driver).newInstance();
			connect = DriverManager.getConnection(dbURL,username,password);  //Database Connection will be established
		
			Statement st = connect.createStatement();	
			ResultSet rs = st.executeQuery("select * from manufacturers");
			
			while(rs.next())
			{
				String manuName = rs.getString("manufacturers_name");
				
				if(manuName.equalsIgnoreCase("Panasonic"))
				{
					System.out.println("Panasonic is present in the list");
				}
				
			}
				
		
		}catch(Exception e)
		{
			
		}
	}

}
