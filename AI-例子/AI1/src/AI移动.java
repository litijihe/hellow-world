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
	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	Image leftImg,rightImg,downImg,upImg;
	Image currentImg;

	public MainCanvas(){
		try
		{
			x=120;
			y=100;
			currentImg=Image.createImage("/sayo31.png");
			//左
			leftImg=Image.createImage("/sayo01.png");
			//右
			rightImg=Image.createImage("/sayo11.png");
			//上
			upImg=Image.createImage("/sayo21.png");
			//下
			downImg=Image.createImage("/sayo31.png");

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
			currentImg=leftImg;
			x=x-1;
		}

		if(action==RIGHT){
			currentImg=rightImg;
			x=x+1;
		}

		if(action==UP){
			currentImg=upImg;
			y=y-1;
		}

		if(action==DOWN){
			currentImg=downImg;
			y=y+1;
		}
		repaint();
	}
}