package com.example.bookApp.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceProviderConfig implements WebMvcConfigurer{
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry){
            String path="file:"+System.getProperty("user.dir")+"/src/main/resources/static/";
            registry.addResourceHandler("/static/**")
                    .addResourceLocations(path);
        }
    
    
}