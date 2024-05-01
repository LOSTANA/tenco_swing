package ch06;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame2 extends JFrame {

	private JLabel jPlayer;
	private JLabel JBackground;
	// 변수는 --> 변하는 수이기도 하다.
	private int jPlayerX = 50;
	private int jPlayerY = 510;
	private final int MOVDE_DISTANCE = 10;
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	private final String PLAYER_NAME = "야스오";
	private final int PLAYER_WIDTH = 100; 
	private final int PLAYER_HEIGHT = 100;
	ImageIcon player1 = new ImageIcon("C:\\Users\\KDP\\Downloads\\images\\playerR.png");
	ImageIcon player2 = new ImageIcon("C:\\Users\\KDP\\Downloads\\images\\playerL.png");		
	
	
	public MiniGame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(1000, 630);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPlayer = new JLabel(player1);
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
		
		Icon background = new ImageIcon("C:\\Users\\KDP\\Downloads\\images\\backgroundMap.png");
		JBackground = new JLabel(background);
		JBackground.setSize(1000, 600);

		
	}

	private void setInitLayout() {
		// 좌표 기반으로 배치관리자 변경
		setLayout(null);
		add(jPlayer);
		jPlayer.setLocation(jPlayerX, jPlayerY);
		add(JBackground);
		JBackground.setLocation(0, 0);

		setVisible(true);
	}

	private void addEventListener() {
		// jPlayer 객체에게서만 keyListener 동작을 시키고자 한다면
		// 익명 구현클래스로 KeyListener 인터페스를 재 정의할 수 있다.
		// jPlayer.addKeyListener(this);
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					jPlayerY -= MOVDE_DISTANCE;
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					jPlayerX -= MOVDE_DISTANCE;
					jPlayer.setIcon(player2);
				} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jPlayerX += MOVDE_DISTANCE;
					jPlayer.setIcon(player1);
				} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					jPlayerY += MOVDE_DISTANCE;
				}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					jPlayerY -=50;
					
				}
				
				jPlayer.setLocation(jPlayerX, jPlayerY);
			}
		});
	}

	// 코드 테스트
	public static void main(String[] args) {
		new MiniGame2();
	} // end of main

} // end of class