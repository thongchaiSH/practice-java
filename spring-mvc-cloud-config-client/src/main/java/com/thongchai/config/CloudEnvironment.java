package com.thongchai.config;

import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.core.env.*;
import org.springframework.web.context.support.StandardServletEnvironment;

import java.util.Iterator;

public class CloudEnvironment extends StandardServletEnvironment {

    @Override
    protected void customizePropertySources(MutablePropertySources propertySources) {
        super.customizePropertySources(propertySources);
        try {
            PropertySource<?> source = initConfigServicePropertySourceLocator(this);
            this.displayFromCloudServer(source);
            propertySources.addLast(source);

        } catch (

                Exception ex) {
            logger.warn("failed to initialize cloud config environment", ex);
        }
    }

    private PropertySource<?> initConfigServicePropertySourceLocator(Environment environment) {

        ConfigClientProperties configClientProperties = new ConfigClientProperties(environment);

        String applicationName=environment.getProperty("SPRING_APPLICATION_NAME");
        String profileActive=environment.getProperty("SPRING_PROFILES_ACTIVE");
        String cloudServerURI=environment.getProperty("SPRING_CLOUD_CONFIG_URI");

        logger.info("==========================================================");
        logger.info("SPRING_APPLICATION_NAME: ["+applicationName+"]");
        logger.info("SPRING_PROFILES_ACTIVE: ["+profileActive+"]");
        logger.info("SPRING_CLOUD_CONFIG_URI: ["+cloudServerURI+"]");
        logger.info("==========================================================");

        configClientProperties.setUri(cloudServerURI);
        configClientProperties.setProfile(profileActive);
        configClientProperties.setName(applicationName);

//    configClientProperties.setLabel("master");

        System.out.println("##################### will load the client configuration");
        System.out.println(configClientProperties);

        ConfigServicePropertySourceLocator configServicePropertySourceLocator =
                new ConfigServicePropertySourceLocator(configClientProperties);

        return configServicePropertySourceLocator.locate(environment);
    }

    private void displayFromCloudServer(PropertySource<?> source ){
        logger.info("CloudEnvironment :: source ==>"+source);
        if(source!=null){
            logger.info("==========================================================");
            for(String name:((EnumerablePropertySource<?>)source).getPropertyNames()){
                logger.info("CloudEnvironment ==> "+name+" : "+(String)source.getProperty(name));
            }
            logger.info("==========================================================");
        }else{
            logger.info("source is null ====>"+source);
        }
    }
}
