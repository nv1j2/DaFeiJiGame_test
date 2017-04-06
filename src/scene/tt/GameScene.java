package scene.tt;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import basic.tt.ImageF;
import main.tt.Game;
import plane.tt.AirPlane;

public class GameScene extends ImageF{

	/*
	 * INTERVAL背景滚动速度，若小于 Game.INTERVAL则为静止
	 */
	public static final int INTERVAL = 10 ;
	private int intervalIndex = 0;
	private int intervaCount = INTERVAL / Game.INTERVAL;
	private ArrayList<AirPlane> airPlanes = new ArrayList<>();
	private BufferedImage tempImage = new BufferedImage(Game.GAME_WINDOW_WIDTH, Game.GAME_WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	public BufferedImage getImage(){

		Graphics g = tempImage.getGraphics() ;
		
		//背景滚动
		this.intervalIndex ++;
		if(this.intervalIndex  == this.intervaCount){
			this.y ++ ;
			this.intervalIndex = 0;
			if(this.y >= this.image.getHeight()){
				this.y = 0 ;
			}
		}else if(this.intervalIndex  > this.intervaCount){
			this.intervalIndex = 0;
		}
		g.drawImage(this.image, this.x, this.y- this.image.getHeight(), null);
		g.drawImage(this.image, this.x, this.y, null);
		
		//绘制飞机,子弹
		for(int i = 0; i < this.airPlanes.size();i ++){
			g.drawImage(this.airPlanes.get(i).getImage(), this.airPlanes.get(i).getX(), this.airPlanes.get(i).getY(), null); 
			this.airPlanes.get(i).start();
			if(this.airPlanes.get(i).getPlaneState() == -1){
				//检测飞机子弹状态,判断是否显示
				this.delAirPlane(i);
			}
		}
		g.dispose();
		return this.tempImage ;
	}
	

	
	public void addAirPlane (AirPlane plane){
		this.airPlanes.add(plane);
	}
	public void delAirPlane(int n){
		if(n < this.airPlanes.size() && n >= 0){
			this.airPlanes.remove(n);
			
		}
	}
	public AirPlane getAirPlane(int n){
		if(n < this.airPlanes.size() && n >= 0){
			return this.airPlanes.get(n);
		}
		return null ;
	}
	public int getAirPlaneSize(){
		return this.airPlanes.size();
	}
	public void setKeyPressed(int n, boolean[] keyPressed){
		this.airPlanes.get(n).setKeyControl(keyPressed);
	}
}
