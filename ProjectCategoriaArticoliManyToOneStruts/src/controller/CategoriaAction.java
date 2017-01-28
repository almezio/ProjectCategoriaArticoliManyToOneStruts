package controller;


import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import entities.Articolo;
import entities.Categoria;
import model.ArticoloDao;
import model.ArticoloDaoIF;
import model.CategoriaDao;
import model.CategoriaDaoIF;

public class CategoriaAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Long idCategoria;
	private String descCategoria;
	private String message;
	private CategoriaDaoIF beanCategoria=new CategoriaDao();
	private ArticoloDaoIF beanArticolo=new ArticoloDao();
	private Long idCategoriaForm;
	private List<Categoria> categorie;
	private List<Articolo> articoli;	
	
	public Long getIdCategoria(){
		return idCategoria;
	}
	
	public String getDescCategoria(){
		return descCategoria;
	}
	
	public void setIdCategoria(Long idCategoria){
		this.idCategoria=idCategoria;
	}

	public void setDescCategoria(String descCategoria){
		this.descCategoria=descCategoria;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Long getIdCategoriaForm(){
		return idCategoriaForm;
	}
	
	public void setIdCategoriaForm(Long idCategoriaForm){
		this.idCategoriaForm=idCategoriaForm;
	}
	
	public List<Categoria> getCategorie(){
		return categorie;
	}
	
	public List<Articolo> getArticoli(){
		return articoli;
	}
	
	public void setArticoli(List<Articolo> articoli){
		this.articoli=articoli;
	}
	public String createCategoria(){
		//Creo la categoria con i valori passati dal form
		Categoria categoria=new Categoria(getDescCategoria());		
		Categoria categoriaDao=beanCategoria.createCategoria(categoria);
		
		if (categoriaDao!=null){
			//categoria creata
			setMessage("Categoria creata");		
		}else{
			setMessage("Nessuna categoria creata");
		}
		return "message";
	}
	
	public String updateCategoria(){
		//Creo la categoria con i valori passati dal form
		Categoria categoria=beanCategoria.getCategoriaFromId(idCategoria).get(0);	
		categoria.setDescCategoria(getDescCategoria());
		int rowUpdated=beanCategoria.updateCategoria(categoria);
		
		if (rowUpdated>0){
			//categoria creata
			setMessage("Categoria aggiornata");		
		}else{
			setMessage("Nessuna categoria aggiornata");
		}
		return "message";
	}
	
	public String deleteCategoria(){
		int rowDeleted=beanCategoria.deleteCategoria(getIdCategoriaForm());
		
		if (rowDeleted>0){
			//categoria eliminata
			setMessage("Categoria eliminata");		
		}else{
			setMessage("Nessuna categoria eliminata");
		}
		return "message";
	}
	
	public String getAllCategorie(){
		//Cerco se esistono	articoli per la categoria di input
		categorie=beanCategoria.getCategorie();
		if (!categorie.isEmpty()){	
			setMessage("Categorie trovate");
			return "show_categorie";
		}else{
			setMessage("Nessuna categoria trovata");
			return "message";
		}
	}
	
	public String getArticoliFromCategoria(){
		//Mi ricavo la categoria a partire all'idCategoria preso da form
		Categoria categoria=beanCategoria.getCategoriaFromId(getIdCategoriaForm()).get(0);
		//Cerco se esistono	articoli per la categoria di input
		articoli=beanArticolo.getArticoliFromCategoria(categoria);
		
		
		if (!articoli.isEmpty()){	
			setMessage("Articoli trovati");
			setArticoli(articoli);
			return "show_articoli";
		}else{
			setMessage("Nessun articolo trovato");
			return "message";
		}		
	}
	public String execute(){				
		return "message";
	}	
}
