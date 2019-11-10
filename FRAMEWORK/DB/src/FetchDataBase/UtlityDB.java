package FetchDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtlityDB {
	public static final String url = "jdbc:mysql://localhost:3306/equifax";
	public static final String Username = "root";
	public static final String password = "bhupunbabu";
	static Connection con;
	static Statement st;
	static ResultSet resuletSet;

	public static Connection createconnection() throws SQLException {
		con = DriverManager.getConnection(url, Username, password);
		return con;
	}

	public static Statement createStatement(Connection con) throws SQLException {
		st = con.createStatement();
		return st;
	}

	public static ResultSet Fetch(Statement st) throws SQLException {
		resuletSet = st.executeQuery("select * from emp where ename='SMITH'");
		return resuletSet;
	}

	public static void main(String[] args) throws SQLException {
		@SuppressWarnings("unused")
		Connection smt = UtlityDB.createconnection();
		Statement smt1 = UtlityDB.createStatement(con);
		ResultSet rs = UtlityDB.Fetch(smt1);
		try {
			while (rs.next()) {
				int empno = rs.getInt(1);
				String Ename = rs.getString(2);
				String job = rs.getString(3);
				String mgr = rs.getString(4);
				String hiredate = rs.getString(5);
				String sal = rs.getString(6);
				String comm = rs.getString(7);
				String deptno = rs.getString(3);

				System.out.println(empno + " " + Ename + " " + job + " " + mgr + " " + hiredate + " " + sal + " " + comm
						+ " " + deptno);
			}
		} finally {
			rs.close();
		}
	}
}
