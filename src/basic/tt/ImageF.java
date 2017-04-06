package basic.tt;

import java.awt.image.BufferedImage;


public abstract class ImageF {
	protected int x ;
	protected int y ;
	protected BufferedImage image ;
	protected BufferedImage[] images ;
	
	
	public void setX(int x){
		this.x = x ;
	}
	public void setY(int y){
		this.y = y ;
	}
	public int getX(){
		return x ;
	}
	public int getY(){
		return y ;
	}
	public void moveXY(int x , int y){
		setX(x);
		setY(y);
	}
	
	public void setImage(BufferedImage image){
		this.image = image ;
	}
	public void setImages(BufferedImage[] images){
		this.images = images ;
	}
}
