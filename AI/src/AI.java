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
	int LeftFlag,RightFlag,UpFlag,DownFlag;
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

			LeftFlag=0;
			RightFlag=0;
			UpFlag=0;
			DownFlag=0;

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

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/

		if(action==LEFT){
			/*
			实现转向代码
			给变量重新赋值即可
			*/
			if(LeftFlag==0)
			{
				currentImg=heroImage[0][1];
				LeftFlag++;
			}
			if(LeftFlag==2)
			{
				currentImg=heroImage[0][2];
				LeftFlag=0;
			}
			x=x-1;
			repaint();
		}

		if(action==RIGHT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			if(RightFlag==0)
			{
				currentImg=heroImage[1][1];
				RightFlag++;
			}
			if(RightFlag==2)
			{
				currentImg=heroImage[1][2];
				RightFlag=0;
			}
			x=x+1;
			repaint();
		}

		if(action==UP){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			if(UpFlag==0)
			{
				currentImg=heroImage[2][1];
				UpFlag++;
			}
			if(UpFlag==2)
			{
				currentImg=heroImage[2][2];
				UpFlag=0;
			}
			y=y-1;
			repaint();
		}

		if(action==DOWN){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			if(DownFlag==0)
			{
				currentImg=heroImage[3][1];
				DownFlag++;
			}
			if(DownFlag==2)
			{
				currentImg=heroImage[3][2];
				DownFlag=0;
			}
			y=y+1;
			repaint();
		}
	}
}