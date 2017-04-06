 package basic.tt;

import java.awt.event.KeyEvent;


public class KeyControl {    
    private boolean[] keyControl = new boolean[]{false, false, false, false, false};  
     //*****************************************{left , right, up   , down , space}
     
    public void setKeyPressed(KeyEvent e){
		int code = e.getKeyCode();
		switch(code) {  
		case  KeyEvent.VK_LEFT :  this.keyControl[0] = true; break; 
		case  KeyEvent.VK_UP :    this.keyControl[1] = true; break;  
		case  KeyEvent.VK_RIGHT : this.keyControl[2] = true; break;  
		case  KeyEvent.VK_DOWN :  this.keyControl[3] = true; break;  
		case  KeyEvent.VK_SPACE : this.keyControl[4] = true; break;  
		} 
	}
    public void setKeyReleased(KeyEvent e){
		int code = e.getKeyCode();
		switch(code) {  
		case  KeyEvent.VK_LEFT :  this.keyControl[0] = false; break;  
		case  KeyEvent.VK_UP :    this.keyControl[1] = false; break;  
		case  KeyEvent.VK_RIGHT : this.keyControl[2] = false; break; 
		case  KeyEvent.VK_DOWN :  this.keyControl[3] = false; break;
		case  KeyEvent.VK_SPACE : this.keyControl[4] = false; break; 
		} 
	}
	public boolean[] getKey(){
		return this.keyControl ;
	}
}
