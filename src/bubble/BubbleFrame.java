package bubble;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BubbleFrame extends JFrame {

	BufferedImage backgroundImage;
	BufferedImage player1;
	BufferedImage enemy1;
	BufferedImage enemy2;
	ImagePanel imagePanel;

	int playerX = 150;
	int playerY = 300;
	int playerSizeW = 50;
	int playerSizeH = 50;

	int enemy1X = 250;
	int enemy2X = 300;
	int enemy1Y = 420;
	int enemy2Y = 180;

	boolean enemymove = true;

	public BubbleFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	// 클래스 안에 클래스 -> 중첩 클래스 -> 외부클래스, 내부클래스
	private class ImagePanel extends JPanel implements Runnable {

		// paintComponents --> x
		// paintComponent --> o
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, 600, 600, null);
			g.drawImage(player1, playerX, playerY, playerSizeW, playerSizeH, null);
			g.drawImage(enemy1, enemy1X, enemy1Y, 50, 50, null);
			g.drawImage(enemy2, enemy2X, enemy2Y, 50, 50, null);

			// Todo 플레이어, 적군 그림 그려야 함
			// 쓰레드를 활용할 예정
		}

		@Override
		public void run() {

			// true : 왼쪽으로 가는 상황
			// false : 오른쪽으로 가는 상황
			boolean direction = true;

			while (enemymove) {

				if (direction) {
					try {
						enemy1 = ImageIO.read(new File("img/enemyL.png"));
						enemy2 = ImageIO.read(new File("img/enemyR.png"));
						System.out.println("왼쪽 진행중");
						if (playerX <= enemy1X + 20 && playerX >= enemy1X - 20 && playerY <= enemy1Y + 45
								&& playerY >= enemy1Y - 45) {

							player1 = null;
							System.out.println("플레이어가 사망하였습니다");

						} else if (playerX <= enemy2X + 20 && playerX >= enemy2X - 20 && playerY <= enemy2Y + 45
								&& playerY >= enemy2Y - 45) {
							player1 = null;
							System.out.println("플레이어가 사망하였습니다");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					enemy1X -= 10;
					enemy2X += 10;
				} else {
					try {
						enemy1 = ImageIO.read(new File("img/enemyR.png"));
						enemy2 = ImageIO.read(new File("img/enemyL.png"));
						System.out.println("오른쪽 진행중");
						if (playerX <= enemy1X + 20 && playerX >= enemy1X - 20 && playerY <= enemy1Y + 45
								&& playerY >= enemy1Y - 45) {

							player1 = null;
							System.out.println("플레이어가 사망하였습니다");

						} else if (playerX <= enemy2X + 20 && playerX >= enemy2X - 20 && playerY <= enemy2Y + 45
								&& playerY >= enemy2Y - 45) {
							player1 = null;
							System.out.println("플레이어가 사망하였습니다");
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					enemy1X += 10;
					enemy2X -= 10;

				}

				// 방향 바꾸는 개념은 적군 x 좌표값이
				if (enemy1X <= 150) {
					direction = false;
				}

				if (enemy1X >= 400) {
					direction = true;
				}

				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}

		}
	}

	private void initData() {
		setTitle("Thread 활용한 미니 예제");
		setSize(600, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			// 예외가 발생할 수 있는 코드를 작성하는 영역
			backgroundImage = ImageIO.read(new File("img/backgroundMap.png"));
			player1 = ImageIO.read(new File("img/playerR.png"));
			enemy1 = ImageIO.read(new File("img/enemyL.png"));
			enemy2 = ImageIO.read(new File("img/enemyL.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		imagePanel = new ImagePanel();

		// 다른작업자에게 일을 위임시킨다
		Thread thread = new Thread(imagePanel);
		thread.start();

	}

	private void setInitLayout() {
		// 배치 관리자를 좌표 기반
		// setLayout(null);
		// setResizable(false);//프레임 크기 조절불가 설정
		setVisible(true);

		add(imagePanel);
	}

	private void addEventListener() {
		// 이벤트 리스너 등록 방법 2가지 중
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println("여기가 동작 합니다");
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_UP) {
					if (playerY <= 20) {
						playerY = 20;
					} else {
						playerY -= 10;
					}

				} else if (code == KeyEvent.VK_DOWN) {
					if (playerY >= 535) {
						playerY = 535;
					} else {
						playerY += 10;
					}
				} else if (code == KeyEvent.VK_LEFT) {
					try {
						if (player1 != null) {
							player1 = ImageIO.read(new File("img/playerL.png"));
							System.out.println("왼쪽 이동중");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if (playerX <= 30) {
						playerX = 30;
					} else {
						playerX -= 10;
					}
				} else if (code == KeyEvent.VK_RIGHT) {
					try {
						if (player1 != null) {
							player1 = ImageIO.read(new File("img/playerR.png"));
							System.out.println("오른쪽 이동중");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if (playerX >= 520) {
						playerX = 520;
					} else {
						playerX += 10;
					}
				} else if (code == KeyEvent.VK_SPACE) {
					// 1. 스페이스를 눌렀을 때 적군을 멈출 수 있도록 코드 수정

					enemymove = false;

				} else if (code == KeyEvent.VK_ENTER) {
					try {
						player1 = ImageIO.read(new File("img/playerR.png"));
						System.out.println("부활합니다");
						playerX = 150;
						playerY = 300;
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
				// 2. player가 적군과 만났다면 player그림을 없애주세요

				repaint();

			}
		});
	}

}
