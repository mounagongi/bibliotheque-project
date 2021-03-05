package IserviceDAO;

import java.util.List;

import entities.Emprunt;

public interface IDAOgererNvEmp {
	boolean insererNouveauEmprunt(Emprunt emprunt);

	List<Emprunt> listerEmprunts();

	boolean deleteEmprunt(int idEmp);
}
