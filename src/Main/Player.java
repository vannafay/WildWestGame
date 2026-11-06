package Main;

public class Player {
	
	GameManager gm; 
	
	public int playerMaxLife;
	public int playerLife;
	
	public int hasGun;
	public int hasFlask;
	public int hasLantern;
	
	public Player(GameManager gm) { 
		
		this.gm = gm;
	}
	
	public void setPlayerDefualtStatus() {
		playerMaxLife = 5;
		playerLife = 1;
		hasGun = 0;
		hasFlask = 0;
		hasLantern = 0;
		
		updatePlayerStatus();
		
	}
	
	public void updatePlayerStatus() {
		//remove all life icons 
		int i = 1;
		while(i<6) {
			gm.ui.lifeLabel[i].setVisible(false);
			i++;
		}
		
		int lifeCount = playerLife;
		while(lifeCount != 0) {
			gm.ui.lifeLabel[lifeCount].setVisible(true);
			lifeCount--;
		}
		 
		//check player items
		if(hasGun == 0 ) {
			gm.ui.gunLabel.setVisible(false);
		}
		if(hasGun == 1 ) {
			gm.ui.gunLabel.setVisible(true);
		}
		if(hasFlask == 0 ) {
			gm.ui.flaskLabel.setVisible(false);
		}
		if(hasFlask == 1 ) {
			gm.ui.flaskLabel.setVisible(true);
		}
		if(hasLantern == 0 ) {
			gm.ui.lanternLabel.setVisible(false);
		}
		if(hasLantern == 1 ) {
			gm.ui.lanternLabel.setVisible(true);
		}
	}

}
