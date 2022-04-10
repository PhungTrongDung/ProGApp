package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.controller_sign_up;
import model.user;
import model.NhanVien;
import model.ql_user;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;


public class sign_up extends JFrame {
	public static ql_user qu;
	private sign_in_bg p;
	private JPasswordField passwordField_pass;
	private JPasswordField passwordField_confirm;
	private JTextField txField_use;
	private JLabel lable_pass;
	private JLabel lable_confirm;
	private JLabel lable_use;
	public String form_use = "((?=.*[A-Z])(?=.*[a-z])(?=.*d))";
	public String form_pass = "((?=.*[a-z])(?=.*d))";
	private JTextField textField_phone;
	private JTextField textField_email;
	private JTextField textField_name;

	public sign_up() {
		p = new sign_in_bg();
		p.setBounds(0, 0, 472, 657);
		
		this.qu = new ql_user();
		
		this.setTitle("Sign Up");
		this.setSize(486, 694);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		URL icon = Sign_in.class.getResource("person-icon.png");
		Image img_icon = Toolkit.getDefaultToolkit().createImage(icon);
		this.setIconImage(img_icon);
		
		Font font =  new Font("Tahoma", Font.PLAIN, 15);
		
		ActionListener ac = new controller_sign_up(this);
		getContentPane().setLayout(null);
		
		JLabel label_name = new JLabel("Name");
		label_name.setForeground(Color.WHITE);
		label_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_name.setBounds(48, 242, 136, 21);
		getContentPane().add(label_name);
		
		textField_name = new JTextField();
		textField_name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_name.setColumns(10);
		textField_name.setBounds(250, 239, 174, 32);
		getContentPane().add(textField_name);
		
		JLabel lable_email = new JLabel("Email");
		lable_email.setForeground(Color.WHITE);
		lable_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_email.setBounds(48, 297, 136, 21);
		getContentPane().add(lable_email);
		
		textField_email = new JTextField();
		textField_email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_email.setColumns(10);
		textField_email.setBounds(250, 294, 174, 32);
		getContentPane().add(textField_email);
		
		JLabel lable_phone = new JLabel("Phone");
		lable_phone.setForeground(Color.WHITE);
		lable_phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_phone.setBounds(48, 350, 136, 21);
		getContentPane().add(lable_phone);
		
		textField_phone = new JTextField();
		textField_phone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_phone.setColumns(10);
		textField_phone.setBounds(250, 347, 174, 32);
		getContentPane().add(textField_phone);
		
		lable_use = new JLabel("Username");
		lable_use.setForeground(Color.WHITE);
		lable_use.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_use.setBounds(48, 405, 136, 21);
		getContentPane().add(lable_use);
		
		txField_use = new JTextField();
		txField_use.setFont(font);
		txField_use.setBounds(250, 402, 174, 32);
		getContentPane().add(txField_use);
		txField_use.setColumns(10);
		
		lable_pass = new JLabel("Password");
		lable_pass.setForeground(Color.WHITE);
		lable_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_pass.setBounds(48, 460, 136, 21);
		getContentPane().add(lable_pass);
		
		passwordField_pass = new JPasswordField();
		passwordField_pass.setFont(font);
		passwordField_pass.setBounds(250, 457, 174, 32);
		getContentPane().add(passwordField_pass);
		
		lable_confirm = new JLabel("Confirm");
		lable_confirm.setForeground(Color.WHITE);
		lable_confirm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lable_confirm.setBounds(48, 514, 136, 21);
		getContentPane().add(lable_confirm);
		
		passwordField_confirm = new JPasswordField();
		passwordField_confirm.setFont(font);
		passwordField_confirm.setBounds(250, 511, 174, 32);
		getContentPane().add(passwordField_confirm);
		
		JButton button_sign_in = new JButton("Sign in");
		button_sign_in.setIcon(new ImageIcon(sign_up.class.getResource("/view/icon_login.png")));
		button_sign_in.addActionListener(ac);
		button_sign_in.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_sign_in.setBounds(83, 576, 118, 32);
		getContentPane().add(button_sign_in);
		
		JButton button_sign_up = new JButton("Sign up");
		button_sign_up.setIcon(new ImageIcon(sign_up.class.getResource("/view/person-icon.png")));
		button_sign_up.addActionListener(ac);
		button_sign_up.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_sign_up.setBounds(278, 575, 118, 33);
		getContentPane().add(button_sign_up);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Sign_in.class.getResource("/view/pc.png")));
		lblNewLabel.setBounds(133, 42, 216, 160);
		getContentPane().add(lblNewLabel);
		
		
		this.getContentPane().add(p);
		this.setVisible(true);
		
	}

	public void signIn() {
		this.setVisible(false);
		try {
			Sign_in si = new Sign_in();
			si.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveUser(user u) {
		
		try {
			FileWriter fw = new FileWriter("data_user.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(u.toString());
			bw.newLine();
			
			bw.close();
			fw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void signUp() {
		String name = this.textField_name.getText() + "";
		String email = this.textField_email.getText() + "";
		String phone = this.textField_phone.getText() + "";
		String use = this.txField_use.getText() + "";
		String pass = this.passwordField_pass.getText() + "";
		String confirm = this.passwordField_confirm.getText() + "";
		
//		if(!use.matches(form_use)) {
		if(use.length() < 6) {
			JOptionPane.showMessageDialog(this, "Tên đăng nhập phải có ít nhất 6 kí tự trở lên!");
			this.txField_use.setText("");
			this.passwordField_pass.setText("");
			this.passwordField_confirm.setText("");
		}
		else {
				if(pass.length() < 6) {
					JOptionPane.showMessageDialog(this, "Mật khẩu phải có ít nhất 6 kí tự!");
				}
				else {
//					if(!pass.matches(form_pass)) {
//						JOptionPane.showMessageDialog(this, "Mật khẩu có ít nhất 1 kí tự là chữ in thường và 1 kí tự là chữ số!");
//						this.passwordField_pass.setText("");
//						this.passwordField_confirm.setText("");
//					}
//					else {
						if(!pass.equals(confirm)) {
							JOptionPane.showMessageDialog(this, "Mật khẩu của bạn không trùng khớp!");
							this.passwordField_pass.setText("");
							this.passwordField_confirm.setText("");
						}
						else {
							user u = new user(name, email, phone, use, pass);
							
							if(this.qu.kiemtratontai(u) == true) {
								JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại");
								this.txField_use.setText("");
								this.passwordField_pass.setText("");
								this.passwordField_confirm.setText("");
							}
							
							else {
								this.qu.insert(u);
								this.saveUser(u);
										
								JOptionPane.showMessageDialog(this, "Đăng kí thành công!");
								this.setVisible(false);

								try {
									Sign_in si = new Sign_in();
									si.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							
						}
//					}
				}
		}
	}
}
