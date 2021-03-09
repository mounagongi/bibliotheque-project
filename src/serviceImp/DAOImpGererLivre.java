package serviceImp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Livre;
public class DAOImpGererLivre {
	

		public boolean insererLivre(Livre livre) {
			Connection conn = super.connect();
			Statement ps = null;
			String requete = "insert into livre (isbn, titre,theme,auteur) values ('"+livre.getIsbn()+
					"','"+livre.getTitre()+"','"+livre.getTheme()+"','"+livre.getAuteur()+ "')";
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
		public boolean deleteLivre(Livre livre) {
			Connection conn = super.connect();
			String requete = "delete from 'livre' where 'isbn' = " + livre.getIsbn();
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
		public List<Livre> listerLivres(){
			Connection conn = super.connect();
			String requete = "select * from livre";
			Statement ps = null;
			ResultSet rs = null;
			List<Livre> listeLivre = new ArrayList<>();
			try {
				ps = conn.createStatement();
				rs = ps.executeQuery(requete);
				while (rs.next()) {
					listeLivre.add(new Livre(rs.getString("titre"), rs.getString("theme"), rs.getString("auteur")));
				}
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listeLivre;
		}

		public Livre findLivre(int isbn) {
			// TODO Auto-generated method stub
			Connection conn = super.connect();
			String requete = "select * from livre where isbn = " + isbn;
			Statement ps = null;
			ResultSet rs = null;
			Livre livre = null;

			try {
				ps = conn.createStatement();
				rs = ps.executeQuery(requete);
				while (rs.next()) {
					livre = new Livre(rs.getString("titre"), rs.getString("theme"), rs.getString("auteur"));
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

}
