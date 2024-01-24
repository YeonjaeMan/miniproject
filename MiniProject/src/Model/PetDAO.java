package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetDAO {
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	private void getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/miniproject";
			String user = "root";
			String password = "12345";

			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getClose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int sleep(PetDTO petDto) {
	      int row = 0;
	      
	      petDto.setHp(petDto.getHp() + 5);
	      petDto.setFullness(petDto.getFullness() - 5);
	      
	      try {
	         getConn();
	         
	         String sql = "update miniproject.pet set Hp = ?, Fullness = ?, Love = ? where p_name = ?";

	         psmt = conn.prepareStatement(sql);

	         psmt.setInt(1, petDto.getHp());
	         psmt.setInt(2, petDto.getFullness());
	         psmt.setInt(3, petDto.getLove());
	         psmt.setString(4, petDto.getName());

	         row = psmt.executeUpdate();

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         getClose();
	      }

	      return row;
	   }
	
}
