package co.com.prueba.cargamasiva.definitions.factory;

import java.io.IOException;
import java.util.Properties;

import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Leonardo Cruz
 *
 */
public class BeanLocator {

	private static final String PROPERTY_FILE = "/jndi.properties";

	public static <T> T lookup(Class<T> clazz, String jndiName) {
		Object bean = lookup(jndiName);
		return clazz.cast(bean);
	}

	public static Object lookup(String jndiName) {
		try {
			Properties config = getJndiConfig();

			return new InitialContext(config).lookup(jndiName);
		} catch (NamingException | IOException e) {
			throw new IllegalArgumentException("JNDI Error");
		}
	}

	private static Properties getJndiConfig() throws IOException {
		Properties config = new Properties();
		config.load(BeanLocator.class.getResourceAsStream(PROPERTY_FILE));
		return config;
	}

	public static class GlobalJNDIName {
		private StringBuilder builder;
		private final String SEPARATOR = "/";
		private final String GLOBAL_PREFIX = "java:global";
		private final String APP_PREFIX = "java:app";
		private final String MODULE_PREFIX = "java:module";
		private String appName;
		private String moduleName;
		private String beanName;
		private String businessInterface;

		public GlobalJNDIName() {
			builder = new StringBuilder();
			builder.append(GLOBAL_PREFIX).append(SEPARATOR);
		}

		public GlobalJNDIName setAppLevel() {
			builder = new StringBuilder();
			builder.append(APP_PREFIX).append(SEPARATOR);

			return this;
		}

		public GlobalJNDIName setModuleLevel() {
			builder = new StringBuilder();
			builder.append(MODULE_PREFIX).append(SEPARATOR);

			return this;
		}

		public GlobalJNDIName withAppName(String appName) {
			this.appName = appName;
			return this;
		}

		public GlobalJNDIName withModuleName(String moduleName) {
			this.moduleName = moduleName;
			return this;
		}

		public GlobalJNDIName withBeanName(String beanName) {
			this.beanName = beanName;
			return this;
		}

		public GlobalJNDIName withBeanName(Class beanClass) {
			this.withBeanName(computeBeanName(beanClass));
			return this;
		}

		public GlobalJNDIName withBusinessInterface(String interfazeName) {
			this.businessInterface = interfazeName;

			return this;
		}

		public GlobalJNDIName withBusinessInterface(Class interfaze) {
			this.businessInterface = interfaze.getName();
			return this;
		}

		private String computeBeanName(Class beanClass) {
			Stateless stateless = (Stateless) beanClass.getAnnotation(Stateless.class);
			if (stateless != null && StringUtils.isNotEmpty(stateless.name())) {
				return stateless.name();
			}
			Stateful stateful = (Stateful) beanClass.getAnnotation(Stateful.class);
			if (stateful != null && StringUtils.isNoneEmpty(stateful.name())) {
				return stateful.name();
			}
			Singleton singleton = (Singleton) beanClass.getAnnotation(Singleton.class);
			if (singleton != null && StringUtils.isNoneEmpty(singleton.name())) {
				return singleton.name();
			}

			return beanClass.getSimpleName();
		}

		public String asString() {
			if (appName != null) {
				builder.append(appName).append(SEPARATOR);
			}

			builder.append(moduleName).append(SEPARATOR).append(beanName);
			if (businessInterface != null) {
				builder.append("!").append(businessInterface);
			}
			return builder.toString();
		}

		public <T> T locate(Class<T> clazz) {
			return BeanLocator.lookup(clazz, asString());
		}

		public Object locate() {
			return BeanLocator.lookup(asString());
		}
	}
}
