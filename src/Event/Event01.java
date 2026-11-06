package Event;

import Main.GameManager;

public class Event01 {
	
	GameManager gm; 
	
	public Event01(GameManager gm) {
		
		this.gm = gm;
		
	}
	
	public void lookTonto() {
		gm.ui.messageText.setText("This is Tonto, your friend.");
	}
	
	public void talkTonto() {
		gm.ui.messageText.setText("Tonto: Hello, Lone Ranger. I'm glad you came when I sent for your help."
				+ " Someone has been stealing all the gold from the town Gold Mine, and the Mayor thinks the Native Americans have something to do with it."
				+ " He has been wrongly imprisioning my freinds and family. You must help me clear our name and find the real criminal.");
	}
	
	public void fightTonto() {
		if(gm.player.hasGun == 0) {
			if(gm.player.hasFlask == 0) {
				if(gm.player.playerLife!=1) {
					gm.ui.messageText.setText("Do not fight your freind.\nThis lost you a heart");
					gm.player.playerLife--;
					gm.player.updatePlayerStatus();
				}
				 else if(gm.player.playerLife==1) {
			    gm.ui.messageText.setText("Your heart is empty.");
			    gm.player.playerLife--;
			    gm.sChanger.showGameOverScreen(1);
		    }
		}
		else if(gm.player.hasGun == 1) {
			gm.ui.messageText.setText("Oh man!");
	  }
		gm.player.updatePlayerStatus();
	} 
	else { 
		gm.ui.messageText.setText("Leave him alone");
	}
	}
	 
	public void lookHorse() {
		gm.ui.messageText.setText("This is your horse. Make sure to feed him!");
	}
	
	public void takeHorse() {
		if(gm.player.hasGun==0) {
			gm.ui.messageText.setText("You take your pistol from your saddle bag and put it into your holster.");
			gm.player.hasGun = 1;
			gm.player.updatePlayerStatus();
		} else {
			gm.ui.messageText.setText("You cannot take anything else.");
		}
	}
	public void feedHorse() {
		if(gm.player.playerLife != gm.player.playerMaxLife) {
			gm.ui.messageText.setText("You fed your horse, gain a heart!");;
			gm.player.playerLife++;
			gm.player.updatePlayerStatus();
		} else {
			gm.ui.messageText.setText("Your heart is full.");
		}
	}
	
	public void lookPoster() {
		gm.ui.messageText.setText("This is the wanted poster.");
	}
	public void readPoster() {
		gm.ui.messageText.setText("Poster Text: WANTED Any Native American suspected of stealing gold from the Mine will be sent to jail immediatly.\n" 
				+ "If you wish to help Tonto, press the 'help' option.");
	}
	
	public void helpPoster() {
		if(gm.player.playerLife != gm.player.playerMaxLife) {
			gm.ui.messageText.setText("You are choosing to help your friend.\nYou gain a heart.");;
			gm.player.playerLife++;
			gm.player.updatePlayerStatus();
		} else {
			gm.ui.messageText.setText("Your heart is full.");
		}
	}
	
}
