package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public class ReimbursementServiceImpl implements ReimbursementService{
	
private ReimbursementDao rd = ReimbursementDao.currentImplementation;
	
	@Override
	public List<Reimbursement> findAll() {
		// TODO Auto-generated method stub
		return rd.findAll();
	}


	@Override
	public List<Reimbursement> findAllByStatus(int status) {
		// TODO Auto-generated method stub
		return rd.findAllByStatus(status);
	}


	@Override
	public int addReimbursement(Reimbursement newReimb) {
		// TODO Auto-generated method stub
		return rd.addReimbursement(newReimb);
	}


	@Override
	public void resolveReimbursement(int reimbId, int userId, int newStatusId, Timestamp resolved) {
		// TODO Auto-generated method stub
		rd.resolveReimbursement(reimbId, userId, newStatusId, resolved);
		//return; No return because this is a void
	}


	@Override
	public List<Reimbursement> findById(int id) {
		// TODO Auto-generated method stub
		return rd.findById(id);
	}


	@Override
	public List<Reimbursement> findAllByAuthor(int author) {
		// TODO Auto-generated method stub
		return rd.findAllByAuthor(author);
	}



}