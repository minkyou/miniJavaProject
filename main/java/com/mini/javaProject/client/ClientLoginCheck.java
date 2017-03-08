package com.mini.javaProject.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mini.javaProject.common.UsersDTO;;

// JDialog를 사용하여 부모프레임에 종속시킬 수 있다.
public class ClientLoginCheck extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	DBConnection dbc =DBConnection.getInstance();
	String userId = "";
	String userPw = "";
	UsersDTO usrDto;
	JTextField inputUserId;
	JTextField inputUserPw;
	JPanel panel;
	JLabel lblNewLabel = new JLabel("");
	
	Socket clientSocket;
	BufferedReader br;
	PrintWriter pw;
	
	ObjectOutputStream oos;
	
	public ClientLoginCheck() {
//		br = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));
//		pw = new PrintWriter(chatSocket.getOutputStream(), true);
	}

	
	public ClientLoginCheck(Socket clientSocket, JTextField inputUserId, JTextField inputUserPw) {
		try {
			this.clientSocket = clientSocket;
			this.inputUserId = inputUserId;
			this.inputUserPw = inputUserPw;
//			br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//			pw = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (Exception e) {
			// TODO: handle exception
			closeDialog();
		}
	}
	
	public ClientLoginCheck(JTextField inputUserId, JTextField inputUserPw) {
		this.inputUserId = inputUserId;
		this.inputUserPw = inputUserPw;
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//				stop();
//				System.exit(0);				// javaw.exe 종료
//				oos.close();
				closeDialog();
			}
		});
	}
	
//	public ClientLoginCheck(String userId) {
//		this.userId = userId;
//		System.out.println("입력된 userId: " + userId);
////		this.userPw = userPw;
//	}
	
	public void init() {
		this.setBounds(400, 100, 125, 68);
		this.setVisible(true);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		userId = inputUserId.getText();
		userPw = inputUserPw.getText();
		
//		System.out.println("actionPerformed:" + userId);
//		System.out.println("actionPerformed:" + userPw);
		
		// 170308 usrDto Setting
		usrDto = new UsersDTO();
		usrDto.setId(userId);
		usrDto.setPw(userPw);
		
//		System.out.println("클라이언트DTO:"+usrDto.toString());
		try {
			if(userId.equals("") || userPw.equals("")) {	// 입력데이터 누락
				openDialog("입력 데이터가 누락되었습니다.");
			} else {
//				pw.println(usrDto.toString());
				oos = new ObjectOutputStream(clientSocket.getOutputStream());
				System.out.println("ObjectOutputStream 생성, 할당");
				oos.writeObject(usrDto);
				oos.flush();
				oos.close();
				System.out.println("ObjectOutputStream 종료");
//				pw.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
//		System.out.println(userId);
		
//		init();
		
//		try {
//			usrDto = dbc.selectIdOne(userId, userPw);
//			System.out.println(usrDto);
//			
//			if(userId.equals("") || userPw.equals("")) {	// 입력데이터 누락
//				openDialog("입력 데이터가 누락되었습니다.");
//			} else if(usrDto != null) {						// 사용자가 존재한다면
////				login(usrDto.getId());						// 로그인
//				openDialog("이미 있는 아이디입니다.");
////				lblNewLabel.setText("이미 있는 아이디입니다.");
//////				lblNewLabel = new JLabel("이미 있는 아이디입니다.");
////				getContentPane().add(lblNewLabel);
//////				this.setSize(200, 100);
////				this.setBounds(400, 100, 200, 100);
////				this.setModal(true);
////				this.setVisible(true);
//			} else {
//				openDialog("없는 아이디입니다.");
////				lblNewLabel.setText("없는 아이디입니다.");
////				getContentPane().add(lblNewLabel);
//////				this.setSize(200, 100);
////				this.setBounds(400, 100, 200, 100);
////				this.setModal(true);
////				this.setVisible(true);
//			}
//			
//			// 추후 변경
////			if(usrDto != null && usrDto.getId().equals(userId)) {
////				// 
////				lblNewLabel = new JLabel("있는 아이디입니다.");
////				panel.add(lblNewLabel);
////			} else {
////				lblNewLabel = new JLabel("없는 아이디입니다.");
////				panel.add(lblNewLabel);
////			}
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
	}
	
	// Login to Messenger
	public void login(String userId) throws Exception {
		ClinetChat ccd = new ClinetChat(userId);
		// setBounds(int x, int y, int width, int height)
		ccd.setBounds(400, 100, 300, 600);
		ccd.setVisible(true);
	}
	
	// Dialog 호출하기
	public void openDialog(String alertMsg) {
		lblNewLabel.setText(alertMsg);
		getContentPane().add(lblNewLabel);
		this.setBounds(400, 100, 200, 100);
		this.setModal(true);
		this.setVisible(true);
	}
	
	// Dialog 종료하기
	public void closeDialog() {
//		lblNewLabel.setText("");
//		getContentPane().add(lblNewLabel);
//		this.setModal(false);
//		this.setVisible(false);
		
		// Returns the operation which occurs when the user initiates a "close" on this dialog.
		this.getDefaultCloseOperation();
	}
	
	public void sendMessageToServer() {
		
	}
}
