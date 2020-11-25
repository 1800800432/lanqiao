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
	Image currentImg;
	Image heroImg[][]=new Image[4][3];
	int heroX,heroY;
	int flag;
	public MainCanvas(){
		try	
		{
			heroX=120;
			heroY=100;
			/*
			i:
			0:down
			1:left
			2:up
			3:right
			*/
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++)
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
			currentImg=heroImg[0][1];
			flag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT)
		{
			changePicAndDir(1);
			heroX=heroX-3;
		}
		if(action==RIGHT)
		{
			changePicAndDir(3);
			heroX=heroX+3;
		}
		if(action==UP)
		{
			changePicAndDir(2);
			heroY=heroY-3;
		}
		if(action==DOWN)
		{
			changePicAndDir(0);
			heroY=heroY+3;
		}
		repaint();
	}
	void changePicAndDir(int i){
		if(currentImg==heroImg[i][0]||currentImg==heroImg[i][1]||currentImg==heroImg[i][2])
			{
				if(flag==1){
					currentImg=heroImg[i][0];
					flag++;
				}
				else{
					currentImg=heroImg[i][2];
					flag=1;
				}
			}
			else
				currentImg=heroImg[i][1];
	}
}