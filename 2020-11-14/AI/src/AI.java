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
	Image img,img1,img2,img3,currentImg;
	public MainCanvas(){
		try
		{
			img=Image.createImage("/sayo10.png");/*xia*/
			img1=Image.createImage("/sayo12.png");/*zuo*/
			img2=Image.createImage("/sayo16.png");/*you*/
			img3=Image.createImage("/sayo14.png");/*shang*/
			currentImg=img;
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
			currentImg=img1;
			System.out.println("xzz");
			repaint();
		}
		if(action==RIGHT){			/*向右*/
			currentImg=img2;
			repaint();
		}
		if(action==UP){				/*向上*/
			currentImg=img3;
			repaint();
		}
		if(action==DOWN){				/*向下*/
			currentImg=img;
			repaint();
		}
	}
}