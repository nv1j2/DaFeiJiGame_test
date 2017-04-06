package scene.tt;

import basic.tt.ImageTools;
import plane.tt.EmberAirplane;
import plane.tt.EmberBee;
import plane.tt.EmberBigplane;
import plane.tt.HeroPlane;

public class CheckPointOne extends GameScene{
	public CheckPointOne(){
		this.setImage(ImageTools.readImage("background.png"));
		this.addAirPlane(new HeroPlane());
		this.addAirPlane(new EmberAirplane());
		this.addAirPlane(new EmberBee());
		this.addAirPlane(new EmberBigplane());
	}

}
