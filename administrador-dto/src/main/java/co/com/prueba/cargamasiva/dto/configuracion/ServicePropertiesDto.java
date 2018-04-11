package co.com.prueba.cargamasiva.dto.configuracion;

import java.io.Serializable;

/**
 * Clase encargada de transportar las propiedades del Services Provider
 * @author Leonardo Cruz 
 *
 */
public class ServicePropertiesDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -6293872845928390467L;

	private final String localBusinessName;
	private final Class remoteClazz;
	private final String beanName;
	private final String appName;
	private final String moduleName;

	public ServicePropertiesDto(String localBusinessName, Class remoteClazz, String beanName, String appName,
			String moduleName) {
		this.localBusinessName = localBusinessName;
		this.remoteClazz = remoteClazz;
		this.beanName = beanName;
		this.appName = appName;
		this.moduleName = moduleName;
	}

	public String getLocalBusinessName() {
		return localBusinessName;
	}

	public Class getRemoteClazz() {
		return remoteClazz;
	}

	public String getBeanName() {
		return beanName;
	}

	public String getAppName() {
		return appName;
	}

	public String getModuleName() {
		return moduleName;
	}
}
