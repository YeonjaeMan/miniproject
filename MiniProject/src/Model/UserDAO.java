package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

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

	public int join(UserDTO dto) {
		int row = 0;

		try {
			getConn();

			String sql = "INSERT INTO miniproject.player(id, pw) VALUES (?, ?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return row;
	}

	public UserDTO login(String id, String pw) {
		UserDTO dto = null;

		try {
			getConn();

			String sql = "SELECT * FROM miniproject.player WHERE id = ? AND pw = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next() == true) {
				dto = new UserDTO(id, pw);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return dto;

	}

	public int decideType(String p_name, String spec, String id) {

		int row = 0;

		try {
			getConn();

			String sql = "INSERT INTO miniproject.pet(p_name, spec, id)" + "VALUES (?, ?, ?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, p_name);
			psmt.setString(2, spec);
			psmt.setString(3, id);

			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return row;
	}

	public PetDTO getPetInfo(String id) {

		PetDTO petDto = null;

		try {
			getConn();

			String sql = "select * from player inner join pet on player.id = pet.id where player.id = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				petDto = new PetDTO(rs.getString("p_name"), rs.getString("spec"), rs.getInt("hp"),
						rs.getInt("fullness"), rs.getInt("love"), rs.getInt("money"), rs.getBoolean("supply_st"), rs.getBoolean("supply_rd"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return petDto;
	}
	
}
