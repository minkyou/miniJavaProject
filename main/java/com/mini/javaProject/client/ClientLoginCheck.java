package com.mini.javaProject.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ClientLoginCheck extends JFrame implements ActionListener{
	private static final long serialVersionUID = -9092293491752413287L;
	DBConnection dbc =DBConnection.getInstance();
	String userId = "";
	String userPw = "";
	UsersDTO usrDto;
	JTextField jf;
	
	public ClientLoginCheck(JTextField jf) {
		this.jf = jf;
	}
	
	public ClientLoginCheck(String userId) {
		this.userId = userId;
		System.out.println("입력된 userId: " + userId);
//		this.userPw = userPw;
	}
	
	public void actionPerformed(ActionEvent e) {
		userId = jf.getText();
		System.out.println(userId);
		
		this.setBounds(400, 100, 125, 68);
		this.setVisible(true);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel;
		
		try {
			usrDto = dbc.selectIdOne(userId);
//			System.out.println(usrDto);
			
			if(usrDto != null && usrDto.getId().equals(userId)) {
				lblNewLabel = new JLabel("있는 아이디입니다.");
				panel.add(lblNewLabel);
			} else {
				lblNewLabel = new JLabel("없는 아이디입니다.");
				panel.add(lblNewLabel);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
