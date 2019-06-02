package com.test.rest.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.test.rest.models.Product;
import com.test.rest.services.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	
	@MockBean
	private ProductService productService;
	
	
	 @Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void getProductsByCatalogIdTest() throws Exception{
		
		Integer catalogId=1;
		
		List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        
        //simuler l'appel au webservice productsbycatalog et vérifier qu'il retourne status ok et une liste de 2 produits
        when(productService.getProductsByCatalogId(catalogId)).thenReturn((List) products); 
		mockMvc.perform(get("/rest/product/productsbycatalog/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
		
	}
	
	@Test
    public void GetProductByIdTest() throws Exception{
        Integer id = 1;

        when(productService.getById(id)).thenReturn(new Product("prod1", "produit pour test", 40.0, "image.jpg"));
//simuler l'appel du webservice productsbyid avec pathvariable id=1 et vérifier qu'il nous retourne la réponse attendue
        mockMvc.perform(get("/rest/product/productsbyid/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.designation").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.designation").value("prod1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("produit pour test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(40.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.imageUrl").value("image.jpg"));
    }

}
