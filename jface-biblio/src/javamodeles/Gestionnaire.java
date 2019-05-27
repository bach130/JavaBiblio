package javamodeles;

public class Gestionnaire {

	private String nom;
	private String prenom;
	private String motdepasse;
	
	public Gestionnaire() {
		
	}

	public Gestionnaire(String nom, String prenom, String motdepasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.motdepasse = motdepasse;
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

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	@Override
	public String toString() {
		return "Gestionnaire [nom=" + nom + ", prenom=" + prenom + ", motdepasse=" + motdepasse + "]";
	}
	
}
