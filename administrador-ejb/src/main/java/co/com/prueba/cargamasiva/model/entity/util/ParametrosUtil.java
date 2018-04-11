package co.com.prueba.cargamasiva.model.entity.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que permite administrar los parametros de un Named Query
 * 
 * @author Leonardo Cruz
 *
 */
public class ParametrosUtil {

    private Map<String,Object> parametros = null;
    
    private ParametrosUtil(String name,Object value){
        this.parametros = new HashMap<String,Object>();
        this.parametros.put(name, value);
    }
    public static ParametrosUtil with(String name,Object value){
        return new ParametrosUtil(name, value);
    }
    public ParametrosUtil and(String name,Object value){
        this.parametros.put(name, value);
        return this;
    }
    public Map<String,Object> parameters(){
        return this.parametros;
    }
}