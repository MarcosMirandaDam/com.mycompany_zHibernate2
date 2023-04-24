
package com.mycompany.zhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Marcos Miranda
 */
public class ZHibernate {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Barco barco = new Barco("Barco118", 28.5f);      
            Amarre amarre = new Amarre(8);

            barco.setAmarre(amarre);
            amarre.setBarco(barco);

            session.save(barco);
            session.save(amarre);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
