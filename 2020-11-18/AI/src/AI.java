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
	int i,x,y,LeftFlag,RightFlag,UpFlag,DownFlag;
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
	Image currentImg;	//定义变量
	public MainCanvas(){
		try	
		{
			for(i=0;i<heroDownImg.length;i++)
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			/*downImg=Image.createImage("/sayo10.png");xia
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");*/


			for(i=0;i<heroLeftImg.length;i++)
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			/*leftImg=Image.createImage("/sayo12.png");zuo
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");*/
	
			for(i=0;i<heroRightImg.length;i++)
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			/*rightImg=Image.createImage("/sayo16.png");you
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");*/

			for(i=0;i<heroUpImg.length;i++)
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			/*upImg=Image.createImage("/sayo14.png");shang
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");*/
			currentImg=heroDownImg[1];
			x=120;
			y=100;
			LeftFlag=1;
			RightFlag=1;
			UpFlag=1;
			DownFlag=1;
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


		/*向左移动*/
		if(action==LEFT){	
			if(currentImg!=heroLeftImg[1]&&currentImg!=heroLeftImg[0]&&currentImg!=heroLeftImg[2])					
			currentImg=heroLeftImg[1];
				else if(LeftFlag==1)
					{
						currentImg=heroLeftImg[0];
						LeftFlag++;
					}
				else if(LeftFlag==2)
					{
						currentImg=heroLeftImg[2];
						LeftFlag=1;
					}
			x=x-2;
		}


		/*向右移动*/
		else if(action==RIGHT){			
		if(currentImg!=heroRightImg[1]&&currentImg!=heroRightImg[0]&&currentImg!=heroRightImg[2])					
			currentImg=heroRightImg[1];
		else if(RightFlag==1){
			currentImg=heroRightImg[0];
			RightFlag++;
		}
		else if(RightFlag==2){
			currentImg=heroRightImg[2];
			RightFlag=1;
		}
			x=x+2;
		}


		/*向上移动*/
		else if(action==UP){				
			if(currentImg!=heroUpImg[1]&&currentImg!=heroUpImg[0]&&currentImg!=heroUpImg[2])					
			currentImg=heroUpImg[1];
		else if(UpFlag==1){
			currentImg=heroUpImg[0];
			UpFlag++;
		}
		else if(UpFlag==2){
			currentImg=heroUpImg[2];
			UpFlag=1;
		}
			y=y-2;
		}


		/*向下移动*/
		else if(action==DOWN){				
			if(currentImg!=heroDownImg[1]&&currentImg!=heroDownImg[0]&&currentImg!=heroDownImg[2])					
			currentImg=heroDownImg[1];
		else if(DownFlag==1){
			currentImg=heroDownImg[0];
			DownFlag++;
		}
		else if(DownFlag==2){
			currentImg=heroDownImg[2];
			DownFlag=1;
		}
			y=y+2;
		}
		
		repaint();
	}
}

