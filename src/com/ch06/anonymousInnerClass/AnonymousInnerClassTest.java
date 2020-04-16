package com.ch06.anonymousInnerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class AnonymousInnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);
		
		// keep program running until user selects "OK"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

/*
 * A clock that prints the time in regular intervals.
 */
class TalkingClock{
	/*
	 * Starts the clock
	 */
	public void start(int interval, boolean beep) {
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("At the tone, the time is "
						+ new Date());
				if(beep) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		};
		Timer t = new Timer(interval, listener);
		t.start();
	}
}
