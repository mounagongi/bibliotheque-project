package entities;

import java.math.BigInteger;
import java.util.UUID;

public class Livre {
private int isbn;
private String titre;
private String theme;
private String auteur;
public Livre(String titre, String theme, String auteur) {
	
	this.isbn = Integer.parseInt(String.format("%040d", 
			new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0, 9));
	this.titre = titre;
	this.theme = theme;
	this.auteur = auteur;
}
public Livre(int isbn,String titre, String theme, String auteur) {
	
	this.isbn = isbn;
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
@Override
public String toString() {
	return "Livre [isbn=" + isbn + ", titre=" + titre + ", theme=" + theme + ", auteur=" + auteur + "]\n";
}


}
