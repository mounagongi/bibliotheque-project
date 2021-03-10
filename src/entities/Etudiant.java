package entities;

import java.math.BigInteger;
import java.util.UUID;

public class Etudiant {
	private int idEtud;
	private String nom;
	private String prenom;

	public Etudiant( String nom, String prenom) {

		this.idEtud =Integer.parseInt(String.format("%040d", 
				new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0, 9));
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getIdEtud() {
		return idEtud;
	}

	public void setIdEtud(int idEtud) {
		this.idEtud = idEtud;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

}
