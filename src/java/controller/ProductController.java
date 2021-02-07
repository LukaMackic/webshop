
package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
      @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String createProductForm(ModelMap model) {
        
        model.addAttribute("product", new Product());
        model.addAttribute("products", Product.selectProducts());
        return "form_product";
    }
     @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, ModelMap model) {
        
    
       product.createProduct();
         
        createProductForm(model);
        
        return "form_product";
    }
 @RequestMapping(value = "/updateproduct", method = RequestMethod.GET)
    public String UpdateProductForm(ModelMap model) {
        model.addAttribute("product", new Product());
        model.addAttribute("products", Product.selectProducts());
        return "form_UpdateProduct";
    }
     @RequestMapping(value = "/updateproduct", method = RequestMethod.POST)
    public String UpdateBuyer(@ModelAttribute("product") Product product, ModelMap model) {
        
       product.updateProduct(product.getId(), product);
          
        UpdateProductForm(model);
        
        return "form_UpdateProduct";
    }

    @RequestMapping(value = "/deleteproduct", method = RequestMethod.GET)
    public String DeleteProductForm(ModelMap model) {
        model.addAttribute("product", new Product());
        model.addAttribute("products", Product.selectProducts());
        return "form_DeleteProduct";
    }
     @RequestMapping(value = "/deleteproduct", method = RequestMethod.POST)
    public String DeleteBuyer(@ModelAttribute("product") Product product, ModelMap model) {
        
      product.deleteProduct(product.getId());
          
        DeleteProductForm(model);
        
        return "form_DeleteProduct";
    }
   
}
