package fr.polytech.projetvdeux;

import fr.polytech.projetvdeux.web.ProduitControlleur;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class Maconfig {

    // configuration de Jaxws et Jersey
    // ProduitControlleur est connu sous le nom de "API rest"
    @Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(ProduitControlleur.class);
        return resourceConfig;
    }

    @Bean
    SimpleJaxWsServiceExporter simpleJaxWsServiceExporter(){
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://0.0.0.0:8981/");
        return exporter;
    }


}
