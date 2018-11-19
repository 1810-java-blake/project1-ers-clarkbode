package com.revature.daos;

//import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import org.apache.log4j.Logger;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class ReimbursementJdbc implements ReimbursementDao {
	private Reimbursement extractFromResultSet(ResultSet rs) throws SQLException {
		return new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
				rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
				rs.getString("reimb_description"), rs.getString("reimb_receipt"), rs.getInt("reimb_author"),
				rs.getInt("reimb_resolver"), rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"), 
				rs.getString("reimb_status"), rs.getString("reimb_type"), rs.getString("user_first_name"), rs.getString("user_last_name"));
	}

	private Logger log = Logger.getRootLogger(); // for some reason getRootLogger() doesn't exist

	@Override
	public int addReimbursement(Reimbursement newReimb) { // QUESTION: In Blake's example, this returns int.
																	// Would it be better to return a reimbursement?
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO \"project-1\".ers_reimbursement(\r\n"
					+ "	reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, NULL, ?, ?);");

			//ps.setInt(1, (newReimb.getReimb_id() + 47)); //this will be removed once the data type is changed to serial
			ps.setDouble(1, newReimb.getReimb_amount());
			ps.setTimestamp(2, newReimb.getReimb_submitted());
			ps.setTimestamp(3, newReimb.getReimb_resolved());
			ps.setString(4, newReimb.getReimb_description());
			ps.setString(5, newReimb.getReimb_receipt());
			ps.setInt(6, newReimb.getReimb_author());
			//ps.setInt(8, newReimb.getReimb_resolver());
			ps.setInt(7, newReimb.getReimb_status_id());
			ps.setInt(8, newReimb.getReimb_type_id());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			System.out.println(ps);

			if (rs.next()) {
				int id = rs.getInt("reimb_id");
				newReimb.setReimb_id(id);
				return id;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DERP ADD REIMBURSEMENT");
		}

		return 0;
	}

	@Override
	public List<Reimbursement> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			//PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement"); // SQL statement to find
			PreparedStatement ps = conn.prepareStatement(
					"SELECT  reimb_id, r.reimb_author, r.reimb_resolver, user_first_name, user_last_name, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_status, reimb_type, r.reimb_status_id, r.reimb_type_id\r\n" + 
					"FROM ers_users u\r\n" + 
					"inner join ers_reimbursement r\r\n" + 
					"on u.ers_users_id = r.reimb_author\r\n" + 
					"inner join ers_reimbursement_status s\r\n" + 
					"on r.reimb_status_id = s.reimb_status_id\r\n" + 
					"inner join ers_reimbursement_type ty\r\n" + 
					"on r.reimb_type_id = ty.reimb_type_id");																					// all the
																								// reimbursements
			ResultSet rs = ps.executeQuery();

			// loop to populate a list with the items found in the ps.
			List<Reimbursement> reimbs = new ArrayList<>();
			while (rs.next()) {
				reimbs.add(extractFromResultSet(rs));
			}
			return reimbs;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DERP FINDALL REIMBURSEMENTS");
		}
		return null;
	}

	@Override
	public List<Reimbursement> findAllByStatus(int status) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT  reimb_id, r.reimb_author, r.reimb_resolver, user_first_name, user_last_name, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_status, reimb_type, r.reimb_status_id, r.reimb_type_id\r\n" + 
					"FROM ers_users u\r\n" + 
					"inner join ers_reimbursement r\r\n" + 
					"on u.ers_users_id = r.reimb_author\r\n" + 
					"inner join ers_reimbursement_status s\r\n" + 
					"on r.reimb_status_id = s.reimb_status_id\r\n" + 
					"inner join ers_reimbursement_type ty\r\n" + 
					"on r.reimb_type_id = ty.reimb_type_id\r\n" + 
					"WHERE r.reimb_status_id = " + status); 

			//ps.setInt(1, status);
			log.debug("finding user with the id " + status);

			ResultSet rs = ps.executeQuery();

			// loop to populate a list with the items found in the ps.
			List<Reimbursement> reimbs = new ArrayList<>();

			while (rs.next()) {
				reimbs.add(extractFromResultSet(rs));
			}
			return reimbs;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DERP FINDALLBYSTATUS");
		}
		return null;
	}
	
	@Override
	public List<Reimbursement> findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.debug("finding reimbursement with the id " + id);
			PreparedStatement ps = conn.prepareStatement("SELECT  reimb_id, r.reimb_author, r.reimb_resolver, user_first_name, user_last_name, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_status, reimb_type, r.reimb_status_id, r.reimb_type_id\r\n" + 
					"FROM ers_users u\r\n" + 
					"inner join ers_reimbursement r\r\n" + 
					"on u.ers_users_id = r.reimb_author\r\n" + 
					"inner join ers_reimbursement_status s\r\n" + 
					"on r.reimb_status_id = s.reimb_status_id\r\n" + 
					"inner join ers_reimbursement_type ty\r\n" + 
					"on r.reimb_type_id = ty.reimb_type_id\r\n" + 
					"WHERE r.reimb_id = " + id); // SQL

			//ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			log.debug("finding reimb with the reimb_id " + id);


			// loop to populate a list with the items found in the ps.
			List<Reimbursement> reimbs = new ArrayList<>();

			while (rs.next()) {
				reimbs.add(extractFromResultSet(rs));
			}
			return reimbs;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DERP FINALLBYID");
		}
		return null;
