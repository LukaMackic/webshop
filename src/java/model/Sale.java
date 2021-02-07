
package model;

import hibernateUtil.HibernateUtil;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
@Table(name= "sale")
public class Sale {

   
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantity;
    private double price;
    private int buyer_id;
    private int product_id;
    
       public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    
      public void createSale() {
      Session sesija = HibernateUtil.createSessionFactory().openSession();

        Sale s = new Sale();

        Transaction tx = null;
        Product p  = (Product) sesija.get(Product.class, product_id);
        Buyer b = (Buyer) sesija.get(Buyer.class , buyer_id);
       if (quantity !=0 && p !=null && b != null && p.getQuantity()>quantity) {
         s.setBuyer_id(buyer_id);
         s.setProduct_id(product_id);
         s.setPrice(p.getPrice()*quantity);
         s.setQuantity(quantity);
         
            try {
                tx = sesija.beginTransaction();

                sesija.save(s);
             p.setQuantity(p.getQuantity()-quantity);
             sesija.update(p);
                tx.commit();

            } catch (Exception ex) {
                System.out.println(ex);
            } finally {

                sesija.close();

          }

        }

    }

  


    
    
}
