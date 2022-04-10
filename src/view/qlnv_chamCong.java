package view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import view.qlnv_view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.table.DefaultTableModel;

import controller.controller_salary;
import model.NhanVien;
import model.Tinh;
import model.qlnv_model;

import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;


class Surface extends JPanel implements ActionListener {

	private Image img;
	private Timer timer;
	private float alpha = 1f;
	
	private final int DELAY = 40;
	private final int INITIAL_DELAY = 500;
	
	public Surface() {
		loadImage();
		setSurfaceSize();
		initTimer();
	}
	
	private void loadImage() {
	
		img = new ImageIcon("D:\\Eclipse\\File_Java\\ProGApp\\src\\view\\bg6.jpg").getImage();
	}
	
	private void setSurfaceSize() {
	
		int h = img.getHeight(this);
		int w = img.getWidth(this);
		setPreferredSize(new Dimension(w, h));
	}
	
	private void initTimer() {
	
		timer = new Timer(DELAY, this);
		timer.setInitialDelay(INITIAL_DELAY);
		timer.start();
	}
	
	private void doDrawing(Graphics g) {
	
		Graphics2D g2d = (Graphics2D) g.create();
		
		AlphaComposite acomp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(acomp);
		g2d.drawImage(img, 0, 0, null);
		
		g2d.dispose();
	}
	
	@Override
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		doDrawing(g);
	}
	
	private void step() {
	 
		alpha += -0.01f;
		
		if (alpha <= 0) {
		
		    alpha = 0;
		    timer.stop();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		step();
		repaint();
	}
}

public class qlnv_chamCong extends JFrame {
	
	private sign_in_bg p;
	private JPanel contentPane;
	private JTable table_luong;
	private JTextField tx_search;
	private JLabel lblNewLabel_1;
	private JButton button_search;
	private JLabel label_id;
	private JTextField textField_id;
	private JLabel label_name;
	private JTextField textField_name;
	private JLabel label_LngTheoGio;
	private JTextField textField_luongCoBan;
	private JLabel label_soGioLam;
	private JTextField textField_soGiolam;
	private JLabel label_diMuon;
	private JTextField textField_muon;
	private JButton button_save;
	public static qlnv_model model;
	public qlnv_view view;

	/**
	 * Create the frame.
	 */
	public qlnv_chamCong() {
		
//		this.add(new Surface());
//		pack();
		
//		p = new sign_in_bg();
//		p.setBounds(0, 0, 486, 263);
		
		this.model = new qlnv_model();
		
		this.setTitle("Chấm công");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		URL urlIcon = qlnv_chamCong.class.getResource("salary.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		this.setIconImage(img);
		
		ActionListener ac = new controller_salary(this);
		
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu IMenu_File = new JMenu("File");
		menuBar.add(IMenu_File);
		
		JMenuItem JMenuItem_Open = new JMenuItem("Open");
		JMenuItem_Open.addActionListener(ac);
		JMenuItem_Open.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(qlnv_view.class.getResource("icon_open.png"))));
		JMenuItem_Open.addActionListener(ac);
		IMenu_File.add(JMenuItem_Open);
		
