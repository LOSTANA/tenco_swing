package ch03;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 중첩 클래스 --> 외부,내부 클래스로
 * 내부 클래스로 --> 인스턴스 클래스, static 클래스
 */

public class MyImageFrame extends JFrame {
	// 내부 클래스로 정의한 데이터 타입니다
	private MyImagePanel myImagePanel;

	public MyImageFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("이미지 활용 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myImagePanel = new MyImagePanel();
	}

	private void setInitLayout() {
		add(myImagePanel);
		setVisible(true);
	}

	// 내부 클래스 --> static 키워드 활용가능
	// 정적(static) 내부 클래스
	static class MyImagePanel extends JPanel {
		private Image image;
		private Image image2;
		private Image image3;

		public MyImagePanel() {
			// ImageIcon 데이터 타입 -> getImage() 메서드를 호출하면
			// Image 데이터 타입을 만들어 낼 수 있다
			JLabel label = new JLabel();
			image = new ImageIcon("image1.png").getImage();
			image2 = new ImageIcon("image2.png").getImage();
			ImageIcon image3 = new ImageIcon("image3.gif");
			label.setIcon(image3);
			label.setBounds(400,100,100,100);
			add(label);
			

		}

		// paints --> x
		// print --> x
		// paint --> o
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(image, 100, 100, 100, 100, null);
			g.drawImage(image2, 300, 300, 300, 300, null);
		
		}
	}

}
