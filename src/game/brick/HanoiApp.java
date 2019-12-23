package game.brick;

public class HanoiApp {
	public static void main(String[] args) {
		System.out.println(hanoiFunc(35));
	}
	public static long hanoiFunc(int cnt) {
		if(cnt == 1) return 1;
		return hanoiFunc(cnt-1)*2+1; 
	}
}
