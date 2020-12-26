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
	int Flag;
	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	Image heroImg[][]=new Image[4][3];
	Image currentImg;

	public MainCanvas(){
		try
		{
			x=120;
			y=100;
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}

			currentImg=heroImg[3][1];

			Flag=1;

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

	public void changPicAndMove(int derection){
		if(Flag==1){
				currentImg=heroImg[derection][1];
				Flag++;
			}
			else if(Flag==2){
				currentImg=heroImg[derection][2];
				Flag--;
			}
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/

		if(action==LEFT){
			changPicAndMove(0);
			x=x-1;
		}

		if(action==RIGHT){
			changPicAndMove(1);
			x=x+1;
		}

		if(action==UP){
			changPicAndMove(2);
			y=y-1;
		}

		if(action==DOWN){
			changPicAndMove(3);
			y=y+1;
		}
		repaint();
	}
}
