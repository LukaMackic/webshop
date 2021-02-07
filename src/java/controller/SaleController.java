
package controller;

import model.Buyer;
import model.Login;
import model.Product;
import model.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaleController {
    public int buyerId;
    
    
    
     @RequestMapping(value = "/sale", method = RequestMethod.GET)
    public String createSaleForm(ModelMap model ) {
        
        model.addAttribute("sale", new Sale());
        model.addAttribute("products", Product.selectProducts());
        return "form_Sale";
    }
     @RequestMapping(value = "/sale", method = RequestMethod.POST)
    public String addSale(@ModelAttribute("sale") Sale sale, ModelMap model) {
        
        sale.setBuyer_id(buyerId);
        sale.createSale();
          
        createSaleForm(model);
        
        return "form_Sale";
    }
    
      @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String createLoginForm(ModelMap model) {
        
        model.addAttribute("login", new Login());
        model.addAttribute("buyers", Buyer.selectBuyer());
        return "form_login";
    }
     @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String addLogin(@ModelAttribute("login") Login login, ModelMap model) {
        
    
       if(login.Log().equals("logedin"))
       {
             buyerId = login.getId();
             createSaleForm(model);
             return"form_Sale";
       }
       else 
           createLoginForm(model);
        return "form_login";
    }
}
