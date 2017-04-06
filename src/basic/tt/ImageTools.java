package basic.tt;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class ImageTools {

	
	public static final String ROOT = "res/";
	/**
	 * 读取图片
	 * @param resName 图片目录及文件名
	 * @return 图片  如果读取失败,返回一个宽高为0的图片
	 */
	public static BufferedImage readImage(String resName) {
		try{
			File file = new File(ROOT + resName);
			return ImageIO.read(file);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	}
	/**
	 * 读取指定目录下指定数量的图片
	 * @param dirName 指定图片目录
	 * @param count 读取图片的总数
	 * @return 图片数组
	 */
	public static BufferedImage[] readImage(String dirName,int count){
		BufferedImage images[] = new BufferedImage[count];
		for(int i = 0;i < count ;i++){
			images[i] = readImage(dirName + i + ".png");
		}
		return images;
	}
}
