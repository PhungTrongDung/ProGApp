package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.qlnv_controller;
import model.NhanVien;
import model.NhanVien;
import model.Tinh;
import model.qlnv_model;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;



class panel3 extends JPanel {
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon img = new ImageIcon("D:\\Eclipse\\File_Java\\ProGApp\\src\\view\\backUI.jpg");
		g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}

class panel_pro extends JPanel {
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon img = new ImageIcon("D:\\Eclipse\\File_Java\\ProGApp\\src\\view\\logo Pro_2.png");
		g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}

public class qlnv_view extends JFrame {
	private panel3 p;
	private panel_pro pro;
	public static qlnv_model model;
	private JPanel contentPane;
	private JTextField textField_search;
	public static JTable table;
	private JTextField textField_mvt;
	private JTextField textField_name;
	private JTextField textField_ngaySinh;
	private JTextField textField_viTri;
	private JTextField textField_luongTheoGio;
	public static JComboBox comboBox_qq;
	private JRadioButton rdb_nam;
	private JRadioButton rdb_nu;
	private ButtonGroup gt_group;
	private JButton button_huyTim;
	private JButton button_tim;
	private Sign_in si;

	public qlnv_view() {
		p = new panel3();
		p.setBounds(0, 0, 1031, 591);
		
		pro = new panel_pro();
		pro.setLocation(25, 29);
		pro.setSize(219, 208);
		
		this.model = new qlnv_model();
		this.si = new Sign_in();
		
		this.setTitle("QLNV");
		this.setSize(1045, 650);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		URL urlIcon = qlnv_view.class.getResource("icon_book.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		this.setIconImage(img);
		
		Font font = new Font("Tahoma", Font.BOLD, 14);

		
		// Khai báo controller cho các đối tượng
		ActionListener ac = new qlnv_controller(this);
		
		
		// Tạo thanh Menu cho chương trình 
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
		
		JMenuItem JMenuItem_Logout = new JMenuItem("Log out");
		JMenuItem_Logout.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(qlnv_view.class.getResource("icon_logout.png"))));
		JMenuItem_Logout.addActionListener(ac);
		IMenu_File.add(JMenuItem_Logout);
		
		JMenu JMenu_About = new JMenu("About");
		menuBar.add(JMenu_About);
		
		JMenuItem JMenuItem_About_me = new JMenuItem("About me");
		JMenuItem_About_me.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(qlnv_view.class.getResource("icon_about.png"))));		
		JMenuItem_About_me.addActionListener(ac);
		JMenu_About.add(JMenuItem_About_me);
		getContentPane().setLayout(null);
		
		
		// Tạo khu vực tìm kiếm dữ liệu
		JLabel label_mvt_search = new JLabel("ID nhân viên");
		label_mvt_search.setBounds(320, 29, 108, 21);
		label_mvt_search.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(label_mvt_search);
		
		textField_search = new JTextField();
		textField_search.setBounds(450, 25, 128, 33);
		getContentPane().add(textField_search);
		textField_search.setColumns(10);
		
		
		// 2 button điều khiển khu vực tìm kiếm dữ liệu
		button_tim = new JButton("Tìm");
		button_tim.setBounds(752, 23, 98, 33);
		button_tim.addActionListener(ac);
		button_tim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(button_tim);
		
		button_huyTim = new JButton("Hủy tìm");
		button_huyTim.setBounds(874, 23, 108, 33);
		button_huyTim.addActionListener(ac);
		button_huyTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(button_huyTim);
		
		
		// ngăn cách khu vực tìm kiếm và bảng dữ liệu bên dưới
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(272, 74, 733, 2);
		getContentPane().add(separator_1);
		
		// Khu vực hiển thị dữ liệu
		JLabel label_dsnv = new JLabel("Danh sách nhân viên");
		label_dsnv.setBounds(281, 86, 219, 25);
		label_dsnv.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(label_dsnv);
		
		
			// Tạo bảng dữ liệu trong khu vực hiển thị
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID nhân viên", "Họ và tên", "Quê quán", "Ngày sinh", "Giới tính", "Vị trí", "Lương theo giờ"
			}
		));
		
//		table.setFont(font);
			// Cho phép bảng tự sắp xếp
