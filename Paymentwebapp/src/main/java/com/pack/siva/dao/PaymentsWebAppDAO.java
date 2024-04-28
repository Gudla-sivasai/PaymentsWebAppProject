package com.pack.siva.dao;

import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentsWebAppDAO {

	public static void storeUserDetails(String userName, String fName, String lName, String email, String phNo,
			Date dob, String address, String pswd) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentwebapp", "root",
					"root");
			Statement st = con.createStatement();
			String storeUserDetailsQuery = "insert into User_info(User_Name, First_Name, Last_Name, Email_Id, Phone_Number, Date_Of_Birth, Address, Password) "
					+ "values('" + userName + "','" + fName + "','" + lName + "','" + email + "','" + phNo + "','" + dob
					+ "','" + address + "','" + pswd + "')";

			int rs = st.executeUpdate(storeUserDetailsQuery);
			System.out.println(rs + "row/s effected.\n");

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean loginValidate(String userNameOrPhoneNo, String password) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paymentwebapp", "root",
					"root");
			Statement st = con.createStatement();
			String loginValidateQuery = "SELECT User_Name, Phone_Number, Password FROM user_info WHERE ((User_Name = '"
					+ userNameOrPhoneNo + "' || Phone_Number = '" + userNameOrPhoneNo + "') && Password ='" + password
					+ "')";
			ResultSet rs = st.executeQuery(loginValidateQuery);
			while (rs.next()) {
				System.out.println("Login Successfull !!");
			}
			con.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
