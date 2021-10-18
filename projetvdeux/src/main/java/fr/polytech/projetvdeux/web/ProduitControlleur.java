package fr.polytech.projetvdeux.web;

import fr.polytech.projetvdeux.dao.Produit;
import fr.polytech.projetvdeux.dao.ProduitInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component // scanner la classe, pour implémentation et tout et tout
@Path("/commerce") // c'est comme un répertoire genre c:\commerce
public class ProduitControlleur {

    @Autowired // injection des dépendances
    // injection des dépendances et inversion de contrôle(pas passer par instance de la classe mais par interface)
    // passer par une interface est moins problématique quand tu dois utiliser une DB, car au moins ça marche pour
    // toutes les databases). Plus exactement : "Un couplage faible entre la couche métiers et entités"
    private ProduitInterface produitInterface;

    @Path("/produits")
    @GET // verbe html (qui sert à dire en HTML que c'est un GET)
    // détail de la méthode
    @Produces({MediaType.APPLICATION_JSON})
    public List<Produit> produitList(){
        return produitInterface.findAll();
    }

    @Path("/produits/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Produit getProduit(@PathParam(value = "id") int id){
        return produitInterface.findById(id).get();
        // faut bien respecter cette mise en forme parce que sinon caca
    }


    @Path("/produits")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Produit save(Produit produit){
        // Ca met produit
        return produitInterface.save(produit);
    }

    @Path("/produits")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Produit save(Produit produit, @PathParam("id") int id){
        // Ca met un new prod avec id, donc PUT. Peut servir pour màj
        produit.setId(id);
        return produitInterface.save(produit);
    }

    @Path("/produits")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void save(@PathParam("id") int id){
        produitInterface.deleteById(id);
    }



}
