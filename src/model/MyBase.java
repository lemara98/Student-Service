package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class MyBase {
	private static MyBase instance = null;
	
	public static MyBase getInstance() {
		if(instance == null)
			instance = new MyBase();
		
		return instance;
	}
	
	private File profesori = new File("src\\podaci\\Profesori.txt");
	private File studenti = new File("src\\podaci\\Studenti.txt");
	private File predmeti = new File("src\\podaci\\Predmeti.txt");
	
	private List<Professor> professors = new ArrayList<Professor>();		//Ove liste nam sluze kao baza podataka za tabelu
	private List<String> columnsProfessor;
	private List<Student> students = new ArrayList<Student>();
	private List<String> columnsStudent;
	private List<Subject> subjects = new ArrayList<Subject>();
	private List<String> columnsSubject;
	
	private MyBase() {
		initProfessors();		//na Pocetku inicijalizujemo listu profesora
		initStudents();
		initSubjects();
		
	}
	
	///////////////////////////////////////////////PROFESSOR////////////////////////////////////////////////
	
	private void initProfessors() {
		
		
		readFromFile(profesori);
		
		columnsProfessor = new ArrayList<String>();
		columnsProfessor.add("ID number");
		columnsProfessor.add("FirstName");
		columnsProfessor.add("LastName");
		columnsProfessor.add("Date");
		columnsProfessor.add("Adress");
		columnsProfessor.add("PhoneNumber");
		columnsProfessor.add("Email");
		columnsProfessor.add("WorkPlace");
		columnsProfessor.add("Title");
		columnsProfessor.add("Rank");
		columnsProfessor.add("Subjects");
	}
	
	public List<Professor> getProfessors(){
		return professors;		//returns my list of professors that we are using to create Professor table
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;	// sets my list of professors 
	}
	
	public int getProfessorColumnCount() {
		return columnsProfessor.size(); 	//returns number of columns in the table	
	}
	public String getProfessorColumnName(int index) {
		return columnsProfessor.get(index);		//returns the name of a column
	}
	public Professor getProfessorRow(int rowIndex) {
		return professors.get(rowIndex);		//returns one of my professors from the list
	}

	public String getProfessorValueAt(int row, int column) {		//returns the string of one table field
			Professor prof = this.professors.get(row);
			switch(column) {
			case 0:
				return prof.getIdNumber();
			case 1:
				return prof.getFirstName();
			case 2:
				return prof.getLastName();
			case 3:
				return prof.getDate();
			case 4:
				return prof.getLivingAdress();
			case 5:
				return prof.getNumber();
			case 6:
				return prof.getEmail();
			case 7:
				return prof.getWorkAdress();
			case 8:
				return prof.getTitle();
			case 9:
				return prof.getRank();
			case 10:
				return "Prikazi";
			default:
				return null;
		}
	}
	
	public void addProfessor(Professor p) {	//this method adds a new professor to my list(table)
		this.professors.add(p);
		MyMainFrame.getInstance().azurirajPrikaz();
	}
	
	public void deleteProfessor(String idNumber) {  //this method deletes a professor from my table by idNumber
		List<Professor> temp = new ArrayList<Professor>(); 
		
		for(Professor pr : professors) {
			if(pr.getIdNumber().equals(idNumber)) {
				temp.add(pr);
			}
		}
		
		professors.removeAll(temp);
	}
	
	public void editProfessor() {
		
	}
	
	public Professor getProfessorById(String id) {
		for (Professor pr : professors) {
			if(pr.getIdNumber().equals(id)) {
				return pr;
			}
		}
		return null;
	}
	
	//////////////////////////////////////////////////SUBJECT/////////////////////////////////////////////////
	public void initSubjects() {
		
		readFromFile(predmeti);
		
		columnsSubject = new ArrayList<String>();
		columnsSubject.add("Subject code");
		columnsSubject.add("Name");
		columnsSubject.add("Semester");
		columnsSubject.add("Year of study");
		columnsSubject.add("Professor");
		columnsSubject.add("Studenti");
		
		
		
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<String> getColumnsSubject() {
		return columnsSubject;
	}

	public void setColumnsSubject(List<String> columnsSubject) {
		this.columnsSubject = columnsSubject;
	}
	
	public int getSubjectColumnCount() {
		return columnsSubject.size();
	}
	
	public String getSubjectColumnName(int index) {
		return columnsSubject.get(index);
	}
	
	public Subject getSubjectRow(int row) {
		return subjects.get(row);
	}
	
	public Subject getSubject(String id) {
		;
		for (Subject s: subjects) {
			if (s.getCode().equals(id))
				return s;
		}
		JOptionPane.showMessageDialog(MyMainFrame.getInstance(), "Ne postoji takav predmet");
		return null;
	}
	
	public String getSubjectValueAt(int row, int column) {
		Subject s = subjects.get(row);
		switch(column) {
		case 0:
			return s.getCode();
		case 1:
			return s.getName();
		case 2:
			return Integer.toString(s.getSemester());
		case 3:
			return Integer.toString(s.getYearOfStuding());
		case 4:
			if(s.getProfessor() == null)
				return "---";
			return s.getProfessor().getFirstName() + " " + s.getProfessor().getLastName();
		case 5:
			return "Prikazi";
		default:
			return null;
		}
	}
	
	public void addSubject(Subject s) {
		subjects.add(s);
		MyMainFrame.getInstance().azurirajPrikaz();	//moram ovde da stavim iz nekog razloga?
	}
	
	public void deleteSubject(String code) {
		List<Subject> temp = new ArrayList<Subject>();
		
		for(Subject s : subjects) {
			if(s.getCode() == code) {	//ako se code podudara treba ga izbrisati
				temp.add(s);
			}
		}
		
		subjects.removeAll(temp);

	}
	
	
	
	public void editSubject(int idx) {
		Subject s = MyBase.getInstance().getSubjectRow(idx);
		new EditFrameSubject(s).setVisible(true);
		MyMainFrame.getInstance().azurirajPrikaz();
		
	}
	
	public Subject getSubjectByCode(String code) {
		Subject sub = new Subject();
		for (Subject s : subjects) {
			if(s.getCode() == code) {
				sub = s;
				break;
			}
		}
		return sub;
	}
	
	public void deleteStudentFromSubjects(Student stud) {
			for(Subject s : subjects) {
				s.deleteStudentFromSubject(stud);
			}
		}

	/////////////////	Studenti	/////////////////

	
	private void initStudents() {
		
		columnsStudent = new ArrayList<String>();
		
		readFromFile(studenti);
	//	Student st1 = new Student("Ljuba", "Alicic", "01-04-1959", "Ilidza", "062431234", "ljuba.alicic@uns.ac.rs", "RA1/3019", "01-10-3019", 1, StatusStudenta.B, 6.34);
	//	students.add(st1);  Ovo te je zezalo!
		
		columnsStudent.add("Ime");
		columnsStudent.add("Prezime");
		columnsStudent.add("Datum rodjenja");
		columnsStudent.add("Adresa stanovanja");
		columnsStudent.add("Kontakt telefon");
		columnsStudent.add("Email Adresa");
		columnsStudent.add("Broj indeksa");
		columnsStudent.add("Datum upisa");
		columnsStudent.add("Trenutna godina studija");
		columnsStudent.add("Status");
		columnsStudent.add("Prosecna ocena");
		columnsStudent.add("Spisak predmeta koje student slusa");
		
		
	}
	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getStudentsColumnCount() {
		return columnsStudent.size(); 	//returns number of columns in the table	
	}
	public String getStudentsColumnName(int index) {
		return columnsStudent.get(index);		//returns the name of a column
	}
	public Professor getStudentsRow(int rowIndex) {
		return professors.get(rowIndex);		//returns one of my professors from the list
	}
	public String getStudentsValueAt(int row, int column) {		//returns the string of one table field
			Student stud = this.students.get(row);
			switch(column) {
			case 0:
				return stud.getIme();
			case 1:
				return stud.getPrezime();
			case 2:
				return stud.getDatumRodjenja().toString();
			case 3:
				return stud.getAdresaStanovanje();
			case 4:
				return stud.getKontaktTelefon();
			case 5:
				return stud.getEmailAdresa();
			case 6:
				return stud.getBrojIndeksa();
			case 7:
				return stud.getDatumUpisa();
			case 8:
				return Integer.toString(stud.getTrenutnaGodinaStudija());
			case 9:
				if(stud.getStatus() == StatusStudenta.B)
					return "Budzet";
				return "Samofinansiranje";
			case 10:
				return Double.toString(stud.getProsecnaOcena());
			case 11:	
				return 	" Prikazi ";	//stud.getSpisakPredmetaKojeStudentSlusa().toString();
			default:
				return null;
		}
	}
	
	//vraca Studenta sa zadatim indexom
	public Student getStudentIndex(String idx) {
		for(Student st : students) {
			if(st.getBrojIndeksa().equals(idx)) {
				return st;
			}
		}
		return null;
	}
	public void addStudent(Student s) {
		students.add(s);
		MyMainFrame.getInstance().azurirajPrikaz();
	}
	public Student getStudentRow(int rowIndex) {
		return students.get(rowIndex);
	}
	
	public void deleteStudent(String brInd) {  
		List<Student> temp = new ArrayList<Student>(); 
		
		for(Student st : students) {
			if(st.getBrojIndeksa().equals(brInd)) {
				temp.add(st);
				break;
			}
		}
		
		students.removeAll(temp);
	}
	
	public void editStudent(int rowSelected) {
			Student temp = students.get(rowSelected);
			new EditFrameStudent(temp).setVisible(true);
	}
	
	public void removeSubjectsFromStudents(Subject s) {
		for(Student st: students)
			st.removeSubjectFromStudents(s);
	}
	
/////////////////////////////////////////////////////////////////////////////////	
	/**
	 * 
	 * Uvozi podatke iz datoteke na lokaciji src\podaci u bazu podataka
	 */
	public void uvoz() {
		readFromFile(studenti);	
		readFromFile(profesori);
		readFromFile(predmeti);
	}
	
	/**
	 * Izvozi podatke iz baze podataka u datoteku na lokaciji src\podaci
	 */
	public void izvoz() {
		writeToFile(studenti);
		writeToFile(profesori);
		writeToFile(predmeti);
	}
	
	private void readFromFile(File fajl) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajl.getPath()), "UTF-8"))){
				
				String trenutni;
				while ((trenutni = br.readLine()) != null) {
					boolean jedinstven = true;
					trenutni.trim();
					String[] podStud = trenutni.split(", ");
					if(fajl == studenti) {
						if (podStud.length > 10) {
							Student ucitani = new Student(podStud[0], 
														  podStud[1],
														  podStud[2], 
														  podStud[3], 
														  podStud[4], 
														  podStud[5], 
														  podStud[6], 
														  podStud[7], 
														  Integer.parseInt(podStud[8]), 
														  StatusStudenta.valueOf(podStud[9]), 
														  Double.parseDouble(podStud[10]));
							
							for (int i = 11; i < podStud.length; i++) {
								for(Subject j: subjects) {
									if (podStud[i].equals(j.getCode())) {
										ucitani.dodajPredmetUSpisak(j);
										break;
									}
								}
							}
							
							for (Student provera : students) {
								if (provera.equals(ucitani)) {
									jedinstven = false;
									break;
								}
							}
							if (jedinstven)
							students.add(ucitani);
						}
					} else if(fajl == profesori) {
						if(podStud.length > 9 ) {
							
							List<Subject> sub = new ArrayList<Subject>();
							for(int i = 9; i < podStud.length; i++) {
								sub.add(getSubjectByCode(podStud[i]));
							}
							
							
							Professor ucitani = new Professor(podStud[0], podStud[1], podStud[2], podStud[3], podStud[4], podStud[5], podStud[6], podStud[7], podStud[8], podStud[9], sub);
							for (Professor provera : professors) {
								if (provera.equals(ucitani)) {
									jedinstven = false;
									break;
								}
							}
							
							if (jedinstven)
							professors.add(ucitani);
						}
					}else if(fajl == predmeti){
						if (podStud.length > 3) {
							Professor pr = null;
							if(podStud[4] != "") { 
								String idProf = podStud[4];
								pr = getProfessorById(idProf);
							}
							ArrayList<Student> st = new ArrayList<Student>();
							Student student;
							
							if(podStud.length >= 6) {
								for(int i = 5; i < podStud.length; i++) {
									student = getStudentIndex(podStud[i]);
									st.add(student); //dodajemo studente
								}
							}
							Subject ucitani = new Subject(podStud[0], podStud[1], Integer.parseInt(podStud[2]), Integer.parseInt(podStud[3]), pr, st);
							for (Subject provera : subjects) {
								if (provera.equals(ucitani)) {
									jedinstven = false;
									break;
								}
							}
							if (jedinstven) {
								subjects.add(ucitani);
								
								if(podStud.length >= 6) {
									for(int i = 5; i < podStud.length; i++) {
										student = getStudentIndex(podStud[i]);
										student.dodajPredmetUSpisak(ucitani);
									}
								if (pr != null)	
									pr.addSubjectToSubjects(ucitani);
								}
							}
						}
					}
					
				}	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	private void writeToFile(File fajl) {
		try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fajl.getPath()), "UTF-8"))){
			
			StringBuilder trenutni = new StringBuilder();
			if(fajl == studenti) {
				for(Student i : students) {
					trenutni.append(i.toString() + "\n");
				}
			}else if(fajl == profesori) {
				for(Professor p : professors) {
					trenutni.append(p.toString() + "\n");
				}
			}else if(fajl == predmeti) {
				for(Subject s : subjects) {
					trenutni.append(s.toString() + "\n");
				}
			}

			br.append(trenutni);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
	

	
	
	
	
	
	

