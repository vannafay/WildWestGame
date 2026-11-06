package Main;

public class SceneChanger {
	
	GameManager gm;
	
	public SceneChanger(GameManager gm) {
		
		this.gm = gm;
		
	}
	 
	public void showScreen1() {
		gm.ui.bgPanel[1].setVisible(true);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.messageText.setText("Welcome to the Wild West, Lone Ranger!\nYour goal in this game is to gather information and make choices from the viewpoint of an antihero."
				+ " You must make the right choices and gain enough hearts to win the game. Good luck!");
	}
	
	public void showScreen2() {
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(true);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.messageText.setText("You've made it to the Tavern.\nMake sure to look around.");
	}
	
	public void showScreen3() {
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(true);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.messageText.setText("This is the entrance to the Gold Mine.");
		
	}
	
	public void showScreen4() {
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(true);
		gm.ui.bgPanel[5].setVisible(false);
		gm.ui.messageText.setText("You are now inside the Gold Mine.");
	}
	
	public void showScreen5() {
		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);	
		gm.ui.bgPanel[5].setVisible(true);
		gm.ui.restartButton.setText("Click here to restart.");
		gm.ui.restartButton.setVisible(true);
		gm.ui.messageText.setText("");
	}
	
	public void showGameOverScreen(int currentBgNum) {
		gm.ui.bgPanel[currentBgNum].setVisible(false);
		gm.ui.titleLabel.setVisible(true);
		gm.ui.titleLabel.setText("You Lost!");
		gm.ui.restartButton.setVisible(true);
		gm.ui.restartButton.setText("Click here to restart.");
		
	}
	
	public void exitGameOverScreen() {
		gm.ui.titleLabel.setVisible(false);
		gm.ui.restartButton.setVisible(false);
		gm.player.setPlayerDefualtStatus();
		
		
	}

}
