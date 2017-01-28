package controller;


import com.opensymphony.xwork2.ActionSupport;

import entities.Articolo;
import entities.Categoria;
import model.ArticoloDao;
import model.ArticoloDaoIF;
import model.CategoriaDao;
import model.CategoriaDaoIF;

public class ArticoloAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Long idArticolo;
	private String descArticolo;
	private String prezzoArticolo;
	//simulazione di bean per strato persistenza
	private ArticoloDaoIF beanArticolo=new ArticoloDao();	
	private CategoriaDaoIF beanCategoria=new CategoriaDao();
	
	//Proprietà prese o inviate dal/al form JSP
	private String message;
	private Long idCategoriaForm;	
	private Long idArticoloForm;
	
	public Long getIdArticolo(){
		return idArticolo;
	}
	
	public String getDescArticolo(){
		return descArticolo;
	}
	
	public String getPrezzoArticolo(){
		return prezzoArticolo;
	}
	
	public void setIdArticolo(Long idArticolo){
		this.idArticolo=idArticolo;
	}

	public void setDescArticolo(String descArticolo){
		this.descArticolo=descArticolo;
	}
		
	public void setPrezzoArticolo(String prezzoArticolo){
		this.prezzoArticolo=prezzoArticolo;
	}
	
	public Long getIdCategoriaForm(){
		return idCategoriaForm;
	}
	
	public void setIdCategoriaForm(Long idCategoriaForm){
		this.idCategoriaForm=idCategoriaForm;
	}
	
	public Long getIdArticoloForm(){
		return idArticoloForm;
	}
	
	public void setIdArticoloForm(Long idArticoloForm){
		this.idArticoloForm=idArticoloForm;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String createArticolo(){
		//Creo l'articolo con i valori passati dal form
		Categoria categoria= beanCategoria.getCategoriaFromId(getIdCategoriaForm()).get(0);
		Articolo articolo=new Articolo(getDescArticolo(),getPrezzoArticolo());
		articolo.setCategoria(categoria);
		Articolo articoloDao=beanArticolo.createArticolo(articolo);
		
		if (articoloDao!=null){
			//categoria creata
			setMessage("Articolo creato");		
		}else{
			setMessage("Nessuna articolo creato");
		}
		return "message";
	}
	
	public String deleteArticolo(){
		int rowDeleted=beanArticolo.deleteArticolo(getIdArticoloForm());
		
		if (rowDeleted>0){
			//articolo eliminato
			setMessage("Articolo eliminato");		
		}else{
			setMessage("Nessun articolo eliminato");
		}
		return "message";
	}
	
	public String execute(){				
		return "message";
	}

	
}
