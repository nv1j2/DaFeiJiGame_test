package plane.tt;

import java.awt.image.BufferedImage;

import basic.tt.ImageF;
import basic.tt.ImageTools;
import main.tt.Game;

public class AirPlane extends ImageF{
	private int interval = 500 ;
	private int planeState = 0 ;//飞行物状态 -1 消失 ,0 普通, 1 爆炸
	private int planeType = 0 ; // 飞行物类型   0 无类型  ;1~9 我方英雄战机 ; 10~99 奖励物   ; 100~999 敌机  ;1000~1999 我方子弹 ; 2000~2999 敌机子弹
	private int bulletState = 0 ; //飞行物 攻击状态   0 无 ; 1 发射普通子弹 UniBullet ;
	private int planeCount ; //飞行物唯一编号
	private int index = 0;
	private int intervalIndex = 0;
	private int intervaCount = this.interval / Game.INTERVAL;//刷新速度
	private boolean[] keyControl ; 
	public AirPlane(){}
		
	public AirPlane( String usName,String boomName,int count) {
		this.image = ImageTools.readImage(usName);
		this.images = ImageTools.readImage(boomName, count);
	}
	public void start(){
		
		/*
		 * Y最大范围不应超过 -Game.GAME_WINDOW_HEIGHT/2 
		 *            和  + Game.GAME_WINDOW_HEIGHT * 3/2 - this.getImage().getHeight()
		 * X最大范围不应超过 -Game.GAME_WINDOW_WIDTH/2 
		 *            和  + Game.GAME_WINDOW_WIDTH * 3/2 - this.getImage().getWidth()          
		 */
		if(this.getY() < -100 || this.getY() > Game.GAME_WINDOW_HEIGHT + 100 ){
			this.planeState = - 1 ;
		}
	}
	public BufferedImage getImage(){
		if(this.planeState == 1){
			this.intervalIndex ++;
			if(this.intervalIndex  == this.intervaCount){
				this.index ++;
				this.intervalIndex = 0;
				if(this.index == this.images.length){
					this.index = 0;
				}
			}else if (this.intervalIndex  > this.intervaCount) {
				this.intervalIndex = 0;
			}
			return this.images[this.index];
		}else if(this.planeState == 0){
			return this.image ;
		}
		else {
			return new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		}

	}
	
	
	public void addX(){
		this.x ++ ;
	}
	public void addX(int n){
		this.x += n ;
	}
	public void addY(){
		this.y ++ ;
	}
	public void addY(int n){
		this.y += n ;
	}
	public void subX(){
		this.x -- ;
	}
	public void subX(int n){
		this.x -= n ;
	}
	public void subY(){
		this.y -- ;
	}
	public void subY(int n){
		this.y -= n ;
	}
	public void setInterval(int in){
		this.intervaCount = in;
	}
	public int getInterval(){
		return intervaCount ;
	}
	public void setPlaneState(int state){
		this.planeState = state ;
	}
	public int getPlaneState(){
		return this.planeState ;
	}
	public void setKeyControl(boolean[] keyControl){
		this.keyControl = keyControl ;
	}
	public boolean[] getKeyControl(){
		return this.keyControl ;
	}
	public void setBulletState(int n ){
		this.bulletState = n;
	}
	public int getBulletState(){
		return this.bulletState ;
	}
	public void setPlaneType(int planeType){
		this.planeType = planeType ;
	}
	public int getPlaneType(){
		return this.planeType ; 
	}
	public void setPlaneCount(int planeCount){
		this.planeCount = planeCount;
	}
	public int getPlaneCount(){
		return this.planeCount;
	}
}
