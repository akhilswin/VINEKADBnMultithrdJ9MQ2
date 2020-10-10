package yaksha;

import static yaksha.TestUtils.businessTestFile;
import static yaksha.TestUtils.currentTest;
import static yaksha.TestUtils.yakshaAssert;
import java.sql.Connection;
import java.sql.ResultSet;
import org.junit.jupiter.api.Test;

class MainClassTest {

	@Test
	public void testExceptionConditon() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.exceptionTestFile);
	}

	@Test
	public void testBoundaryCondition() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.boundaryTestFile);
	}

	@Test
	void testDisplay() throws Exception {
		// Test will pass
		ContactDAO cdao = new ContactDAO();
		ContactBO cbo = new ContactBO();
		Connection con = ContactDAO.getConnection();
		ResultSet resultset = null;
		String fname1;
		String lname1;
		String email1;
		String phoneNo1;
		String stringExpected = "Rajesh Singh rajesh@gmail.com 9898765432";
		String stringResult = null;
		String fname = "Rajesh";
		String phoneNo = "9898765432";
		cbo.updateRecord(fname, phoneNo, con);
		resultset = cbo.display(con, fname);
		fname1 = resultset.getString("firstName");
		lname1 = resultset.getString("lastName");
		email1 = resultset.getString("email");
		phoneNo1 = resultset.getString("phoneNo");
		stringResult = fname1 + " " + lname1 + " " + email1 + " " + phoneNo1;
		yakshaAssert(currentTest(), (stringExpected.equals(stringResult) ? "true" : "false"), businessTestFile);
		cdao.closeConnection();
	}
}
