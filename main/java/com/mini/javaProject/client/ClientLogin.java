package com.mini.javaProject.client;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientLogin extends JFrame {
	private static final long serialVersionUID = 4849985493479885708L;
	private JTextField inputUserId;
	private JTextField inputUserPw;

//	BufferedReader br;
//	PrintWriter pw;
	Socket clientSocket;
	
	boolean flag;
	
	public ClientLogin() {
		connect();		// Socket
		design();
//		new Thread(this).start();
		
		// 익명클래스 > 이벤트 발생 시에만 메모리에 올라간다.
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//				stop();
//				System.out.println("로그인창 종료");
				disconnect();
				System.exit(0);				// javaw.exe 종료
			}
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				inputUserId.requestFocus();
			}
		});
	}
	
	// 화면 구성
	public void design() {
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		inputUserId = new JTextField();
		panel.add(inputUserId);
		inputUserId.setColumns(12);
		
		inputUserPw = new JTextField();
		panel.add(inputUserPw);
		inputUserPw.setColumns(12);
		
		JButton btnLogin = new JButton("로그인");
		panel.add(btnLogin);
		
		JButton btnJoin = new JButton("회원가입");
		panel.add(btnJoin);
		
		// 로그인 버튼 클릭 > Id / Pw 체크
//		System.out.println(inputUserId.getText());
		btnLogin.addActionListener(new ClientLoginCheck(clientSocket, inputUserId, inputUserPw));
		
		// 회원가입 버튼 클릭 > 회원가입 창 띄우기 > 서버로 데이터 넘기기
//		btnJoin.addActionListener(new ClientJoin);
	}

	
	// 소켓 연결
	public void connect() {
		try {
			clientSocket = new Socket("127.0.0.1", 8889);
//			br = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));
//			pw = new PrintWriter(chatSocket.getOutputStream(), true);
		} catch (Exception e) {
			System.out.println("연결 실패");
			System.exit(0);
		}
//		this.sendMessage("["+nickName+"] 님이 입장하셨습니다.");
	}
	
	// 소켓 해제
	public void disconnect() {
		try {
//			if(br != null) br.close();
//			if(pw != null) pw.close();
			if(clientSocket != null) clientSocket.close();
			System.out.println("clientSocket 종료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void run() {
//		// TODO Auto-generated method stub
//		
//	}
}
