package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.controller_home;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

class panel extends JPanel {
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon img = new ImageIcon("D:\\Eclipse\\File_Java\\ProGApp\\src\\view\\intro.png");
		g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}

public class Home_admin extends JFrame {

//	private JPanel contentPane;
	private panel p;
	private JLabel labelClock_clock, label_date;
	
	private String text = "CLB Lập trình PTIT";
	
	public static void main(String[] args) {		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Home_admin();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Home_admin() throws HeadlessException {
		
		p = new panel();
		p.setBounds(0, 0, 870, 513);
		
		this.setTitle("Home");
		this.setSize(884, 550);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		URL icon = Sign_in.class.getResource("/view/logo Pro_2.png");
		Image img_icon = Toolkit.getDefaultToolkit().createImage(icon);
		this.setIconImage(img_icon);
		getContentPane().setLayout(null);
		
		ActionListener ac = new controller_home(this);
		
		JButton Sign_in = new JButton("");
		Sign_in.setActionCommand("Sign in");
		Sign_in.setIcon(new ImageIcon(Home_admin.class.getResource("login2.png")));
		Sign_in.addActionListener(ac);
		Sign_in.setContentAreaFilled(false);
		Sign_in.setBorderPainted(false);
		Sign_in.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Sign_in.setBackground(Color.WHITE);
		Sign_in.setBounds(736, 16, 67, 51);
		getContentPane().add(Sign_in);
		
		JButton btnSignUp = new JButton("");
		btnSignUp.setActionCommand("Sign up");
		btnSignUp.setIcon(new ImageIcon(Home_admin.class.getResource("person3.png")));
		btnSignUp.addActionListener(ac);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSignUp.setBackground(Color.LIGHT_GRAY);
		btnSignUp.setBounds(801, 16, 59, 57);
		getContentPane().add(btnSignUp);
		
		JButton button_youtube = new JButton("");
		button_youtube.setIcon(new ImageIcon(Home_admin.class.getResource("/view/youtube-icon.png")));
		button_youtube.setActionCommand("youtube");
		button_youtube.addActionListener(ac);
		button_youtube.setContentAreaFilled(false);
		button_youtube.setBorderPainted(false);
		button_youtube.setBounds(820, 472, 40, 41);
		
		button_youtube.addMouseListener(new MouseAdapter() {
			 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.youtube.com/c/CLBL%E1%BA%ADpTr%C3%ACnhPTIT"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
            	button_youtube.setText("<html><a href=''>" + text + "</a></html>");
            }
 
        });
		
		getContentPane().add(button_youtube);
		
		JButton button_fb = new JButton("");
		button_fb.setIcon(new ImageIcon(Home_admin.class.getResource("/view/facebook.png")));
		button_fb.setActionCommand("facebook");
		button_fb.addActionListener(ac);
		button_fb.setContentAreaFilled(false);
		button_fb.setBorderPainted(false);
		button_fb.setBounds(770, 472, 40, 41);
		
		button_fb.addMouseListener(new MouseAdapter() {
			 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/clubproptit"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
            	button_fb.setText("<html><a href=''>" + text + "</a></html>");
            }
 
        });
		
		getContentPane().add(button_fb);
		
		
		labelClock_clock = new JLabel();
		labelClock_clock.setForeground(Color.WHITE);
		labelClock_clock.setFont(new Font("Vivaldi", Font.PLAIN, 30));
        labelClock_clock.setBounds(33, 0, 175, 63);
        getContentPane().add(labelClock_clock);
        
        label_date = new JLabel();
        label_date.setForeground(Color.WHITE);
        label_date.setFont(new Font("Vivaldi", Font.PLAIN, 15));
        label_date.setBounds(31, 36, 157, 41);
        getContentPane().add(label_date);
        
//        // dóng chương trình khi đóng của sổ
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
		
		this.getContentPane().add(p);
		this.setVisible(true);
		
      // thiết lập lại đồng hồ sau mỗi 1 giây
      try {
          while (true) {
        	  Calendar cal = new GregorianCalendar();
        	  int second = cal.get(Calendar.SECOND);
        	  int minute = cal.get(Calendar.MINUTE);
        	  int hour = cal.get(Calendar.HOUR_OF_DAY);
        	  String thu;
//        	  int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//        	  if(dayOfWeek == 1) {
//        		  thu = "Chủ nhật";
//        	  }
//        	  else {
//        		  thu = "Thứ " + Integer.toString(dayOfWeek);
//        	  }
        	  
        	  int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        	  int month = cal.get(Calendar.MONTH);
        	  int year = cal.get(Calendar.YEAR);
        	  labelClock_clock.setText(hour + ":" + minute + ":" + second);
//              timeSystemBD.setText(hour + ":" + minute + ":" + second);
//              timeSystemTK.setText(hour + ":" + minute + ":" + second);
//              calendarBD.setText(thu + " ngày " + dayOfMonth + " tháng " + (month + 1) + " năm " + year);
//        	  label_thu.setText(thu);
              label_date.setText(dayOfMonth + " - " + (month + 1) + " - " + year);
//              sleep(1000);
        	  
//              Calendar calendar = Calendar.getInstance();
//              String hour = (calendar.getTime().getHours() > 9) ? 
//                      "" + calendar.getTime().getHours() + ""
//                      : "0" + calendar.getTime().getHours();
//              String minute = (calendar.getTime().getMinutes() > 9) ? 
//                      "" + calendar.getTime().getMinutes() + ""
//                      : "0" + calendar.getTime().getMinutes();
//              String second = (calendar.getTime().getSeconds() > 9) ? 
//                      "" + calendar.getTime().getSeconds() + ""
//                      : "0" + calendar.getTime().getSeconds();
//              
//              String time = hour + ":" + minute + ":" + second;
//              
//              labelClock_clock.setText(time);
              Thread.sleep(1000);
          }
      } catch (Exception e) {
//    	  InterruptedException e
          e.printStackTrace();
      }
		
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

	public void signUp() {
		this.setVisible(false);
		try {
			new sign_up();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
