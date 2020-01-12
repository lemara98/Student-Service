package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Klasa za dodavanje studenta u bazu
 * @author Mile
 *
 */
public class AddFrameStudent extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7035957960442633423L;
	
	private JTextField imet = new JTextField("");
	private JTextField pret = new JTextField("");
	private JTextField datrt = new JTextField("");
	private JTextField adrst = new JTextField("");
	private JTextField kontt = new JTextField("");
	private JTextField emat = new JTextField("");
	private JTextField brit = new JTextField("");
	private JTextField datut = new JTextField("");
	private JTextField tgst = new JTextField("");
	private JTextField prot = new JTextField("");
	private JRadioButton budzet = new JRadioButton("Budzet");
	private JRadioButton samofinansiranje = new JRadioButton("Samofinansiranje");
	private ButtonGroup status = new ButtonGroup();
	private ArrayList<JCheckBox> listaCekBoxova;
	
	
	
	/**
	 * Prozor sa formularom za dodavanje studenta
	 */
	public AddFrameStudent() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ss = kit.getScreenSize();
		Dimension vel = new Dimension(ss.width/2, ss.height/2);
		setTitle("Dodaj novog studenta");
		setSize(vel);
		setIconImage(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\inbox_plus [#1554].png").getImage());
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		
		status.add(budzet);
		status.add(samofinansiranje);
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		panel.setLayout(new GridBagLayout());
		panel.setSize(vel);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		//// Labele ////
		// Ime
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel ime = new JLabel("Ime*");
		
		panel.add(ime, gbc);
		
		add(panel);
		
		// Prezime
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel pre = new JLabel("Prezime*");
		
		panel.add(pre, gbc);
		
		add(panel);
		
		// Datum rodjenja
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel datr = new JLabel("Datum rodjenja* [dd.MM.yyyy.]");
		
		panel.add(datr, gbc);

		// Adresa stanovanja
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel adrs = new JLabel("Adresa stanovanja*");
		
		panel.add(adrs, gbc);
		
		// Kontakt telefon
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel kont = new JLabel("Kontakt telefon*");
		
		panel.add(kont, gbc);
		
		// Email adresa
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel ema = new JLabel("Email adresa");
		
		panel.add(ema, gbc);
		
		
		// broj indeksa
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel bri = new JLabel("Broj indeksa* [XX nnn/yyyy]");
		
		panel.add(bri, gbc);
		
		
		// Datum upisa
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel datu = new JLabel("Datum upisa [dd.MM.yyyy.]");
		
		panel.add(datu, gbc);
		
		// Trenutna godina studija
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel tgs = new JLabel("Trenutna godina studija* [1-4]");
		
		
		panel.add(tgs, gbc);
		
		// Status
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		
		panel.add(budzet, gbc);
		
		// Prosecna ocena
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel pro = new JLabel("Prosecna ocena");
		
		
		panel.add(pro, gbc);
		
		//// JTextArea ////
		
				// Ime
				Dimension v = new Dimension(200,25);
				
				gbc.gridx = 1;
				gbc.gridy = 0;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
				imet.setPreferredSize(v);
				
				panel.add(imet, gbc);
				
				add(panel);
				
				// Prezime
				gbc.gridx = 1;
				gbc.gridy = 1;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
				pret.setPreferredSize(v);
				
				panel.add(pret, gbc);
				
				add(panel);
				
				// Datum rodjenja
				gbc.gridx = 1;
				gbc.gridy = 2;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
				datrt.setPreferredSize(v);
				
				panel.add(datrt, gbc);

				// Adresa stanovanja
				gbc.gridx = 1;
				gbc.gridy = 3;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
				adrst.setPreferredSize(v);
				
				panel.add(adrst, gbc);
				
				// Kontakt telefon
				gbc.gridx = 1;
				gbc.gridy = 4;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
				kontt.setPreferredSize(v);
				
				panel.add(kontt, gbc);
				
				// Email adresa
				gbc.gridx = 1;
				gbc.gridy = 5;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
				emat.setPreferredSize(v);
				
				panel.add(emat, gbc);
				
				
				// broj indeksa
				gbc.gridx = 1;
				gbc.gridy = 6;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
				brit.setPreferredSize(v);
				
				panel.add(brit, gbc);
				
				
				// Datum upisa
				gbc.gridx = 1;
				gbc.gridy = 7;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
				datut.setPreferredSize(v);
				
				panel.add(datut, gbc);
				
				// Trenutna godina studija
				gbc.gridx = 1;
				gbc.gridy = 8;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
				tgst.setPreferredSize(v);
				
				
				panel.add(tgst, gbc);
				
				// Status
				gbc.gridx = 1;
				gbc.gridy = 9;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
//				stat.setPreferredSize(v);
				
				panel.add(samofinansiranje, gbc);
//				panel.add(stat, gbc);
				
				// Prosecna ocena
				gbc.gridx = 1;
				gbc.gridy = 10;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
				prot.setPreferredSize(v);
				
				
				panel.add(prot, gbc);
				

				
				
		JPanel panelDugmadi = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelDugmadi.setPreferredSize(new Dimension(200,40));
				
		//// Dugmadi Submit i Cancel
				
				
			
		Dimension vd = new Dimension(100,25);
		
		// Submit
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		
		JButton btnSub = new JButton("Submit");
		btnSub.setPreferredSize(vd);
		btnSub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean im = true, pr = true, da = true, dub = true, ad = true, ko = true, br = true, prs = true, st = true, godb = true;
				ime.setForeground(Color.BLACK);
				pre.setForeground(Color.BLACK);
				datr.setForeground(Color.BLACK);
				adrs.setForeground(Color.BLACK);
				kont.setForeground(Color.BLACK);
				bri.setForeground(Color.BLACK);
				pro.setForeground(Color.BLACK);
				ema.setForeground(Color.BLACK);
				datu.setForeground(Color.BLACK);
				tgs.setForeground(Color.BLACK);
				budzet.setForeground(Color.BLACK);
				samofinansiranje.setForeground(Color.BLACK);
				
				
				try {
					
					if (imet.getText().equals(""))  im = false;
					if (pret.getText().equals("")) pr = false;
					if (datrt.getText().equals("")) da = false;
					if (adrst.getText().equals("")) ad = false;
					if (kontt.getText().equals("")) ko = false;
					if (brit.getText().equals("")) br = false;
					
					
					List<Student> ls;
					boolean greska = false;
					
					StatusStudenta n = null;
					if (budzet.isSelected()) {
						n = StatusStudenta.B;
					}
					else if (samofinansiranje.isSelected()) {
						n = StatusStudenta.S;
					}
					
					if (n == null) st = false;
					
					String[] datum = datrt.getText().split("\\.");
					if (datum.length != 3) da = false;
					
					datum = datut.getText().split("\\.");
					if (datum.length != 3) dub = false;
					
					Date dr = new SimpleDateFormat("dd.MM.yyyy.").parse(datrt.getText());
					Date du = new SimpleDateFormat("dd.MM.yyyy.").parse(datut.getText());
					if (dr.after(du)) {
						da = false;
						dub = false;
					}
					
					
					
					
					String[] index = brit.getText().split("/");
					if(index.length != 2) br = false;
					
					double d = 0.00;
					if (!prot.getText().equals("")) {
						d = Double.parseDouble(prot.getText());
						if (d != 0.0) 
							if (d < 6.0 || d > 10.0) prs = false;
					}
					
					
					int god = Integer.parseInt(tgst.getText());
					if (god < 1 || god > 4) godb = false;
					
					if (d == 0 && god != 1) {
						godb = false;
						prs = false;
					}
					
					
					Student s = new Student(imet.getText(),
											pret.getText(),
											datrt.getText(),
											adrst.getText(),
											kontt.getText(),
											emat.getText(),
											brit.getText(),
											datut.getText(),
											Integer.parseInt(tgst.getText()),
											n,
											d
											);
					
					for (JCheckBox i : listaCekBoxova) {
						if (i.isSelected()) {
							String text = i.getText();
							String[] prvi = text.split(" | ");
							String sifra = prvi[0].trim();

							Subject predmet = MyBase.getInstance().getSubject(sifra);
							s.dodajPredmetUSpisak(predmet);
							predmet.addStudentToSubject(s);
						}
					}
					
					ls = MyBase.getInstance().getStudents();
					for(Student i : ls) {
						if (i.equals(s)) {	
							greska = true;
							JOptionPane.showMessageDialog(panel, "YOU CAN'T ADD SAME STUDENT TWICE\nYOU ADDED SAME INDEX NUMBER AGAIN!", "ERROR", JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							break;
						}
					}
					// boolean im = true, pr = true, da = true, ad = true, ko = true, br = true, prs = true, st = true, godb = true;
					if (!(im && pr && da && ad && ko && br && prs && st && godb && dub)) {
						greska = true;
						throw new Exception();
					}
					
					if (!greska) {
						MyBase.getInstance().addStudent(s);
						setVisible(false);
					}
				}
				catch (Exception er) {
					if (!im) ime.setForeground(Color.RED);
					if (!pr) pre.setForeground(Color.RED);
					if (!da) datr.setForeground(Color.RED);
					if (!ad) adrs.setForeground(Color.RED);
					if (!ko) kont.setForeground(Color.RED);
					if (!br) bri.setForeground(Color.RED);
					if (!prs) pro.setForeground(Color.RED);
					if (!st)  {
						budzet.setForeground(Color.RED);
						samofinansiranje.setForeground(Color.RED);
					}
					if (!godb) tgs.setForeground(Color.RED);
					if (!dub) datu.setForeground(Color.RED);
					
					JOptionPane.showMessageDialog(panel, "Ubacili ste neodgovarajuce podatke!", "ERROR IN ADDDING NEW STUDENT", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		panelDugmadi.add(btnSub, gbc);
		
		// Cancel
		gbc.gridx = 1;
		gbc.gridy = 12;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		
		JButton btnCan = new JButton("Cancel");
		btnCan.setPreferredSize(vd);
		btnCan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panelDugmadi.add(btnCan, gbc);	
		
		/////// CHECHBOXI SA PREDMETIMA ////////
		JPanel panelPred = new JPanel(new GridBagLayout());
		listaCekBoxova = new ArrayList<JCheckBox>();
		
		JLabel dp = new JLabel("Dostupni Predmeti:");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;

		panelPred.add(dp,gbc);

		List<Subject> listaPredmeta = MyBase.getInstance().getSubjects();
		int j = 1;
		for (Subject i : listaPredmeta) {
			addPredmetToList(panelPred, i, j);
			j++;
		}
		
		JScrollPane panelSaPredmetima = new JScrollPane(panelPred);
		panelSaPredmetima.setPreferredSize(new Dimension(300,480));

		/////////////
		
		
		add(panelDugmadi,BorderLayout.SOUTH);
		add(panel, BorderLayout.WEST);
		add(panelSaPredmetima, BorderLayout.CENTER);
	}
	
	/**
	 * Funkcija koja  ubacuje postojece predmete u desni panel za odabir
	 * @param panel
	 * @param predmet
	 * @param rbr
	 */
	private void addPredmetToList(JPanel panel, Subject predmet, int rbr) {
			JCheckBox cekBox = new JCheckBox(predmet.getCode() + " | "+ predmet.getName());
			listaCekBoxova.add(cekBox);
			GridBagConstraints gbc = new GridBagConstraints();
			
			gbc.gridx = 0;
			gbc.gridy = rbr;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.anchor = GridBagConstraints.WEST;
			
			panel.add(cekBox, gbc);
	}

	
}
