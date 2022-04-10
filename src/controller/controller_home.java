package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Home_admin;

public class controller_home implements ActionListener {
//	private main m;
	private Home_admin m;

//	public controller_main(main m) {
//		super();
//		this.m = m;
//	}

	public controller_home(Home_admin m) {
		this.m = m;
	}

	public Home_admin getM() {
		return m;
	}

	public void setM(Home_admin m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Sign in")) {
			this.m.signIn();
		}else if(src.equals("Sign up")) {
			this.m.signUp();
		}	
	}
}
