package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_CATEGORIA")
public class Categoria implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long idCategoria;
	private String descCategoria;
	private Set<Articolo> articoli;
		
	public Categoria() {
	}
	
	public Categoria(String nome) {
		this.descCategoria = nome;
	}
	
	@Id
	@SequenceGenerator(name="SEQ",sequenceName="SEQ_CATEGORIA",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
	@Column(name = "ID_CATEGORIA", unique = true, nullable = false)
	public Long getIdCategoria() {
		return this.idCategoria;
	}
	
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(name = "NOME_CATEGORIA", length = 50)
	public String getDescCategoria() {
		return this.descCategoria;
	}

	public void setDescCategoria(String nome) {
		this.descCategoria = nome;
	}

	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="ID_CATEGORIA")
	public Set<Articolo> getArticoli() {
	    return articoli;
	}
	
	public void setArticoli(Set<Articolo> articoli) {
		this.articoli=articoli;
	}
}
