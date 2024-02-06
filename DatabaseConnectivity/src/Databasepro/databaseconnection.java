package Databasepro;

import java.sql.*;

public class databaseconnection {

	public static void main(String[] args)
	{
		
		Connection connect;
		String dbURL = "jdbc:mysql://127.0.0.1:3306/gadgetsgallery";
		String username = "root";
		String password = "";
		String driver = "com.mysql.jdbc.Driver";
		
		try 
		{
		
			Class.forName(driver).newInstance();
			connect = DriverManager.getConnection(dbURL,username,password);  //Database Connection will be established
			
			System.out.println("--------------------Statement----------------------");
			
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery("select * from manufacturers where manufacturers_id = 13");
			
			while(rs.next())
			{
				System.out.println(rs.getString("manufacturers_id")+"--"+rs.getString("manufacturers_name"));
			}
				
			System.out.println("--------------------Prepared Statement----------------------");

			PreparedStatement pst = connect.prepareStatement("select * from manufacturers where manufacturers_id=? or manufacturers_name=?");
			
			pst.setString(1, "14");
			pst.setString(2, "Samsung");
			
			ResultSet rs1 = pst.executeQuery();
			
			while(rs1.next())
			{
				System.out.println(rs1.getString("manufacturers_id")+"--"+rs1.getString("manufacturers_name"));
			}
			
			System.out.println("----------------------------------------------------------");

			pst.setString(1, "15");
			pst.setString(2, "Apple");
			
			rs1 = pst.executeQuery();
			
			while(rs1.next())
			{
				System.out.println(rs1.getString("manufacturers_id")+"--"+rs1.getString("manufacturers_name"));
			}
			
			
			
			
		}catch(Exception e)
		{
			
			
		}
		
		
		
	}
}
