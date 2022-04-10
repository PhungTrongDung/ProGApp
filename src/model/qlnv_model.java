package model;

import java.util.ArrayList;

public class qlnv_model {
	public static ArrayList<NhanVien> dsnv;
	public static ArrayList<NhanVien> salary;
	private String choice;
	private String tenFile;
	private String tenFile2;
	
	public qlnv_model() {
		this.dsnv = new ArrayList<NhanVien>();
		this.salary = new ArrayList<NhanVien>();
		this.choice = "";
		this.tenFile = "";
		this.tenFile2 = "";
	}
	public static ArrayList<NhanVien> getSalary() {
		return salary;
	}
	public void setSalary(ArrayList<NhanVien> salary) {
		this.salary = salary;
	}
	
	
	public ArrayList<NhanVien> getDsnv() {
		return dsnv;
	}
	public void setDsnv(ArrayList<NhanVien> dsnv) {
		this.dsnv = dsnv;
	}
	
	
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	
	public String getTenFile() {
		return tenFile;
	}
	
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
	public String getTenFile2() {
		return tenFile2;
	}
	public void setTenFile2(String tenFile2) {
		this.tenFile2 = tenFile2;
	}
	public void insert(NhanVien nv) {
		dsnv.add(nv);
	}
	
	public void delete(NhanVien nv) {
		dsnv.remove(nv);
	}
	
	public void update(NhanVien nv) {
		dsnv.remove(nv);
		dsnv.add(nv);
	}
	
	public void insert_salary(NhanVien nv) {
		salary.add(nv);
	}
	
	public void delete_salary(NhanVien nv) {
		salary.remove(nv);
	}
	
	public void update_salary(NhanVien nv) {
		salary.remove(nv);
		salary.add(nv);
	}
	
	public boolean kiemTraTonTai(NhanVien nv) {
		for (NhanVien nhanVien : dsnv) {
			if(nhanVien.getMaVanTay() == nv.getMaVanTay()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean kiemTraTonTai_salary(NhanVien nv) {
		for (NhanVien nhanVien : salary) {
			if(nhanVien.getMaVanTay() == nv.getMaVanTay()) {
				return true;
			}
		}
		return false;
	}
	
}