//
//			if (rs.next()) {
//				log.trace("reimb found with id " + id + " attempting to extract result set");
//				Reimbursement foundReimb = new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"), 
//						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"), rs.getString("reimb_description"), 
//						rs.getString("reimb_receipt"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"), 
//						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
//				
//				//System.out.println("I AM RETURNING: " + foundReimb);
//				if (foundReimb == null)
//				{
//					System.out.println("There is no such reimbursement");
//					
//				}
//				return foundReimb;
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Derp reimbursement findbyID");
//		}
//		return null;
	}

	@Override
	public void resolveReimbursement(int reimbId, int userId, int newStatusId, Timestamp resolved) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ers_reimbursement\r\n"
					+ "SET reimb_status_id = ?, reimb_resolver = ?, reimb_resolved = ?\r\n" + "WHERE reimb_id ="
					+ reimbId); 
			
			ps.setInt(1, newStatusId);
			ps.setInt(2, userId);
			ps.setTimestamp(3, resolved);
			System.out.println("jdbc changing reimbursement to " + newStatusId);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DERP RESOLVEREIMBURSEMENT");
		}

		return;
	}

	@Override
	public List<Reimbursement> findAllByAuthor(int author) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT  reimb_id, r.reimb_author, r.reimb_resolver, user_first_name, user_last_name, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_status, reimb_type, r.reimb_status_id, r.reimb_type_id\r\n" + 
					"FROM ers_users u\r\n" + 
					"inner join ers_reimbursement r\r\n" + 
					"on u.ers_users_id = r.reimb_author\r\n" + 
					"inner join ers_reimbursement_status s\r\n" + 
					"on r.reimb_status_id = s.reimb_status_id\r\n" + 
					"inner join ers_reimbursement_type ty\r\n" + 
					"on r.reimb_type_id = ty.reimb_type_id\r\n" + 
					"WHERE r.reimb_author = " + author); // SQL
																														// statement

			//ps.setInt(1, author);
			log.debug("finding reimb with the author_id " + author);

			ResultSet rs = ps.executeQuery();

			// loop to populate a list with the items found in the ps.
			List<Reimbursement> reimbs = new ArrayList<>();

			while (rs.next()) {
				reimbs.add(extractFromResultSet(rs));
			}
			return reimbs;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DERP FINDALLBYAUTHOR");
		}
		return null;
	}

}
