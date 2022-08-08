package fr.exemple;

import fr.exemple.config.ApplicationConfiguration;
import fr.exemple.entity.*;
import fr.exemple.factory.MusicienFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void dependanceDirect(){
        Musicien musicien = new Guitariste("Jone",new Guitare("power3000"));
        musicien.jouer();
    }
    public static void InjectionDependance(){
        Musicien musicien2 =  MusicienFactory.getGuitariste("Jane","gibson");
        musicien2.jouer();

        Musicien musicien1 =  MusicienFactory.getPianiste("Jone","power1000");
        musicien1.jouer();
    }

    public static void withApplicationContext(){
       AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Musicien leMusicien = (Musicien) context.getBean("guitariste");
        leMusicien.jouer();
        Musicien lepianiste = (Musicien) context.getBean("pianiste");
        lepianiste.jouer();

        context.close();
    }
    public static void withACinClasse(){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        AbstractApplicationContext contextxml = new ClassPathXmlApplicationContext("application-context.xml");

        Instrument laCornemuse = context.getBean(Cornemuse.class);
        System.out.println(laCornemuse);
        Musicien leMusicien = context.getBean(Sonneur.class);
        leMusicien.jouer();

        Musicien leAutre= contextxml.getBean(Guitariste.class);
        leAutre.jouer();
        context.close();
    }

    public static void main(String[] args) {
        System.out.println("------dependance directe-------");
        dependanceDirect();

        System.out.println("------Injection de dependance -------");
        InjectionDependance();

        System.out.println("------Utilisation d un contexte -------");
        withApplicationContext();

        System.out.println("------Utilisation de classe de configuration -------");
        withACinClasse();
    }
}
