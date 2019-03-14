package lt.v;

import lt.v.model.Person;
import lt.v.model.Salary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Salary.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Person person = new Person("Ponas", 45);
        session.save(person);
        Salary salary = new Salary(12345);
        salary.setId(person.getId());
        person.setSalary(salary);
        session.save(person);
        session.getTransaction().commit();

        System.out.println(salary.getId() + " - " + salary.getPay());

        session.disconnect();


//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
//        EntityManager em= ((EntityManagerFactory) emf).createEntityManager();
//        Session session = em.unwrap(Session.class);
//        em.getTransaction().begin();
//
//        Person person =new Person("tetras",29);
//        session.save(person);
//
//        Salary salary = new Salary (4559);
//        salary.setId(person.getId());
//        person.setSalary(salary);
//        session.save(person);
//
//        em.getTransaction().commit();
//        Salary foundSalary=session.find(Salary.class,236);
//        System.out.println(foundSalary.getId()+"-"+foundSalary.getPay());
//
//        em.close();

    }
}
