package com.ne.neflex.vo;
import java.sql.*;

public class MemberVo {
	private int mem_no;
    private String mem_id;
    private String mem_pw;
    private String mem_name;
    private String mem_nick;
    private String mem_phone;
    private String mem_email;
    private String mem_gender;
    private Date mem_birthdate;
    private Date mem_joindate;
    private String mem_imageurl;
	
    public MemberVo() {
		super();
	}

	public MemberVo(int mem_no, String mem_id, String mem_pw, String mem_name, String mem_nick, String mem_phone,
			String mem_email, String mem_gender, Date mem_birthdate, Date mem_joindate, String mem_imageurl) {
		super();
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_nick = mem_nick;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
		this.mem_gender = mem_gender;
		this.mem_birthdate = mem_birthdate;
		this.mem_joindate = mem_joindate;
		this.mem_imageurl = mem_imageurl;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_gender() {
		return mem_gender;
	}

	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}

	public Date getMem_birthdate() {
		return mem_birthdate;
	}

	public void setMem_birthdate(Date mem_birthdate) {
		this.mem_birthdate = mem_birthdate;
	}

	public Date getMem_joindate() {
		return mem_joindate;
	}

	public void setMem_joindate(Date mem_joindate) {
		this.mem_joindate = mem_joindate;
	}

	public String getMem_imageurl() {
		return mem_imageurl;
	}

	public void setMem_imageurl(String mem_imageurl) {
		this.mem_imageurl = mem_imageurl;
	}
    
}
