package Main;

import Event.Event01;
import Event.Event02;
import Event.Event03;
import Event.Event04;


public class GameManager {
	
	ActionHandeler aHandeler = new ActionHandeler(this);
	public UI ui = new UI(this);
	public Player player = new Player(this);
	public SceneChanger sChanger = new SceneChanger(this);
	
	public Event01 ev1 = new Event01(this);
	public Event02 ev2 = new Event02(this);
	public Event03 ev3 = new Event03(this);
	public Event04 ev4 = new Event04(this);

	public static void main(String[] args) {
		new GameManager();
		
	}
	public GameManager() {
		
		player.setPlayerDefualtStatus();
		sChanger.showScreen1();
		
	}

}
