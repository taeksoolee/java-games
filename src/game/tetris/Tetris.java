package game.tetris;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tetris extends Application{
//variables
	public static final int MOVE = 25;
	public static final int SIZE = 25;
	public static int XMAX = SIZE *12;
	public static int YMAX = SIZE *24;
	public static int [][] MESH = new int [XMAX/SIZE][YMAX/SIZE];
	private static Pane groupe = new Pane();
	private static Form object;
	private static Scene scene = new Scene(groupe, XMAX+150, YMAX);
	public static int score = 0;
	public static int top = 0;
	private static boolean game = true;
	private static Form nextObj = Controller.makeRect();
	private static int linesNo = 0;
	
	//creating scene and start the game
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		for(int[] a : MESH) {
			Arrays.fill(a, 0);
		}// for end
		
		//Creating score and level text
		Line line = new Line(XMAX, 0, XMAX, YMAX);
		
		Text scoreText = new Text("Score : ");
		scoreText.setStyle("-fx-font: 20 arials");
		scoreText.setY(50);
		scoreText.setX(XMAX + 5);
		
		Text level = new Text("Lines : ");
		level.setStyle("-fx-font: 20 arials");
		level.setY(100);
		level.setX(XMAX + 5);
		level.setFill(Color.GREEN);
		
		groupe.getChildren().addAll(scoreText, line, level);
		
		//Creating first block and the stage
		Form a = nextObj;
		groupe.getChildren().addAll(a.a, a.b, a.c, a.d);
		moveOnKeyPress(a);
		object =  a;
		nextObj = Controller.makeRect();
		stage.setScene(scene);
		stage.setTitle("T E T R I S");
		stage.show();
		
		//Timer
		TimerTask fall = new TimerTask() {
			@Override
			public void run() {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					if(object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0 || object.d.getY() == 0) {
						top++;
					}else top = 0;
					
					if(top == 2) {
						Text over = new Text("GAME OVER");
						over.setFill(Color.RED);
						over.setStyle("-fx-font: 70 arial;");
						over.setY(250);
						over.setX(10);
						groupe.getChildren().add(over);
						game = false;
					}
						
					//Exit
					if(top == 15) {
						System.exit(0);
					}
						
					if(game) {
						MoveDown(object);
						scoreText.setText ("Score : " + Integer.toString(score));
						level.setText ("Lines : " + Integer.toString(linesNo));
					}
				}//run end
			}//run end
		};// timerTask end
	}// start end	
}//class end
