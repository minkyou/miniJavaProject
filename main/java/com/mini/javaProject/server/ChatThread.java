package com.mini.javaProject.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import com.mini.javaProject.common.UsersDTO;

public class ChatThread extends Thread {
	Socket socket;
	PrintWriter pw;
	BufferedReader br;
	boolean flag;
	UsersDTO usrDto;
	ObjectInputStream ois;
	boolean oisCheck;
	StringTokenizer st;
	ServerDBConnection serverDbc = ServerDBConnection.getInstance();
	
	
	boolean flagObject;
	String[] arr;
	
	public ChatThread(Socket socket) {
		this.socket = socket;
//		initNetwork();		// 
	}
	
	public void initNetwork() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
//		"] 님이 퇴장하셨습니다."를 사용해도 무방하다.
		String endOfMsg = "!@#$";
//		System.out.println("run() 시작");
		
		
		try {
//			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			pw = new PrintWriter(socket.getOutputStream(), true);
			
			// 170308 ObjectInputStream
			// Hang문제 해결 방안 > ObjectOutputStream을 먼저 생성하도록 한다.
			while(!flagObject) {
				if(ois == null) {
					ois = new ObjectInputStream(socket.getInputStream());
					System.out.println("ObjectInputStream 생성, 할당");
					flagObject = true;
				}				
			}
			
			Object ob = ois.readObject();
			// 170308 server측 UsersDTO
			if(ob instanceof UsersDTO) {
				usrDto = (UsersDTO)ob;
			}
			
//				System.out.println(ob.toString());
//			} else {
//				ois.close();
//				System.out.println("ObjectInputStream 종료1");
//			}
//			ois.close();
//			System.out.println(usrDto.getId());
//			System.out.println(usrDto.getPw());
			
			// ID, PW 확인
			if(serverDbc.userSelectOne(usrDto.getId(), usrDto.getPw())) {
				System.out.println("기존 유저");
			} else {
				System.out.println("아이디, 패스워드 불일치");
//				ois = new ObjectInputStream(socket.getInputStream());
				ois.close();
				System.out.println("ObjectInputStream 종료2");
				if(ois == null) {
					System.out.println("현재 ois는 null");
				}
//				this.resume();
			}
			
			
			
			
			
			
//			Object obj;
//			while(!oisCheck) {
//				System.out.println(ois.readObject());
////				arr = obj.toString().split(", ");
////				usrDto = (UsersDTO)obj;
////				System.out.println(usrDto.getId());
//			}
			
//			while(!flag) {
//				String msg = br.readLine();
////				
//				if(msg != null && !msg.equals("")) {
//					if(msg.endsWith(endOfMsg)) {
//						ChatServerMain.chatManage.removeChatThread(this);
//						msg = msg.substring(0, msg.length() - 5);
//						socket.close();
//						br.close();
//						pw.close();
//						flag = true;
//					}
////					System.out.println(msg);
//					arr = msg.split(", ");
//					for(String i:arr) {
//						System.out.println(i);
//					}
////					ChatServerMain.chatManage.sendAllMessage(msg);
//				}
				
				
//				usrDto = new UsersDTO();
//				Object obj;
//				while(!oisCheck) {
//					System.out.println(ois.readObject());
////					arr = obj.toString().split(", ");
////					usrDto = (UsersDTO)obj;
////					System.out.println(usrDto.getId());
//				}
				
//				usrDto = (UsersDTO)oj;
//				System.out.println(usrDto.toString());
//				System.out.println("-------------------------");
//				System.out.println(usrDto.getPw());
//				if(usrDto != null) {
//				}
				// 일시막음
//				String msg = br.readLine();
//				
//				if(msg != null && !msg.equals("")) {
//					if(msg.endsWith(endOfMsg)) {
//						ChatServerMain.chatManage.removeChatThread(this);
//						msg = msg.substring(0, msg.length() - 5);
//						socket.close();
//						br.close();
//						pw.close();
//						flag = true;
//					}
//					System.out.println(msg);
//					ChatServerMain.chatManage.sendAllMessage(msg);
//				}
//			}
		} catch (Exception e) {
			try {
//				if(br != null) br.close();
//				if(pw != null) pw.close();
				if(ois != null) ois.close();
				if(socket != null) socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
//			oisCheck = false;
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String msg) {
		pw.println(msg);
	}
//	
//	public void checkUserOne(String userId, String userPw) throws Exception {
//		
//	}
}
