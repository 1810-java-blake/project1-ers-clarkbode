package com.revature.services;

import java.sql.Timestamp;
import java.util.List;
import com.revature.model.*;

public interface ReimbursementService {

	ReimbursementService currentImplementation = new ReimbursementServiceImpl();

	List<Reimbursement> findAll();
	
	List<Reimbursement> findAllByStatus(int status);
	
	List<Reimbursement> findAllByAuthor(int author);
	
	int addReimbursement(Reimbursement newReimb);
	
	void resolveReimbursement(int reimbId, int userId, int newStatusId, Timestamp resolved);

	Reimbursement findById(int id);
}
