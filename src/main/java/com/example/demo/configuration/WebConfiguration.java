package com.example.demo.configuration;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

	// 国际化
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);

		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");

		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	// 设置session过期时间
	@Bean
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
		/*
		 * return new EmbeddedServletContainerCustomizer(){
		 * 
		 * @Override public void customize(ConfigurableEmbeddedServletContainer
		 * container) { container.setSessionTimeout(1, TimeUnit.MINUTES); } };
		 */

		return (ConfigurableEmbeddedServletContainer container) -> {
			container.setSessionTimeout(1, TimeUnit.MINUTES);
		};
	}

	// 自定义HttpMessageConveters
	// 1. @Bean定义
	/*
	 * @Bean public ByteArrayHttpMessageConverter
	 * byteArrayHttpMessageConverter() { return new
	 * ByteArrayHttpMessageConverter(); }
	 */

	// 2. configureMessageConverters
	/*
	 * @Override public void
	 * configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	 * converters.add(new ByteArrayHttpMessageConverter()); }
	 */

	// 3. extendMessageConverters
	/*
	 * @Override public void
	 * extendMessageConverters(List<HttpMessageConverter<?>> converters) {
	 * converters.clear(); converters.add(new ByteArrayHttpMessageConverter());
	 * }
	 */

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		super.configurePathMatch(configurer);
		// 常用的两种
		// 匹配结尾 / :会识别 url 的最后一个字符是否为 /
		// localhost:8080/test 与 localhost:8080/test/ 等价
		configurer.setUseTrailingSlashMatch(true);
		// 匹配后缀名：会识别 xx.* 后缀的内容
		// localhost:8080/test 与 localhost:8080/test.jsp 等价
		configurer.setUseSuffixPatternMatch(true);

		// 默认的情况下，SpringMVC会删除掉带有分号的URL地址请求。让请求的多值URL地址是有效的
		// Enable Matrix variables
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false);
		configurer.setUrlPathHelper(urlPathHelper);
	}

	// 自定义静态资源路径
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);

		registry.addResourceHandler("/internal/**").addResourceLocations("classpath:/");
	}


}
