package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenuBar extends JMenuBar { // Milan Knezevic
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -822368112626186686L;
	
	private static MyMenuBar instance = null;
	
	private MyMenuBar() {
		super();
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		ImageIcon ci = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\shut_down [#1431].png"));
		ImageIcon ni = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\plus [#1513].png"));
		ImageIcon oi = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\delete [#1487].png"));
		ImageIcon ii = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\pen [#1319].png"));
		ImageIcon hi = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\question [#1445].png"));
		ImageIcon ai = resizeIcon(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG2_black_icons\\mr_robot [#120].png"));
		
		
		JMenuItem novi = new JMenuItem("New", ni);
		novi.setMnemonic(KeyEvent.VK_N);
		JMenuItem close = new JMenuItem("Close", ci);
		close.setMnemonic(KeyEvent.VK_C);
		
		JMenuItem izmeni = new JMenuItem("Edit", ii);
		izmeni.setMnemonic(KeyEvent.VK_E);
		JMenuItem obrisi = new JMenuItem("Delete", oi);
		obrisi.setMnemonic(KeyEvent.VK_D);
		
		JMenuItem pomoc = new JMenuItem("Help", hi);
		pomoc.setMnemonic(KeyEvent.VK_H);
		JMenuItem about = new JMenuItem("About", ai);
		about.setMnemonic(KeyEvent.VK_A);
		
		file.add(novi);
		file.add(close);
		
		edit.add(izmeni);
		edit.add(obrisi);
		
		help.add(pomoc);
		help.add(about);
		
		this.add(file);
		this.add(edit);
		this.add(help);	
		
		
	}

	public static MyMenuBar getInstance() {
		if (instance == null) instance = new MyMenuBar();
		return instance;
	}
	
	private ImageIcon resizeIcon(ImageIcon ul) {
		Image slika = ul.getImage();
		BufferedImage bi = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.getGraphics();
		g.drawImage(slika, 0, 0, 20, 20, null);
		return new ImageIcon(bi);
	}

}
