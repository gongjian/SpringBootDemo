package com.example.demo.configuration;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ConditionalOnExpression(value = "${tomcat.ssl.enable:false}")
@Configuration
@PropertySource("classpath:/tomcat.ssl.properties")
public class CustomTomcatSSLConfiguration {

	@Value("${tomcat.ssl.port:false}")
	private Boolean enabled;

	@Value("${tomcat.ssl.port:8443}")
	private Integer port;

	@Value("${tomcat.ssl.scheme:false}")
	private String scheme;

	@Value("${tomcat.ssl.secure:false}")
	private Boolean secure;

	@Value("${tomcat.ssl.port:}")
	private String absoluteKeystoreFile;

	@Value("${tomcat.ssl.port:654321}")
	private String keystorePassword;

	@Value("${tomcat.ssl.keystoreAlias:tomcat}")
	private String keystoreAlias;

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.addAdditionalTomcatConnectors(createSslConnector());

		return tomcat;
	}

	private Connector createSslConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		try {
			connector.setScheme(scheme);
			protocol.setSSLEnabled(enabled);
			connector.setSecure(secure);
			connector.setPort(port);
			protocol.setKeystoreFile(absoluteKeystoreFile);
			protocol.setKeystorePass(keystorePassword);
			protocol.setKeyAlias(keystoreAlias);
			return connector;
		} catch (Exception ex) {
			throw new IllegalStateException("cant access keystore: [" + "keystore" + "]  ", ex);
		}
	}

}
