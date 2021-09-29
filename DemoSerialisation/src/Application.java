import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Application {

        public static void main(String[] args) throws JAXBException {
            JAXBContext jc =  JAXBContext.newInstance(Personne.class); // Java Architecture for XML Building
            Personne p_1 = new Personne("LOTH","Clement", new Date(11,7,2000));
            Marshaller m = jc.createMarshaller(); // Sert de lien entre java et XML
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // met en format comme un fichier .xml en pile
            m.marshal(p_1,new File("resultat.xml"));

            System.out.println("********d****e****m****o****m****a****n**********");
            JAXBContext jc_1 = JAXBContext.newInstance(Personnes.class);
            Personnes ps = new Personnes();
            ps.getPersonnes().add(new Personne("A","B",new Date(1,1,2000)));
            ps.getPersonnes().add(new Personne("C","D",new Date(1,1,2000)));
            ps.getPersonnes().add(new Personne("E","F",new Date(1,1,2000)));
            ps.getPersonnes().add(new Personne("G","H",new Date(1,1,2000)));
            ps.getPersonnes().add(new Personne("I","J",new Date(1,1,2000)));
            ps.getPersonnes().add(new Personne("K","L",new Date(1,1,2000)));

            Marshaller ms = jc_1.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            ms.marshal(ps, new File("personnes.xml"));

            Unmarshaller um = jc_1.createUnmarshaller();
            Personnes pums = (Personnes)um.unmarshal(new File("personnes.xml"));
            System.out.println(pums.getPersonnes().get(0).getPrenom()); // Renvoie B

        }
}
