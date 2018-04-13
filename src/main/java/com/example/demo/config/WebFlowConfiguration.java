package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;

@Configuration
public class WebFlowConfiguration extends AbstractFlowConfiguration {

	@Autowired
	private MvcConfiguration mvcConfiguration;
	
	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		return getFlowDefinitionRegistryBuilder() //
				.setBasePath("/WEB-INF/flows") //
				.addFlowLocationPattern("/**/*-flow.xml") //
				.setFlowBuilderServices(flowBuilderServices()) //
				.build();
	}

	@Bean
	public FlowExecutor flowExecutor() {
		return getFlowExecutorBuilder(flowRegistry()) //
				.build();
	}

	@Bean
	public FlowBuilderServices flowBuilderServices() {
		return getFlowBuilderServicesBuilder() //
				.setViewFactoryCreator(mvcConfiguration.mvcViewFactoryCreator())
				.build();
	}
}
