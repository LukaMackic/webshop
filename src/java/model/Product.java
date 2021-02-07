
package model;

import hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


@Entity
@Table(name = "product")
public class Product {

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int quantity;
    private double price;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void createProduct() {
      Session sesija = HibernateUtil.createSessionFactory().openSession();

      Product p  = new Product();

        Transaction tx = null;

        if (name != null && !(name.isEmpty()) && price != 0 && quantity != 0) {
         p.setName(name);
         p.setPrice(price);
         p.setQuantity(quantity);

            try {
                tx = sesija.beginTransaction();

                sesija.save(p);
             
                tx.commit();

            } catch (Exception ex) {
                System.out.println(ex);
            } finally {

                sesija.close();

            }

        }

    }

    public void updateProduct(int id, Product product) {
        Session sesija = null;
        try {
            sesija = HibernateUtil.createSessionFactory().openSession();

           Product p  = (Product) sesija.get(Product.class, id);

            if (product.getName() != null && !(name.isEmpty())) {
                p.setName(product.getName());
            }

            if (product.getPrice() !=0) {
                p.setPrice(product.getPrice());
            }
      
            if (product.getQuantity() != 0) {
                p.setQuantity(product.getQuantity());
            }

            Transaction tx = null;
            try {
                tx = sesija.beginTransaction();

                sesija.update(p);

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

    public void deleteProduct(int id) {
        Session sesija = null;
        try {
            sesija = HibernateUtil.createSessionFactory().openSession();

           Product p = (Product) sesija.get(Product.class, id);
            Transaction tx = null;
            try {
                tx = sesija.beginTransaction();

                sesija.delete(p);

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
       public static Object selectProducts() {
         StringBuilder products= new StringBuilder();
       products.append("id   name                price             quantity\n");
       products.append("----------------------------------------------------------------------------------------------------\n");

        Session sesija = HibernateUtil.createSessionFactory().openSession();
        List<Product> products_collection = new ArrayList();
        Query query = sesija.createQuery("from Product");
        products_collection = query.list();
        for (int i = 0; i < products_collection.size(); i++) {
            products.append(products_collection.get(i).toString() + "\n");

        }

        return products.toString();
    }
    
  @Override
    public String toString() {
        int nameL = name.length();
        String nameSpace = "";
        for (int i = 0; i < 20 - nameL; i++) {
            nameSpace = nameSpace.concat(" ");
        }
        return id + "    " + name + nameSpace + price + "               " + quantity ;
    }
   
}
