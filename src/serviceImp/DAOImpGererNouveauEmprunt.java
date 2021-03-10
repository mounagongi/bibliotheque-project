package serviceImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import IserviceDAO.IDAOgererNvEmp;
import entities.Emprunt;

public class DAOImpGererNouveauEmprunt implements IDAOgererNvEmp {

	MySingleton singleton = MySingleton.getInstance();
	Connection conn = singleton.getConn();

	public boolean insererNouveauEmprunt(Emprunt emprunt) {
		String requete2= "select * from emprunt where (codeExmp="+Integer.toString(emprunt.getCodeExmp()) + " AND DRE is not NULL)"
				+ " OR ("+Integer.toString(emprunt.getCodeExmp()) +" NOT IN (select codeExmp from emprunt));";
		
		
		String requete = "insert into emprunt(idEmp,DE,idEtud,codeExmp) values ("+Integer.toString(emprunt.getIdEmp())+",'"
				+emprunt.getDE() + "'," 
				+ Integer.toString(emprunt.getIdEtud()) + "," + Integer.toString(emprunt.getCodeExmp()) + ")";
		Statement ps = null;
		ResultSet rs = null; 
		try {
			ps = conn.createStatement();
			rs=ps.executeQuery(requete2);
			if(rs.next()) {
				ps.execute(requete);
				return true;
				
			}
			else {
				System.out.println("Exemplaire non disponible !!");
			}
			ps.close();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Emprunt> listerEmprunts() {
		String requete = "select * from emprunt";
		Statement ps = null;
		ResultSet rs = null;
		List<Emprunt> listeEmprunt = new ArrayList<>();
		try {
			ps = conn.createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				listeEmprunt.add(new Emprunt(rs.getString("DE"), rs.getString("DRE"),
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
		String requete = "delete from emprunt where idEmp = " + Integer.toString(idEmp);
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
