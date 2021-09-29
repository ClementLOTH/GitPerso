import javax.xml.bind.annotation.*;
import java.io.Serializable;
@XmlRootElement(name = "nae_nae_sfx") // change le nom de l'en tete XML
// @XmlAccessorOrder / A 2 paramètres : ALPHABETICAL et DEFAULT, mais ne sert à rien si combiné avec XmlType(propOrder), à retirer
@XmlType(propOrder = {"prenom","dateNaissance"})
public class Personne implements Serializable {

    private String nom;
    private String prenom;
    private Date dateNaissance;

    public Personne() {
    }

    public Personne(String nom, String prenom, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    // @XmlAttribute / Met l'element XML "nom" comme un attribut XML /!\ A METTRE avant le get si l'atttibut JAVA est private
    @XmlTransient // n'affiche pas l'élément "nom" dans le fichier XML
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
