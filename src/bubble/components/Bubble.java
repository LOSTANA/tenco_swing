package bubble.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bubble.BubbleFrame;
import bubble.interfaces.Moveable;
import bubble.service.BackgroundBubbleService;

public class Bubble extends JLabel implements Moveable {

	private BubbleFrame mContext;
	
	
	// 의존성 컴포지션 관계
	private Player player;
	private BackgroundBubbleService backgroundBubbleService;

	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// 적군을 맞춘 상태
	private int state; // 0.(기본 물방울), 1.(적을 가둔 상태 물방울)

	private ImageIcon bubble; // 기본 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울 팡!

	// 연관관계, 의존성 컴포지션 관계, 생성자 의존 (DI)
	public Bubble(BubbleFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		initData();
		setInitLayout();

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getBubble() {
		return bubble;
	}

	public void setBubble(ImageIcon bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
	}

	private void initData() {
		bubble = new ImageIcon("img/bubble.png");
		bubbled = new ImageIcon("img/bubbled.png");
		bomb = new ImageIcon("img/bomb.png");
		backgroundBubbleService = new BackgroundBubbleService(this);

		left = false;
		right = false;
		up = false;
		state = 0;
	}

	private void setInitLayout() {

		x = player.getX();
		y = player.getY();

		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);

	}

	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);
			// 만약 왼쪽벽 --> up()

			if (backgroundBubbleService.leftWall()) {
				break;
			}
			
			
			// 현재 버블에 x,y 좌표값을 알고 있다
			int absX = Math.abs(x - mContext.getEnemy().getX());
			int absY = Math.abs(y - mContext.getEnemy().getY());
			
			if(absX < 10 && absY < 50) {
				// 단., 적군이 살아 있을때 crash() 메서드 호출이 되어야 함
				if(mContext.getEnemy().getState() == 0) {
					crash();
				}
				
			}
			
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		up();
	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);

			if (backgroundBubbleService.rightWall()) {
				break;
			}
			
			// 적군 감지 및 충돌처리
			int absX = Math.abs(x - mContext.getEnemy().getX());
			int absY = Math.abs(y - mContext.getEnemy().getY());
			if(absX < 10 && absY < 50) {
				if(mContext.getEnemy().getState() == 0) {
					crash();
				}
				
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		up();

	}

	@Override
	public void up() {
		up = true;
		while (true) {
			y--;
			setLocation(x, y);
			if (backgroundBubbleService.topWall()) {
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		clearBubble();
	}

	// 외부 호출 안될 메서드
	private void clearBubble() {
		// 3초 뒤에 터짐
		try {
			Thread.sleep(3000);
			setIcon(bomb);
			// 메모리에서 해제처리 해야함
			
			Thread.sleep(500);
			setIcon(null);
			//컴포넌트 제거 --> 다시 그림을 그리지 않는다
			//mContext.remove(this);
			//mContext.repaint();
			//JFrame 안에 remove 메서드가 있다
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void crash() {
		mContext.getEnemy().setState(1);
		state = 1;
		setIcon(bubbled);
		// 적군이 살아 있는 상태에서 부딪히면 버블에 갇힌 상태로 변경
		mContext.getEnemy().setIcon(null);
		mContext.remove(mContext.getEnemy());
		mContext.repaint();
		//버블의 이미지를 변경 처리
	}

}
