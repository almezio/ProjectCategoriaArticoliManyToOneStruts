package model;

import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import entities.Articolo;
import entities.Categoria;

public class CategoriaDao implements CategoriaDaoIF {
	SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();

	public CategoriaDao(){}
	
	@Override
	public Categoria createCategoria(Categoria categoria) {
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			sessionFactory.getCurrentSession().save(categoria);
			sessionFactory.getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().close();
							
			return categoria;				
		}catch(Exception e){
			return null;
		}		
	}

	@Override
	public Categoria createCategConArticoli(Categoria categoria, Set<Articolo> articoli) {
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		
		categoria.setArticoli(articoli);			
		
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			sessionFactory.getCurrentSession().save(categoria);
			sessionFactory.getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().close();
							
			return categoria;				
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int updateCategoria(Categoria categoria) {
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			Query query=sessionFactory.getCurrentSession().createQuery("update Categoria set descCategoria= :descCategoria where idCategoria= :idCategoria");
			query.setLong("idCategoria", categoria.getIdCategoria());
			query.setString("descCategoria", categoria.getDescCategoria());
			int entitiesUpdate=query.executeUpdate();  // in entitiesUpdate è indicato il numero di righe aggiornate
			sessionFactory.getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().close();
			return entitiesUpdate;				
		}catch(Exception e){
			System.out.println(e.getMessage());
			return 0;
		}
	}

	@Override
	public int deleteCategoria(Long idCategoria) {
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			Query query=sessionFactory.getCurrentSession().createQuery("delete Categoria where idCategoria= :idCategoria");
			query.setLong("idCategoria", idCategoria);				
			int entitiesUpdate=query.executeUpdate();  // in entitiesUpdate è indicato il numero di righe cancellate
			sessionFactory.getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().close();
			return entitiesUpdate;				
		}catch(Exception e){
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> getCategoriaFromId(Long idCategoria) {
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			Query query=sessionFactory.getCurrentSession().createQuery("from Categoria a where a.idCategoria=:idCategoria");
			query.setLong("idCategoria",idCategoria);
			return (List<Categoria>)query.list();				
		}catch(Exception e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> getCategorie() {
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		
		List<Categoria> categorie;
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			categorie=(List<Categoria>)sessionFactory.getCurrentSession().createQuery("from Categoria").list();				
			return categorie;
		}catch(Exception e){
			return null;
		}
	}
}
