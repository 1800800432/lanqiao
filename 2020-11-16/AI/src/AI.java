import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image downImg,leftImg,rightImg,upImg,currentImg;	//定义变量
	public MainCanvas(){
		try	
		{
			downImg=Image.createImage("/sayo10.png");/*xia*/
			leftImg=Image.createImage("/sayo12.png");/*zuo*/
			rightImg=Image.createImage("/sayo16.png");/*you*/
			upImg=Image.createImage("/sayo14.png");/*shang*/
			currentImg=downImg;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,120,100,0);
	}
	public void keyPressed(int keyCode){	/*转向判断*/
		int action=getGameAction(keyCode);
		if(action==LEFT){					/*向左*/
			currentImg=leftImg;
			System.out.println("左转");
		}
		if(action==RIGHT){			/*向右*/
			currentImg=rightImg;
			System.out.println("右转");
		}
		if(action==UP){				/*向上*/
			currentImg=upImg;
			System.out.println("向上");
		}
		if(action==DOWN){				/*向下*/
			currentImg=downImg;
			System.out.println("向下")	
		}
		repaint();
	}
}
