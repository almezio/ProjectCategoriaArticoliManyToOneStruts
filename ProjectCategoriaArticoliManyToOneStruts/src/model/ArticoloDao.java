package model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import entities.Articolo;
import entities.Categoria;

public class ArticoloDao implements ArticoloDaoIF {
	SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	
	public ArticoloDao(){}
	
	@Override
	public Articolo createArticolo(Articolo articolo) {
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			sessionFactory.getCurrentSession().save(articolo);
			sessionFactory.getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().close();
							
			return articolo;				
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public int updateArticolo(Articolo articolo) {
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			Query query=sessionFactory.getCurrentSession().createQuery("update Articolo set descArticolo= :descArticolo where idArticolo= :idArticolo");
			query.setLong("idArticolo", articolo.getIdArticolo());
			query.setString("descArticolo", articolo.getDescArticolo());
			int entitiesUpdate=query.executeUpdate();  // in entitiesUpdate è indicato il numero di righe aggiornate
			sessionFactory.getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().close();
			return entitiesUpdate;				
		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public int deleteArticolo(Long idArticolo) {
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			Query query=sessionFactory.getCurrentSession().createQuery("delete Articolo where idArticolo= :idArticolo");
			query.setLong("idArticolo", idArticolo);				
			int entitiesUpdate=query.executeUpdate();  // in entitiesUpdate è indicato il numero di righe cancellate
			sessionFactory.getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().close();
			return entitiesUpdate;				
		}catch(Exception e){
			System.out.println("Eccezione: " + e.toString());
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Articolo> getArticoloFromId(Long idArticolo) {
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			Query query=sessionFactory.getCurrentSession().createQuery("from Articolo a where a.idArticolo=:idArticolo");
			query.setLong("idArticolo",idArticolo);
			return (List<Articolo>)query.list();				
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Articolo> getArticoliFromCategoria(Categoria categoria) {
		try{
			sessionFactory.getCurrentSession().getTransaction().begin();
			
			//Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Articolo.class).add(Restrictions.eq("idCategoria", idCategoria));
			@SuppressWarnings("unchecked")
			List <Articolo> articoli=sessionFactory.getCurrentSession().createCriteria(Articolo.class).add(Restrictions.eq("categoria",categoria)).list();
			
			return articoli;				
		}catch(Exception e){
			System.out.println("****************** Eccezione: " + e.toString());
			return null;
		}
	}
}
