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
				chatManage.addChatThread(chatThread);
				chatThread.start();
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
