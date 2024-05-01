package ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 단축키 습관 - ctrl + shift + s, f, o
public class BorderLayoutEx2 extends JFrame {
	final int WIDTH = 600;
	final int HEIGHT = 600;

	JButton[] buttons;
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH, BorderLayout.NORTH,
			BorderLayout.CENTER };

	// 생성자 만들기
	public BorderLayoutEx2() {

		initData();
		setInitLayout();
	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		// 프로그램 닫으면 종료해
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttons = new JButton[directions.length];

	}

	public void setInitLayout() {
		// 배치 관리자 선정
		// BorderLayout -- 컴포넌트들을 동서남북 가운데로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());

		for (int i = 0; i < directions.length; i++) {
			add(new JButton(directions[i]), directions[i]);
		}
	}

	public static void main(String[] args) {
		new BorderLayoutEx2();
	}

}
