package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MyToolBar extends JToolBar{


	private static final long serialVersionUID = 2933819767532950350L;

	public MyToolBar() {
		super(SwingConstants.HORIZONTAL);
		
		setBackground(Color.DARK_GRAY);
		//setPreferredSize(new Dimension(tbWidth,tbHeight));

		
		Icon icon = new ImageIcon("ikonice/Ikone24x24/icons8-add-user-male-24.png");
		JButton btnAdd = new JButton(icon);
		btnAdd.setToolTipText("Add");
		
		icon = new ImageIcon("ikonice/Ikone24x24/icons8-edit-24.png");
		JButton btnEdit = new JButton(icon);
		btnEdit.setToolTipText("Edit");
		
		icon = new ImageIcon("ikonice/Ikone24x24/icons8-delete-bin-24.png");
		JButton btnDelete = new JButton(icon);
		btnDelete.setToolTipText("Delete");
		
		icon = new ImageIcon("ikonice/Ikone24x24/icons8-search-more-24.png");
		JButton btnSearch= new JButton(icon);
		btnSearch.setToolTipText("Search");
		
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(100,20));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(btnAdd);
		add(btnEdit);
		add(btnDelete);
		add(Box.createHorizontalStrut(720));
		add(textField);
		add(btnSearch);
		
		this.setFloatable(true);
		
	}
	
}
