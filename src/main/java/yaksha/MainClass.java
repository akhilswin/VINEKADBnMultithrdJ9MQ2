package yaksha;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner in = new Scanner(System.in);
		ContactDAO cdao = new ContactDAO();
		ContactBO cbo = new ContactBO();
		Connection con = ContactDAO.getConnection();
		System.out.println("Updating The PhoneNumber of the Contact");
		System.out.println("Enter The FirstName of the Contact to update his PhoneNumber");
		String fname = in.nextLine();
		System.out.println("Before the update");
		cbo.display(con, fname);
		System.out.println("Enter The PhoneNumber of the Contact");
		String phoneNo = in.nextLine();
		System.out.println("After the update");
		cbo.updateRecord(fname, phoneNo, con);
		cbo.display(con, fname);
		cdao.closeConnection();
		in.close();
	}
}
