package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.controller_sign_in;
import model.NhanVien;
import model.Tinh;
//import view.sign_in_bg;
import model.user;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;


public class Sign_in extends JFrame {
	private sign_in_bg p;
	private JTextField textField_use;
	private JPasswordField passwordField;
	
	public static user nguoiDung;

	public Sign_in() {
		
		p = new sign_in_bg();
		p.setBounds(0, 0, 486, 463);
		
		this.setTitle("Sign In");	
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font =  new Font("Tahoma", Font.PLAIN, 15);
		
		URL icon = Sign_in.class.getResource("icon_login.png");
		Image img_icon = Toolkit.getDefaultToolkit().createImage(icon);
		this.setIconImage(img_icon);
		
		ActionListener ac = new controller_sign_in(this);
		getContentPane().setLayout(null);
		
		JLabel label_use = new JLabel("Username");
		label_use.setBounds(69, 235, 115, 24);
		label_use.setForeground(Color.WHITE);
		label_use.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(label_use);
		
		textField_use = new JTextField();
		textField_use.setBounds(256, 232, 150, 35);
		textField_use.setFont(font);
		getContentPane().add(textField_use);
		textField_use.setColumns(10);
		
		JLabel label_pass = new JLabel("Password");
		label_pass.setBounds(69, 304, 115, 24);
		label_pass.setForeground(Color.WHITE);
		label_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(label_pass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(256, 301, 150, 35);
		passwordField.setFont(font);
		getContentPane().add(passwordField);
		
		JButton button_sign_in = new JButton("Sign in");
		button_sign_in.setBounds(99, 373, 115, 30);
		button_sign_in.setIcon(new ImageIcon(Sign_in.class.getResource("icon_login.png")));
		button_sign_in.addActionListener(ac);
		button_sign_in.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(button_sign_in);
		
		JButton button_sign_up = new JButton("Sign up");
		button_sign_up.setBounds(276, 373, 115, 30);
		button_sign_up.setIcon(new ImageIcon(Sign_in.class.getResource("person-icon.png")));
		button_sign_up.addActionListener(ac);
		button_sign_up.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(button_sign_up);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Sign_in.class.getResource("pc.png")));
		lblNewLabel.setBounds(133, 42, 216, 160);
		getContentPane().add(lblNewLabel);
		
		this.getContentPane().add(p);
		
//		this.setVisible(true);
	}
	
	public void signIn() {
		String use = this.textField_use.getText() + "";
		String pass = this.passwordField.getText() + "";
		
		user a = new user("", "", "", use, pass);
		
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
				
				
				u.add(new user(name, email, sdt, tdn, mk));
				
			}
			
			int ok = 0;
			for (user person : u) {
				if(person.getUseName().equals(use)) {
					ok = 1;
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
					nguoiDung = person;
					this.setVisible(false);
					new qlnv_view();
				}
			}
			
			if(ok == 0) {
				JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại!");
				this.textField_use.setText("");
				this.passwordField.setText("");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
//		JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
//		this.setVisible(false);
//		new qlnv_view();
	}
	
	public static user getNguoiDung() {
		return nguoiDung;
	}

	public static void setNguoiDung(user nguoiDung) {
		Sign_in.nguoiDung = nguoiDung;
	}

	public void signUp() {
		this.setVisible(false);
		try {
			new sign_up();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Sign_in si = new Sign_in();
			si.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
