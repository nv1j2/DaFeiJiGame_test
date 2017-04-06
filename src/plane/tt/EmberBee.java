package plane.tt;

public class EmberBee extends AirPlane{
	public EmberBee(){
		super("bee.png","bee_ember",4);
		this.moveXY(250, 200);
		this.setPlaneType(10);
		this.setPlaneCount(10);
	}
}
