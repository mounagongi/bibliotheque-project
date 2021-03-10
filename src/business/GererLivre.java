package business;

import java.util.List;

import IserviceDAO.IDAOgererLivre;
import entities.Exemplaire;
import entities.Livre;

public class GererLivre {
	IDAOgererLivre gererLivre;

	public GererLivre(IDAOgererLivre gererLivre) {
		this.gererLivre = gererLivre;

	}

	public boolean insererLivre(Livre livre, Exemplaire exemplaire, int i) {
		return gererLivre.insererLivre(livre,exemplaire,i);
	}
	
	public boolean deleteLivre(int isbn) {
		return gererLivre.deleteLivre(isbn);
	}

	public List<Livre> listerLivres(){
		return gererLivre.listerLivres();
	}

	public Livre findLivre(int isbn) {
		return gererLivre.findLivre(isbn);
	}
}
