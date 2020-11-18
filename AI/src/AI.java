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


public class MainCanvas extends Canvas
{	
	int x,y,Change;

	Image downImg1,downImg2,leftImg1,leftImg2,upImg1,upImg2,rightImg1,rightImg2,currentImg;

	public MainCanvas(){
		try
		{
			downImg1=Image.createImage("/sayo00.png"); //DOWN
			leftImg1=Image.createImage("/sayo02.png"); //LEFT
			upImg1=Image.createImage("/sayo04.png"); //UP
			rightImg1=Image.createImage("/sayo06.png"); //RIGHT

			downImg2=Image.createImage("/sayo20.png"); //DOWN
			leftImg2=Image.createImage("/sayo22.png"); //LEFT
			upImg2=Image.createImage("/sayo24.png"); //UP
			rightImg2=Image.createImage("/sayo26.png"); //RIGHT


			x=110;
			y=140;


			currentImg=downImg1;
			
			Change=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}


	public void paint(Graphics g){
		g.setColor(0,255,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}


	public void keyPressed(int keyCode)
	{
			if(action==LEFT)
			{
				currentImg=leftimg1;
				x=x-2;
			}
			else if(action==RIGHT)
			{
				currentImg=rightimg1;
				x=x+2;
			}
			else if(action==UP)
			{
				currentImg=upimg1;
				y=y-2;
			}
			else if(action==DOWN)
			{
				currentImg=downImg1;
				y=y+2;
			}

		repaint();
	}
}