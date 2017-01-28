package model;

import java.util.List;
import entities.Articolo;
import entities.Categoria;

public interface ArticoloDaoIF {
	public Articolo createArticolo(Articolo articolo);
	public int updateArticolo(Articolo articolo);
	public int deleteArticolo(Long idarticolo);
	public List<Articolo> getArticoloFromId(Long idArticolo);	
	public List<Articolo> getArticoliFromCategoria(Categoria categoria);
}
