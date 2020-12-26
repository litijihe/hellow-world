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
	����������
	�﷨���������� �������ƣ���ʶ����;
	*/
	Image leftImg,rightImg,downImg,upImg;
	Image currentImg;

	public MainCanvas(){
		try
		{
			x=120;
			y=100;
			currentImg=Image.createImage("/sayo31.png");
			//��
			leftImg=Image.createImage("/sayo01.png");
			//��
			rightImg=Image.createImage("/sayo11.png");
			//��
			upImg=Image.createImage("/sayo21.png");
			//��
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
		g.drawImage(currentImg,x,y,0);//120��X���ꡢ100��Y����
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
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