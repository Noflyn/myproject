package com.dresses.controller;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dresses.model.Product;
import com.dresses.service.ProductServiceImpl;




@Controller
public class ProductController {
	
	private Path path;  
	private ResourceLoader load;
	@Autowired
	ProductServiceImpl  productService;
 
	
	 @Autowired
	    public void setProductService(ProductServiceImpl productService){
	    	this.productService = productService;
	    }
	 
	 @RequestMapping("/list")
		public String listProduct(Model model) {
			model.addAttribute("productlist",productService.listProduct());
			return "productlist";
			}
			
			@RequestMapping("/products")
		    public ModelAndView createProduct() {
		        ModelAndView model = new  ModelAndView("productspage");
		        model.addObject("product", new Product());
		        return model;
		    }
			
			@RequestMapping(value="/add", method=RequestMethod.POST)
			public String addProduct(@ModelAttribute("product") Product product,MultipartFile file, HttpServletRequest request, BindingResult res)
			{
				
				System.out.println("test1");	
			
				if(product.getId()==0){									
					
					productService.addProduct(product);			
					
					 MultipartFile productImage = product.getProductimage();					 
				        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
				        System.out.println("TEST1gggggggggggg" +rootDirectory);	
//				        path = Paths.get(rootDirectory + "WEB-INF/resources/images/"+product.getProductId()+".png");
				        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/"+product.getId()+".jpg");
				      //  file.getOriginalFilename().getBytes();
				        System.out.println("path.toString()  dddddddddddddddddd  " +path.toString());	
				        if (productImage != null && !productImage.isEmpty()) {
				            try {
				            	productImage.transferTo(load.getResource("/resources/images/"+product.getId()+".jpg").getFile());
				           //     productImage.transferTo(new File(path.toString()));
				            } catch (Exception e) {
				                e.printStackTrace();
				                throw new RuntimeException("Product image saving failed.", e);
				            }
				        }
					
				}
				else{
										
					productService.updateProduct(product);
					 MultipartFile productImage = product.getProductimage();
				        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//				        path = Paths.get(rootDirectory + "WEB-INF/resources/images/"+product.getProductId()+".png");
				        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getId()+".png");


				        if (productImage != null && !productImage.isEmpty()) {
				            try {
				                productImage.transferTo(new File(path.toString()));
				            } catch (Exception e) {
				                e.printStackTrace();
				                throw new RuntimeException("Product image saving failed.", e);
				            }
				        }
				}
				System.out.println("test1");
					return "redirect:/list";
				
				} 
			
			@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
			public String showProductPage(@PathVariable("id") int id, Model model,final RedirectAttributes redirectAttributes) {
				Product product = productService.getbyid(id);
				model.addAttribute("product", product);
				return "productspage";

			}
			
			 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
			 public String delete(@PathVariable("id") int id,Product product) {
			  System.out.println("TEST");
			  Path path=Paths.get("E:/Ecp/workspace//src/main/webapp/WEB-INF/resources/" + product.getName()+ ".png");
				if(Files.exists(path))
						{
					           try {
								Files.delete(path);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}

			  productService.deleteProduct(id);
			  return "home";
			 }

			 @RequestMapping("/viewProduct/{id}")
			    public String viewProduct(@PathVariable int id, Model model) throws IOException {
			        Product product=productService.getbyid(id);
			        model.addAttribute("product", product);
			        return "viewProduct";
			    }

			
}
