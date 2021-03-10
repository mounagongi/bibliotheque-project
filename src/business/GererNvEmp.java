package business;

import java.util.List;

import IserviceDAO.IDAOgererNvEmp;
import entities.Emprunt;

public class GererNvEmp {
	IDAOgererNvEmp gererNvEmp;

	public GererNvEmp(IDAOgererNvEmp gererNvEmp) {
		this.gererNvEmp = gererNvEmp;
	}

	public boolean insererNouveauEmprunt(Emprunt emprunt) {
		return gererNvEmp.insererNouveauEmprunt(emprunt);
	}

	public List<Emprunt> listerEmprunts() {
		return gererNvEmp.listerEmprunts();
	}

	public boolean deleteEmprunt(int idEmp) {
		return gererNvEmp.deleteEmprunt(idEmp);
	}

}
