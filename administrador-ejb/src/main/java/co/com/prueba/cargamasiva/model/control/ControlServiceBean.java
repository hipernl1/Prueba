package co.com.prueba.cargamasiva.model.control;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * 
 * @author Leonardo Cruz
 *
 */
public class ControlServiceBean implements CrudService{
    
	@PersistenceContext
    private EntityManager em;
	
	public EntityManager getEntityManager(){
		return em;
	}
    
    public <T> T crear(T t) {
    	getEntityManager().persist(t);
    	getEntityManager().flush();
    	getEntityManager().refresh(t);
        return t;
    }
    
    @Override
    public <T> T buscar(Class<T> type,Object id) {
       return (T) getEntityManager().find(type, id);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public <T>T buscarConNamedQuery(Class<T> type, String namedQueryName){
        return (T) getEntityManager().createNamedQuery(namedQueryName).getSingleResult();
    }
    
    @Override
    public void eliminar(Object t) {
       //Object ref = getEntityManager().getReference(t.getClass(), t);
       getEntityManager().remove(em.merge(t));
    }
    @Override
    public <T> T actualizar(T t) {
        return (T) getEntityManager().merge(t);
    }
    @Override
    public List<?> buscarConNamedQuery(String namedQueryName){
        return getEntityManager().createNamedQuery(namedQueryName).getResultList();
    }
    @Override
    public List<?> buscarConNamedQuery(String namedQueryName, Map<String,Object> parameters){
        return buscarConNamedQuery(namedQueryName, parameters, 0, 0);
    }

    @Override
    public List<?> buscarConNamedQuery(String queryName, int resultLimit) {
        return getEntityManager().createNamedQuery(queryName).
                setMaxResults(resultLimit).
                getResultList();    
    }

    @Override
   public List<?> buscarConNamedQuery(String namedQueryName, Map<String,Object> parameters,int resultInit, int resultLimit){
        Set<Entry<String, Object>> rawParameters = parameters.entrySet();
        Query query = getEntityManager().createNamedQuery(namedQueryName);
        if(resultInit > 0)
        	query.setFirstResult(resultInit);
        if(resultLimit > 0)
            query.setMaxResults(resultLimit);
        for (Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }

	@Override
	public Integer contarConNamedQuery(String queryName) {
		return  (Integer)getEntityManager().createNamedQuery(queryName).getSingleResult();
	}


}