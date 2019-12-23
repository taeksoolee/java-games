package test;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
// �ð踦 ��Ÿ���� ��
public class DigitalClockLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	ClockThread t;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy��\tMM��\tdd��\tHH��\tmm��\tss��");
	String time = sdf.format(new Date());
	
	//Font font = new Font("����", Font.BOLD, 50);

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
	
	//��¥�� �ð��� ����ϴ� Thread Class
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