package IserviceDAO;

import java.util.List;

import entities.Exemplaire;
import entities.Livre;

public interface IDAOgererLivre {
	boolean insererLivre(Livre livre, Exemplaire exemplaire, int i);

	boolean deleteLivre(int isbn);

	List<Livre> listerLivres();

	Livre findLivre(int isbn);
}
