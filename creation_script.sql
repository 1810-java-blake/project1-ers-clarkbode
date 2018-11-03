SET SCHEMA 'project-1';

CREATE TABLE ers_reimbursement(
	reimb_id number,
	reimb_amount number,
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_description varchar2(250),
	reimb_receipt blob,
	reimb_author number,
	reimb_resolver number,
	reimb_status_id number,
	reimb_type_id number,
	
	PRIMARY KEY (reimb_id),
	FOREIGN KEY(reimb_author) REFERENCES ers_users(ers_username),
	FOREIGN KEY(reimb_resolver) REFERENCES ers_users (ers_users_id),
	FOREIGN KEY(reimb_status_id) REFERENCES ers_reimbursement_status (reimb_status_id),
	FOREIGN KEY(reimb_type_id) REFERENCES ers_reimbursement_type (reimb_type_id)

);

CREATE TABLE ers_users(
	ers_users_id number,
	ers_username varchar2(50) UNIQUE,
	ers_password varchar2(50),
	user_first_name varchar2(100),
	user_last_name varchar2(100),
	user_email varchar2(150) UNIQUE,
	user_role_id number,
	
	PRIMARY KEY (ers_users_id),
	FOREIGN KEY (user_role_id) REFERENCES ers_user_roles (ers_user_role_id)
);

CREATE TABLE ers_reimbursement_status(
	reimb_status_id number,
	reimb_status varchar2(10),
	
	PRIMARY KEY (reimb_status_id)
);

CREATE TABLE ers_reimbursement_type(
	reimb_type_id number,
	reimb_type varchar2(10),
	
	PRIMARY KEY (reimb_type_id)
);

CREATE TABLE ers_user_roles(
	ers_user_role_id number,
	user_role varchar2(10),
	
	PRIMARY KEY (ers_user_role_id)
);