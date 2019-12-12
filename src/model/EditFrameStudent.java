package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

public class EditFrameStudent extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -617832339058983070L;
	
	private JTextField imet;
	private JTextField pret;
	private JTextField datrt;
	private JTextField adrst;
	private JTextField kontt;
	private JTextField emat;
	private JTextField brit;
	private JTextField datut;
	private JTextField tgst;
	private String stat;
	private JTextField prot;
	private JRadioButton budzet = new JRadioButton("Budzet");
	private JRadioButton samofinansiranje = new JRadioButton("Samofinansiranje");
	private ButtonGroup status = new ButtonGroup();
	private ArrayList<JCheckBox> listaCekBoxova;
	private List<Subject> listaPredmeta;
	private Student menjaniStudent;
	
	
	public EditFrameStudent(Student temp) {
		super();
		
		try {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension ss = kit.getScreenSize();
		Dimension vel = new Dimension(ss.width/2, ss.height/2);
		setTitle("Edit student " + temp.getBrojIndeksa() + " " + temp.getIme() + " " + temp.getPrezime());
		setSize(vel);
		setIconImage(new ImageIcon("slike\\ikonice\\1800_Icon_Pack_20x20\\PNG1_black_icons\\pen [#1319].png").getImage());
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		
		status.add(budzet);
		status.add(samofinansiranje);
		
		imet = new JTextField(temp.getIme());
		pret = new JTextField(temp.getPrezime());
		datrt = new JTextField(temp.getDatumRodjenja());
		adrst = new JTextField(temp.getAdresaStanovanje());
		kontt = new JTextField(temp.getKontaktTelefon());
		emat = new JTextField(temp.getEmailAdresa());
		brit = new JTextField(temp.getBrojIndeksa());
		datut = new JTextField(temp.getDatumUpisa());
		tgst = new JTextField(Integer.toString(temp.getTrenutnaGodinaStudija()));
		stat = new String(temp.getStatus().toString());
		prot = new JTextField(Double.toString(temp.getProsecnaOcena()));
		
		listaCekBoxova = new ArrayList<JCheckBox>();
		JCheckBox box;
		for (Subject i : MyBase.getInstance().getSubjects()) {
			box = new JCheckBox(i.getCode() + " | " + i.getName());
			listaCekBoxova.add(box);
		}
		
		String text;
		String[] kod;
		for (Subject i : temp.getSpisakPredmetaKojeStudentSlusa()) {
			for (JCheckBox j : listaCekBoxova) {
				text = j.getText();
				kod = text.split(" | ");
				if (i.getCode().equals(kod[0]))
					j.setSelected(true);
			}
		}
		
		
		
		if (stat.equals("B")) {
			budzet.setSelected(true);
		}
		else {
			samofinansiranje.setSelected(true);
		}
				
		menjaniStudent = temp;
	
		
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
		
		JLabel ime = new JLabel("Ime");
		
		panel.add(ime, gbc);
		
		add(panel);
		
		// Prezime
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel pre = new JLabel("Prezime");
		
		panel.add(pre, gbc);
		
		add(panel);
		
		// Datum rodjenja
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel datr = new JLabel("Datum rodjenja");
		
		panel.add(datr, gbc);

		// Adresa stanovanja
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel adrs = new JLabel("Adresa stanovanja");
		
		panel.add(adrs, gbc);
		
		// Kontakt telefon
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel kont = new JLabel("Kontakt telefon");
		
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
		
		JLabel bri = new JLabel("Broj indeksa [ XX-nnn/yyyy]");
		
		panel.add(bri, gbc);
		
		
		// Datum upisa
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel datu = new JLabel("Datum upisa [dd-MM-yyyy]");
		
		panel.add(datu, gbc);
		
		// Trenutna godina studija
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel tgs = new JLabel("Trenutna godina studija");
		
		
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
				
				panel.add(samofinansiranje, gbc);
				
				// Prosecna ocena
				gbc.gridx = 1;
				gbc.gridy = 10;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.anchor = GridBagConstraints.WEST;
				
				prot.setPreferredSize(v);
				
				
				panel.add(prot, gbc);
				
		//// Dugmadi Submit i Cancel
				
		Dimension vd = new Dimension(100,25);
		JPanel panelDugmadi = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
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
				try {
					// TODO Auto-generated method stub
					List<Student> ls;
					boolean greska = false;
					
					StatusStudenta n;
					if (budzet.isSelected()) {
						n = StatusStudenta.B;
					}
					else {
						n = StatusStudenta.S;
					}
					
					menjaniStudent.setIme(imet.getText());
					menjaniStudent.setPrezime(pret.getText());
					menjaniStudent.setDatumRodjenja(datrt.getText());
					menjaniStudent.setAdresaStanovanje(adrst.getText());
					menjaniStudent.setKontaktTelefon(kontt.getText());
					menjaniStudent.setEmailAdresa(emat.getText());
					menjaniStudent.setBrojIndeksa(brit.getText());
					menjaniStudent.setDatumUpisa(datut.getText());
					menjaniStudent.setTrenutnaGodinaStudija(Integer.parseInt(tgst.getText()));
					menjaniStudent.setStatus(n);
					menjaniStudent.setProsecnaOcena(Double.parseDouble(prot.getText()));
					
					ArrayList<Subject> izmenjeniSpisak = new ArrayList<Subject>();
					String tekst;
					String[] sifra;
					for(JCheckBox k : listaCekBoxova) {
						System.out.println(k.getText());
						if (k.isSelected()) {
							tekst = k.getText();
							sifra = tekst.split(" | ");
							izmenjeniSpisak.add(MyBase.getInstance().getSubject(sifra[0]));
						}
					}
					
					menjaniStudent.setSpisakPredmetaKojeStudentSlusa(izmenjeniSpisak);
					

					ls = MyBase.getInstance().getStudents();
					
					for(Student i : ls) {
						if (i == menjaniStudent) continue;
						if (i.equals(menjaniStudent)) {	
								greska = true;
								JOptionPane.showMessageDialog(panel, "THERE ALREADY IS A STUDENT WITH THAT INDEX!", "ERROR", JOptionPane.ERROR_MESSAGE);
								break;
							}
						}
					
					if (!greska) {
					MyMainFrame.getInstance().azurirajPrikaz();
					setVisible(false);
					}
				}
				catch (Exception er) {
					JOptionPane.showMessageDialog(panel, "Ubacili ste ne odgovarajuce podatke!", "ERROR IN ADDDING NEW STUDENT", JOptionPane.ERROR_MESSAGE);
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
				// TODO Auto-generated method stub
//				imet.setText("");
//				pret.setText("");
//				datrt.setText("");
//				adrst.setText("");
//				kontt.setText("");
//				emat.setText("");
//				brit.setText("");
//				datut.setText("");
//				tgst.setText("");
//				prot.setText("");
				setVisible(false);
			}
		});
		panelDugmadi.add(btnCan, gbc);	
		
		
		////// CHECHBOXI SA PREDMETIMA //////
		JPanel panelPred = new JPanel(new GridBagLayout());
		
		JLabel dp = new JLabel("Dostupni predmeti:");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;

		panelPred.add(dp,gbc);

		listaPredmeta = MyBase.getInstance().getSubjects();
		int j = 1;
		for (Subject i : listaPredmeta) {
			addPredmetToList(panelPred, i, j);
			j++;
		}
		
		JScrollPane panelSaPredmetima = new JScrollPane(panelPred);
		panelSaPredmetima.setPreferredSize(new Dimension(300,480));
		
		
		//////
		
		
		add(panel, BorderLayout.WEST);
		add(panelSaPredmetima, BorderLayout.EAST);
		add(panelDugmadi, BorderLayout.SOUTH);
	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

//	public Student getStudentInformation() {
//		Student s = new Student(imet.getText(),
//				pret.getText(),
//				datrt.getText(),
//				adrst.getText(),
//				kontt.getText(),
//				emat.getText(),
//				brit.getText(),
//				datut.getText(),Integer.parseInt(tgst.getText()),
//				StatusStudenta.valueOf(stat.toUpperCase()),
//				Double.parseDouble(prot.getText()));
//		
////				s.setSpisakPredmetaKojeStudentSlusa(spisakPredmetaKojeStudentSlusa);
//		// Mora biti neka greska negde ako se ovo poziva! SPisakPredmeta se opet inicira
//		return s;
//	}
	
	
	private void addPredmetToList(JPanel panel, Subject predmet, int rbr) {

		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = rbr;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		
		panel.add(listaCekBoxova.get(rbr-1), gbc);
}
	
}
