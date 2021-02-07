
package model;

import hibernateUtil.HibernateUtil;
import org.hibernate.Session;


public class Login {
    
    private int id;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public  String Log() {
     
        Session sesija = HibernateUtil.createSessionFactory().openSession();
          
        Buyer b = (Buyer) sesija.get(Buyer.class , id);
       
        if(b!= null && b.getPassword().equals(password))
        {
           
            return "logedin";
        }
       
        return "wrong";
    }
    
}
