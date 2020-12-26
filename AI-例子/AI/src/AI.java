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
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	Image heroImage[][]=new Image[4][3];
	Image currentImg;

	int x=120,y=100;

	public MainCanvas(){
		try
		{
			/*
			0:Left
			1:Right
			2:Up
			3:Down
			*/
			for (int i=0;i<heroImage.length ;i++)
			{
				for (int j=0;j<heroImage[i].length ;j++ )
				{
					heroImage[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}

			currentImg=heroImage[3][1];

			Flag=1;

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}

	public void changePicAndMove(int derection){
		if(Flag==1)
			{
				currentImg=heroImage[derection][1];
				Flag++;
			}
		else if(Flag==2)
		{
			currentImg=heroImage[derection][2];
			Flag=1;
		}

	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/

		if(action==LEFT){
			changePicAndMove(0);
			x=x-1;
		}
		if(action==RIGHT){
			changePicAndMove(1);
			x=x+1;
		}

		if(action==UP){
			changePicAndMove(2);
			y=y-1;
		}

		if(action==DOWN){
			changePicAndMove(3);
			y=y+1;
		}
		repaint();
	}
}