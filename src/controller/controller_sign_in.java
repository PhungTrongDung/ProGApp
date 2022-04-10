package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Sign_in;

public class controller_sign_in implements ActionListener {
	
	private Sign_in si;
	
	public controller_sign_in(Sign_in si) {
		this.si = si;
	}

	public Sign_in getSi() {
		return si;
	}

	public void setSi(Sign_in si) {
		this.si = si;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Sign in")) {
			this.si.signIn();
		}
		else if(src.equals("Sign up")) {
			this.si.signUp();
		}
		
	}
	
}
