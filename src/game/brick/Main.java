package game.brick;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		GamePlay gamePlay = new GamePlay();
		
		JFrame obj = new JFrame();
		obj.setBounds(10, 10, 700, 600); //size
		obj.setTitle("Breakout Ball");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
		
	}

}
