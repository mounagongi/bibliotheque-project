package entities;

import java.math.BigInteger;
import java.util.UUID;

public class Emprunt {
	private int idEmp;
	private String DE;
	private String DRE;
	private int idEtud;
	private int codeExmp;

	public Emprunt(String dE, String dRE, int idEtud, int codeExmp) {
		this.idEmp = Integer.parseInt(String.format("%040d", 
				new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0, 9));
		DE = dE;
		DRE = dRE;
		this.idEtud = idEtud;
		this.codeExmp = codeExmp;
	}
	public Emprunt(String dE, int idEtud, int codeExmp) {
		this.idEmp = Integer.parseInt(String.format("%040d", 
				new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0, 9));
		DE = dE;
		this.idEtud = idEtud;
		this.codeExmp = codeExmp;
	}
	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public String getDE() {
		return DE;
	}

	public void setDE(String dE) {
		DE = dE;
	}

	public String getDRE() {
		return DRE;
	}

	public void setDRE(String dRE) {
		DRE = dRE;
	}

	public int getIdEtud() {
		return idEtud;
	}

	public void setIdEtud(int idEtud) {
		this.idEtud = idEtud;
	}

	public int getCodeExmp() {
		return codeExmp;
	}

	public void setCodeExmp(int codeExmp) {
		this.codeExmp = codeExmp;
	}
	@Override
	public String toString() {
		return "Emprunt [idEmp=" + idEmp + ", DE=" + DE + ", DRE=" + DRE + ", idEtud=" + idEtud + ", codeExmp="
				+ codeExmp + "]\n";
	}

}
