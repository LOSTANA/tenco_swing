package ch02;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

//내부 클래스를 활용해서 코드를 완성해주세요
public class PaintFrame extends JFrame {

	Drawing drawing;

	public PaintFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {

		drawing = new Drawing();
		setTitle("낙서장");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setInitLayout() {
		add(drawing);
		setVisible(true);

	}

	class Drawing extends JPanel {

		@Override
		public void paint(Graphics g) {
			super.paint(g);

			g.setFont(new Font("돋움", Font.BOLD, 30));
			g.setColor(new Color(235, 184, 102));
			g.drawString("금요일 정산서", 130, 30);
			g.setColor(new Color(0, 0, 0));
			g.drawLine(0, 60, 500, 60);
			g.drawLine(230, 60, 230, 400);
			g.drawLine(0, 165, 1000, 165);
			g.setFont(new Font("돋움", Font.PLAIN, 20));
			g.setColor(new Color(0, 0, 255));
			g.drawString("이득", 30, 115);
			g.setColor(new Color(0, 0, 0));
			g.drawOval(10, 130, 10, 10);
			g.drawString("지식력상승 + 1050", 30, 145);
			g.setColor(new Color(255, 0, 0));
			g.drawString("패널티", 30, 195);
			g.setColor(new Color(0, 0, 0));
			g.drawOval(10, 210, 10, 10);
			g.drawString("피곤함상승 + 540", 30, 225);
			g.drawOval(10, 240, 10, 10);
			g.drawString("압박감 + 100", 30, 255);
			g.drawOval(10, 270, 10, 10);
			g.drawString("정신력 - 100", 30, 285);
			g.drawOval(350, 290, 100, 100);
			g.drawOval(370, 320, 20, 20);
			g.drawLine(410, 330, 430, 320);
			g.drawLine(410, 330, 430, 340);
			g.drawLine(400, 360, 380, 350);
			g.drawLine(400, 360, 420, 350);
			g.drawLine(410, 330, 430, 340);
			g.drawLine(0, 400, 500, 400);
			g.setFont(new Font("돋움", Font.ITALIC, 15));
			g.setColor(new Color(255, 0, 0));
			g.drawString("위의견은 가상된 환경이며 현 상태와 관련이 없음을 알려드립니다", 10, 430);

		}
	}

}
