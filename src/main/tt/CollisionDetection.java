package main.tt;

import java.util.Arrays;

import basic.tt.EasyRectangle;
import bullet.tt.UniBullet;
import plane.tt.AirPlane;
import plane.tt.EmberAirplane;
import plane.tt.EmberBee;
import plane.tt.EmberBigplane;
import plane.tt.HeroPlane;
import scene.tt.GameScene;

public class CollisionDetection {
	/*
	 * 碰撞检测
	 */
	

	private static final int COLLISION_POOL_COUNT = 5 ;
	private static final int COLLISION_POOL_HEIGHT = Game.GAME_WINDOW_HEIGHT * 2;
	private static final int COLLISION_POOL_WIDTH = Game.GAME_WINDOW_WIDTH * 2;
	/*
	 * 游戏碰撞判断池,这里暂定为游戏窗体的2倍,并且collisionPool[0][0] 设定为 窗体的 y = - Game.GAME_WINDOW_HEIGHT/2 ; x = -Game.GAME_WINDOW_WIDTH / 2
	 * 第0层 ，绘制 我方英雄战机
	 * 第1层 ，绘制 奖励物 
	 * 第2层， 绘制 敌机
	 * 第3层， 绘制 我方子弹
	 * 第4层 ，绘制 敌方子弹
	 * 
	 */
	private boolean[][][] collisionPool = new boolean[COLLISION_POOL_COUNT][COLLISION_POOL_HEIGHT][COLLISION_POOL_WIDTH] ;
	private boolean[][] uniBulletPool ;//planeCount = 1000 飞行物唯一编号
	private boolean[][] emberAirplanePool ;//planeCount = 100
	private boolean[][] emberBeePool; //planeCount = 10
	private boolean[][] emberBigplanePool ; //planeCount = 101
	private boolean[][] heroPlanePool ; // planeCount = 1 
	public CollisionDetection() {
		// TODO Auto-generated constructor stub
		this.uniBulletPool = setBoolPool(new UniBullet());
		this.emberAirplanePool = setBoolPool(new EmberAirplane());
		this.emberBeePool = setBoolPool(new EmberBee());
		this.emberBigplanePool = setBoolPool(new EmberBigplane());
		this.heroPlanePool = setBoolPool(new HeroPlane());
	}
	public void start(GameScene gameScene){
		this.setCollisionPool();
		for(int n = 0 ; n < gameScene.getAirPlaneSize() ; n ++ ){
			int getCollisionPoolCount = 0 ;
			if(gameScene.getAirPlane(n).getPlaneType() >= 1 && gameScene.getAirPlane(n).getPlaneType() < 10 ){
				getCollisionPoolCount = 0 ;	
			}else if (gameScene.getAirPlane(n).getPlaneType() >= 10 && gameScene.getAirPlane(n).getPlaneType() < 100) {
				getCollisionPoolCount = 1 ;
			}else if (gameScene.getAirPlane(n).getPlaneType() >= 100 && gameScene.getAirPlane(n).getPlaneType() < 1000) {
				getCollisionPoolCount = 2 ;
			}else if (gameScene.getAirPlane(n).getPlaneType() >= 1000 && gameScene.getAirPlane(n).getPlaneType() < 2000) {
				getCollisionPoolCount = 3 ;
			}else if(gameScene.getAirPlane(n).getPlaneType() >= 2000 && gameScene.getAirPlane(n).getPlaneType() < 3000){
				getCollisionPoolCount = 4 ;
			}
			int startY = gameScene.getAirPlane(n).getY() + Game.GAME_WINDOW_HEIGHT/2;
			int startX = gameScene.getAirPlane(n).getX() + Game.GAME_WINDOW_WIDTH/2;
			int imageH =  gameScene.getAirPlane(n).getImage().getHeight();
			int imageW =  gameScene.getAirPlane(n).getImage().getWidth();
			int planeCount = gameScene.getAirPlane(n).getPlaneCount();
				
			if(planeCount == 1){
				for(int i =  0 ; i < imageH ; i ++){
					System.arraycopy(heroPlanePool[i], 0, collisionPool[getCollisionPoolCount][startY + i], startX, imageW);
				}
			}else if (planeCount == 10) {
				for(int i =  0 ; i < imageH ; i ++){
					System.arraycopy(emberBeePool[i], 0, collisionPool[getCollisionPoolCount][startY + i], startX, imageW);
				}
			}else if (planeCount == 100) {
				for(int i =  0 ; i < imageH ; i ++){
					System.arraycopy(emberAirplanePool[i], 0, collisionPool[getCollisionPoolCount][startY + i], startX, imageW);
				}
			}else if (planeCount == 101) {
				for(int i =  0 ; i < imageH ; i ++){
					System.arraycopy(emberBigplanePool[i], 0, collisionPool[getCollisionPoolCount][startY + i], startX, imageW);
				}
			}else if (planeCount == 1000) {
				for(int i =  0 ; i < imageH ; i ++){ 
					System.arraycopy(uniBulletPool[i], 0, collisionPool[getCollisionPoolCount][startY + i], startX, imageW);
				}
			}else if (planeCount == 2000) {
				for(int i =  0 ; i < imageH ; i ++){ 
					System.arraycopy(uniBulletPool[i], 0, collisionPool[getCollisionPoolCount][startY + i], startX, imageW);
				}
			}
		}

		EasyRectangle test1 = new EasyRectangle(10, 10, 40, 40);
		EasyRectangle test2 = new EasyRectangle(51, 50, 1, 1);
		System.out.println(EasyRectangle.intersection(test1, test2));
		
		System.exit(0);
		
		
		
		
	}
	
	private void setCollisionPool(){
		for(int i = 0 ; i < COLLISION_POOL_COUNT ; i ++ ){
			for(int j = 0 ; j < COLLISION_POOL_HEIGHT; j ++){
				Arrays.fill(this.collisionPool[0][j], false);
			}
		}
	}
	 
	
	private boolean[][] setBoolPool(AirPlane plane){
		boolean[][] temp = new boolean[plane.getImage().getHeight()][plane.getImage().getWidth()];
		for(int i = 0 ;i < plane.getImage().getHeight() ; i ++){
			for(int j = 0 ; j < plane.getImage().getWidth() ; j ++ ){
				temp[i][j] = (plane.getImage().getRGB(j, i) >> 24 == 0);
			}
		}
		return temp ; 
	}

	
}
