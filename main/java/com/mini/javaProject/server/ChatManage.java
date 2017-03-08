/**
 * ChatManage.java
 * Ŭ���̾�Ʈ�� �����ϴ� Ŭ����
 * @Date 2017. 2. 22.
 */
package com.mini.javaProject.server;

import java.util.Iterator;
import java.util.Vector;

public class ChatManage extends Vector<ChatThread> {

	private static final long serialVersionUID = 1L;

	// Login 전 접속 대기자
	public synchronized void addBeforeLoginThread(ChatThread thread) {
		this.add(thread);
		System.out.println("[서버]: " + this.size() + "명 접속 대기 중입니다.");
	}
	
	// Login 후
	public synchronized void addChatThread(ChatThread thread) {
		this.add(thread);
		System.out.println("[서버]: " + this.size() + "명 접속해있습니다.");
	}
	
	public synchronized void removeChatThread(ChatThread thread) {
		this.remove(thread);
		System.out.println("[서버]: " + this.size() + "명 접속해있습니다.");
	}	

	// Message Broadcasting
	public synchronized void sendAllMessage(String msg) {
		Iterator<ChatThread> iterator= this.iterator();
		
		while(iterator.hasNext()) {
			ChatThread chatThread = iterator.next();
			chatThread.sendMessage(msg);
		}
	}
}
