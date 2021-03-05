package entities;

import java.util.UUID;

public class Livre {
private int isbn;
private String titre;
private String theme;
private String auteur;
public Livre(String titre, String theme, String auteur) {
	
	this.isbn = Integer.parseInt(UUID.randomUUID().toString());
	this.titre = titre;
	this.theme = theme;
	this.auteur = auteur;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getTheme() {
	return theme;
}
public void setTheme(String theme) {
	this.theme = theme;
}
public String getAuteur() {
	return auteur;
}
public void setAuteur(String auteur) {
	this.auteur = auteur;
}


}
