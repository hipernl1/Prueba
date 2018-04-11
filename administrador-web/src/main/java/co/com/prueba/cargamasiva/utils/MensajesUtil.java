package co.com.prueba.cargamasiva.utils;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 * Clase de utilidad para el manejo de mensajes
 * @author Leonardo Cruz
 *
 */
@Dependent
public class MensajesUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7984822853758844555L;

	public  String getMessage(String key) {
        FacesContext fc = FacesContext.getCurrentInstance();
        String mb = fc.getApplication().getMessageBundle();
        ResourceBundle resourceBundle = ResourceBundle.getBundle(mb, fc.getViewRoot().getLocale());
        return resourceBundle.getString(key);
    }

    public String getMessage(String key, String... params) {
        MessageFormat messageFormat = new MessageFormat(getMessage(key), FacesContext.getCurrentInstance().getViewRoot().getLocale());
        return messageFormat.format(params);
    }

}
