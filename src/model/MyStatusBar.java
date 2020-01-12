package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 * Klasa StatusBar
 * @author Mile
 *
 */
public class MyStatusBar extends JPanel { // Milan Knezevic
	
	
	/**
	 * Privatna potklasa za pravilno racunanje vremena
	 * @author Mile
	 *
	 */
	private class MyCurrentTimeAndDate extends JPanel { // Milan Knezevic
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 8627133511401339205L;

		private JLabel sat;

		
		public MyCurrentTimeAndDate() {	
			super(new BorderLayout());
			sat = new JLabel();
			pomeri();
			this.setAlignmentX(CENTER_ALIGNMENT);
			this.add(sat, BorderLayout.CENTER);
			
			
		// Timer koji proverava da li je doslo do promene vremena na svakih 1000 ms
		Timer timer = new Timer(1000, new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pomeri();	
			}
		} );
		
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		timer.setRepeats(true);
		timer.start();			// Pocetak merenja vremena
		
		}
		
		/**
		 *  Function which changes label text
		 */
		private void pomeri() {
			// format zapisa vremena u labeli
			DateFormat df = new SimpleDateFormat("dd.MM.YYYY. HH:mm "); 
			sat.setText(df.format(new Date()));
		}
		

	}
	
	
	
	
	
	
	
	private static final long serialVersionUID = -921271096182956691L;
	
	private static MyStatusBar instance = null;
	
	/**
	 * Privatni konstruktor bez parametara
	 */
	private MyStatusBar() {
		super();
		this.setLayout(new BorderLayout());
		Dimension d = new Dimension(300, 30);
		this.setPreferredSize(d);
		this.setBackground(Color.gray);
		
		
		JLabel naziv = new JLabel("Studentska služba");
		
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
		});
		
		JPanel ss = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ss.setBackground(Color.GRAY);
		ss.add(naziv);
		MyCurrentTimeAndDate divpanel = new MyCurrentTimeAndDate();
		divpanel.setBackground(Color.GRAY);
		
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.add(ss, BorderLayout.WEST);
	//	this.add(separator, BorderLayout.CENTER);
		this.add(divpanel, BorderLayout.EAST);
		
		this.setVisible(true);
		
	}
	
	/**
	 *  poziv sigleton konstruktora statusbar-a
	 * @return statusbar
	 */
	public static MyStatusBar getInstance() {
		if (instance == null) instance = new MyStatusBar();
		return instance;
	}
}
