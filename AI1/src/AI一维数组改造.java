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
	int leftFlag,rightFlag,upFlag,downFlag;
	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
	Image currentImg;

	public MainCanvas(){
		try
		{
			x=120;
			y=100;
			for(int i=0;i<heroLeftImg.length;i++){
				heroLeftImg[i]=Image.createImage("/sayo0"+i+".png");
				heroRightImg[i]=Image.createImage("/sayo1"+i+".png");
				heroUpImg[i]=Image.createImage("/sayo2"+i+".png");
				heroDownImg[i]=Image.createImage("/sayo3"+i+".png");
			}

			currentImg=heroDownImg[1];

			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/

		if(action==LEFT){
			if(leftFlag==1){
				currentImg=heroLeftImg[1];
				leftFlag++;
			}
			else if(leftFlag==2){
				currentImg=heroLeftImg[2];
				leftFlag--;
			}
			x=x-1;
		}

		if(action==RIGHT){
			if(rightFlag==1){
				currentImg=heroRightImg[1];
				rightFlag++;
			}
			else if(rightFlag==2){
				currentImg=heroRightImg[2];
				rightFlag--;
			}
			x=x+1;
		}

		if(action==UP){
			if(upFlag==1){
				currentImg=heroUpImg[1];
				upFlag++;
			}
			else if(upFlag==2){
				currentImg=heroUpImg[2];
				upFlag--;
			}
			y=y-1;
		}

		if(action==DOWN){
			if(downFlag==1){
				currentImg=heroDownImg[1];
				downFlag++;
			}
			else if(downFlag==2){
				currentImg=heroDownImg[2];
				downFlag--;
		}
		y=y+1;
		}
		repaint();
	}
}
