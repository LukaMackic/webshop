package model;

import hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String pasword) {
        this.password = pasword;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   
  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    public static String selectBuyer() {
        StringBuilder buyers = new StringBuilder();
        buyers.append("id   name                surname             email\n");
        buyers.append("----------------------------------------------------------------------------------------------------\n");

        Session sesija = HibernateUtil.createSessionFactory().openSession();
        List<Buyer> buyers_collection = new ArrayList();
        Query query = sesija.createQuery("from Buyer");
        buyers_collection = query.list();
        for (int i = 0; i < buyers_collection.size(); i++) {
            buyers.append(buyers_collection.get(i).toString() + "\n");

        }

        return buyers.toString();

    }

    
    
    @Override
    public String toString() {
        int nameL = name.length();
        String nameSpace = "";
        for (int i = 0; i < 20 - nameL; i++) {
            nameSpace = nameSpace.concat(" ");
        }
        int surnameL = surname.length();
        String surnameSpace = "";
        for (int i = 0; i < 20 - surnameL; i++) {
            surnameSpace = surnameSpace.concat(" ");
        }

        return id + "    " + name + nameSpace + surname + surnameSpace + email;
    }

    
    
    public void createBuyer() {
        Session sesija = HibernateUtil.createSessionFactory().openSession();

        Buyer b = new Buyer();

        Transaction tx = null;

        if (name != null && !(name.isEmpty()) && surname != null && !(surname.isEmpty()) && email != null && !(email.isEmpty()) && password!=null && !(password.isEmpty())) {
            b.setName(name);
            b.setSurname(surname);
            b.setEmail(email);
            b.setPassword(password);

            try {
                tx = sesija.beginTransaction();

                sesija.save(b);
            
                tx.commit();

            } catch (Exception ex) {
                System.out.println(ex);
            } finally {

                sesija.close();

            }

        }

    }

    
    
    public void deleteBuyer(int id) {
        Session sesija = null;
        try {
            sesija = HibernateUtil.createSessionFactory().openSession();

            Buyer b = (Buyer) sesija.get(Buyer.class, id);
            Transaction tx = null;
            try {
                tx = sesija.beginTransaction();

                sesija.delete(b);

                tx.commit();
            } catch (HibernateException eh) {
                if (tx != null) {
                    tx.rollback();
                }

            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            sesija.close();
        }

    }

    
    
    public void updateBuyer(int id, Buyer buyer) {
        Session sesija = null;
        try {
            sesija = HibernateUtil.createSessionFactory().openSession();

            Buyer b = (Buyer) sesija.get(Buyer.class, id);

           if (buyer.getName() != null && !(name.isEmpty())) {
                b.setName(buyer.getName());
            }

            if (buyer.getSurname() != null && !(surname.isEmpty())) {
                b.setSurname(buyer.getSurname());
            }
            if (buyer.getEmail() != null && !(email.isEmpty())) {
                b.setEmail(buyer.getEmail());
            }

            Transaction tx = null;
            try {
                tx = sesija.beginTransaction();

                sesija.update(b);

                tx.commit();
            } catch (HibernateException eh) {
                if (tx != null) {
                    tx.rollback();
                }

            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            sesija.close();
        }

    }

}
