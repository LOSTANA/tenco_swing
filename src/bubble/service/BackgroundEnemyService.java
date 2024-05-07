package bubble.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bubble.components.Enemy;

/**
 * 현재 메인 쓰레드는 너~무 빠쁨 백그라운드에서 계속 Player 에 움직임을 관찰할 예정
 */
public class BackgroundEnemyService implements Runnable {

	private BufferedImage image;
	private Enemy enemy;

	// 생성자 의존 주입 DI
	public BackgroundEnemyService(Enemy enemy) {
		this.enemy = enemy;
		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (true) {
			// 흰색이면 바닥 RGB => 255 255 255
			// 바닥인 경우 --> 225 0 0 (바닥이라고 판단 가능)
			// 바닥인 경우 --> 0 0 255(바닥이라고 판단 가능)
			int bottomColorLeft = image.getRGB(enemy.getX() + 20, enemy.getY() + 50 + 5);
			int bottomColorRight = image.getRGB(enemy.getX() + 50, enemy.getY() + 50 + 5);

			// 하얀색 --> int값이 -2

			if (bottomColorLeft + bottomColorRight  != -2) {
				
			} else{
				if(enemy.isLeft() == true) {
					enemy.setLeft(false);
					enemy.setRight(true);
					enemy.right();
				}else {
				enemy.setRight(false);
				enemy.setLeft(true);
				enemy.left();
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

		// 왼쪽에 충돌함
	}
}
