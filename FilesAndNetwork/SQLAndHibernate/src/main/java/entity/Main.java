package entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        int changedRows = session.createQuery(Queries.fillLinkedPurchaseList).executeUpdate();

        System.out.println(changedRows);

        transaction.commit();

        LinkedPurchaseList.LinkedPurchaseListId id = new LinkedPurchaseList.LinkedPurchaseListId(1,2);

        LinkedPurchaseList list = session.get(LinkedPurchaseList.class, id);

        System.out.println(list.getStudent().getName() + " " + list.getCourse().getName());
        System.out.println("Test Subscription");

        Subscription.SubscriptionId subscriptionId = new Subscription.SubscriptionId (2, 11);

        Subscription subscription =  session.get(Subscription.class, subscriptionId);

        System.out.println(subscription.getCourse().getName() + " " + subscription.getStudent().getName() + " " + subscription.getSubscriptionDate());

        System.out.println("Test PurchaseList");

        PurchaseList.PurchaseListId purchaseListId = new PurchaseList.PurchaseListId("Квасников Емельян", "Рекламная графика");
        PurchaseList purchaseList = session.get(PurchaseList.class, purchaseListId);

        System.out.println(purchaseList.getCourseName() + " " +  purchaseList.getPrice()  + " " +  purchaseList.getSubscriptionDate());
        sessionFactory.close();

    }
}