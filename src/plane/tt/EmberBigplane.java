package plane.tt;

public class EmberBigplane extends AirPlane{
	public EmberBigplane(){
		super("bigplane.png","bigplane_ember",4);
		this.moveXY(150, 300);
		this.setPlaneType(101);
		this.setPlaneCount(101);
	}
}
