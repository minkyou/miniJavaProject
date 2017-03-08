package com.mini.javaProject.client;

import java.util.ArrayList;

//	Business Logic
public class SelectOneUserId {
	DBConnection dbc =DBConnection.getInstance();
	ArrayList<UsersDTO> usrList;
	UsersDTO usrDto;
	
	public SelectOneUserId(String userId) {
//		try {
//			usrDto = dbc.selectIdOne(userId);
//			System.out.println(usrDto); 	// toString()
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
//	public void selectOne() {
//		try{
//			eld = dbc.selectOne(108);
//			System.out.println(eld);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//	
//	public void select() {
//		try{
//			employeeList =  dbc.select();
//			for(EmployeesDTO employeesDTO : employeeList){
////				System.out.print(employeesDTO);
//				System.out.print(employeesDTO.getEmployee_id() + " ");
//				System.out.println(employeesDTO.getDepartment_id());
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}
}
