import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;

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
	Random rd=new Random();
	Thread thread;
	int i,flag;
	int bossX,bossY,heroX,heroY;
	Image heroImg[][]=new Image[4][3];
	Image bossImg;
	Image currentImg;	//�������
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
			flag=1;

			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run(){			/* boss �ƶ�*/
		while(true){
			int rdNumber=rd.nextInt(12);/*��boss������֮һ�ĸ���׷��hero*/
			System.out.println(rdNumber);
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if(rdNumber%3==0){
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
			}
			repaint();
		}
	}
	public void paint(Graphics g){		/*��ͼƬ����*/
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);	
		g.drawImage(bossImg,bossX,bossY,0);	
	}
	public void keyPressed(int keyCode){	/*ת���ж�*/
		int action=getGameAction(keyCode);
		/*�����ƶ�*/
		if(action==LEFT){	
			changePicAndDir(0);
			heroX=heroX-2;
		}
		/*�����ƶ�*/
		else if(action==RIGHT){			
			changePicAndDir(1);
			heroX=heroX+2;
		}
		/*�����ƶ�*/
		else if(action==UP){				
			changePicAndDir(2);
			heroY=heroY-2;
		}
		/*�����ƶ�*/
		else if(action==DOWN){				
			changePicAndDir(3);
			heroY=heroY+2;
		}
	}

	void changePicAndDir(int direction){		/*��hero��ת����ƶ�*/
		if(currentImg!=heroImg[direction][1]&&currentImg!=heroImg[direction][0]&&currentImg!=heroImg[direction][2])					
			currentImg=heroImg[direction][1];
		else if(flag==1){
			currentImg=heroImg[direction][0];
			flag++;
		}
		else if(flag==2){
			currentImg=heroImg[direction][2];
			flag=1;
		}
	}
}