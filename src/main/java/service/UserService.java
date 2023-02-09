package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.UtileConnection;
import entity.User;

public class UserService {

	public List<User> getAll(){
		List<User> ret = new ArrayList<User>();
		
		try {
			Connection con = UtileConnection.seConnecter();
			
			String query = "SELECT * FROM users";
			ResultSet rs = con.createStatement().executeQuery(query);
			
			while ( rs.next() ) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String phone = rs.getString("phone");

				ret.add( new User(id,firstName,lastName, username, email, password,phone) );
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	
	public User getById(int id) {
		try {
			Connection con = UtileConnection.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id=?;");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String phone = rs.getString("phone");
				
				return new User(id,firstName,lastName, username, email, password,phone);
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void add(User u) {
		try {
			Connection con = UtileConnection.seConnecter();
			PreparedStatement ps = con.prepareStatement("INSERT INTO users (first_name, last_name, username, email, password,phone) VALUES (?,?,?,?,?,?);");
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPassword());
			ps.setString(6, u.getPhone());
			
			
			ps.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	


	public void update(User u) {
		try {
			Connection con = UtileConnection.seConnecter();

			PreparedStatement ps = con.prepareStatement("UPDATE users SET first_name=?, last_name=?, username=?, email=?, password=?,phone=? WHERE id=?;");
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPassword());
			ps.setString(6, u.getPhone());
			ps.setInt(7, u.getId());

			ps.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			Connection con = UtileConnection.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id=?;");
			ps.setInt(1, id);
			ps.executeUpdate();
						
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

