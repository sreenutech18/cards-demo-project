package com.citibank.rewards.balance.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallableTest {

	public static void main(String[] args)  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			String sql = "{call GetBalance(?,?,?,?)}";
			CallableStatement cs = connection.prepareCall(sql);

			cs.setString(1, "web");
			cs.setString(2, "05211140058239");
			
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);

			cs.execute();
			ResultSet rs = cs.executeQuery();
			System.out.println("ResultSet is:"+rs);
			while (rs.next()) {
				System.out.println(rs.getString(1) + "--" + rs.getString(2) + "--" + rs.getString(3));
			}

			System.out.println(cs.getString(3));
			System.out.println(cs.getString(4));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
