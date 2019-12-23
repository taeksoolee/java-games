package test;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
// 시계를 나타내는 라벨
public class DigitalClockLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	ClockThread t;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년\tMM월\tdd일\tHH시\tmm분\tss초");
	String time = sdf.format(new Date());
	
	//Font font = new Font("굴림", Font.BOLD, 50);

	public DigitalClockLabel() {
		super();
//		setHorizontalAlignment(JLabel.CENTER);
		t = new ClockThread();
		t.start();
	}
	
	public void setTextTime() {
		setText(time);
	}
	public void closeThread() {
		t.close();
	}
	
	//날짜와 시간을 출력하는 Thread Class
	public class ClockThread extends Thread{
		boolean toggle = false;
		
		@Override
		public void run() {
			toggle = true;
			while(toggle) {
				time = sdf.format(new Date());
				setTextTime();
				/* term control
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				*/
			}
		}
		
		public void close() {
			toggle = false;
		}
	}
}