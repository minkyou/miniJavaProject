package com.mini.javaProject.client;

// Singleton
public class ClientIdCheck {

	// 프로그램 크기가 작을 때 > 클래스가 로드되는 시점에 인스턴스 생성
//	private static SingletonEdu sei = new SingletonEdu();
	private static ClientIdCheck clientIdCheck;
	
	// 생성자를 private으로 한다.
	private ClientIdCheck() {}

	// 장기간 사용X > JVM이 제거 > null을 리턴
	public static ClientIdCheck getInstance() {
		if(clientIdCheck == null) {
			clientIdCheck = new ClientIdCheck();
		}
		return clientIdCheck;
	}
	
	private void checkId() {
		
	}
}
