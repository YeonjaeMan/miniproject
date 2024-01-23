package pet_raise_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO {
	
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	private void getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/jdbctest";
			String user = "root";
			String password = "12345";
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getClose() {
		try {
			if(rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int join(GameDTO dto) {
		int row = 0;

		try {
			getConn();
			
			String sql = "INSERT INTO test1.userdata(user_id, user_pw) VALUES (?, ?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getUserId());
			psmt.setString(2, dto.getUserPw());

			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return row;
	}
	
	public GameDTO login(String id, String pw) {
		GameDTO dto = null;

		try {
			getConn();
			
			String sql = "SELECT * FROM test1.userdata WHERE user_id = ? AND user_pw = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next() == true) {
				dto = new GameDTO(id, pw, rs.getString("pet_name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return dto;

	}
	
}
