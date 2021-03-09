package serviceImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Emprunt;

public class DAOImpGererNouveauEmprunt {

	public boolean insererNouveauEmprunt(Emprunt emprunt) {
		Connection conn = super.connect();
		String requete = "insert into emprunt(idEmp,dE,dRE,idEtud,codeExmp) values ('" + emprunt.getIdEmp() + "','"
				+ emprunt.getDE() + "','" + emprunt.getDRE() + "','" + emprunt.getIdEtud() + "','"
				+ emprunt.getCodeExmp() + "')";
		Statement ps = null;
		try {
			ps = conn.createStatement();
			ps.execute(requete);
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public List<Emprunt> listerEmprunts() {
		Connection conn = super.connect();
		String requete = "select * from emprunt";
		Statement ps = null;
		ResultSet rs = null;
		List<Emprunt> listeEmprunt = new ArrayList<>();
		try {
			ps = conn.createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				listeEmprunt.add(new Emprunt(rs.getInt("idEmp"), rs.getString("dE"), rs.getString("dRE"),
						rs.getInt("idEtud"), rs.getInt("codeExmp")));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEmprunt;
	}

	public boolean deleteEmprunt(int idEmp) {
		Connection conn = super.connect();
		String requete = "delete from 'emprunt' where 'isbn' = " + idEmp;
		Statement ps = null;
		try {
			ps = conn.createStatement();
			ps.execute(requete);
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
