package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExxecuteQuery {
	
	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver(); // take driver from mysql
		//step 1: register DB
		DriverManager.registerDriver(driverRef);
		//step 2:get the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Organizationdb", "root", "T#9758@qlph");
		//step 3: issue create statement
		Statement state = con.createStatement();
		//step 4: execute query
		ResultSet result = state.executeQuery("select * from orgainfo");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
		}
		//step 5: close db
		con.close();
	}

}
