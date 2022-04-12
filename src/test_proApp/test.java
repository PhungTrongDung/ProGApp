package test_proApp;

import javax.swing.UIManager;

import view.qlnv_view;
import view.sign_up;
import view.Home_admin;
import view.qlnv_chamCong;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			new qlnv_chamCong();
//			new qlnv_view();
			new Home_admin();
//			new sign_up();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
