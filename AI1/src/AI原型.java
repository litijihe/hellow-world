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
	int Flag;
	/*
	����������
	�﷨���������� �������ƣ���ʶ����;
	*/
	Image heroImage[][]=new Image[4][3];
	Image currentImg;

	int x=120,y=100;

	public MainCanvas(){
		try
		{

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120��X���ꡢ100��Y����
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/

		if(action==LEFT){
			x=x-1;
		}
		if(action==RIGHT){
			x=x+1;
		}

		if(action==UP){
			y=y-1;
		}

		if(action==DOWN){
			y=y+1;
		}
		repaint();
	}
}