//		table.setAutoCreateRowSorter(true);
		
		
			// Tạo thanh cuộn và đưa bảng đã tạo vào thanh cuộn
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(271, 121, 734, 190);
		getContentPane().add(scrollPane);
		
		
		// Ngăn cách khu vực
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(272, 332, 733, 2);
		getContentPane().add(separator_2);
		
		
		// Tạo khu vực nhập dữ liệu
		JLabel label_thongTin = new JLabel("Thông tin");
		label_thongTin.setBounds(281, 344, 98, 25);
		label_thongTin.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(label_thongTin);
		
		JLabel lblIdNhnVin = new JLabel("ID");
		lblIdNhnVin.setBounds(271, 396, 92, 21);
		lblIdNhnVin.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblIdNhnVin);
		
		textField_mvt = new JTextField();
		textField_mvt.setBounds(373, 396, 96, 19);
		getContentPane().add(textField_mvt);
		textField_mvt.setColumns(10);
		
		JLabel label_name = new JLabel("Họ và Tên");
		label_name.setBounds(271, 425, 92, 21);
		label_name.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(label_name);
		
		textField_name = new JTextField();
		textField_name.setBounds(373, 425, 96, 19);
		textField_name.setColumns(10);
		getContentPane().add(textField_name);
		
		JLabel label_date = new JLabel("Ngày sinh");
		label_date.setBounds(271, 455, 92, 19);
		label_date.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(label_date);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setBounds(373, 454, 96, 19);
		textField_ngaySinh.setColumns(10);
		getContentPane().add(textField_ngaySinh);
		
		JLabel label_position = new JLabel("Vị trí");
		label_position.setBounds(517, 454, 85, 21);
		label_position.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(label_position);
		
		textField_viTri = new JTextField();
		textField_viTri.setBounds(619, 457, 96, 19);
		textField_viTri.setColumns(10);
		getContentPane().add(textField_viTri);
		
		JLabel label_luongTheoGio = new JLabel("Lương theo giờ");
		label_luongTheoGio.setBounds(774, 396, 124, 21);
		label_luongTheoGio.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(label_luongTheoGio);
		
		textField_luongTheoGio = new JTextField();
		textField_luongTheoGio.setBounds(908, 399, 96, 19);
		textField_luongTheoGio.setColumns(10);
		getContentPane().add(textField_luongTheoGio);
		
		JLabel label_hometown = new JLabel("Quê quán");
		label_hometown.setBounds(517, 423, 92, 25);
		label_hometown.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(label_hometown);
		
		comboBox_qq = new JComboBox();
		comboBox_qq.setBounds(619, 428, 96, 19);
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_qq.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_qq.addItem(tinh.getTenTinh());
		}
		getContentPane().add(comboBox_qq);
		
		JLabel label_sex = new JLabel("Giới Tính");
		label_sex.setBounds(517, 396, 75, 21);
		label_sex.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(label_sex);
		
		rdb_nam = new JRadioButton("Nam");
		rdb_nam.setBounds(598, 396, 66, 21);
		rdb_nam.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(rdb_nam);
		
		rdb_nu = new JRadioButton("Nữ");
		rdb_nu.setBounds(666, 396, 66, 21);
		rdb_nu.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(rdb_nu);
		
		gt_group = new ButtonGroup();
		gt_group.add(rdb_nam);
		gt_group.add(rdb_nu);
		
		
		// Ngăn cách khu vực 
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(258, 512, 747, 2);
		getContentPane().add(separator_3);
		
		
		// Các button điều khiển chương trình
		JButton button_them = new JButton("Thêm");
		button_them.setBounds(320, 536, 85, 21);
		button_them.addActionListener(ac);
		button_them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(button_them);
		
		JButton button_xoa = new JButton("Xóa");
		button_xoa.setBounds(451, 536, 85, 21);
		button_xoa.addActionListener(ac);
		button_xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(button_xoa);
		
		JButton button_cap_nhat = new JButton("Cập nhật");
		button_cap_nhat.setBounds(582, 536, 98, 21);
		button_cap_nhat.addActionListener(ac);
		button_cap_nhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(button_cap_nhat);
		
		JButton button_save = new JButton("Save");
		button_save.setBounds(735, 536, 85, 21);
		button_save.addActionListener(ac);
		button_save.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(button_save);
		
		JButton button_cancel = new JButton("Cancel");
		button_cancel.setBounds(874, 536, 85, 21);
		button_cancel.addActionListener(ac);
		button_cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(button_cancel);
		
		JButton button_luong = new JButton("Tính lương");
		button_luong.setBounds(834, 455, 108, 33);
		button_luong.addActionListener(ac);
		button_luong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(button_luong);
		
