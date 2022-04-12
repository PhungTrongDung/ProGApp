package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.qlnv_chamCong;

public class controller_salary implements ActionListener {

	private qlnv_chamCong salary;
		
	public controller_salary(qlnv_chamCong salary) {
		super();
		this.salary = salary;
	}

	public qlnv_chamCong getSalary() {
		return salary;
	}

	public void setSalary(qlnv_chamCong salary) {
		this.salary = salary;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Tìm")) {
			this.salary.thucHienTim();
		}else if(src.equals("Cập nhật")) {
			this.salary.thucHienUpdate();
		}else if(src.equals("Save")) {
			this.salary.thucHienThem();
		}
		else if(src.equals("Thêm")) {
			this.salary.luu();
			this.salary.xoaForm();
		}
		else if(src.equals("Open")) {
			this.salary.thucHienOpen();
		}
		else if(src.equals("Save File")) {
			this.salary.thucHienSaveFile();
		}
		else if(src.equals("Exit")) {
			salary.thoatChuongTrinh();
		}
	}	
}
