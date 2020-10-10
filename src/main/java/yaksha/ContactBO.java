package yaksha;

import java.sql.*;

public class ContactBO {
	public static PreparedStatement pStatement;

	public void insertRecord(Contact contact, Connection connection) {
		try {
			String query = "insert into contact(firstName,lastName,email,phoneNo) values (?,?,?,?)";
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, contact.firstName);
			pStatement.setString(2, contact.lastName);
			pStatement.setString(3, contact.email);
			pStatement.setString(4, contact.phoneNo);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateRecord(String fname, String phoneNo, Connection connection) {
		try {
			String query = "update contact set phoneNo=? where firstName=?";
			pStatement = connection.prepareStatement(query);
			pStatement.setString(2, fname);
			pStatement.setString(1, phoneNo);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet display(Connection con, String fName1) {
		ResultSet resultset = null;
		String fname;
		String lname;
		String email;
		String phoneNo;
		String query = "select firstName,lastName,email,phoneNo from contact where firstName='" + fName1 + "'";
		try {
			pStatement = con.prepareStatement(query);
			resultset = pStatement.executeQuery(query);
			System.out.format("%-15s %-15s %-30s %-15s\n", "FirstName", "LastName", "Email", "PhoneNumber");
			resultset.next();
			fname = resultset.getString("firstName");
			lname = resultset.getString("lastName");
			email = resultset.getString("email");
			phoneNo = resultset.getString("phoneNo");
			System.out.format("%-15s %-15s %-30s %-15s\n", fname, lname, email, phoneNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultset;
	}
}