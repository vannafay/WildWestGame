package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class UI {
	
	GameManager gm; 
	
	JFrame window;
	public JTextArea messageText;
	public JPanel bgPanel[] = new JPanel[10];
	public JLabel bgLabel[] = new JLabel[10];
	
	//player UI
	JPanel lifePanel;
	JLabel lifeLabel[] = new JLabel[6];
	JPanel inventoryPanel;
	public JLabel gunLabel, flaskLabel, lanternLabel;
	
	//gave over UI
	public JLabel titleLabel;
	public JButton restartButton;
	
	public UI(GameManager gm) {
		
		this.gm = gm;
		
		createMainField();
		createPlayerFeild();
		createGameOverField();
		generateScreen();
		
		window.setVisible(true);
	}
	
   public void createMainField() {
	   
	   //background square(black)
	   window = new JFrame();
	   window.setSize(800,600);
	   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   window.getContentPane().setBackground(Color.black);
	   window.setLayout(null);
	   
	   //text at the bottom 
	   messageText = new JTextArea("THIS IS SAMPLE TEXT");
	   messageText.setBounds(50, 410, 700, 150);
	   messageText.setBackground(Color.black);
	   messageText.setForeground(Color.white);
	   messageText.setEditable(false);
	   messageText.setLineWrap(true);
	   messageText.setWrapStyleWord(true);
	   messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
	   window.add(messageText);
	   
   } 
   public void createBackground(int bgNum, String bgFileName) {
	  
	   //main square - act as game display 
	   bgPanel[bgNum] = new JPanel();
	   bgPanel[bgNum].setBounds(50,50,700,350);
	   bgPanel[bgNum].setBackground(Color.blue);
	   bgPanel[bgNum].setLayout(null);
	   bgPanel[bgNum].setVisible(false);
	   window.add(bgPanel[bgNum]);
	   
	   bgLabel[bgNum] = new JLabel();
	   bgLabel[bgNum].setBounds(0,0,700,350);
	   
	   ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
	   bgLabel[bgNum].setIcon(bgIcon);
   }
   
   public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName, 
		   String choice1Name, String choice2Name, String choice3Name, String choice1Command, String choice2Command, 
		   String choice3Command) {
	   
	   //create pop-up menu 
	   JPopupMenu popMenu = new JPopupMenu();
	   
	   //create pop-up menu items 
	   JMenuItem menuItem[] = new JMenuItem[4]; 
	   menuItem[1] = new JMenuItem(choice1Name);
	   menuItem[1].addActionListener(gm.aHandeler);
	   menuItem[1].setActionCommand(choice1Command);
	   popMenu.add(menuItem[1]);
	   
	   menuItem[2] = new JMenuItem(choice2Name);
	   menuItem[2].addActionListener(gm.aHandeler);
	   menuItem[2].setActionCommand(choice2Command);
	   popMenu.add(menuItem[2]);
	  
	   menuItem[3] = new JMenuItem(choice3Name);
	   menuItem[3].addActionListener(gm.aHandeler);
	   menuItem[3].setActionCommand(choice3Command);
	   popMenu.add(menuItem[3]);
	   
	   //create objects 
	   JLabel objectLabel = new JLabel();
	   objectLabel.setBounds(objx,objy,objWidth,objHeight);
	//   objectLabel.setOpaque(true);
    //   objectLabel.setBackground(Color.blue);
	   
	   ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
	   objectLabel.setIcon(objectIcon);
	   
	   objectLabel.addMouseListener(new MouseListener() {

		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			
			if(SwingUtilities.isRightMouseButton(e)) {
				popMenu.show(objectLabel, e.getX(), e.getY());
				
			}
			
		}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		});
	   
		
	   
	   bgPanel[bgNum].add(objectLabel);
   }
   
   public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command) {
	   
	   ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));
	   
	   JButton arrowButton = new JButton();
	   arrowButton.setBounds(x, y, width, height);
	   arrowButton.setBackground(null);
	   arrowButton.setContentAreaFilled(false);
	   arrowButton.setFocusPainted(false);
	   arrowButton.setIcon(arrowIcon);
	   arrowButton.addActionListener(gm.aHandeler);
	   arrowButton.setActionCommand(command);
	   arrowButton.setBorderPainted(false);
	   
	   bgPanel[bgNum].add(arrowButton);  
   }
   
   public void createPlayerFeild() {
	   
	   lifePanel = new JPanel();
	   lifePanel.setBounds(50,0,250,50);
	   lifePanel.setBackground(Color.black);
	   lifePanel.setLayout(new GridLayout(1,5));
	   window.add(lifePanel);
	   
	   ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
	   
	   int i = 1;
	   while(i<6) {
		   lifeLabel[i] = new JLabel();
		   lifeLabel[i].setIcon(lifeIcon);
		   lifePanel.add(lifeLabel[i]);
		   i++;
	   }
	   
	   inventoryPanel = new JPanel();
	   inventoryPanel.setBounds(650,0,100,50);
	   inventoryPanel.setBackground(Color.black);
	   inventoryPanel.setLayout(new GridLayout(1,3));
	   window.add(inventoryPanel);
	   
	   //create items
	   gunLabel = new JLabel();
	   ImageIcon gunIcon = new ImageIcon(getClass().getClassLoader().getResource("gun.png"));
	   gunLabel.setIcon(gunIcon);
	   inventoryPanel.add(gunLabel);
	   
	   flaskLabel = new JLabel();
	   ImageIcon flaskIcon = new ImageIcon(getClass().getClassLoader().getResource("flask.png"));
	   flaskLabel.setIcon(flaskIcon);
	   inventoryPanel.add(flaskLabel);
	   
	   lanternLabel = new JLabel();
	   ImageIcon lanternIcon = new ImageIcon(getClass().getClassLoader().getResource("lantern4.0.png"));
	   lanternLabel.setIcon(lanternIcon);
	   inventoryPanel.add(lanternLabel);
	   
   }
   
   public void createGameOverField() {
	   
	   titleLabel = new JLabel();
	   titleLabel.setBounds(200,150,400,200);
	   titleLabel.setForeground(Color.red);
	   titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 70));
	   titleLabel.setVisible(false);
	   window.add(titleLabel);
	   
	   restartButton = new JButton();
	   restartButton.setBounds(620,210,120,50);
	   restartButton.setBorder(null);
	   restartButton.setBackground(Color.black);
	   restartButton.setForeground(Color.white);
	   restartButton.setFocusPainted(false);
	   restartButton.addActionListener(gm.aHandeler);
	   restartButton.setActionCommand("restart");
	   restartButton.setVisible(false);
	   window.add(restartButton);
	   
   }
   
   public void generateScreen() { 
	   
	   //scene one 
	   createBackground(1, "bg0.1 (1).png");
	   createObject(1,50,175,150,177,"tontoSize.png", "Look", "Talk", "Fight", "lookTonto", "talkTonto", "fightTonto");
	   createObject(1,475,210,700,700,"horse4.png", "Look", "Take", "Feed", "lookHorse", "takeHorse", "feedHorse");
	   createObject(1,240,255,134,100,"wanted poster.Size (1).png", "Look", "Read", "Help", "lookPoster", "readPoster", "helpPoster");
	   createArrowButton(1,0,150,50,53,"CLeftArrow.png", "goScene2");
	   bgPanel[1].add(bgLabel[1]);  
	   
	   //scene two 
	   createBackground(2, "tavern.jpeg");
	   createArrowButton(2,650,150,50,56,"CRightArrow.png", "goScene1");
	   
	   createObject(2,175,80,150,117,"bartender3.0.png", "Look", "Talk", "Fight", "lookBartender", "talkBartender", "fightBartender");
	   createObject(2,400,130,300,700,"chair 3.0.png", "Look", "Question", "Act", "lookChair", "questionChair", "actChair");
	   createArrowButton(2,0,150,50,53,"CLeftArrow.png", "goScene3");
	   createArrowButton(2,650,150,50,56,"CRightArrow.png", "goScene1");
	   bgPanel[2].add(bgLabel[2]);  
	   
	   //scene three
	   createBackground(3, "CROutsideCoalMine.jpg");
	   createObject(3,250,50,100,300,"blankObject.png", "Look", "Talk", "Enter", "lookMine", "talkMine", "enterMine");
	   createObject(3,450,180,50,50,"blankObject.png", "Look", "Talk", "Search", "lookRoot", "talkRoot", "searchRoot");
	   createArrowButton(3,650,150,50,56,"CRightArrow.png", "goScene2");
	   bgPanel[3].add(bgLabel[3]); 
	   
	   //scene four
	   createBackground(4,"insideMine.jpeg");
	   createObject(4,100,60,400,300,"mayor3.0.png", "Look", "Question", "Fight", "lookMayor", "questionMayor", "fightMayor");
	   createArrowButton(4,0,150,50,53,"CLeftArrow.png", "goScene5");
	   bgPanel[4].add(bgLabel[4]);
	   
	   //scene five -- ending screen 
	   createBackground(5, "endScreen2.0.png");
	   bgPanel[5].add(bgLabel[5]);
	  
	   
   }
}





