package kanban;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Fiche {

	private Long id;
	private String libelle;
	private String date_butoire;
	private Utilisateur utilisateur;
	private int temps;
	private List<Tag> tag = new ArrayList<Tag> ();
	private String lieu;
	private String url;
	private String note;
	
	public Fiche() {
	}
	
	public Fiche(String libelle, String date_butoire, Utilisateur utilisateur, int temps, String lieu, String url, String note) {
		this.libelle = libelle;
		this.date_butoire = date_butoire;
		this.utilisateur = utilisateur;
		this.temps = temps;
		this.lieu = lieu;
		this.url = url;
		this.note = note;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDate_butoire() {
		return date_butoire;
	}
	public void setDate_butoire(String date_butoire) {
		this.date_butoire = date_butoire;
	}
	@ManyToOne
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}
	@ManyToMany	
	public List<Tag> getTag() {
		return tag;
	}
	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}

	public String getLieu() {
		return lieu;
	}	
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
