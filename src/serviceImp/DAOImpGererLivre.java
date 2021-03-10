package serviceImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import IserviceDAO.IDAOgererLivre;
import entities.Exemplaire;
import entities.Livre;

public class DAOImpGererLivre implements IDAOgererLivre {
	MySingleton singleton = MySingleton.getInstance();
	Connection conn = singleton.getConn();

	public boolean insererLivre(Livre livre, Exemplaire exemplaire, int nbExmp) {
		Statement ps = null;
		String requete = "insert into livre (isbn, titre,theme,auteur) values (" + Integer.toString(livre.getIsbn()) + ",'"
				+ livre.getTitre() + "','" + livre.getTheme() + "','" + livre.getAuteur() + "')";
		
		try {
			ps = conn.createStatement();
			ps.execute(requete);
			for(int i=0;i<nbExmp;i++) {
				String requete2 = "insert into exemplaire (isbn) values (" + Integer.toString(livre.getIsbn())
				+ ")";
				ps.execute(requete2);
			}
			ps.close();
			return true;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteLivre(int isbn) {
		String requete = "delete from livre where isbn = " + Integer.toString(isbn);
		String requete2 = "delete from exemplaire where isbn = " + Integer.toString(isbn);
		Statement ps = null;
		try {
			ps = conn.createStatement();
			
			ps.execute(requete2);
			ps.execute(requete);
			ps.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Livre> listerLivres() {
		String requete = "select * from livre";
		Statement ps = null;
		ResultSet rs = null;
		List<Livre> listeLivre = new ArrayList<>();
		try {
			ps = conn.createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				listeLivre.add(new Livre((int)rs.getLong("isbn"),rs.getString("titre"), rs.getString("theme"), rs.getString("auteur")));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeLivre;
	}

	public Livre findLivre(int isbn) {
		String requete = "select * from livre where isbn = " + Integer.toString(isbn);
		Statement ps = null;
		ResultSet rs = null;
		Livre livre = null;

		try {
			ps = conn.createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				livre = new Livre((int)rs.getLong("isbn"),rs.getString("titre"), rs.getString("theme"), rs.getString("auteur"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livre;
	}

}