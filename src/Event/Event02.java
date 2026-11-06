package Event; 

import Main.GameManager;

public class Event02 {
	
	public GameManager gm; 
	
	public Event02(GameManager gm) {
		
		this.gm = gm;
		
	}
	
	public void lookBartender() {
		gm.ui.messageText.setText("This is the bartender. He might have some useful information.");
	}
	
	public void talkBartender() {
		if(gm.player.hasFlask == 0) {
    		gm.ui.messageText.setText("Bartender: Howdy Ranger!"
    				+ " As you know the Gold Mine is the town's main natural resourse, and is what keeps our economy running."
    				+ " The mayor has been in here recently talking about using the money from the mine to expand "
    				+ "town into the Native American's territory.\n"
    				+ "He fills up your flask.");
    		gm.player.hasFlask = 1;
    		gm.player.updatePlayerStatus(); 
    	} else {
    		gm.ui.messageText.setText("You didn't find anything");
    	}
	}
	
	public void fightBartender() {
	if(gm.player.hasGun == 0) {
		if(gm.player.hasFlask == 0) {
			if(gm.player.playerLife!=1) {
				gm.ui.messageText.setText("You started an unnessisary fight!.\nThis lost you a heart");
				gm.player.playerLife--;
				gm.player.updatePlayerStatus();
			}
			 else if(gm.player.playerLife==1) {
		    gm.ui.messageText.setText("Your heart is empty.");
		    gm.player.playerLife--;
		    gm.sChanger.showGameOverScreen(2);
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
	 
	public void lookChair() {
		gm.ui.messageText.setText("It appears the mayor has left his badge at the bar");
		
	}
	
	public void questionChair() {
		gm.ui.messageText.setText("The seat that the badge was left at has a bunch of red mud dried on the floor."
				+ " The only place in town with red mud is the Gold Mine. Has the mayor been at the Mine?");
	}
	
	public void actChair() {
		if(gm.player.playerLife != gm.player.playerMaxLife) {
			gm.ui.messageText.setText("You are acting on this lead."
					+ " Continue on to the mine.");;
			gm.player.playerLife++;
			gm.player.updatePlayerStatus();
		} else {
			gm.ui.messageText.setText("Your heart is full.");
		}
	}

}
