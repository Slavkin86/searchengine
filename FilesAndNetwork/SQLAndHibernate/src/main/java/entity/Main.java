package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception{
        try{
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();


            String hql = "From " + Course.class.getSimpleName();
            List<Course> courseList1 = session.createQuery(hql).getResultList();
            for (Course course1 : courseList1){
                System.out.println(course1.getName() + " - " + course1.getPrice());
            }

            fillTable(session);



            transaction.commit();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fillTable(Session session) {
        List<PurchaseList> hql = session.createQuery("From " + PurchaseList.class.getSimpleName())
                .getResultList();
        for (PurchaseList a : hql) {

            DetachedCriteria studentsCriteria = DetachedCriteria.forClass(Student.class)
                    .add(Restrictions.eq("name", a.getStudentName()));
            Student student = (Student) studentsCriteria.getExecutableCriteria(session).list().stream()
                    .findFirst().get();

            DetachedCriteria coursesCriteria = DetachedCriteria.forClass(Course.class)
                    .add(Restrictions.eq("name", a.getCourseName()));
            Course course = (Course) coursesCriteria.getExecutableCriteria(session).list().stream()
                    .findFirst().get();
            System.out.println(course.getName());

            LinkedPurchaseList newTable = new LinkedPurchaseList(new Key(student.getId(), course.getId()), student, course,
                    course.getPrice(), a.getSubscriptionDate());
            session.save(newTable);
        }
    }
}
