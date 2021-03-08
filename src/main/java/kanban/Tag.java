package kanban;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Tag {
	private long id;
	private String name;
	private List<Fiche> fiche = new ArrayList<Fiche>();
	
	public Tag(String name) {
		this.name = name;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToMany
	public List<Fiche> getFiche() {
		return fiche;
	}

	public void setFiche(List<Fiche> Fiche) {
		this.fiche = Fiche;
	}

}
