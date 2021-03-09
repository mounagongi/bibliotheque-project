package business;

import java.util.List;

import IserviceDAO.IDAOgererNvEmp;
import entities.Emprunt;

public class GererNvEmp {
	IDAOgererNvEmp gererNvEmp;

	public GererNvEmp(IDAOgererNvEmp gererNvEmp) {
		this.gererNvEmp = gererNvEmp;
	}

	boolean insererNouveauEmprunt(Emprunt emprunt) {
		return gererNvEmp.insererNouveauEmprunt(emprunt);
	}

	List<Emprunt> listerEmprunts() {
		return gererNvEmp.listerEmprunts();
	}

	boolean deleteEmprunt(int idEmp) {
		return gererNvEmp.deleteEmprunt(idEmp);
	}

}
