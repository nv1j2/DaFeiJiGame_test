package plane.tt;

public class EmberAirplane extends AirPlane{
	public EmberAirplane() {
		// TODO Auto-generated constructor stub
		super("airplane.png","airplane_ember",4);
		this.moveXY(50, 200);
		this.setPlaneType(100);
		this.setPlaneCount(100);
	}
}
