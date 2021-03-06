package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the auteur database table.
 * 
 */
@Entity
@NamedQuery(name="Auteur.findAll", query="SELECT a FROM Auteur a")
public class Auteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;

	private String nationalite;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Livre
	@OneToMany(mappedBy="auteur")
	private List<Livre> livres;

	public Auteur() {
	}
	
	public Auteur(int num, String nationalite, String nom, String prenom, List<Livre> livres) {
		super();
		this.num = num;
		this.nationalite = nationalite;
		this.nom = nom;
		this.prenom = prenom;
		this.livres = livres;
	}
	public Auteur(String nationalite, String nom, String prenom) {
		super();
		this.num = num;
		this.nationalite = nationalite;
		this.nom = nom;
		this.prenom = prenom;
		
	}
	public Auteur(String nom, String prenom) {
		super();
		
		
		this.nom = nom;
		this.prenom = prenom;
		
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNationalite() {
		return this.nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Livre> getLivres() {
		return this.livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	public Livre addLivre(Livre livre) {
		getLivres().add(livre);
		livre.setAuteur(this);

		return livre;
	}

	public Livre removeLivre(Livre livre) {
		getLivres().remove(livre);
		livre.setAuteur(null);

		return livre;
	}

}