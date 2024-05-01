package ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing -> 배치 관리자 : FlowLayout
// 컴포넌트들을 (버츤, 라벨) 등을 수평, 수직으로 배치를 해주는 클래스이다.
public class FlowLayoutEx2 extends JFrame {
	
	// 배열 활용 - 하나의 변수로 여러개 통으로 관리하고 싶다면 배열을 써보자.
	private JButton[] buttons;
	

	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 생성자에서 메서드 호출 가능하다.
		initData();
		setIniLayout();

	}

	// 멤버 변수를 초기화 하는 기능 (값을 넣다)
	public void initData() {
		
		buttons = new JButton[6];  		//공간만 선언   [][][][][][]
								   // 인덱스 번호를 활용 0 1 2 3 4 5
		// 반복문
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("button" + (i + 1)); // 인덱스 번호가 0부터 시작하기에 +1함 
		}

	}

	// 컴포넌트들을 배치하는 기능
	public void setIniLayout() {
		// 배치 관리자 --> BorderLayout 이라는 배치관리자가 기본으로 활용 된다.
		// FlowLayout flowLayout = new FlowLayout();
		// super.setLayout(flowLayout); // 배치 관리자 --> FlowLayout

		// 배치 관리자 생성 및 JFrame 셋팅
		super.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50)); // 배치 관리자 --> FlowLayout

		// 컴포넌트들을 붙이다.
		// 반복문
		for (int i = 0; i < buttons.length; i++) {
			super.add(buttons[i]);
		}

	}

	// 코드 테스트
	public static void main(String[] args) {
		// FlowLayoutEx f1 = new FlowLayoutEx(); // <--- 부를 수 있는 이름이 있는 상태

		// 다시 접근해서 사용할 일 없으면
		new FlowLayoutEx2(); // <--- 익명 클래스

	} // end of main

} // end of class
