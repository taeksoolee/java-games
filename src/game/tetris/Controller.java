package game.tetris;

import javafx.scene.shape.Rectangle;

public class Controller {
	//getting numvers and MESH from Tetris class
	public static final int MOVE = Tetris.MOVE;
	public static final int SIZE = Tetris.SIZE;
	public static int XMAX = Tetris.XMAX;
	public static int YMAX = Tetris.YMAX;
	public static int [][] MESH = Tetris.MESH;
	
	//moving the blocks
	public static void MoveRight (Form form) {
		if(form.a.getX() + MOVE <= XMAX -SIZE
				&& form.b.getX() + MOVE <= XMAX - SIZE
				&& form.c.getX() + MOVE <= XMAX - SIZE
				&& form.d.getX() + MOVE <= XMAX - SIZE
				) {
			int movea = MESH[((int)form.a.getX()/SIZE)+1][(int)form.a.getY()/SIZE];
			int moveb = MESH[((int)form.b.getX()/SIZE)+1][(int)form.b.getY()/SIZE];
			int movec = MESH[((int)form.c.getX()/SIZE)+1][(int)form.c.getY()/SIZE];
			int moved = MESH[((int)form.d.getX()/SIZE)+1][(int)form.d.getY()/SIZE];
			
			
			if(movea == 0 && movea == moveb && moveb == movec && movec == moved) {
				form.a.setX(form.a.getX() + MOVE);
				form.b.setX(form.b.getX() + MOVE);
				form.c.setX(form.c.getX() + MOVE);
				form.d.setX(form.d.getX() + MOVE);
			}
		}
	}
	public static void MoveLeft (Form form) {
		if(form.a.getX() - MOVE >= 0
				&& form.b.getX() - MOVE >= 0
				&& form.c.getX() - MOVE >= 0
				&& form.d.getX() - MOVE >= 0
				) {
			int movea = MESH[((int)form.a.getX()/SIZE)-1][(int)form.a.getY()/SIZE];
			int moveb = MESH[((int)form.b.getX()/SIZE)-1][(int)form.b.getY()/SIZE];
			int movec = MESH[((int)form.c.getX()/SIZE)-1][(int)form.c.getY()/SIZE];
			int moved = MESH[((int)form.d.getX()/SIZE)-1][(int)form.d.getY()/SIZE];
			
			
			if(movea == 0 && movea == moveb && moveb == movec && movec == moved) {
				form.a.setX(form.a.getX() - MOVE);
				form.b.setX(form.b.getX() - MOVE);
				form.c.setX(form.c.getX() - MOVE);
				form.d.setX(form.d.getX() - MOVE);
			}
		}
	}
	
	//create the stones
	public static Form makeRect() {
		//random color for the stones
		int block = (int)(Math.random() *100);
		String name;
		
		Rectangle a = new Rectangle(SIZE-1, SIZE-1);
		Rectangle b = new Rectangle(SIZE-1, SIZE-1);
		Rectangle c = new Rectangle(SIZE-1, SIZE-1);
		Rectangle d = new Rectangle(SIZE-1, SIZE-1);
		
		if(block < 15) {
			name = "j";
			a.setX(XMAX / 2 - SIZE);
			b.setX(XMAX / 2 - SIZE);
			b.setY(SIZE);
			c.setX(XMAX / 2);
			c.setY(SIZE);
			d.setX(XMAX / 2 + SIZE);
			d.setY(SIZE);
		}else if(block < 30) {
			name = "l";
			a.setX(XMAX / 2 + SIZE);
			b.setX(XMAX / 2 - SIZE);
			b.setY(SIZE);
			c.setX(XMAX / 2);
			c.setY(SIZE);
			d.setX(XMAX / 2 + SIZE);
			d.setY(SIZE);
		}else if(block < 45) {
			name = "o";
			a.setX(XMAX / 2 - SIZE);
			b.setX(XMAX / 2);
			c.setX(XMAX / 2 - SIZE);
			c.setY(SIZE);
			d.setX(XMAX /  2 + SIZE);
			d.setY(SIZE);
		}else if(block < 60) {
			name = "s";
			a.setX(XMAX / 2 + SIZE);
			b.setX(XMAX / 2);
			c.setX(XMAX / 2 - SIZE);
			c.setY(SIZE);
			d.setX(XMAX / 2);
			d.setY(SIZE);
		}else if(block < 75) {
			name = "t";
			a.setX(XMAX / 2);
			b.setX(XMAX / 2 - SIZE);
			b.setY(SIZE);
			c.setX(XMAX / 2);
			c.setY(SIZE);
			d.setX(XMAX / 2 + SIZE);
			d.setY(SIZE);
		}else if(block < 90) {
			name = "z";
			a.setX(XMAX / 2 - SIZE);
			b.setX(XMAX / 2);
			c.setX(XMAX / 2); 
			c.setY(SIZE);
			d.setX(XMAX / 2 + SIZE);
			d.setY(SIZE);
		}else {
			name = "i";
			a.setX(XMAX / 2 - SIZE - SIZE);
			b.setX(XMAX / 2 - SIZE);
			c.setX(XMAX / 2); 
			d.setX(XMAX / 2 + SIZE);
		}
		
		
		return new Form(a, b, c, d, name);
		
		
	}
}
