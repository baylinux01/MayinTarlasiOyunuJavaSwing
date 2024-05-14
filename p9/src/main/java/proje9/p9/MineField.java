package proje9.p9;


import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class MineField extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int colnumber=10;
	private int rownumber=10;
	private Object [] [] fieldBtn = new Object [rownumber] [colnumber];
	private Btn btn;
	private int width=600;
	private int height=600;
	private Timer timer;
	
	
	public boolean winned() 
	{   int count=0;
		for(int i=0; i<rownumber ;i++) 
		{
			for(int j=0; j<colnumber;j++) 
			{
				if(((Btn) fieldBtn[i][j]).isOpened()==true) count++;
			}
			
			
		}
		if (count>=(int)(((rownumber*colnumber)*90)/100)) return true;
		else return false;
		
	}
	
	public void open(int a, int b)
	{
		if(a<0 || a>=rownumber || b<0 || b>=colnumber || ((Btn) fieldBtn[a][b]).isOpened()==true 
				|| ((Btn) fieldBtn[a][b]).isEnabled()==false) {return;}
			
		else if(((Btn) fieldBtn[a][b]).getCount()==0 && ((Btn) fieldBtn[a][b]).isMined()==false)
			{
			 
			 ((Btn) fieldBtn[a][b]).setOpened(true);
			 ((Btn) fieldBtn[a][b]).setEnabled(false);
			 ((Btn) fieldBtn[a][b]).setIcon(null);
			 ((Btn) fieldBtn[a][b]).setFlagged(false);
			 
			 
			 
				open(a-1,b);
				open(a+1,b);
				open(a,b-1);
				open(a,b+1);
				open(a-1,b-1);
				open(a-1,b+1);
				open(a+1,b-1);
				open(a+1,b+1);
				
				return;
		
			 
			 	
//				for (int i=a-1;i<a+2;i++) 
//				{
//					for(int j=b-1;j<b+2;j++) 
//					{
//						if(a<0 || a>=rownumber || b<0 || b>=colnumber || ((Btn) fieldBtn[a][b]).isOpened()==true 
//								|| ((Btn) fieldBtn[a][b]).isEnabled()==false) {}
//						else 
//						{
//							
//							 open(((Btn) fieldBtn[i][j]).getRowno(),((Btn) fieldBtn[i][j]).getColno());
//						}
//					}
//				}
			}
	}
	
	
	
	public void print() 
	{
		for(int i=0;i<rownumber;i++) 
		{
			for(int j=0; j<colnumber;j++)
			{
				if(((Btn) fieldBtn[i][j]).isMined()==false)
				{((Btn) fieldBtn[i][j]).setText("T");}
			}
		}
	}
	
	public void determine_counts() 
	{
		for(int i=0;i<rownumber;i++)
		{
			for(int j=0; j<colnumber;j++) 
			{
				
		
					try {
						if(((Btn) fieldBtn[i+1][j]).isMined()==true) 
						{
							((Btn) fieldBtn[i][j]).setCount(((Btn) fieldBtn[i][j]).getCount()+1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					try {
						if(((Btn) fieldBtn[i-1][j]).isMined()==true) 
						{
							((Btn) fieldBtn[i][j]).setCount(((Btn) fieldBtn[i][j]).getCount()+1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					try {
						if(((Btn) fieldBtn[i][j+1]).isMined()==true) 
						{
							((Btn) fieldBtn[i][j]).setCount(((Btn) fieldBtn[i][j]).getCount()+1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					try {
						if(((Btn) fieldBtn[i][j-1]).isMined()==true) 
						{
							((Btn) fieldBtn[i][j]).setCount(((Btn) fieldBtn[i][j]).getCount()+1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					try {
						if(((Btn) fieldBtn[i+1][j+1]).isMined()==true) 
						{
							((Btn) fieldBtn[i][j]).setCount(((Btn) fieldBtn[i][j]).getCount()+1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					try {
						if(((Btn) fieldBtn[i+1][j-1]).isMined()==true) 
						{
							((Btn) fieldBtn[i][j]).setCount(((Btn) fieldBtn[i][j]).getCount()+1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					try {
						if(((Btn) fieldBtn[i-1][j+1]).isMined()==true) 
						{
							((Btn) fieldBtn[i][j]).setCount(((Btn) fieldBtn[i][j]).getCount()+1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					try {
						if(((Btn) fieldBtn[i-1][j-1]).isMined()==true) 
						{
							((Btn) fieldBtn[i][j]).setCount(((Btn) fieldBtn[i][j]).getCount()+1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
					}
					
			
			}
		}
		
				
	
	}
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineField frame = new MineField();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MineField() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width,height);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(10,10));

		setContentPane(contentPane);
		timer=new Timer(1,this);
		timer.start();
		for(int i=0;i<rownumber;i++) 
		{
			for(int j=0;j<colnumber;j++) 
			{
				fieldBtn[i][j]=new Btn();
				((Btn) fieldBtn[i][j]).setOpened(false);
				((Btn) fieldBtn[i][j]).setFlagged(false);
				((Btn) fieldBtn[i][j]).setRowno(i);
				((Btn) fieldBtn[i][j]).setColno(j);
				
			}
		}
		
		Random rand= new Random();
		for(int i=0;i<rownumber;i++) 
		{
			int a=(int)rand.nextInt(rownumber);
			int b=(int)rand.nextInt(colnumber);
			if (((Btn) fieldBtn[a][b]).isMined()==false) 
			{
				((Btn) fieldBtn[a][b]).setMined(true);
				
			}
			else 
			{
				i--;
			}
		}
		
		determine_counts();
		
		
		for(int i=0;i<rownumber;i++) 
		{
			for(int j=0;j<colnumber;j++) 
			{
			
				((Btn) fieldBtn[i][j]).addMouseListener(ml);
				contentPane.add((Btn) fieldBtn[i][j]);
				
				
				
				
			}
		}
		
		
		
		
		
		
		
		
	}
	MouseListener ml=new MouseListener() 
	{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e)
		{
			Btn b= (Btn) e.getComponent();
			if(e.getButton()==1) 
			{
				if (b.isMined()==false) 
				{
						
							b.setIcon(null);
							if(b.getCount()!=0) 
							{
								b.setText(b.getCount()+"");	
								b.setEnabled(false);
								b.setOpened(true);
							}
							
							if(b.getCount()==0)
							open(b.getRowno(),b.getColno());
							
				}		
				
				else if (b.isMined()==true) 
				{
				
				
					
					
					for(int i=0;i<rownumber;i++) 
					{
						for(int j=0;j<colnumber;j++) 
						{
							ImageIcon imageIc = new ImageIcon(getClass().getClassLoader().getResource("mine.png")); // load the image to a imageIcon
							Image image = imageIc.getImage(); // transform it 
							Image newimg = image.getScaledInstance(width/(colnumber*3), height/(rownumber*3),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
							imageIc = new ImageIcon(newimg); 
							if (((Btn) fieldBtn[i][j]).isMined()==true)
	                        {
								((Btn) fieldBtn[i][j]).setText("");
		                        ((Btn) fieldBtn[i][j]).setIcon(imageIc);
		                       
	                        }
							if (((Btn) fieldBtn[i][j]).isMined()==false)
	                        {
								((Btn) fieldBtn[i][j]).setText("");
		                         
	                        }
							
						}
						
					}
					JOptionPane.showMessageDialog(contentPane, "Mayına Bastınız Oyun Bitti!");
					for(int i=0;i<rownumber;i++) 
					{
						for(int j=0;j<colnumber;j++) 
						{
							((Btn) fieldBtn[i][j]).setEnabled(false);
							((Btn) fieldBtn[i][j]).removeMouseListener(ml);
						}
					}
					
					
				}
			}
			else if(e.getButton()==3) 
			{
				
				if(b.isFlagged()==false) 
				{
					
					ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("flag.png")); // load the image to a imageIcon
					Image image = imageIcon.getImage(); // transform it 
					Image newimg = image.getScaledInstance(width/(colnumber*3), height/(rownumber*3),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					imageIcon = new ImageIcon(newimg); 
					b.setIcon(imageIcon);
					b.setFlagged(true);
				}
				else if(b.isFlagged()!=false) 
				{
					b.setIcon(null);
					b.setFlagged(false);
				}
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public void actionPerformed(ActionEvent e) {
		
		if (winned()==true)
		{
			for(int i=0;i<rownumber;i++) 
			{
				for(int j=0;j<colnumber;j++) 
				{
					ImageIcon imageIc = new ImageIcon(getClass().getClassLoader().getResource("rose.png")); // load the image to a imageIcon
					Image image = imageIc.getImage(); // transform it 
					Image newimg = image.getScaledInstance(width/(colnumber*2), height/(rownumber*2),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					imageIc = new ImageIcon(newimg); 
					if (((Btn) fieldBtn[i][j]).isMined()==true)
                    {
                        ((Btn) fieldBtn[i][j]).setIcon(imageIc);
                        ((Btn) fieldBtn[i][j]).removeMouseListener(ml);
            
                    }
					if (((Btn) fieldBtn[i][j]).isMined()==false)
                    {
                        ((Btn) fieldBtn[i][j]).setText("");
                        ((Btn) fieldBtn[i][j]).removeMouseListener(ml);
            
                    }
		
				}
			}
			JOptionPane.showMessageDialog(contentPane, "Kazandınız Oyun Bitti!");
			for(int i=0;i<rownumber;i++) 
			{
				for(int j=0;j<colnumber;j++) 
				{
					((Btn) fieldBtn[i][j]).setFocusable(false);
				}
			}
			timer.stop();
		}
	}

}
