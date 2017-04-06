package bullet.tt;


import plane.tt.AirPlane;

public class UniBullet extends AirPlane{
	public UniBullet(){
		super("bullet.png", "baozha_", 3);
	}
	public UniBullet(int x ,int y) {
		// TODO Auto-generated constructor stub
		super("bullet.png", "baozha_", 3);
		this.moveXY(x, y);
		this.setPlaneState(0);
		this.setInterval(1000);
		this.setPlaneCount(1000);
	}
	public void start(){
		this.subY(3);/////////////////test
		super.start();
	}

}
