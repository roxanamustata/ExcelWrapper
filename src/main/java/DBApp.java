import DAO.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class DBApp {

    private SessionFactory sessionFactory;

    public DBApp() {


        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        MetadataSources sources = new MetadataSources(registry);

        Metadata metadata = sources.getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();


    }

    public void insertEmployees(ArrayList<ArrayList<Object>> records) {


        for (ArrayList<Object> record : records) {
            Employee employee = new Employee(record.get(1).toString(), record.get(2).toString(),
                    Integer.parseInt(record.get(3).toString()));
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
            session.close();
        }
    }




}
