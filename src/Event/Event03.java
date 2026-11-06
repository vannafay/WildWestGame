package Event;

import Main.GameManager;

public class Event03 {
	 
public GameManager gm;
	
	public Event03(GameManager gm) {
		
		this.gm = gm;
		
	}
	
	public void lookMine() {
		gm.ui.messageText.setText("This is the Gold Mine that has been robbed.");
		
	}
	
	public void talkMine() {
		gm.ui.messageText.setText("You can hear sounds from inside the cave.");
		
	}
	
    public void enterMine () {
    	if(gm.player.hasLantern == 0) {
    		gm.ui.messageText.setText("It is too dark to enter.\nYou need a lantern.");
    	} else {
    		gm.sChanger.showScreen4();
    	}
		
	}
    
    public void lookRoot() {
    	gm.ui.messageText.setText("There is something in the barrels.");
    	
    }
    
    public void talkRoot() {
    	gm.ui.messageText.setText("");
    	
    }
    
    public void searchRoot() {
    	if(gm.player.hasLantern == 0) {
    		gm.ui.messageText.setText("You have found the lantern! You may now enter the mine.");
    		gm.player.hasLantern = 1;
    		gm.player.updatePlayerStatus(); 
    	} else {
    		gm.ui.messageText.setText("You didn't find anything");

    	}
    }

}
