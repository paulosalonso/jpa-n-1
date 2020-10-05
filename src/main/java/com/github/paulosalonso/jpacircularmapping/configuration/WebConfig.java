package com.github.paulosalonso.jpacircularmapping.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

//        Hibernate5Module hibernate5Module = new Hibernate5Module();
//
//        hibernate5Module.disable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
//        hibernate5Module.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);

        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        builder.modulesToInstall(hibernate5Module);
        builder.serializationInclusion(Include.NON_NULL);
        builder.serializationInclusion(Include.NON_EMPTY);

        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }

}
