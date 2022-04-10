package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.qlnv_view;

public class qlnv_controller implements ActionListener {
	private qlnv_view view;
	
	public qlnv_controller(qlnv_view view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		try {
			if(src.equals("Thêm")) {
				try {
					this.view.thucHienThem();
//					System.out.println(this.view.model.getDsnv().size());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				this.view.xoaForm();
			}
			else if(src.equals("Xóa")) {
				this.view.thucHienXoa();
			}
			else if(src.equals("Cập nhật")) {
				this.view.thucHienCapNhat();
			}
			else if(src.equals("Save")) {
				try {
					this.view.thucHienThem();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			else if(src.equals("Cancel")) {
				this.view.xoaForm();
			}
			else if(src.equals("Open")) {
				this.view.thucHienOpen();
			}
			else if(src.equals("Save File")) {
				this.view.thucHienSaveFile();
			}
			else if(src.equals("Log out")) {
				view.thoatChuongTrinh();
			}else if(src.equals("About me")) {
				this.view.hienThiAbout();
			}
			else if(src.equals("Tìm")) {
				this.view.thucHienTim();
			}
			else if(src.equals("Hủy tìm")) {
				this.view.thucHienTaiLaiDuLieu();
			}
			else if(src.equals("Tính lương")) {
				this.view.hienThiForm();
			}
//			else if(src.equals("Profile")) {
//				this.view.showProfile();
//			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	
}
