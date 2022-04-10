package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class sign_in_bg extends JPanel {
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon img = new ImageIcon("D:\\Eclipse\\File_Java\\ProGApp\\src\\view\\bg6.jpg");
		g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}

//public class sign_in_bg{
//	static panel p;
//	public static void main(String[] args) {
//		JFrame win = new JFrame();
//		p = new panel();
//		win.add(p);
//		
//		win.setTitle("BackGround");
//		win.setSize(500, 300);
//		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		win.setLocationRelativeTo(null);
//		win.setVisible(true);
//	}
//}
