package bubble.test.ex02;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{

	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}


	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame --> root Panel
		setContentPane(backgroundMap); // add 처리
		setSize(1000, 640);
		
		player = new Player();
	}
	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setResizable(false); //프레임 조절 불가
		setLocationRelativeTo(null);// JFrame 여러분 모니터 자동 배치
		setVisible(true);
		
		add(player);
		
	}
	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.left();
					break;
				case KeyEvent.VK_RIGHT:
					player.right();
					break;
				case KeyEvent.VK_UP:
					player.up();
					break;
					
				}
				
				
			}//end of KeyPressed
		});
		
	}
	
}

