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
class MainCanvas extends Canvas implements Runnable
{
	Thread thread;
	int i,LeftFlag,RightFlag,UpFlag,DownFlag;
	int bossX,bossY,heroX,heroY;
	Image heroImg[][]=new Image[4][3];
	Image bossImg;
	Image currentImg;	//定义变量
	public MainCanvas(){
		try	
		{
			/*
			i:
			0:left
			1:right
			2:up
			3:dowm
			*/
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++)
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][1];
			heroX=120;
			heroY=100;
			bossX=0;
			bossY=0;
			LeftFlag=1;
			RightFlag=1;
			UpFlag=1;
			DownFlag=1;

			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if(bossX<heroX){
				bossX++;
			}
			else{
				bossX--;
			}
			if(bossY<heroY){
				bossY++;
			}
			else{
				bossY--;
			}

			repaint();
		}
	}

	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);	
		g.drawImage(bossImg,bossX,bossY,0);	
	}
	public void keyPressed(int keyCode){	/*转向判断*/
		int action=getGameAction(keyCode);
		/*向左移动*/
		if(action==LEFT){	
			if(currentImg!=heroImg[0][1]&&currentImg!=heroImg[0][0]&&currentImg!=heroImg[0][2])					
			currentImg=heroImg[0][1];
				else if(LeftFlag==1)
					{
						currentImg=heroImg[0][0];
						LeftFlag++;
					}
				else if(LeftFlag==2)
					{
						currentImg=heroImg[0][2];
						LeftFlag=1;
					}
			heroX=heroX-2;
		}


		/*向右移动*/
		else if(action==RIGHT){			
		if(currentImg!=heroImg[1][1]&&currentImg!=heroImg[1][0]&&currentImg!=heroImg[1][2])					
			currentImg=heroImg[1][1];
		else if(RightFlag==1){
			currentImg=heroImg[1][0];
			RightFlag++;
		}
		else if(RightFlag==2){
			currentImg=heroImg[1][2];
			RightFlag=1;
		}
			heroX=heroX+2;
		}


		/*向上移动*/
		else if(action==UP){				
			if(currentImg!=heroImg[2][1]&&currentImg!=heroImg[2][0]&&currentImg!=heroImg[2][2])					
			currentImg=heroImg[2][1];
		else if(UpFlag==1){
			currentImg=heroImg[2][0];
			UpFlag++;
		}
		else if(UpFlag==2){
			currentImg=heroImg[2][2];
			UpFlag=1;
		}
			heroY=heroY-2;
		}


		/*向下移动*/
		else if(action==DOWN){				
			if(currentImg!=heroImg[3][1]&&currentImg!=heroImg[3][0]&&currentImg!=heroImg[3][2])					
			currentImg=heroImg[3][1];
		else if(DownFlag==1){
			currentImg=heroImg[3][0];
			DownFlag++;
		}
		else if(DownFlag==2){
			currentImg=heroImg[3][2];
			DownFlag=1;
		}
			heroY=heroY+2;
		}
		
		
	}
}

