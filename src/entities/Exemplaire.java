package entities;

import java.math.BigInteger;
import java.util.UUID;

public class Exemplaire extends Livre {

private int codeExmp;

public Exemplaire(String titre, String theme, String auteur) {
	super(titre, theme, auteur);
	//codeExemplaire est auto increment
}

public int getCodeExmp() {
	return codeExmp;
}

public void setCodeExmp(int codeExmp) {
	this.codeExmp = codeExmp;
}

}
