package plane.tt;

import java.awt.image.BufferedImage;

import basic.tt.ImageF;
import basic.tt.ImageTools;
import main.tt.Game;

public class AirPlane extends ImageF{
	private int interval = 500 ;
	private int planeState = 0 ;//������״̬ -1 ��ʧ ,0 ��ͨ, 1 ��ը
	private int planeType = 0 ; // ����������   0 ������  ;1~9 �ҷ�Ӣ��ս�� ; 10~99 ������   ; 100~999 �л�  ;1000~1999 �ҷ��ӵ� ; 2000~2999 �л��ӵ�
	private int bulletState = 0 ; //������ ����״̬   0 �� ; 1 ������ͨ�ӵ� UniBullet ;
	private int planeCount ; //������Ψһ���
	private int index = 0;
	private int intervalIndex = 0;
	private int intervaCount = this.interval / Game.INTERVAL;//ˢ���ٶ�
	private boolean[] keyControl ; 
	public AirPlane(){}
		
	public AirPlane( String usName,String boomName,int count) {
		this.image = ImageTools.readImage(usName);
		this.images = ImageTools.readImage(boomName, count);
	}
	public void start(){
		
		/*
		 * Y���Χ��Ӧ���� -Game.GAME_WINDOW_HEIGHT/2 
		 *            ��  + Game.GAME_WINDOW_HEIGHT * 3/2 - this.getImage().getHeight()
		 * X���Χ��Ӧ���� -Game.GAME_WINDOW_WIDTH/2 
		 *            ��  + Game.GAME_WINDOW_WIDTH * 3/2 - this.getImage().getWidth()          
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
