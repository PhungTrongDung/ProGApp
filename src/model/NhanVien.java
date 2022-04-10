package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.swing.JButton;

public class NhanVien implements Serializable{
	private int maVanTay;
	private String name;
	private Date ngaySinh;
	private Tinh queQuan;
	private boolean gioiTinh;
	private String chucVu;
	public double luongTheoGio;
	public int soGioLam;
	public int phutMuon;
	public double phat;
	public double tongLuong;
	
	//	public NhanVien() {}

	public NhanVien(int maVanTay, String name, Date ngaySinh, Tinh queQuan, boolean gioiTinh, String chucVu,
			double luongTheoGio, int soGioLam, int phutMuon, double phat, double tongLuong) {
		super();
		this.maVanTay = maVanTay;
		this.name = name;
		this.ngaySinh = ngaySinh;
		this.queQuan = queQuan;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.luongTheoGio = luongTheoGio;
		this.soGioLam = soGioLam;
		this.phutMuon = phutMuon;
		this.phat = phat;
		this.tongLuong = tongLuong;
	}

	public int getMaVanTay() {
		return maVanTay;
	}
	
	public void setMaVanTay(int maVanTay) {
		this.maVanTay = maVanTay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public Tinh getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(Tinh queQuan) {
		this.queQuan = queQuan;
	}
	
	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public double getLuongTheoGio() {
		return luongTheoGio;
	}

	public void setLuongTheoGio(double luongTheoGio) {
		this.luongTheoGio = luongTheoGio;
	}

	public int getSoGioLam() {
		return soGioLam;
	}

	public void setSoGioLam(int soGioLam) {
		this.soGioLam = soGioLam;
	}

	public int getPhutMuon() {
		return phutMuon;
	}

	public void setPhutMuon(int phutMuon) {
		this.phutMuon = phutMuon;
	}

	public double getPhat() {
		return phat;
	}

	public void setPhat(double phat) {
		this.phat = phat;
	}

	public double getTongLuong() {
		return tongLuong;
	}

	public void setTongLuong(double tongLuong) {
		this.tongLuong = tongLuong;
	}

	@Override
	public String toString() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		String NgaySinh = simpleDate.format(this.ngaySinh);
		return this.maVanTay + ";" + this.name + ";" + this.gioiTinh + ";" + NgaySinh + ";" + this.queQuan + ";" + this.chucVu + ";" + this.luongTheoGio;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(chucVu, other.chucVu)
				&& Double.doubleToLongBits(luongTheoGio) == Double.doubleToLongBits(other.luongTheoGio)
				&& maVanTay == other.maVanTay && Objects.equals(name, other.name)
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(queQuan, other.queQuan);
	}
	
}
