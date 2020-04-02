package Testdatas;

public class Contact {

	private String hoTen;
	private String email;
	private String dienThoai;
	private String mucDich;
	private String message;
	
	
	public Contact(String hoTen, String email, String dienThoai, String mucDich, String message) {
		super();
		this.hoTen = hoTen;
		this.email = email;
		this.dienThoai = dienThoai;
		this.mucDich = mucDich;
		this.message = message;
	}

	public Contact() {
		super();
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getMucDich() {
		return mucDich;
	}

	public void setMucDich(String mucDich) {
		this.mucDich = mucDich;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