//		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setBounds(33, 29, 196, 190);
//		getContentPane().add(lblNewLabel_1);
		
		JLabel lb_show_name = new JLabel();
		lb_show_name.setText(si.getNguoiDung().getName());
		lb_show_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_show_name.setBounds(33, 323, 196, 33);
		getContentPane().add(lb_show_name);
		
		JLabel lb_show_email = new JLabel();
		lb_show_email.setText(si.getNguoiDung().getEmail());
		lb_show_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_show_email.setBounds(33, 382, 196, 33);
		getContentPane().add(lb_show_email);
		
		JLabel lb_show_sdt = new JLabel();
		lb_show_sdt.setText(si.getNguoiDung().getSdt());
		lb_show_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_show_sdt.setBounds(33, 441, 196, 33);
		getContentPane().add(lb_show_sdt);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 262, 85, 38);
		getContentPane().add(lblNewLabel);
		
		this.getContentPane().add(pro);
		this.getContentPane().add(p);
		this.setVisible(true);
	}

	public void thoatChuongTrinh() {
		int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất?", "Log out", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			this.setVisible(false);
			Sign_in si = new Sign_in();
			si.setVisible(true);
		}
	}
	
	public void xoaForm() {
		this.textField_mvt.setText("");
		this.textField_name.setText("");
		this.textField_ngaySinh.setText("");
		this.comboBox_qq.setSelectedIndex(-1);
		this.textField_viTri.setText("");
		this.textField_luongTheoGio.setText("");
		this.gt_group.clearSelection();
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mền quản lí nhân viên WhileD - ProPTIT");
	}

	public void themNhanVienVaoBang(NhanVien nv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		String ngaySinh = simpleDate.format(nv.getNgaySinh());
		
		model_table.addRow(new Object[] {
				nv.getMaVanTay()+"", 
				nv.getName(), 
				nv.getQueQuan().getTenTinh(),
				ngaySinh,
				(nv.isGioiTinh()?"Nam":"Nữ"),
				nv.getChucVu()+"",
				nv.getLuongTheoGio()+"",
		});
	}
	
	public void themOrCapNhatNhanVien(NhanVien nv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(nv)) {
			this.model.insert(nv);
			this.themNhanVienVaoBang(nv);;
		}else {
			
			int choice = JOptionPane.showConfirmDialog(this, "Id đã tồn tại. Bạn có muốn cập nhật thông tin cho nhân viên không?", "Thông báo", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION) {
				this.model.update(nv);
				int soLuongDong = model_table.getRowCount();
				for(int i=0; i<soLuongDong; i++) {
					String id = model_table.getValueAt(i, 0)+"";
					if(id.equals(nv.getMaVanTay()+"")) {
						model_table.setValueAt(nv.getMaVanTay()+"", i, 0);
						model_table.setValueAt(nv.getName()+"", i, 1);
						model_table.setValueAt(nv.getQueQuan().getTenTinh()+"", i, 2);
						
						SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
						model_table.setValueAt(simpleDate.format(nv.getNgaySinh()), i, 3);
						
						model_table.setValueAt((nv.isGioiTinh()?"Nam":"Nữ"),i, 4);
						model_table.setValueAt(nv.getChucVu()+"", i, 5);
						model_table.setValueAt(nv.getLuongTheoGio()+"", i, 6);
					}
				}
			}
		}
	}
	
	public void thucHienThem() {
		int maVT = Integer.valueOf(this.textField_mvt.getText());
		String name = this.textField_name.getText();
		int queQuan = this.comboBox_qq.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			ngaySinh = simpleDate.parse(this.textField_ngaySinh.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Boolean gioiTinh = true;
		if(this.rdb_nam.isSelected()) {
			gioiTinh = true;
		}
		else {
			gioiTinh = false;
		}
		String ChucVu = this.textField_viTri.getText();
		double luongTheoGio = Double.valueOf(this.textField_luongTheoGio.getText());
		
		NhanVien nv = new NhanVien(maVT, name, ngaySinh, tinh, gioiTinh, ChucVu, luongTheoGio, 0, 0, 0, 0);
		
		this.themOrCapNhatNhanVien(nv);
		
	}
	
	
	private NhanVien getNhanVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		model_table.getValueAt(i_row, 0);
		
		int maVT = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String name = model_table.getValueAt(i_row, 1)+"";
		int queQuan = this.comboBox_qq.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		
		Date ngaySinh = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			ngaySinh = simpleDate.parse(model_table.getValueAt(i_row, 3) + "");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
//		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
//		Date ngaySinh = new Date(s_ngaySinh);
		
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		Boolean gioiTinh = textGioiTinh.equals("Nam");
		
		String ChucVu = model_table.getValueAt(i_row, 5)+"";
		double luongTheoGio = Double.valueOf(model_table.getValueAt(i_row, 6)+"");
		
		NhanVien nv = new NhanVien(maVT, name, ngaySinh, tinh, gioiTinh, ChucVu, luongTheoGio, 0, 0, 0, 0);
		
		return nv;
	}
	
	public void thucHienCapNhat() {
		NhanVien nv = this.getNhanVienDangChon();
		
		this.textField_mvt.setText(nv.getMaVanTay() + "");
		this.textField_name.setText(nv.getName() + "");
		this.comboBox_qq.setSelectedItem(nv.getQueQuan().getTenTinh());
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		String ngaySinh = simpleDate.format(nv.getNgaySinh());
		
//		String ngaySinh = nv.getNgaySinh().toString();
		
		this.textField_ngaySinh.setText(ngaySinh + "");
		
		if(nv.isGioiTinh()) {
			rdb_nam.setSelected(true);
		}
		else {
			rdb_nu.setSelected(true);
		}
		
		this.textField_viTri.setText(nv.getChucVu()+"");
		this.textField_luongTheoGio.setText(nv.getLuongTheoGio() + "");
		
	}
	
	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = -1;
		i_row = table.getSelectedRow();
		if(i_row == -1) {
			JOptionPane.showMessageDialog(this, "Chọn nhân viên cần xóa!");
		}
		else {
			int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?");
			if(choice == JOptionPane.YES_OPTION) {
				NhanVien nv = getNhanVienDangChon();
				this.model.delete(nv);
				model_table.removeRow(i_row);
			}
		}
	}
	
