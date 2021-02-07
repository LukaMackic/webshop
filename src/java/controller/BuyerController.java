
package controller;

import model.Buyer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BuyerController {
    
    @RequestMapping(value = "/buyer", method = RequestMethod.GET)
    public String createBuyerForm(ModelMap model) {
        
        model.addAttribute("buyer", new Buyer());
        model.addAttribute("buyers", Buyer.selectBuyer());
        return "form_buyer";
    }
     @RequestMapping(value = "/buyer", method = RequestMethod.POST)
    public String addBuyer(@ModelAttribute("buyer") Buyer buyer, ModelMap model) {
        
    
        buyer.createBuyer();
          
        createBuyerForm(model);
        
        return "form_buyer";
    }
 @RequestMapping(value = "/updatebuyer", method = RequestMethod.GET)
    public String UpdateBuyerForm(ModelMap model) {
        model.addAttribute("buyer", new Buyer());
        model.addAttribute("buyers", Buyer.selectBuyer());
        return "form_UpdateBuyer";
    }
     @RequestMapping(value = "/updatebuyer", method = RequestMethod.POST)
    public String UpdateBuyer(@ModelAttribute("buyer") Buyer buyer, ModelMap model) {
        
        buyer.updateBuyer(buyer.getId(), buyer);
          
        UpdateBuyerForm(model);
        
        return "form_UpdateBuyer";
    }

    @RequestMapping(value = "/deletebuyer", method = RequestMethod.GET)
    public String DeleteBuyerForm(ModelMap model) {
        model.addAttribute("buyer", new Buyer());
        model.addAttribute("buyers", Buyer.selectBuyer());
        return "form_DeleteBuyer";
    }
     @RequestMapping(value = "/deletebuyer", method = RequestMethod.POST)
    public String DeleteBuyer(@ModelAttribute("buyer") Buyer buyer, ModelMap model) {
        
        buyer.deleteBuyer(buyer.getId());
          
        DeleteBuyerForm(model);
        
        return "form_DeleteBuyer";
    }
   
}
