import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class Game {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, healthBarPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, imageLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP, monsterHP, silverRing;
	String weapon, position;
	
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	JProgressBar healthBar;
	
	
	
	public static void main(String[] args) {
		
		new Game();

	}

	
	public Game() {
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.BLACK);
		window.setLayout(null);
		window.setVisible(true);
		
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.BLACK);
		
		titleNameLabel = new JLabel("ADVENTURE GAME");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.BLACK);
		
		
		startButton = new JButton("START GAME");
		startButton.setBackground(Color.BLACK);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		
		
	}
	
	public void createGameScreen(){
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text Area");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.BLACK);
		mainTextArea.setForeground(Color.WHITE);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.BLACK);
		choice1.setForeground(Color.WHITE);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.BLACK);
		choice2.setForeground(Color.WHITE);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.BLACK);
		choice3.setForeground(Color.WHITE);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.BLACK);
		choice4.setForeground(Color.WHITE);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
				
		healthBarPanel = new JPanel();
		healthBarPanel.setBounds(100,15, 200, 30);
		healthBarPanel.setBackground(Color.BLACK);
		con.add(healthBarPanel);
		
		
		
		healthBar = new JProgressBar(0,15);
		healthBar.setPreferredSize(new Dimension(200, 30));
		healthBar.setBackground(Color.red);
		healthBar.setForeground(Color.GREEN);
		healthBarPanel.add(healthBar);
		
		
		playerPanel = new JPanel();
		playerPanel.setBounds(400, 15, 300, 30);
		playerPanel.setBackground(Color.BLACK);
		playerPanel.setLayout(new GridLayout(1, 2));
		con.add(playerPanel);
		
		//	hpLabel = new JLabel("HP: ");
		//	hpLabel.setFont(normalFont);
		//	hpLabel.setForeground(Color.WHITE);
		//	playerPanel.add(hpLabel);
		
		//	hpLabelNumber = new JLabel();
		//	hpLabelNumber.setFont(normalFont);
		//	hpLabelNumber.setForeground(Color.WHITE);
		//	playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.WHITE);
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.WHITE);
		playerPanel.add(weaponLabelName);
		
		
		
		
		
		
		playerSetup();
		
		
	}
	
	public void playerSetup() {
		playerHP = 15;
		monsterHP = 20;
		weapon = "Knife";
		weaponLabelName.setText(weapon);
		// hpLabelNumber.setText("" + playerHP);
		
		healthBar.setValue(playerHP);
		townGate();
	}
	
	public void townGate() {
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town.\nA guard is standing in front of you. \n\nWhat do you do?");
		
		choice1.setText("Talk to the guard");
		choice2.setText("Attack  the guard");
		choice3.setText("Leave");
		choice4.setText("");
		
		
		
		
	}
	
	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello, stranger.\nI have never seen your face,\nI m sorry but we cannot \nlet a stranger enter our town.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
		
	}
	
	public void attackGuard() {
		
		position = "attackGuard";
		mainTextArea.setText("Guard: Dont be stupid,\n\n Guard hit you back.\n\n (You received 3 damage)");
		playerHP -= 3;
		//hpLabelNumber.setText(""+ playerHP);
		healthBar.setValue(playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void crossRoad() {
		
	
		
		 position = "crossRoad";
		 mainTextArea.setText("You are at a crossroad\n If you go south, you will go back to the town.");
		 choice1.setText("Go north");
		 choice2.setText("Go east");
		 choice3.setText("Go south");
		 choice4.setText("Go west");
		 
		
		
	}
	
	public void north() {
		 position = "north";
		 mainTextArea.setText("There is a river. \n You drink water and take a nap.\n\n(You recover 2 HP)");
		 playerHP += 2;
		 healthBar.setValue(playerHP);
		 //hpLabelNumber.setText(""+ playerHP);
		 healthBar.setValue(playerHP);
		 choice1.setText("Go south");
		 choice2.setText("");
		 choice3.setText("");
		 choice4.setText("");
		
	}
	
	public void east() {
		position = "east";
		mainTextArea.setText("You walked into a forest \nand found a sword.\n\n (You obtained a long sword.)\n");
		weapon = "Sword";
		weaponLabelName.setText(weapon);
		choice1.setText("Go west");
		 choice2.setText("");
		 choice3.setText("");
		 choice4.setText("");
		
	}
	
	public void west() {
	
		position = "west";
		mainTextArea.setText("You encounter a goblin.!)");
		
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void fight() {
		position = "fight";
		mainTextArea.setText("Monster HP:" + monsterHP + "\n\nWhat do you do?") ;
		
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public void win() {
		
		position = "win";
		mainTextArea.setText("You defeated the Monster. \n The monster dropped a ring \n (You obtained a silver ring)");
		silverRing = 1;
		choice1.setText("Go east");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
	}
	
	public void lose() {
		position = "lose";
		mainTextArea.setText("You are dead..\n\n GAME OVER!!");
				
				choice1.setText(">");
				choice2.setText("");
				choice3.setText("");
				choice4.setText("");
				choice1.setVisible(false);
				choice2.setVisible(false);
				choice3.setVisible(false);
				choice4.setVisible(false);
		
	}
	
	public void ending() {
		
	mainTextArea.setText("Guard: Oh you killed that goblin.\n Thank you so much, you are a hero \n Welcome to our town\n\n THE END!");
	choice1.setText(">");
	choice2.setText("");
	choice3.setText("");
	choice4.setText("");
	choice1.setVisible(false);
	choice2.setVisible(false);
	choice3.setVisible(false);
	choice4.setVisible(false);
		
	}
	
	
	public void playerAttack() {
		position = "playerAttack";
		
		int playerDamage = 0;
		if(weapon.equals("Knife")) {
			playerDamage = new java.util.Random().nextInt(3);
		}
		else if (weapon.equals("Sword")) {
			playerDamage = new java.util.Random().nextInt(5);
		}
		
		mainTextArea.setText("You attacked the monster and gave " +playerDamage+ "damage");
		monsterHP = monsterHP - playerDamage;
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void monsterAttack() {
		position = "monsterAttack";
		
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(4);
		mainTextArea.setText("The monster attacked you for " + monsterDamage + "damage");
		playerHP = playerHP - monsterDamage;
		//hpLabelNumber.setText(""+ playerHP);
		healthBar.setValue(playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	
	public class TitleScreenHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
			
			switch(position) {
			case "townGate" :
				switch(yourChoice) {
				case "c1":
					if(silverRing==1) {
						ending();
					}
					else {
					
						talkGuard();
					
					}
					break;
				case "c2": attackGuard();
				if(playerHP<1) {
					lose();
				}break;
				case "c3": crossRoad(); break;
				}
				break;
			case "talkGuard" :
				switch(yourChoice) {
				case "c1": townGate(); break;
				} break;
			case "attackGuard" :
				if(playerHP<1) {
					lose();
				}
				switch(yourChoice) {
				case "c1": townGate(); break;
				}
				break;
			case "crossRoad" :
				switch(yourChoice) {
				case "c1" : north(); break;
				case "c2" : east(); break;
				case "c3" : townGate(); break;
				case "c4" : west(); break;
				
				
				}
				break;
			case "north" :
				switch(yourChoice) {
				case "c1" : crossRoad(); break;
				
				}
				break;
				 
			case "east" :
				switch(yourChoice) {
				case "c1" : crossRoad(); break;
				
				}
				break;
			case "west" :
				switch(yourChoice) {
				case "c1" : fight(); break;
				case "c2" : crossRoad(); break;
				
				}
				break;
			case "fight" :
				switch(yourChoice) {
				case "c1" : playerAttack(); break;
				case "c2" : crossRoad(); break;
				}
				break;
			case "playerAttack" :
				switch(yourChoice) {
				case "c1" :
					if(monsterHP<1) {
						win();
					}
					else {
					monsterAttack();
				
				} 
				}break;
			case "monsterAttack" :
				switch(yourChoice) {
				case "c1" :
					if(playerHP<1) {
						lose();
					}
					else {
					fight(); 
				}
				break;
			}
				break;
			case "win" :
				switch(yourChoice) {
				case "c1" : crossRoad();
				}
				 break; 
				}
				
			}
		}
	}

			

	
	

