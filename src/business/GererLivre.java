package business;

import java.util.List;

import IserviceDAO.IDAOgererLivre;
import entities.Livre;

public class GererLivre {
	IDAOgererLivre gererLivre;

	public GererLivre(IDAOgererLivre gererLivre) {
		this.gererLivre = gererLivre;

	}

	boolean insererLivre(Livre livre) {
		return gererLivre.insererLivre(livre);
	}
	
	boolean deleteLivre(Livre livre) {
		return gererLivre.deleteLivre(livre);
	}

	List<Livre> listerLivres(){
		return gererLivre.listerLivres();
	}

	Livre findLivre(int isbn) {
		return gererLivre.findLivre(isbn);
	}
}