		JMenuItem JMenuItem_saveFile = new JMenuItem("Save File");
		JMenuItem_saveFile.addActionListener(ac);
		JMenuItem_saveFile.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(qlnv_view.class.getResource("icon_save.png"))));
		JMenuItem_saveFile.addActionListener(ac);
		IMenu_File.add(JMenuItem_saveFile);
		
		JSeparator separator = new JSeparator();
		IMenu_File.add(separator);
		
		JMenuItem JMenuItem_Logout = new JMenuItem("Exit");
		JMenuItem_Logout.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(qlnv_view.class.getResource("icon_logout.png"))));
		JMenuItem_Logout.addActionListener(ac);
		IMenu_File.add(JMenuItem_Logout);
		
		
		
		JLabel lblNewLabel = new JLabel("ID nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(145, 259, 105, 26);
		getContentPane().add(lblNewLabel);
		
		tx_search = new JTextField();
		tx_search.setBounds(269, 259, 154, 32);
		getContentPane().add(tx_search);
		tx_search.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Bảng công");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(55, 10, 118, 26);
		getContentPane().add(lblNewLabel_1);
		
		table_luong = new JTable();
		table_luong.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID nhân viên", "Họ và tên", "Lương theo giờ", "Số giờ làm", "Số phút đi muộn", "Phạt đi muộn", "Tổng lương"
			}
		));
		
		JScrollPane js = new JScrollPane(table_luong);
		js.setBounds(33, 48, 715, 182);
		getContentPane().add(js);
		
		button_search = new JButton("Tìm");
		button_search.addActionListener(ac);
		button_search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_search.setBounds(506, 259, 105, 32);
		getContentPane().add(button_search);
		
		label_id = new JLabel("ID nhân viên");
		label_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_id.setBounds(91, 326, 105, 26);
		getContentPane().add(label_id);
		
		textField_id = new JTextField();
		textField_id.setBounds(212, 326, 118, 32);
		getContentPane().add(textField_id);
		textField_id.setColumns(10);
		
		label_name = new JLabel("Họ và tên");
		label_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_name.setBounds(91, 380, 105, 26);
		getContentPane().add(label_name);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(212, 380, 118, 32);
		getContentPane().add(textField_name);
		
		label_LngTheoGio = new JLabel("Lương theo giờ");
		label_LngTheoGio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_LngTheoGio.setBounds(91, 433, 105, 26);
		getContentPane().add(label_LngTheoGio);
		
		textField_luongCoBan = new JTextField();
		textField_luongCoBan.setColumns(10);
		textField_luongCoBan.setBounds(212, 433, 118, 32);
		getContentPane().add(textField_luongCoBan);
		
		label_soGioLam = new JLabel("Số giờ làm");
		label_soGioLam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_soGioLam.setBounds(439, 326, 105, 26);
		getContentPane().add(label_soGioLam);
		
		textField_soGiolam = new JTextField();
		textField_soGiolam.setColumns(10);
		textField_soGiolam.setBounds(566, 326, 118, 32);
		getContentPane().add(textField_soGiolam);
		
		label_diMuon = new JLabel("Phút đi muộn");
		label_diMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_diMuon.setBounds(439, 380, 105, 26);
		getContentPane().add(label_diMuon);
		
		textField_muon = new JTextField();
		textField_muon.setColumns(10);
		textField_muon.setBounds(566, 380, 118, 32);
		getContentPane().add(textField_muon);
		
		button_save = new JButton("Save");
		button_save.addActionListener(ac);
		button_save.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_save.setBounds(436, 499, 94, 32);
		getContentPane().add(button_save);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(33, 475, 715, 2);
		getContentPane().add(separator2);
		
		JButton button_update = new JButton("Cập nhật");
		button_update.addActionListener(ac);
		button_update.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_update.setBounds(269, 499, 94, 32);
		getContentPane().add(button_update);
		
//		JButton button_back = new JButton("Quay lại");
//		button_back.addActionListener(ac);
//		button_back.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		button_back.setBounds(506, 499, 94, 32);
//		getContentPane().add(button_back);
		
//		this.add(new Surface());
//		pack();
		
