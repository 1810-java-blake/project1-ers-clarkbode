package com.revature.daos;

import java.sql.Timestamp;
import java.util.List;

import com.revature.model.Reimbursement;
import com.revature.model.User;

public interface ReimbursementDao {
	public static final  ReimbursementDao currentImplementation = new ReimbursementJdbc();
	
	int addReimbursement(Reimbursement newReimb);
	
	void resolveReimbursement(int reimbId, int userId, int newStatusId, Timestamp resolved);
	
	List<Reimbursement> findAll();
	List<Reimbursement> findAllByStatus(int status);

	Reimbursement findById(int id);  
	
	List<Reimbursement> findAllByAuthor(int author);

}
