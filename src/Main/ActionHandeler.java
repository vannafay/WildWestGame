package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandeler implements ActionListener{

	GameManager gm; 
	
	public ActionHandeler(GameManager gm) {
		
		this.gm = gm;
	}

	public void actionPerformed(ActionEvent e) {
		 
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice) {
		//scene 1 
		case "lookTonto": gm.ev1.lookTonto(); break;
		case "talkTonto": gm.ev1.talkTonto(); break;
		case "fightTonto": gm.ev1.fightTonto(); break;
		case "lookHorse": gm.ev1.lookHorse(); break;
		case "takeHorse": gm.ev1.takeHorse(); break;
		case "feedHorse": gm.ev1.feedHorse(); break;
		case "lookPoster": gm.ev1.lookPoster(); break;
		case "readPoster": gm.ev1.readPoster(); break;
		case "helpPoster": gm.ev1.helpPoster(); break;
		
		//scene 2
		case "lookBartender": gm.ev2.lookBartender(); break;
		case "talkBartender": gm.ev2.talkBartender(); break;
		case "fightBartender": gm.ev2.fightBartender(); break;
		case "lookChair": gm.ev2.lookChair(); break;
		case "questionChair": gm.ev2.questionChair(); break;
		case "actChair": gm.ev2.actChair(); break;
		
		//scene 3 
		case "lookMine": gm.ev3.lookMine(); break;
		case "talkMine": gm.ev3.talkMine(); break;
		case "enterMine": gm.ev3.enterMine(); break;
		case "lookRoot": gm.ev3.lookRoot(); break;
		case "talkRoot": gm.ev3.talkRoot(); break;
		case "searchRoot": gm.ev3.searchRoot(); break;
		
		//scene 4 
		case "lookMayor": gm.ev4.lookMayor(); break;
		case "questionMayor": gm.ev4.questionMayor(); break;
		case "fightMayor": gm.ev4.fightMayor(); break;
		
		//change scene
		case "goScene1": gm.sChanger.showScreen1(); break;
		case "goScene2": gm.sChanger.showScreen2(); break;
		case "goScene3": gm.sChanger.showScreen3(); break;
		case "goScene4": gm.sChanger.showScreen4(); break;
		case "goScene5": gm.sChanger.showScreen5(); break;
		
		//other 
		case "restart": gm.sChanger.exitGameOverScreen(); gm.sChanger.showScreen1(); break;
		
		}
		
	}
	
}
