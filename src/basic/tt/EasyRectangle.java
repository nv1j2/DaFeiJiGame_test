package basic.tt;

import java.awt.Rectangle;
import java.util.Arrays;

/*
 * ���׾�����,���ڷ�����ײ���
 * ���þ��ε������Խǵ����꣬ȷ�����εĴ�С��λ��
 * 
 * 
 */



class xx extends Rectangle{
	
}
public class EasyRectangle {
	public int x ;
	public int y ;
	public int width ;
	public int height ;
	public static EasyRectangle returnIntersection;
	
	public EasyRectangle(int x ,int y ,int width ,int height){
		this.x = x ;
		this.y = y ;
		this.width = width ;
		this.height = height ;
		
	}
	/*
	 * ���׵ľ�����ײ���
	 * �����������Σ��ж����������Ƿ���ײ��
	 * ��δ��ײ������false
	 * ����ײ������true ,������returnIntersection�з��������ص��ľ���
	 * 
	 * 
	 */
	public static boolean intersection(EasyRectangle p1 , EasyRectangle p2){
		boolean flag = false;
		if(((p2.width  + p2.x) <= p2.x  || (p2.width  + p2.x) >= p1.x) &&
           ((p2.height + p2.y) <= p2.y  || (p2.height + p2.y) >= p1.y) &&
           ((p1.width  + p1.x) <= p1.x  || (p1.width  + p1.x) >= p2.x) &&
           ((p1.height + p1.y) <= p1.y  || (p1.height + p1.y) >= p2.y)){
			flag = true ;
			
//	        int tx1 = p1.x;
//	        int ty1 = p1.y;
//	        int rx1 = p2.x;
//	        int ry1 = p2.y; bgh
//	        long tx2 = tx1; tx2 += p1.width;
//	        long ty2 = ty1; ty2 += p1.height;
//	        long rx2 = rx1; rx2 += p2.width;
//	        long ry2 = ry1; ry2 += p2.height;
//	        if (tx1 < rx1) tx1 = rx1;
//	        if (ty1 < ry1) ty1 = ry1;
//	        if (tx2 > rx2) tx2 = rx2;
//	        if (ty2 > ry2) ty2 = ry2;
//	        tx2 -= tx1;
//	        ty2 -= ty1;
//
//	        return new Rectangle(tx1, ty1, (int) tx2, (int) ty2);
			
			
			
			
			
		}
		
		
		
        return flag;
	}
	
}
