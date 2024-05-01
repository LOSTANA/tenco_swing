package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//이벤트 리스너를 사용하는 방법
public class ColorChangeFrame2 extends JFrame implements ActionListener {

	private JPanel panel;
	private JButton button1;
	private JButton button2;
	private String max;

	public ColorChangeFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); // BorderLayout
		panel = new JPanel();
		panel.setBackground(Color.yellow);
		button1 = new JButton("click1");
		button2 = new JButton("click2");
	}

	private void setInitLayout() {
		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);

	}

	// 오버라이드 : 이벤트가 일어나면 호출 되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		JButton selectedButton = (JButton) e.getSource();

		if (selectedButton == this.button1) {
			System.out.println("button1 객체가 눌러졌다라고 판명 가능");
			panel.setBackground(Color.yellow);
		} else
			System.out.println("button2 객체가 눌러졌다라고 판명 가능");
		panel.setBackground(Color.black);

	}

	public static void main(String[] args) {
		new ColorChangeFrame2();
	}

}// end of class
