package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.UtileConnection;
import entity.Announce;

public class AnnounceService {
	
	public Announce getById(int id) {
		try {
			Connection con = UtileConnection.seConnecter();
						
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Announces WHERE id=?;");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery(); 
			
			if (rs.next()) {
				String category = rs.getString("category");
				String announceTitle = rs.getString("announce_title");
				String region = rs.getString("region");
				String description = rs.getString("description");
				String state = rs.getString("state");
				String photos = rs.getString("photos");
				int userId = rs.getInt("user_id");
				int price = rs.getInt("price");

				return new Announce(category, announceTitle, region, description, state, photos, userId, price );
		}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Announce> getAll(){
		List<Announce> ret = new ArrayList<Announce>();
		
		try {
			Connection con = UtileConnection.seConnecter();
			String query = "SELECT * FROM Announces;";
			ResultSet rs = con.createStatement().executeQuery(query);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String category = rs.getString("category");
				String announceTitle = rs.getString("announce_title");
				String region = rs.getString("region");
				String description = rs.getString("description");
				String state = rs.getString("state");
				String photos = rs.getString("photos");
				int userId = rs.getInt("user_id");
				float price = rs.getFloat("price");
				
				ret.add(new Announce(id, category, announceTitle, region, description, state, photos, userId, price));
			}


			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public void add(Announce a) {
		try {
			Connection con = UtileConnection.seConnecter();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Announces (category, announce_title, region, description, state, photos, user_id, price) VALUES (?,?,?,?,?,?,?,?);");
			ps.setString(1, a.getCategory());
			ps.setString(2, a.getAnnounceTitle());
			ps.setString(3, a.getRegion());
			ps.setString(4, a.getDescription());
			ps.setString(5, a.getState());
			ps.setString(6, a.getPhotos());
			ps.setInt(7, a.getUserId());
			ps.setFloat(8, a.getPrice());
			
			ps.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Announce a) {
		try {
			Connection con = UtileConnection.seConnecter();

			PreparedStatement ps = con.prepareStatement("UPDATE Announces SET category=?, announce_title=?, region=?, description=?, state=?, photos=?, user_id=?, price=? WHERE id=?;");
			ps.setString(1, a.getCategory());
			ps.setString(2, a.getAnnounceTitle());
			ps.setString(3, a.getRegion());
			ps.setString(4, a.getDescription());
			ps.setString(5, a.getState());
			ps.setString(6, a.getPhotos());
			ps.setInt(7, a.getUserId());
			ps.setFloat(8, a.getPrice());
			ps.setInt(9, a.getId());

			ps.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		try {
			Connection con = UtileConnection.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM Announces WHERE id=?;");
			ps.setInt(1, id);
			ps.executeUpdate();
						
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public List<Announce> getByCategory(String category ){
		List<Announce> ret = new ArrayList<Announce>();
		
		try {
			Connection con = UtileConnection.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Announces WHERE category=?;");
			ps.setString(1,category);
			ResultSet rs = ps.executeQuery(); 
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String announceTitle = rs.getString("announce_title");
				String region = rs.getString("region");
				String description = rs.getString("description");
				String state = rs.getString("state");
				String photos = rs.getString("photos");
				int userId = rs.getInt("user_id");
				float price = rs.getFloat("price");
				
				ret.add(new Announce(id, category, announceTitle, region, description, state, photos, userId, price));
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public List<Announce> getByUserId(int userId ){
		List<Announce> ret = new ArrayList<Announce>();
		
		try {
			Connection con = UtileConnection.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Announces WHERE user_id=?;");
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery(); 
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String category = rs.getString("category");
				String announceTitle = rs.getString("announce_title");
				String region = rs.getString("region");
				String description = rs.getString("description");
				String state = rs.getString("state");
				String photos = rs.getString("photos");
				float price = rs.getFloat("price");
				
				ret.add(new Announce(id, category, announceTitle, region, description, state, photos, userId, price));
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public static void main(String[] args) {
		//test getAll
//		AnnounceService service = new AnnounceService();
//		System.out.println(service.getAll());
		
//		//test create
//		AnnounceService service = new AnnounceService();
//		Announce a1 = new Announce("Jeux", "Monopoly", "France", "Jeu de carte", "Bon état",  "url", 2, (float) 8.5);
//		service.add(a1);
		
		
//		//test update
//		AnnounceService service = new AnnounceService();
//		Announce a2 = new Announce(5,"Jeux", "Uno", "Jeu de carte Bon état", "Très Bon état", "Nord pas de Calais", "url", 2, 20);
//		service.update(a2);
//		
//		//test getByCategory
//		AnnounceService service = new AnnounceService();
//		System.out.println(service.getByCategory("Jeux"));
		
//		//test delete
//		AnnounceService service = new AnnounceService();
//		service.delete(5);
		
//		//test getById
//		AnnounceService service = new AnnounceService();
//		System.out.println(service.getById(3));
		
//		//test getByUserId
//		AnnounceService service = new AnnounceService();
//		System.out.println(service.getByUserId(2));
	}

}