import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.Container;
public class XandOval extends JFrame{
	private final JButton[] buttons;
	private boolean dissabled;
	private final Container container;
	private final GridLayout gridLayout;
	private String[] choices={"x","o"};
	private Icon[] icons;
	private static int counter=9;
	public XandOval(){
		super("X and Oval game application");
		JMenu filemenu=new JMenu("File");
		filemenu.setMnemonic('F');
		
		JMenuItem about=new JMenuItem("About...");
		about.setMnemonic('A');
		filemenu.add(about);
		
		JMenuItem close=new JMenuItem("Close");
		close.setMnemonic('C');
		filemenu.add(close);
		

		
		about.addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent event){
					JOptionPane message=new JOptionPane();
					message.showMessageDialog(null,"I am testing XandOval game in java GUI");
				}
			}
			);
		
		close.addActionListener(
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent event){
					JOptionPane message=new JOptionPane();
					message.showMessageDialog(null,"The game is closed");
					System.exit(0);
				}
			}
			);	
		JMenuBar menubar=new JMenuBar();
		setJMenuBar(menubar);
		menubar.add(filemenu);
		
		gridLayout=new GridLayout(3,3,3,3);
		container =getContentPane();
		setLayout(gridLayout);
		
	  	Icon icon3=new ImageIcon(getClass().getResource("click.png"));
	  	
		ButtonHandler buttonHandler=new ButtonHandler();
		buttons=new JButton[9];
		for(int i=0;i<buttons.length;i++)
		{
			buttons[i]=new JButton();
			buttons[i].setIcon(icon3);
			buttons[i].setText("");
			buttons[i].addActionListener(buttonHandler);
			add(buttons[i]);	
		}
		icons=new ImageIcon[2];
		icons[0]=new ImageIcon(getClass().getResource(choices[0]+".png"));
		icons[1]=new ImageIcon(getClass().getResource(choices[1]+".png"));
		JOptionPane message=new JOptionPane();
	    message.showMessageDialog(null,"First player default choice is X","The second player default choice is O",JOptionPane.INFORMATION_MESSAGE,icons[0]);


				
				
	}
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			int k=0;
			counter=9;
			Icon icon1=new ImageIcon(getClass().getResource(choices[0]+".png"));
	    	Icon icon2=new ImageIcon(getClass().getResource(choices[1]+".png"));
	     	Icon icon3=new ImageIcon(getClass().getResource("click.png"));
			JOptionPane message=new JOptionPane();
	  // 	message.showConfirmDialog(null,icon1,"First Player please do your choice",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE ,icon2);
		//	String str="";

			for(int i=0;i<buttons.length;i++)
			{
				if(buttons[i].isEnabled())
				{
					k++;
				}
				else
					counter--;
					
			}
			
	    	for(int i=0;i<buttons.length;i++)
			{
				if(event.getSource()==buttons[i]&&(counter==9||counter==7||counter==5||counter==3||counter==1))
				{
					buttons[i].setIcon(icon1);
					buttons[i].setEnabled(false);
					buttons[i].setText("Player 1");
					break;
				}
				else if(event.getSource()==buttons[i]&&(counter==8||counter==6||counter==4||counter==2))
				{
					buttons[i].setIcon(icon2);
					buttons[i].setEnabled(false);
					buttons[i].setText("Player 2");
					break;
				}
			}

		
			if(((((buttons[3].getText()!="")&&((buttons[3].getText()==buttons[4].getText()&& buttons[4].getText()==buttons[5].getText()))) || (buttons[1].getText()!="")&&((buttons[1].getText()==buttons[4].getText()&& buttons[4].getText()==buttons[7].getText()))) || (buttons[0].getText()!="")&&((buttons[0].getText()==buttons[1].getText()&& buttons[1].getText()==buttons[2].getText()))) || ((buttons[0].getText()!="")&&((buttons[0].getText()==buttons[3].getText()&& buttons[3].getText()==buttons[6].getText()))) || (buttons[6].getText()!="")&&((buttons[6].getText()==buttons[7].getText()&& buttons[7].getText()==buttons[8].getText())) || (buttons[8].getText()!="")&&((buttons[8].getText()==buttons[5].getText()&& buttons[5].getText()==buttons[2].getText())) || (buttons[0].getText()!="")&&((buttons[0].getText()==buttons[4].getText()&& buttons[4].getText()==buttons[8].getText())) || (buttons[2].getText()!="")&&((buttons[2].getText()==buttons[4].getText()&& buttons[4].getText()==buttons[6].getText())))
		    {
	           message.showMessageDialog(null,"Congratulations!!!","You are the winner",JOptionPane.INFORMATION_MESSAGE);
	           for(int i=0;i<buttons.length;i++)
	           {
	           	   buttons[i].setIcon(icon3);
			       buttons[i].setText("");		
			       buttons[i].setEnabled(true);
	           }
			}
			else
			{
			counter=9;
			for(int i=0;i<buttons.length;i++)
			{
				if(buttons[i].isEnabled())
				{
					counter+=0;
					
				}
				else
					counter--;
				
			}
			if(counter==0)
			{
		      message.showMessageDialog(null,"New game will be started","NO WINNER!",JOptionPane.INFORMATION_MESSAGE);
				for(int i=0;i<buttons.length;i++)
			{
			    buttons[i].setIcon(icon3);
			    buttons[i].setText("");		
			    buttons[i].setEnabled(true);
				
			}
			}

				counter=9;
	    }
	
	}
}
}

