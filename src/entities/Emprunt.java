package entities;

public class Emprunt {
	private int idEmp;
	private String DE;
	private String DRE;
	private int idEtud;
	private int codeExmp;

	public Emprunt(int idEmp, String dE, String dRE, int idEtud, int codeExmp) {
		super();
		this.idEmp = idEmp;
		DE = dE;
		DRE = dRE;
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

}
