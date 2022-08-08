package fr.exemple.config;

import fr.exemple.entity.Cornemuse;
import fr.exemple.entity.Instrument;
import fr.exemple.entity.Musicien;
import fr.exemple.entity.Sonneur;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean(name = "cornemuse")
    public Instrument getCornemuse(){
        Instrument instru = new Cornemuse();
        return instru;
    }
    //injection de bean par attribut
    @Bean
    public Musicien getSonneur(){
        Musicien leSonneur = new Sonneur("henz",getCornemuse());
        return leSonneur;
    }
    //injection de bean par nom
    //@Bean
    public Musicien getSonneur1(String nom, @Qualifier("cornemuse")Instrument cornemuse){
        Musicien leSonneur = new Sonneur(nom,cornemuse);
        return leSonneur;
    }
}
