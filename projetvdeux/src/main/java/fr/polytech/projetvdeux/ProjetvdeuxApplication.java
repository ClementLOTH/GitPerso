package fr.polytech.projetvdeux;

import fr.polytech.projetvdeux.dao.Produit;
import fr.polytech.projetvdeux.dao.ProduitInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sun.tools.jar.CommandLine;

@SpringBootApplication
public class ProjetvdeuxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetvdeuxApplication.class, args);
	}

	@Bean // exécute la méthode
	CommandLineRunner runner(ProduitInterface produitInterface){
		return args -> {
			produitInterface.save(new Produit(1,"Tablette",500));
			produitInterface.save(new Produit(2,"PC Gamer",1700));
			produitInterface.save(new Produit(3,"Câble ethernet",10));
			produitInterface.save(new Produit(4,"Tacos",8.50));

			produitInterface.findAll().forEach(produit -> {
				System.out.println(produit.getDesigniation());
			});
		};
	}

}
