package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.qlnv_view;

public class ql_user {
	private ArrayList<user> u;

	public ql_user() {
		this.u = new ArrayList<user>();
	}

	public ArrayList<user> getU() {
		return u;
	}

	public void setU(ArrayList<user> u) {
		this.u = u;
	}
	
	public void insert (user a) {
		u.add(a);
	}
	
	public boolean kiemtratontai(user a) {
//		for (user use : u) {
//			if(use.getUseName() == a.getUseName()) {
//				return true;
//			}
//		}
//		return false;
		
		ArrayList<user> u = new ArrayList<>();
		
		try {
			FileReader fr = new FileReader("data_user.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			
			while(true) {
				line = br.readLine();
				if(line == null) {
					break;
				}
				String sLine[] = line.split(";");
				
				String name = sLine[0];
				String email = sLine[1];
				String sdt = sLine[2];
				String tdn = sLine[3];
				String mk = sLine[4];
				
				
				u.add(new user(name, email, sdt, name, mk));				
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for (user person : u) {
			if(person.getUseName().equals(a.getUseName())) {
				return true;
			}
		}
		return false;
		
	}
	
}
