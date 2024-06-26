package ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 단축키 습관 - ctrl + shift + s, f, o
public class BorderLayoutEx1 extends JFrame {

	// 생성자 만들기
	public BorderLayoutEx1() {

		initData();
		setInitLayout();
	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(600, 600);
		setVisible(true);
		// 프로그램 닫으면 종료해
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setInitLayout() {
		// 배치 관리자 선정
		// BorderLayout -- 컴포넌트들을 동서남북 가운데로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());
		add(new JButton("동"), BorderLayout.EAST);
		add(new JButton("서"), BorderLayout.WEST);
		add(new JButton("남"), BorderLayout.SOUTH);
		add(new JButton("북"), BorderLayout.NORTH);
		add(new JButton("센터"), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new BorderLayoutEx1();
	}

}
