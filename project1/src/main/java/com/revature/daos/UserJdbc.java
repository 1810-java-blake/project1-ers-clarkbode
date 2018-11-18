package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.model.UserRole;
import com.revature.util.ConnectionUtil;

public class UserJdbc implements UserDao {

	private User extractFromResultSet(ResultSet rs) throws SQLException {
		return new User(rs.getInt("ers_users_id"), rs.getString("username"), rs.getString("password"),
				rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), rs.getInt("ers_user_role_id"),
				new UserRole(rs.getInt("ers_user_role_id"), rs.getString("user_role")));
	}

	private Logger log = Logger.getRootLogger(); // for some reason getRootLogger() doesn't exist

	@Override
	public User findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.debug("finding user with the id " + id);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_users\r\n" + "WHERE ers_users_id = " + id); 
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				log.trace("user found with id " + id + " attempting to extract result set");
				return new User(rs.getInt("ers_users_id"), rs.getString("username"), rs.getString("password"),
						rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), rs.getInt("ers_user_role_id"),
						new UserRole(rs.getInt("ers_user_role_id"), rs.getString("user_role")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Derp user findbyID");
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT ers_users_id, username, password, user_first_name, user_last_name, user_email, u.ers_user_role_id, user_role\r\n" + 
					"FROM ers_users u\r\n" + 
					"LEFT JOIN ers_user_roles r\r\n" + 
					"on u.ers_user_role_id = r.ers_user_role_id"); // SQL statement to find all the
																						// users
			ResultSet rs = ps.executeQuery();

			// loop to populate a list with the items found in the ps.
			List<User> users = new ArrayList<>();
			System.out.println(users);
			while (rs.next()) {
				System.out.println(users);
				users.add(extractFromResultSet(rs));
			}
			System.out.println(users);
			return users;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DERP FINDALL USERS");
		}
		return null;
	}

	@Override
	public User findbyUsernameAndPassword(String username, String password) {

			try (Connection conn = ConnectionUtil.getConnection()) {
				PreparedStatement ps = conn.prepareStatement(
						"SELECT * FROM ers_users INNER JOIN ers_user_roles USING (ers_user_role_id) WHERE username = ?  AND password = ?");
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					User u = extractFromResultSet(rs);
					System.out.println("Returning the user's info: " + u.toString());
					return u;
				}
			} catch (SQLException e) {
				System.out.println("DERP FINDBYUSERNAMEANDPASS");
				e.printStackTrace();
			}
		return null;
	}

}
