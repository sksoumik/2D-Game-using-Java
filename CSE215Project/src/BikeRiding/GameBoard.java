package BikeRiding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoard  extends JPanel implements KeyListener
{
	
	Bike bike;
	Coin[] coin = new Coin[10];
	 int  count = 0;
	 int bonus = 50; 
	
	public GameBoard()
	{
		super();
		super.addKeyListener(this);
		super.setFocusable(true);
		
		bike = new Bike(5,591,"bikeStraight.png");
		
		coin[0] = new Coin(74,592,true,"coin.png");
		coin[1] = new Coin(165,555,true,"coin.png");
		coin[2] = new Coin(212,510,true,"coin.png");
		coin[3] = new Coin(326,592,true,"coin.png");
		coin[4] = new Coin(440,520,true,"coin.png");
		coin[5] = new Coin(530,425,true,"coin.png");
		coin[6] = new Coin(620,330,true,"coin.png");
		coin[7] = new Coin(750,320,true,"coin.png");
		coin[8] = new Coin(815,465,true,"coin.png");
		coin[9] = new Coin(945,591,true,"coin.png");
	}
	
	public void paint(Graphics g)
	{
		
		ImageIcon background = new ImageIcon("mountain.png");
		g.drawImage(background.getImage(), 0, 0, null);

		bike.draw(g);
		
		for(int i=0;i<coin.length;i++)
		{
			if(coin[i].isThere() == true)
				coin[i].draw(g);
		}
		
		g.setColor(Color.cyan);
		Font any = new Font ("sakib",Font.BOLD,50);
		g.setFont(any);
		
		if(bike.getX()==940)                                                        
			g.drawString("STAGE 1 COMPLETE", 330, 250);
		
		g.setColor(Color.LIGHT_GRAY);
		
		if(bike.getX()==5)
			g.drawString("PRESS RIGHT KEY TO START", 200, 250);
		else if(bike.getX()>=612 && bike.getX()<800)
			g.drawString("HOLD 'J' FOR JUMP", 300, 250);
		else if(bike.getX() == 800)
			g.drawString("PRESS RIGHT KEY", 300, 250);
		
		g.setColor(Color.cyan);
		Font f = new Font ("sakib",Font.BOLD,30);
		g.setFont(f);
		
		CheckCollision();
		
		g.drawString("score >>" + count, 100, 100);
		
		if(bike.getX() ==  940 && bike.getY() == 591)
			{	
				count = 150;
				g.drawString("bonus >> " + bonus, 100, 150);
			}
	}
	
	 public void CheckCollision()
	 
	{
		Rectangle bikeRect = new Rectangle(bike.getX(),bike.getY(),35,35);
		
		for(int i = 0; i < coin.length; i++)
		{
			
			Rectangle coinRect = new Rectangle(coin[i].getX(),coin[i].getY(),40,40);
			
			if(bikeRect.intersects(coinRect) == true)
			{
				coin[i].isThere(false);
				coin[i].setX(-3000);
				count+=10;
				GameSound.music();
				break;
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{	
		
		if(e.getKeyCode() == KeyEvent.VK_J)                                                                             //jump key functionality
		{	
			 if(bike.getX()>=612 && bike.getX()<670)
			 {
				 bike.setX(bike.getX()+1);
				 bike.setY(bike.getY()-1);
				 //System.out.println(bike.getX()+"----"+bike.getY());					
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			 
			 else if(bike.getX()>=670 && bike.getX()<685)
			 {
				 bike.setX(685);
				 bike.setY(260);
				 //System.out.println(bike.getX()+"----"+bike.getY());		
				 bike = new Bike(bike.getX(),bike.getY(),"bikeStraight.png");
			 } 
			 
			 else if(bike.getX()>=685 && bike.getX()<730)
			 {
				 bike.setX(bike.getX()+1);
				 bike.setY(bike.getY()+1);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeStraight.png");
			 }
			 
			else if(bike.getX()>=730 && bike.getX()<732)
			 {
				 bike.setX(732);
				 bike.setY(320);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeDown2.png");
			 }
			 
			else if(bike.getX()>=732 && bike.getX()<750)
			 {
				 bike.setX(bike.getX()+1);
				 bike.setY(bike.getY()+1);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeDown2.png");
			 }
			 
			else if(bike.getX()>=750 && bike.getX()<760)
			 {
				 bike.setX(760);
				 bike.setY(380);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeDown1.png");
			 }
			 
			else if(bike.getX()>=760 && bike.getX()<780)
			 {
				 bike.setX(bike.getX()+1);
				 bike.setY(bike.getY()+2);
				// System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeDown1.png");
			 }
			
			else if(bike.getX()>=780 && bike.getX()<800)
			 {
				 bike.setX(800);
				 bike.setY(450);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeDown1.png");
			 }
			super.repaint();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)                                                                // left key functionality
		{
			 if(bike.getX()>=1 && bike.getX()<107)
				{
					bike.setX(bike.getX() - 1);
					bike.setY(bike.getY() );
					//System.out.println(bike.getX()+"----"+bike.getY());
				}
			
			 else if(bike.getX()>=114 && bike.getX()<175)
			 {
				 bike.setX(bike.getX()-1);
				 bike.setY(bike.getY()+1);
				//System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			
			 else if(bike.getX() >=175 && bike.getX()<210)
			 {	
				 bike.setX(210);
				 bike.setY(510);
				// System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeStraight.png");
			 }
			 
			 else if(bike.getX() >=210 && bike.getX()<226)
			 {	
				 bike.setX(226);
				 bike.setY(512);
				//System.out.println(bike.getX()+"----"+bike.getY());	 
				 bike = new Bike(bike.getX(),bike.getY(),"bikeDown1.png");
			 }
			 
			 else if(bike.getX() >=226 && bike.getX()<280)
			 {	
				 bike.setX(bike.getX()-1);
				 bike.setY(bike.getY()-1);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeDown1.png");
			 }
			 
			 else if (bike.getX()>=280 && bike.getX()<305)
			 {
				 bike.setX(305);
				 bike.setY(590);
				 System.out.println(bike.getX()+"----"+bike.getY());		
				 bike = new Bike(bike.getX(),bike.getY(),"bikeStraight.png");
			 }
			 
			 else if(bike.getX()>=305 && bike.getX()<355)
			 {
				 bike.setX(bike.getX()-1);
				 bike.setY(bike.getY());
				 System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeStraight.png");
			 }
			 
			 else if(bike.getX()>=355 && bike.getX()<360)
			 {
				 bike.setX(360);
				 bike.setY(555);
				 System.out.println(bike.getX()+"----"+bike.getY());	
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			 
			 else if(bike.getX()>=360 && bike.getX()<480)
			 {	
				 bike.setX(bike.getX()-2);
				 bike.setY(bike.getY()+2);
				 System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 } 
			
			 else if(bike.getX()>=480 && bike.getX()<481)
			 {	
				 bike.setX(481);
				 bike.setY(430);
				 System.out.println(bike.getX()+"----"+bike.getY());		
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");		 
			 }
			 
			 else if(bike.getX()>=481 && bike.getX()<520)
			 {
				 bike.setX(bike.getX()-2);
				 bike.setY(bike.getY()+2);
				 System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			 
			 else if(bike.getX()>=520 && bike.getX()<521)
			 {
				 bike.setX(521);
				 bike.setY(385);
				// System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			 
			 else if(bike.getX()>=521 && bike.getX()<610)
			 {
				 bike.setX(bike.getX()-1);
				 bike.setY(bike.getY()+1);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			 
			 else if(bike.getX()>=610 && bike.getX()<612)
			 {
				 bike.setX(612);
				 bike.setY(290);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 } 
			 
			 else if(bike.getX()>=612 && bike.getX()<660)
			 {
				 bike.setX(bike.getX()-1);
				 bike.setY(bike.getY()+1);
				// System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			
			 super.repaint();
		}
		
		 if(e.getKeyCode() == KeyEvent.VK_RIGHT)                                                               //right key functionality
		 {
				
			 if(bike.getX() >=0 && bike.getX()<107)
			{
				bike.setX(bike.getX() + 2);
				//System.out.println(bike.getX()+"----"+bike.getY());
			}
			  
			 else if(bike.getX()>=107 && bike.getX()<114)
			 {	 	
				 bike.setX(114);
				 bike.setY(555);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			 
			 else if(bike.getX()>=114 && bike.getX()<175)
			 {
				 bike.setX(bike.getX()+2);
				 bike.setY(bike.getY()-2);
				//System.out.println(bike.getX()+"----"+bike.getY());	 
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			 
			 else if(bike.getX() >=175 && bike.getX()<215)
			 {	
				 bike.setX(215);
				 bike.setY(510);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeStraight.png");
			 }
			 
			 else if(bike.getX() >=215 && bike.getX()<220)
			 {	
				 bike.setX(bike.getX()+2);
				//System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeStraight.png");
			 }
			 
			 else if(bike.getX() >=220 && bike.getX()<226)
			 {	
				 bike.setX(226);
				 bike.setY(512);
				//System.out.println(bike.getX()+"----"+bike.getY());	 
				 bike = new Bike(bike.getX(),bike.getY(),"bikeDown1.png");
			 }
			 
			 else if(bike.getX() >=226 && bike.getX()<280)
			 {	
				 bike.setX(bike.getX()+2);
				 bike.setY(bike.getY()+2);
				// System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeDown1.png");
			 }
			 
			 else if (bike.getX()>=280 && bike.getX()<305)
			 {
				 bike.setX(305);
				 bike.setY(590);
				// System.out.println(bike.getX()+"----"+bike.getY());		
				 bike = new Bike(bike.getX(),bike.getY(),"bikeStraight.png");
			 }
			 
			 else if(bike.getX()>=305 && bike.getX()<355)
			 {
				 bike.setX(bike.getX()+2);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeStraight.png");
			 }
			 
			 else if(bike.getX()>=355 && bike.getX()<360)
			 {
				 bike.setX(360);
				 bike.setY(555);
				// System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			  }
			 
			 else if(bike.getX()>=360 && bike.getX()<480)
			 {	
				 bike.setX(bike.getX()+2);
				 bike.setY(bike.getY()-2);
				 //System.out.println(bike.getX()+"----"+bike.getY());		
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
					 
			 } 
			
			 else if(bike.getX()>=480 && bike.getX()<481)
			 {	
				 bike.setX(481);
				 bike.setY(430);
				// System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");					 
			 }
			 
			 else if(bike.getX()>=481 && bike.getX()<520)
			 {
				 bike.setX(bike.getX()+2);
				 bike.setY(bike.getY()-2);
				 //System.out.println(bike.getX()+"----"+bike.getY());
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			 
			 else if(bike.getX()>=520 && bike.getX()<521)
			 {
				 bike.setX(521);
				 bike.setY(370);
				 //System.out.println(bike.getX()+"----"+bike.getY());					
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");					
			 }
			 
			 else if(bike.getX()>=521 && bike.getX()<545)
			 {
				 bike.setX(bike.getX()+2);
				 bike.setY(bike.getY()-2);
				 //System.out.println(bike.getX()+"----"+bike.getY());					
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			 else if(bike.getX()>=545 && bike.getX()<546)
			 {

				 bike.setX(546);
				 bike.setY(358);
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			
			 }
			 else if(bike.getX() >=546 && bike.getX()<608)
			 {	
				 bike.setX(bike.getX()+2);
				 bike.setY(bike.getY()-2);
				 //System.out.println(bike.getX()+"----"+bike.getY());					
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			 else if(bike.getX() >=608 && bike.getX()<612)
			 {	
				 bike.setX(612);
				 bike.setY(290);
				 bike = new Bike(bike.getX(),bike.getY(),"bikeUp1.png");
			 }
			else if(bike.getX()>=800 && bike.getX()<920)
			 {
				 bike.setX(bike.getX()+3);
				 bike.setY(bike.getY()+3);
				// System.out.println(bike.getX()+"----"+bike.getY());					
				 bike = new Bike(bike.getX(),bike.getY(),"bikeDown1.png");
			 }
			 
			else if(bike.getX()>=920 && bike.getX()<940)
			 {
				 bike.setX(940);
				 bike.setY(591);
				// System.out.println(bike.getX()+"----"+bike.getY());					
				 bike = new Bike(bike.getX(),bike.getY(),"bikeStraight.png");
			 }
			 
		super.repaint();
		 }		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}