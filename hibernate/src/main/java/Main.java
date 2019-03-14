
import lt.v.Person;
import lt.v.Salary;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em= ((EntityManagerFactory) emf).createEntityManager();
        Session session = em.unwrap(Session.class);
        em.getTransaction().begin();

        Person person =new Person("getras",49);
        session.save(person);

        Salary salary = new Salary (6644);
        salary.setId(person.getId());
        person.setSalary(salary);
        session.save(person);

        em.getTransaction().commit();
        Salary foundSalary=session.find(Salary.class,216);
        System.out.println(foundSalary.getId()+"-"+foundSalary.getPay());

        em.close();

    }
}
