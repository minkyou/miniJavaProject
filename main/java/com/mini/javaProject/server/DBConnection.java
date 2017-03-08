package com.mini.javaProject.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	private static DBConnection dbc = new DBConnection();	// Singleton1
	PreparedStatement pstmt;
	Connection con;
	ResultSet rs;
	UsersDTO usrDto;
//	EmployeesDTO eld;
//	ArrayList<EmployeesDTO> employeeList;
	
	private DBConnection() {
		
	}

	public static DBConnection getInstance() {				// Singleton2
		if(dbc == null) {
			dbc = new DBConnection();
		}
		return dbc;
	}
	
	private Connection getConnection() throws Exception {	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = DriverManager.getConnection(url, "Kyou", "1234");
		return conn;
	}
	
//	public ArrayList<EmployeesDTO> select() throws Exception {
//		con = this.getConnection();
//		pstmt = con.prepareStatement("select * from EMPLOYEES");		
//		rs = pstmt.executeQuery();		
//		employeeList = new ArrayList<>();
//		
//		while(rs.next()) {
//			eld = new EmployeesDTO();
//			eld.setEmployee_id(rs.getInt("employee_id"));
//			eld.setFirst_name(rs.getString("first_name"));
//			eld.setLast_name(rs.getString("last_name"));
//			eld.setEmail(rs.getString("email"));
//			eld.setPhone_number(rs.getString("phone_number"));
//			eld.setHire_date(rs.getTimestamp("hire_date"));
//			eld.setJob_id(rs.getString("job_id"));
//			eld.setSalary(rs.getInt("salary"));
//			eld.setCommission_pct(rs.getInt("commission_pct"));
//			eld.setManager_id(rs.getInt("manager_id"));
//			eld.setDepartment_id(rs.getInt("department_id"));
//			employeeList.add(eld);
//		}		
//		
//		streamClose();
//		return employeeList;
//	}
//	
	public UsersDTO checkUserOne(String userId, String userPw) throws Exception {
		con = this.getConnection();
		pstmt = con.prepareStatement("SELECT id, pw FROM users WHERE id = ? and pw = ?");
		pstmt.setString(1, userId);
		pstmt.setString(2, userPw);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			usrDto = new UsersDTO();
			usrDto.setId(rs.getString("id"));
			usrDto.setPw(rs.getString("pw"));
			System.out.println("DBC 쪽: "+usrDto);
		}
		
		streamClose();
		
		return usrDto;
	}
	
	public UsersDTO selectOne(String userId, String userPw) throws Exception {
		con = this.getConnection();
		pstmt = con.prepareStatement("SELECT id, pw FROM users WHERE id = ? and pw = ?");
		pstmt.setString(1, userId);
		pstmt.setString(2, userPw);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			usrDto = new UsersDTO();
			usrDto.setId(rs.getString("id"));
			usrDto.setPw(rs.getString("pw"));
			System.out.println("DBC 쪽: "+usrDto);
		}
		
		streamClose();
		
		return usrDto;
	}
//	
//	public int insert(EmployeesDTO eld) throws Exception {
//		con = this.getConnection();
//		StringBuffer query = new StringBuffer();
//		query.append("insert into employees ");
//		query.append("values(employees_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?,");
//		query.append("null, ?, ?)");
//		
//		pstmt = con.prepareStatement(query.toString());
//		pstmt.setString(1, eld.getFirst_name());
//		pstmt.setString(2, eld.getLast_name());
//		pstmt.setString(3, eld.getEmail());
//		pstmt.setString(4, eld.getPhone_number());
//		pstmt.setString(5, eld.getJob_id());
//		pstmt.setInt(6, eld.getSalary());
//		pstmt.setInt(7, eld.getManager_id());
//		pstmt.setInt(8, eld.getDepartment_id());
//		
//		int result = pstmt.executeUpdate();
//		streamClose();
//		return result;
//	}
	
	public void streamClose() {
		try{
			if(rs != null){
				rs.close();
			}
			pstmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
