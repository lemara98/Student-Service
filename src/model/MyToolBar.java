package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MyToolBar extends JToolBar{


	private static final long serialVersionUID = 2933819767532950350L;

	public MyToolBar() {
		super(SwingConstants.HORIZONTAL);
		
		setBackground(Color.DARK_GRAY);
		//setPreferredSize(new Dimension(tbWidth,tbHeight));

		// Dodao sam svoje ikonice(20x20) posto tvoje nisu stavljene u repozitorijum i podesio velicinu dugmeta na 30x30
		
		Icon icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\profile_plus [#1357].png");
		JButton btnAdd = new JButton(icon);
		btnAdd.setPreferredSize(new Dimension(30,30));
		btnAdd.setToolTipText("Add");
		
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\edit_cover [#1481].png");
		JButton btnEdit = new JButton(icon);
		btnEdit.setPreferredSize(new Dimension(30,30));
		btnEdit.setToolTipText("Edit");
		
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\profile_close [#1358].png");
		JButton btnDelete = new JButton(icon);
		btnDelete.setPreferredSize(new Dimension(30,30));
		btnDelete.setToolTipText("Delete");
		
		icon = new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\search_left [#1504].png");
		JButton btnSearch= new JButton(icon);
		btnSearch.setPreferredSize(new Dimension(30,30));
		btnSearch.setToolTipText("Search");
		
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(150,20));
		
	//	setLayout(new FlowLayout(FlowLayout.LEFT)); // Saletova verzija
		setLayout(new BorderLayout());  // Miletova verzija -- Dodao sam samo dugmice na panele da bi moglo lepse da izgleda.
										// Ako ti nije jasno zasto, pozovi me nocas u 3. Insomnia. Broj: 0631623155
		JPanel leviDeo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		leviDeo.setBackground(Color.DARK_GRAY);
		
		JPanel desniDeo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		desniDeo.setBackground(Color.DARK_GRAY);
		
		leviDeo.add(btnAdd);
		leviDeo.add(btnEdit);
		leviDeo.add(btnDelete);
	//	add(Box.createHorizontalStrut(720));
		desniDeo.add(textField);
		desniDeo.add(btnSearch);
		
		add(leviDeo, BorderLayout.WEST);
		add(desniDeo, BorderLayout.EAST);
		
		this.setFloatable(false);	// Mile promenio!
		
	}
	
}
