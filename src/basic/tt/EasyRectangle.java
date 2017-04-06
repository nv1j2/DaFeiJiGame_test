package basic.tt;

import java.awt.Rectangle;
import java.util.Arrays;

/*
 * 简易矩形类,用于方便碰撞检测
 * 设置矩形的两个对角点坐标，确定矩形的大小，位置
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
	 * 简易的矩形碰撞检测
	 * 传入两个矩形，判断两个矩形是否碰撞。
	 * 若未碰撞，返回false
	 * 若碰撞，返回true ,并且在returnIntersection中返回两者重叠的矩形
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
