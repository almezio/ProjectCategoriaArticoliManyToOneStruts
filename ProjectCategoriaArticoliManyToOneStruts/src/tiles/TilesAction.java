package tiles;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import entities.Categoria;
import model.CategoriaDao;
import model.CategoriaDaoIF;

public class TilesAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private List<Categoria> categorie;

	public String template(){
		System.out.println("Nel metodo template di TilesAction...");
		return "template";
	}
	
	public String index(){
		System.out.println("Nel metodo index di TilesAction...");
		return "index";
	}
	
	public String main_categoria(){
		System.out.println("Nel metodo main_categoria di TilesAction...");
		return "main_categoria";
	}
	
	public String main_categoriaUpdate(){
		System.out.println("Nel metodo main_categoriaUpdate di TilesAction...");
		return "main_categoriaUpdate";
	}
	
	public String main_ricercaArtFromCategoria(){
		System.out.println("Nel metodo main_ricercaArtFromCategoria di TilesAction...");
		return "main_ricercaArtFromCategoria";
	}
	
	public String main_articolo(){
		CategoriaDaoIF beanCategoria=new CategoriaDao();
		
		//Estrarre tutte le categire e passarle alla jsp main_Articolo
		categorie=beanCategoria.getCategorie();
		return "main_articolo";
	}
	
	public String main_ricercaArticolo(){
		System.out.println("Nel metodo maimain_ricercaArticolon_articolo di TilesAction...");
		return "main_ricercaArticolo";
	}
	
	public List<Categoria> getCategorie(){
		return this.categorie;
	}	
}
