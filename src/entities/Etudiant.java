package entities;

import java.util.UUID;

public class Etudiant {
	private int idEtud;
	private String nom;
	private String prenom;

	public Etudiant( String nom, String prenom) {

		this.idEtud = Integer.parseInt(UUID.randomUUID().toString());
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
