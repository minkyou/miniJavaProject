/**
 * ChatServerMain.java
 * ä�� ���� Main Ŭ����
 * @Date 2017. 2. 22.
 */
package com.mini.javaProject.server;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerMain {

	private ServerSocket serverSocket;
	private Socket socket;
	static ChatManage chatManage = new ChatManage();
	
	public void startServer() {
		try {
			serverSocket = new ServerSocket(8889);
			while(true) {
				System.out.println("서버 대기중");
				socket = serverSocket.accept();
				ChatThread chatThread = new ChatThread(socket);
				chatManage.addBeforeLoginThread(chatThread);	// 로그인창 접속
				System.out.println("chatThread.start()");
				chatThread.start();
//				chatManage.addChatThread(chatThread);			// 채팅창 접속
//				chatThread.start();								// 채팅창 접속 후 while()
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ChatServerMain chatServer = new ChatServerMain();
		chatServer.startServer();
	}
	
}
