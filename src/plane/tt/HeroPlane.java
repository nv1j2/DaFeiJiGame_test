package plane.tt;

import java.awt.image.BufferedImage;

import basic.tt.ImageTools;
import main.tt.Game;

public class HeroPlane extends AirPlane{
	
	
	private int interval = 10 ;
	private BufferedImage[] usImages ;
	private int index ;
	private int intervalIndex = 0;
	private int intervaCount = interval / Game.INTERVAL;
	
	
	public HeroPlane() {
		// TODO Auto-generated constructor stub
		this("hero", 2, "hero_ember", 4);
		this.moveXY(200, 450);
		this.setPlaneType(1);
		this.setPlaneCount(1);
		
	}
	
	public HeroPlane(String usName,int usCount,String boomName,int boomCount){
		this.usImages = ImageTools.readImage(usName, usCount);
		this.images = ImageTools.readImage(boomName, boomCount);
	}
	public BufferedImage getImage(){
		if(this.getPlaneState() == 0){
			this.intervalIndex ++;
			if(this.intervalIndex  == this.intervaCount){
				this.index ++;
				this.intervalIndex = 0;
				if(this.index == this.usImages.length){
					this.index = 0;
				}
			}
			return this.usImages[this.index];
		}else {
			return super.getImage();
		}
	}
	public void start(){
		if(getKeyControl()[0] == true){//left
			this.subX();
		}
		if(getKeyControl()[1] == true){//up
			this.subY();
		}
		if(getKeyControl()[2] == true){//right
			this.addX();
		}
		if(getKeyControl()[3] == true){//down
			this.addY();
		}
		if(getKeyControl()[4] == true){//Éä»÷
			this.setBulletState(1);
		}
		if(this.getX() < -50 ){
			this.addX();
		}else if(this.getX() > Game.GAME_WINDOW_WIDTH + 50){
			this.subX();
		}
		if(this.getY() < -50 ){
			this.addY();
		}else if (this.getY() > Game.GAME_WINDOW_HEIGHT + 50) {
			this.subY();
		}
			
	}
	public void test(){}
	
}
