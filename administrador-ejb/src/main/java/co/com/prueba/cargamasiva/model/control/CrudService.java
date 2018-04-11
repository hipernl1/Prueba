package co.com.prueba.cargamasiva.model.control;

import java.util.List;
import java.util.Map;

/**
 * Define la funcionalidad generica para las entidades
 * 
 * @author Leonardo Cruz
 *
 */
public interface CrudService {
	<T> T crear(T t);

	public <T> T buscar(Class<T> type, Object id);

	public <T> T actualizar(T t);

	public void eliminar(Object t);

	public Integer contarConNamedQuery(String queryName);
	
	public List<?> buscarConNamedQuery(String queryName);

	public List<?> buscarConNamedQuery(String queryName, int resultLimit);
	
	public List<?> buscarConNamedQuery(String namedQueryName, Map<String, Object> parameters);

	public List<?> buscarConNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultInit, int resultLimit);
	
	public <T>T buscarConNamedQuery(Class<T> type, String namedQueryName);
}
