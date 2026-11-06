package Event;

import Main.GameManager;

public class Event04 {
	
public GameManager gm;
	
	public Event04(GameManager gm) {
		
		this.gm = gm;
	}

	public void lookMayor() {
		gm.ui.messageText.setText("It's the Mayor!");
		
	}
	
	public void questionMayor() {
		gm.ui.messageText.setText("Mayor: I have been stealing the gold and framing the Native Americans so I can "
				+ "steal their land to expand the town! If you choose not to fight me I can give you some of this gold...");
		
	}
	
	public void fightMayor() {
		if(gm.player.playerLife != gm.player.playerMaxLife) {
			gm.ui.messageText.setText("You chose to fight and take down the Mayor! "
					+ "This saves the Native Americans' land and brings to light a currupt leader.");
			gm.player.playerLife++;
			gm.player.updatePlayerStatus();
		} else {
			gm.ui.messageText.setText("Your heart is full.");
		}
	}
}

	
