package main.tt;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import basic.tt.KeyControl;
import scene.tt.CheckPointOne;
import scene.tt.GameScene;

public class Game extends JFrame implements Runnable,KeyListener{
	private static final long serialVersionUID = 1L;
	public static final int GAME_WINDOW_WIDTH = 480 ;
	public static final int GAME_WINDOW_HEIGHT = 600 ; 
	public static final int INTERVAL = 10;
	private GameScene gameScene = new CheckPointOne() ;
	private KeyControl keyControl = new KeyControl() ;
	private ControlCenter controlCenter  ;
	private Image iBuffer ;
	private Graphics gBuffer ;
	public Game() {
		// TODO Auto-generated constructor stub
		
		this.setTitle("打飞机");
		this.setSize(GAME_WINDOW_WIDTH,GAME_WINDOW_HEIGHT);
        this.setResizable(false);
        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if(frameSize.width > displaySize.width)
            frameSize.width = displaySize.width;
        if(frameSize.height > displaySize.height)
            frameSize.height = displaySize.height;
        this.setLocation((displaySize.width - frameSize.width)/2,(displaySize.height - frameSize.height)/2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.controlCenter = new ControlCenter(gameScene,keyControl);
        this.controlCenter.start();
        
	}
	
	public void start(){
		new Thread(this).start();
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(gameScene.getImage(), 0, 0, null);
	}
	
	@Override
	public void update(Graphics g) {//双缓冲
		if(iBuffer == null){
			iBuffer = createImage(GAME_WINDOW_WIDTH,GAME_WINDOW_HEIGHT);
			gBuffer = iBuffer.getGraphics() ;
		}
		gBuffer.setColor(getBackground());
		gBuffer.fillRect(0,0,GAME_WINDOW_WIDTH,GAME_WINDOW_HEIGHT);
		this.paint(gBuffer);
		g.drawImage(iBuffer, 0, 0, this);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			this.controlCenter.start();
			this.repaint();
			try {
				Thread.sleep(INTERVAL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {//按下
		// TODO Auto-generated method stub
		this.keyControl.setKeyPressed(e);
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {//弹起
		// TODO Auto-generated method stub
		this.keyControl.setKeyReleased(e);
	}
	@Override
	public void keyTyped(KeyEvent e) {//触击
		// TODO Auto-generated method stub
	}


	
	
}
