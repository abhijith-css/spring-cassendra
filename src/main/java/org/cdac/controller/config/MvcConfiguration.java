package org.cdac.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "org.cdac.controller")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.jsp("/WEB-INF/views/", ".jsp");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/",
        "classpath:/resources/", "classpath:/static/", "classpath:/public/", "/resources/assets/")
        .setCachePeriod(3600);
    registry
        .addResourceHandler("/ajax/**").addResourceLocations("classpath:/META-INF/resources/",
            "classpath:/resources/", "classpath:/static/", "classpath:/public/", "/resources/ajax/")
        .setCachePeriod(3600);
  }

}
