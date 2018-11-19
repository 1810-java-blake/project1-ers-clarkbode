package com.revature.model;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int reimb_id;
	private double reimb_amount;
	private Timestamp reimb_submitted;
	private Timestamp reimb_resolved;
	private String reimb_description;
	private String reimb_receipt;
	private int reimb_author;
	private int reimb_resolver;
	private int reimb_status_id;
	private int reimb_type_id;
	private String reimb_status;
	private String reimb_type;
	private String user_first_name;
	private String user_last_name;
	
	
	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursement(int reimb_id, double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, String reimb_receipt, int reimb_author, int reimb_resolver, int reimb_status_id,
			int reimb_type_id, String reimb_status, String reimb_type, String user_first_name, String user_last_name) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
	}
	
	public String getReimb_type() {
		return reimb_type;
	}
	
	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}
	
	public String getReimb_status() {
		return reimb_status;
	}
	
	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}
	
	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	public double getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	public String getReimb_receipt() {
		return reimb_receipt;
	}
	public void setReimb_receipt(String reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}
	public int getReimb_author() {
		return reimb_author;
	}
	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}
	public int getReimb_resolver() {
		return reimb_resolver;
	}
	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}
	public int getReimb_status_id() {
		return reimb_status_id;
	}
	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}
	public int getReimb_type_id() {
		return reimb_type_id;
	}
	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}


	public String getUser_first_name() {
		return user_first_name;
	}


	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}


	public String getUser_last_name() {
		return user_last_name;
	}


	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	
	
	

}
