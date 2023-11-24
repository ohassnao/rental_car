package VoitureDAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class MarqueDAO {
    private final Session session;

    public MarqueDAO(Session session) {
        this.session = session;
    }

    public List<String> fetchMarqueData() {
        List<String> marqueList;
        try {
            session.beginTransaction();

            // Assuming 'Marque' is a property in your 'Voiture' entity mapped with Hibernate
            Query<String> query = session.createQuery("SELECT DISTINCT v.marque FROM Voiture v", String.class);
            marqueList = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            marqueList = null; // Handle exceptions appropriately
            e.printStackTrace(); // Log the exception or handle it as needed
        }
        return marqueList;
    }
}
