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
	int x,y;
	Image downImg,leftImg,leftImg1,leftImg2,rightImg,upImg,currentImg;	//定义变量
	public MainCanvas(){
		try	
		{
			downImg=Image.createImage("/sayo10.png");/*xia*/
			leftImg=Image.createImage("/sayo12.png");/*zuo*/
			leftImg1=Image.createImage("/sayo02.png");/*zuo*/
			leftImg2=Image.createImage("/sayo22.png");/*zuo*/
			rightImg=Image.createImage("/sayo16.png");/*you*/
			upImg=Image.createImage("/sayo14.png");/*shang*/
			currentImg=downImg;
			x=120;
			y=100;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){	/*转向判断*/
		int action=getGameAction(keyCode);
		if(action==LEFT){					/*向左*/
			currentImg=leftImg;
			x=x-5;
			
		}
		if(action==RIGHT){			/*向右*/
			currentImg=rightImg;
			x=x+5;
		}
		if(action==UP){				/*向上*/
			currentImg=upImg;
			y=y-5;
		}
		if(action==DOWN){				/*向下*/
			currentImg=downImg;
			y=y+5;
		}
	}

		if (x%2!=0)
			{
			}
		repaint();

}
