package entities;

public class Exemplaire extends Livre {

private int codeExmp;

public Exemplaire(int codeExmp,String titre, String theme, String auteur) {
	super(titre, theme, auteur);
	this.codeExmp=codeExmp;
}

public int getCodeExmp() {
	return codeExmp;
}

public void setCodeExmp(int codeExmp) {
	this.codeExmp = codeExmp;
}

}
