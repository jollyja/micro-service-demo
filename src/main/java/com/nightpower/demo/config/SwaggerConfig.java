/**
 * 
 */
package com.nightpower.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * you can get api docs by : http://localhost:8080/v2/api-docs
 * 
 * 
 * @author jollyja
 *
 */
@Profile({"dev", "sit", "uat"})
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	//服务对应联系人信息
	@Value("${micro-service-demo.swagger.contact.principalName}")
	private String principalName;
	
	//服务主页URL
	@Value("${micro-service-demo.swagger.contact.url}")
	private String url;
	
	//服务邮箱地址
	@Value("${micro-service-demo.swagger.contact.email}")
	private String email;
	
	//服务描述
	@Value("${micro-service-demo.swagger.description}")
	private String description;
	
	//服务分组
	@Value("${micro-service-demo.swagger.groupName}")
	private String groupName;
	
	//服务名称
	@Value("${spring.application.name}")
	private String appName;
	
	/**
	 * 配置API文档类型为Swagger2，并指定扫描范围
	 * 
	 * @return Docket
	 */
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nightpower"))//扫描指定范围的包，不指定会扫描出spring框架的接口
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * 定义Api基本信息
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title(appName)
				.description(description)
				.contact(new Contact(principalName, url, email))
				.build();
	}
	
}
