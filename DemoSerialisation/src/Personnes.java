import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
public class Personnes implements Serializable {
    private List<Personne> personnes = new ArrayList<>();

    public Personnes() {
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }


}
