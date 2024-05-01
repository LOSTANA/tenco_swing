package ch04;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	/*
	 * JLabel 이용햇허 이미지를 다룰 수 있다
	 * Jlabel.add();메서드를 통해서 이지를 겹칠 수 있다
	 * 좌표 기준으로 이미지를 셋팅을 할려면
	 * 배치관리자를  ㅜㅐ ㄴㄴㄴㄴ
	 */
	
	private JLabel backgroundMap;
	private JLabel player;

	public MyFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("JLable을 활용한 이미지 사용 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon icon = new ImageIcon("images/background1.png");// 업 캐스팅 상태
		backgroundMap = new JLabel(icon);
		
		backgroundMap.setSize(500,500);
		backgroundMap.setLocation(0, 0);
		
		player = new JLabel(new ImageIcon("images/image2.png"));
		player.setSize(100,100);
		player.setLocation(300, 100);
		
	}

	private void setInitLayout() {
		//좌표값으로 셋팅하기 위해서는 배치관리자를 null값으로 만들어주어야 한다
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(player);
		setVisible(true);
	}

}