package it.polito.tdp.anagramma.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class AnagrammaDAO {
	 
	 
	public boolean isCorretto(String anagramma) {

		final String sql = "SELECT p.nome "+
		"FROM parola as p "+
				"Where p.nome=? ";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				conn.close();
				return true;
			}else {
				conn.close();
				return false;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	

}
