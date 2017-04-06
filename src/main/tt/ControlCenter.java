package main.tt;

import basic.tt.KeyControl;
import bullet.tt.UniBullet;
import scene.tt.GameScene;



public class ControlCenter {
	
	private int uniBulletFrequency = 8 ; //UniBullet 发射速度 ; 1为最快 ; 0为不发
	private int uniBulletCount = 0 ;
	private GameScene gameScene ;
	private KeyControl keyControl ;
	private int heroSign = 0 ;   //标记我方英雄飞机
	private CollisionDetection collisionDetection = new CollisionDetection();
	
	public ControlCenter(GameScene gameScene,KeyControl keyControl ){
		this.gameScene = gameScene ;
		this.keyControl = keyControl ;
		this.setHeroSign();
	}
	public void start(){
		this.collisionDetection.start(gameScene);
		this.gameScene.setKeyPressed(this.heroSign,this.keyControl.getKey());
		this.uniBulletCount ++ ;
		if(this.uniBulletCount  == this.uniBulletFrequency){
			if(this.keyControl.getKey()[4] == true ){
				this.gameScene.addAirPlane(new UniBullet(this.gameScene.getAirPlane(this.heroSign).getX(), this.gameScene.getAirPlane(this.heroSign).getY()));
			}
			this.uniBulletCount = 0 ; 
		}else if (this.uniBulletCount  > this.uniBulletFrequency) {
			this.uniBulletCount = 0 ;
		}
	}
	public void setHeroSign(){
		for(int i = 0 ; i < gameScene.getAirPlaneSize() ; i ++){
			if(gameScene.getAirPlane(i).getPlaneType() >= 1 && gameScene.getAirPlane(i).getPlaneType() < 10){
				this.heroSign =  i;
				break ;
			}
		}
	}
}