//		this.getContentPane().add(p);
		
		this.setVisible(true);
	}

	public void xoaForm() {
		this.textField_id.setText("");
		this.textField_name.setText("");
		this.textField_luongCoBan.setText("");
		this.textField_soGiolam.setText("");
		this.textField_muon.setText("");
	}
	
	public void themNhanVienVaoBang(NhanVien nv) {
		DefaultTableModel model_table = (DefaultTableModel) table_luong.getModel();
		
		model_table.addRow(new Object[] {
				nv.getMaVanTay()+"", 
				nv.getName(), 
				nv.getLuongTheoGio()+"",
				nv.getSoGioLam()+"",
				nv.getPhutMuon()+"",
				nv.getPhat()+"",
				nv.getTongLuong()+"",
		});	
	}

	public void thucHienTim() {
		
//		this.thucHienTaiLaiDuLieu();
		
		String mVT = this.tx_search.getText();
		DefaultTableModel model_table = (DefaultTableModel) qlnv_view.table.getModel();
		int soLuongDong = model_table.getRowCount();
		Integer id = -1;
		
		if(mVT.length() > 0) {
			for (int i=0; i<soLuongDong; i++) {
				String mvt_table = model_table.getValueAt(i, 0) + "";
				if(mvt_table.equals(mVT)) {
					id = i;
					break;
				}
			}
			if(id == -1) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}else {
				this.textField_id.setText(model_table.getValueAt(id, 0) + "");
				this.textField_name.setText(model_table.getValueAt(id, 1) + "");
				this.textField_luongCoBan.setText(model_table.getValueAt(id, 6) + "");
				this.textField_soGiolam.setText("");
				this.textField_muon.setText("");
				
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Nhập Id nhân viên cần tìm!");
		}
	}
	
	
	public Integer thucHienTimId() {
		
//		this.thucHienTaiLaiDuLieu();
		
		String mVT = this.tx_search.getText();
		DefaultTableModel model_table = (DefaultTableModel) qlnv_view.table.getModel();
		int soLuongDong = model_table.getRowCount();
		Integer id = -1;
		
		if(mVT.length() > 0) {
			for (int i=0; i<soLuongDong; i++) {
				String mvt_table = model_table.getValueAt(i, 0) + "";
				if(mvt_table.equals(mVT)) {
					id = i;
					break;
				}
			}
		}	
		return id;
	}

	private NhanVien getNhanVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table_luong.getModel();
		int i_row = table_luong.getSelectedRow();
		model_table.getValueAt(i_row, 0);
		
		int maVT = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String name = model_table.getValueAt(i_row, 1)+"";
		
		double luongTheoGio = Double.valueOf(model_table.getValueAt(i_row, 2)+"");
		
		int soGioLam = Integer.parseInt(model_table.getValueAt(i_row, 3) + "");
		
		int phutMuon = Integer.parseInt(model_table.getValueAt(i_row, 4) + "");
		
		double phat = Double.parseDouble(model_table.getValueAt(i_row, 5) + "");
		
		double salary = Double.parseDouble(model_table.getValueAt(i_row, 6) + "");
		
		NhanVien nv = new NhanVien(maVT, name, null, null, rootPaneCheckingEnabled, "", luongTheoGio, soGioLam, phutMuon, phat, salary);
		
		return nv;
	}
	
	public void thucHienUpdate() {
		NhanVien nv = this.getNhanVienDangChon();
		
		this.textField_id.setText(nv.getMaVanTay() + "");
		this.textField_name.setText(nv.getName() + "");
		this.textField_luongCoBan.setText(nv.getLuongTheoGio() + "");
		this.textField_soGiolam.setText(nv.getSoGioLam() + "");
		this.textField_muon.setText(nv.getPhutMuon() + "");
		
	}
	
	
	public void thucHienTaiLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table_luong.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong == 0) {
				break;
			}
			else {
				try {
					model_table.removeRow(0);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		for (NhanVien nv : this.model.getSalary()) {
			this.themNhanVienVaoBang(nv);
		}
	}

	
	public void themOrCapNhatNhanVien(NhanVien nv) {
		DefaultTableModel model_table = (DefaultTableModel) this.table_luong.getModel();
		
		if(!this.model.kiemTraTonTai_salary(nv)) {
			this.model.insert_salary(nv);
			this.themNhanVienVaoBang(nv);
		}else {
//			int choice = JOptionPane.showConfirmDialog(this, "Id đã tồn tại. Bạn có muốn cập nhật thông tin cho nhân viên không?", "Thông báo", JOptionPane.YES_NO_OPTION);
			this.model.update_salary(nv);
			int soLuongDong = model_table.getRowCount();
			for(int i=0; i<soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if(id.equals(nv.getMaVanTay() + "")) {
					model_table.setValueAt(nv.getMaVanTay() + "", i, 0);
					model_table.setValueAt(nv.getName() + "", i, 1);
					model_table.setValueAt(nv.getLuongTheoGio() + "", i, 2);

					model_table.setValueAt(nv.getSoGioLam() + "", i, 3);
					model_table.setValueAt(nv.getPhutMuon() + "", i, 4);
					model_table.setValueAt(nv.getPhat() + "", i, 5);
					model_table.setValueAt(nv.getTongLuong() + "", i, 6);
				}
			}
		}
	}
	
	
	public void luu() {
		DefaultTableModel model_table = (DefaultTableModel) qlnv_view.table.getModel();
		int i_row = thucHienTimId();
		
		int maVT = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String name = model_table.getValueAt(i_row, 1)+"";
		int queQuan = qlnv_view.comboBox_qq.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		
		Date ngaySinh = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			ngaySinh = simpleDate.parse(model_table.getValueAt(i_row, 3) + "");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		Boolean gioiTinh = textGioiTinh.equals("Nam");
		
		String ChucVu = model_table.getValueAt(i_row, 5)+"";
		double luongTheoGio = Double.valueOf(model_table.getValueAt(i_row, 6)+"");
		
		int soGioLam = Integer.valueOf(this.textField_soGiolam.getText());
		int phutMuon = Integer.valueOf(this.textField_muon.getText());
		double phat = Double.valueOf(phutMuon * 5000);
		double tongLuong = (luongTheoGio * soGioLam) - phat;
		
		
		NhanVien nv = new NhanVien(maVT, name, ngaySinh, tinh, rootPaneCheckingEnabled, ChucVu, luongTheoGio, soGioLam, phutMuon, phat, tongLuong);
		
		
		this.themOrCapNhatNhanVien(nv);
		
	}

//	public void Back() {
//		this.setVisible(false);
//	}

	
	public void saveFile(String path) {
		try {
			this.model.setTenFile2(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (NhanVien nv : this.model.getSalary()) {
				oos.writeObject(nv);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile2().length()>0) {
			saveFile(this.model.getTenFile2());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	public void openFile(File file) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		try {
			this.model.setTenFile2(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			NhanVien nv = null;
			while((nv = (NhanVien) ois.readObject())!=null) {
				ds.add(nv);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setSalary(ds);
	}
	
	public void thucHienOpen() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}
	
	
	
//	public void thucHienOpen() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void thucHienSaveFile() {
//		// TODO Auto-generated method stub
//		
//	}

	public void thoatChuongTrinh() {
		this.setVisible(false);
	}

//	public void Back() {
//		
//		try {
//			this.setVisible(false);
////			new qlnv_view();
//			
////			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
//			
//			try {
//				for (NhanVien nhanVien : qlnv_view.model.dsnv) {
////				ds.add(nhanVien);
//					this.themNhanVienVaoBang(nhanVien);
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
}
