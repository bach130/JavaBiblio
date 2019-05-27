package resources;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;

import model.Adherent;
import model.AdherentEjbRemote;

@ManagedBean
@RequestScoped
public class LoginBean {

	public LoginBean() {

	}

	private HtmlDataTable dataTable;
	private List<Adherent> lesAdherent;
	private List<Adherent> lesAdherentBis;

	private Adherent adherent;
	@EJB
	AdherentEjbRemote lesadherentbean;

	@PostConstruct
	public void init() {
		adherent = new Adherent(0,null,null,null,null,null,null);
		lesAdherent = lesadherentbean.getAdherentFindAll();
		lesAdherentBis= lesadherentbean.getAdherentFindAll();

		// lesAdherent = lesadherentbean.findparNPTM();
	}

	public List<Adherent> getLesAdherentBis() {
		return lesAdherentBis;
	}

	public void setLesAdherentBis(List<Adherent> lesAdherentBis) {
		this.lesAdherentBis = lesAdherentBis;
	}

	public LoginBean(Adherent adherent) {
		super();
		this.adherent = adherent;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public List<Adherent> getLesAdherent() {
		return lesAdherent;
	}

	public void setLesAdherent(List<Adherent> lesAdherent) {
		this.lesAdherent = lesAdherent;
	}

	public String listAdherent() {

		lesAdherent = lesadherentbean.getAdherentFindAll();

		return "affAdherent.xhtml";

	}

	public String listAdherent2() {

		lesAdherent = lesadherentbean.findparNomEtPrenomAdh(adherent);

		return "ModefierAd.xhtml";

	}

	public String chercherAdheParNometPrenom() {

		lesAdherent = lesadherentbean.findparNomEtPrenomAdh(adherent);
		if (lesAdherent.size() <= 0) {
			System.out.println("cette Personne n'est pas un Adherent");
		}
		return "UnAdherent.xhtml";

	}

	public String ajoutAdhrent() {
		adherent = lesadherentbean.persistAdherent(adherent);
		return listAdherent();
	}

	public void SupprimerAdherent() {
		System.out.println(adherent.getNom());
		lesadherentbean.removeAdherent(adherent);
		lesAdherent = lesadherentbean.getAdherentFindAll();

	}

	public String nouveauAdherent() {
		return "AjoutAdherent.xhtml";
	}
	//////////////////////////////////////////////////////
	//methode qui ne marche pas 
	public void modifierAdherent() {

		//lesAdherent = lesadherentbean.findparNomEtPrenomAdh(adherent);
		if (lesAdherent.size() <= 0) {

		} else {
			for (Adherent adhe : lesAdherent) {
				System.out.println(adhe.getNom());
				adhe.setAdrCP(adherent.getAdrCP());
				adhe.setAdrRue(adherent.getAdrRue());
				adhe.setAdrVille(adherent.getAdrVille());
				adhe.setTel(adherent.getTel());
				adhe.setMel(adherent.getMel());
				//adhe.setMel("toto");
				//System.out.println(adhe.getMel());
				lesadherentbean.mergeAdherent(adhe); 

			}
		}
	}




	////////////////////////////////////////////////:


	public String modefA() {

		lesAdherent = lesadherentbean.findparNomEtPrenomAdh(adherent);
		lesadherentbean.mergeAdherent(adherent);
		return listAdherent();
	}

	////////////////////////////////////////////////




}

