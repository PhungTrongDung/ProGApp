package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.sign_up;

public class controller_sign_up implements ActionListener {
	private sign_up su;

	public controller_sign_up(sign_up su) {
		this.su = su;
	}

	public sign_up getSu() {
		return su;
	}

	public void setSi(sign_up su) {
		this.su = su;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Sign in")) {
			this.su.signIn();
		}
		else if(src.equals("Sign up")) {
			this.su.signUp();
		}
		
	}
	
}
