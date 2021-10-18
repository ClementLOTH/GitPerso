package fr.polytech.projetvdeux.dao;


// les deux annotations nécessaires pour que ça soit une entité : @Entity et @Id

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produit {
    @Id
    private int id;
    private String designiation;
    private double prix;

    public Produit() {
    }

    public Produit(int id, String designiation, double prix) {
        this.id = id;
        this.designiation = designiation;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesigniation() {
        return designiation;
    }

    public void setDesigniation(String designiation) {
        this.designiation = designiation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", designiation='" + designiation + '\'' +
                ", prix=" + prix +
                '}';
    }
}

