package IserviceDAO;

import java.util.List;

import entities.Livre;

public interface IDAOgererLivre {
	boolean insererLivre(Livre livre);

	boolean deleteLivre(Livre livre);

	List<Livre> listerLivres();

	Livre findLivre(int isbn);
}