//	 xử lí file 
//	private void saveFile(String path) {
//		try {
//			this.model.setTenFile(path);
//			FileOutputStream fos = new FileOutputStream(path);
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			for (NhanVien sv : this.model.getDsnv()) {
//				oos.writeObject(sv);
//			}
//			oos.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		
////		try {
////			FileWriter fw = new FileWriter("data.txt", StandardCharsets.UTF_8);
////			BufferedWriter bw = new BufferedWriter(fw);
////			
//////			FileOutputStream fo = new FileOutputStream("nhanvien.txt");
//////			ObjectOutputStream oos = new ObjectOutputStream(fo);
////			
////			for (NhanVien nhanVien : this.model.getDsnv()) {
////				bw.write(nhanVien.toString());
////				bw.newLine();
//////				oos.writeObject(nhanVien);
////			}
////			
////			bw.close();
////			fw.close();
////			
//////			oos.close();
//////			fo.close();
////			
////		}catch(Exception e) {
////			e.printStackTrace();
////		}
//		
//	}
	
//	private void openFile(File file) {
//		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
//		try {
//			this.model.setTenFile(file.getAbsolutePath());
//			FileInputStream fis = new FileInputStream(file);
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			NhanVien sv = null;
//			while((sv = (NhanVien) ois.readObject()) != null ) {
//				ds.add(sv); 
//			}
//			ois.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		this.model.setDsnv(ds);
//	}
	
//	public void thucHienOpen() {
//		
//		while(true) {
//			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
//			int soLuongDong = model_table.getRowCount();
//			if(soLuongDong == 0) {
//				break;
//			}
//			else {
//				try {
//					model_table.removeRow(0);
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		ArrayList<NhanVien> nv = new ArrayList<>();
//		
//		try {
//			FileReader fr = new FileReader("data.txt");
//			BufferedReader br = new BufferedReader(fr);
//			String line = "";
//			
//			while(true) {
//				line = br.readLine();
//				if(line == null) {
//					break;
//				}
//				String sLine[] = line.split(";");
//				
//				int maVT = Integer.parseInt(sLine[0]+ "");
//				String name = sLine[1] + "";
//				
//				Boolean gioiTinh = Boolean.parseBoolean(sLine[2] + "");
//				
//				Date ngaySinh = new Date();
//				SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
//				try {
//					ngaySinh = simpleDate.parse(sLine[3] + "");
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				
//				String queQuan = sLine[4] + "";
//				Tinh tinh = Tinh.getTinhByTen(queQuan);
//				
//				String ChucVu = sLine[5] + "";
//				double luongTheoGio = Double.valueOf(sLine[6] + "");
//				
//				
//				nv.add(new NhanVien(maVT, name, ngaySinh, tinh, gioiTinh, ChucVu, luongTheoGio, 0, 0, 0, 0));
//				
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		for (NhanVien nhanvien : nv) {
//			this.themNhanVienVaoBang(nhanvien);
//		}
		
		
//		JFileChooser fc = new JFileChooser();
//		int returnVal = fc.showSaveDialog(this);
//		if (returnVal == JFileChooser.APPROVE_OPTION) {
//			File file = fc.getSelectedFile();
////			openFile(file);
//			thucHienTaiLaiDuLieu();
//		} 
//		
//	}

//	public void thucHienSaveFile() {
//		
//		ArrayList<NhanVien> nv = this.model.getDsnv();
//		try {
//			FileWriter fw = new FileWriter("data.txt", StandardCharsets.UTF_8);
//			BufferedWriter bw = new BufferedWriter(fw);
//			
////			FileOutputStream fo = new FileOutputStream("nhanvien.txt");
////			ObjectOutputStream oos = new ObjectOutputStream(fo);
//			
//			for (NhanVien nhanVien : nv) {
//				bw.write(nhanVien.toString());
//				bw.newLine();
////				oos.writeObject(nhanVien);
//			}
//			
//			bw.close();
//			fw.close();
//			
////			oos.close();
////			fo.close();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		
////		if(this.model.getTenFile().length() > 0) {
////			  saveFile(this.model.getTenFile()); 
////		}else {
////			JFileChooser fc = new JFileChooser();
////			int returnVal = fc.showSaveDialog(this);
////			if (returnVal == JFileChooser.APPROVE_OPTION) {
////				File file = fc.getSelectedFile();
//////				saveFile(file.getAbsolutePath());
////				thucHienTaiLaiDuLieu();
////			}
////		}
//	}

	
	
	
	public void thucHienTaiLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
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
		for (NhanVien nv : this.model.getDsnv()) {
			this.themNhanVienVaoBang(nv);
		}
	}

	public void thucHienTim() {
		
		this.thucHienTaiLaiDuLieu();
		
		String x = this.textField_search.getText();
		int mVT = Integer.parseInt(x);
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> cacMVTCanXoa = new TreeSet<Integer>();
		
		if(x.length() > 0) {
			for (int i=0; i<soLuongDong; i++) {
				String a = model_table.getValueAt(i, 0) + "";
				int mvt_table = Integer.parseInt(a);
				if(mvt_table != mVT) {
					cacMVTCanXoa.add(mvt_table);
				}
			}
			if(cacMVTCanXoa.size() == soLuongDong) {
				for (int i=0; i<soLuongDong; i++) {
					model_table.removeRow(i);
				}
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}else {
				for (Integer mvt : cacMVTCanXoa) {
					for (int i=0; i<soLuongDong; i++) {
						String mvt_table = model_table.getValueAt(i, 0) + "";
						if(mvt_table.equals(mvt.toString())) {
							try {
								model_table.removeRow(i);
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Nhập ID cần tìm!");
		}
	}

	public void hienThiForm() {
//		this.setVisible(false);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new qlnv_chamCong();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (NhanVien nv : this.model.getDsnv()) {
				oos.writeObject(nv);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
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
			this.model.setTenFile(file.getAbsolutePath());
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
		this.model.setDsnv(ds);
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

}
