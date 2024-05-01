package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//이벤트 리스너를 사용하는 방법
public class ColorChangeFrame3 extends JFrame implements ActionListener {

	private JPanel panel1;
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;

	public ColorChangeFrame3() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); // BorderLayout
		panel1 = new JPanel();
		panel1.setBackground(Color.ORANGE);
		panel2 = new JPanel();
		panel2.setBackground(Color.white);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 20,40));
		button1 = new JButton("빨강색");
		button1.setPreferredSize(new Dimension(90,50));
		button1.setFont(new Font("D2Coding",Font.BOLD,15));
		button2 = new JButton("파랑색");
		button2.setPreferredSize(new Dimension(90,50));
		button2.setFont(new Font("D2Coding",Font.BOLD,15));
		button3 = new JButton("초록색");
		button3.setPreferredSize(new Dimension(90,50));
		button3.setFont(new Font("D2Coding",Font.BOLD,15));
		button4 = new JButton("하얀색");
		button4.setPreferredSize(new Dimension(90,50));
		button3.setFont(new Font("D2Coding",Font.BOLD,15));
		button5 = new JButton("검정색");
		button5.setPreferredSize(new Dimension(90,50));
		button5.setFont(new Font("D2Coding",Font.BOLD,15));
	}

	private void setInitLayout() {
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);

		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);

		setVisible(true);
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);

	}

	// 오버라이드 : 이벤트가 일어나면 호출 되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		JButton selectedButton = (JButton) e.getSource();

		if (selectedButton == this.button1) {
			System.out.println("빨강색으로 변경");
			panel1.setBackground(Color.red);
		} else if (selectedButton == this.button2) {
			System.out.println("파랑색으로 변경");
			panel1.setBackground(Color.blue);
		} else if (selectedButton == this.button3) {
			System.out.println("초록색으로 변경");
			panel1.setBackground(Color.green);
		} else if (selectedButton == this.button4) {
			System.out.println("하얀색으로 변경");
			panel1.setBackground(Color.white);
		} else {
			System.out.println("검정색으로 변경");
			panel1.setBackground(Color.black);
		}
	}

	public static void main(String[] args) {
		new ColorChangeFrame3();
	}

}// end of class
