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
	Image leftImg,rightImg,downImg,upImg;
	Image leftImg1,rightImg1,downImg1,upImg1;
	Image currentImg;

	public MainCanvas(){
		try
		{
			x=120;
			y=100;
			currentImg=Image.createImage("/sayo31.png");
			//左
			leftImg=Image.createImage("/sayo01.png");
			leftImg1=Image.createImage("/sayo02.png");
			//右
			rightImg=Image.createImage("/sayo11.png");
			rightImg1=Image.createImage("/sayo12.png");
			//上
			upImg=Image.createImage("/sayo21.png");
			upImg1=Image.createImage("/sayo22.png");
			//下
			downImg=Image.createImage("/sayo31.png");
			downImg1=Image.createImage("/sayo32.png");

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
				currentImg=leftImg;
				leftFlag++;
			}
			else if(leftFlag==2){
				currentImg=leftImg1;
				leftFlag--;
			}
			x=x-1;
		}

		if(action==RIGHT){
			if(rightFlag==1){
				currentImg=rightImg;
				rightFlag++;
			}
			else if(rightFlag==2){
				currentImg=rightImg1;
				rightFlag--;
			}
			x=x+1;
		}

		if(action==UP){
			if(upFlag==1){
				currentImg=upImg;
				upFlag++;
			}
			else if(upFlag==2){
				currentImg=upImg1;
				upFlag--;
			}
			y=y-1;
		}

		if(action==DOWN){
			if(downFlag==1){
				currentImg=downImg;
				downFlag++;
			}
			else if(downFlag==2){
				currentImg=downImg1;
				downFlag--;
		}
		y=y+1;
		}
		repaint();
	}
}
