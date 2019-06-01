package com.test.rest.services;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.rest.config.TestConfig;
import com.test.rest.models.Product;
import com.test.rest.populates.StartPopulate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class ProductServiceTest {
	@MockBean
	private StartPopulate startPopulate;

    private ProductService productService;
    private static Product savedProduct;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @Test
    public void a_saveOrUpdateTest() {

        // cas 1 : créer un nouveau produit
        Product product =  new Product();
        product.setDesignation("product1");
        product.setDescription("Junit Product Test");
        product.setPrice(20.0);
        product.setImageUrl("Test image url");

        //enregistrer le produit
        savedProduct = productService.saveOrUpdate(product);
        
        //Vérifier que le produit enregistré à les mêmes attributs que le produit crée
        assertNotNull(savedProduct);
        assertEquals(savedProduct.getDesignation(), "product1");
        assertTrue(savedProduct.getId()>0);
        assertEquals(savedProduct.getDescription(),"Junit Product Test");
        assertEquals(savedProduct.getImageUrl(),"Test image url");

        // case2 : modifier le produit
        //on modifie sa description
        savedProduct.setDescription("Junit Product Updated");
        
        //enregistrer le produit après sa modification
        Product savedProduct2 = productService.saveOrUpdate(savedProduct);

        //vérifier que c'est le meme produit
        assert  savedProduct2.getId()== savedProduct.getId();
        
        //vérifier que la description est bien changée
        assert  savedProduct2.getDescription().equals("Junit Product Updated");

    }
  @Test
  public void b_listAllProductsTest() {
	  //recuperer la liste des produits
      List<Product> list = (List<Product>) productService.listAll();
      
      //vérifier qu'on a un seul produit
      assertEquals(list.size(), 1);  
  }
    

    @Test
    public void c_deleteOrUpdateTest() {
        // supprimer le produit
        productService.delete(savedProduct.getId());
        
        //récuperer tous le produits
        List<Product> list = (List<Product>) productService.listAll();
        
        //vérifier qu'il n y a plus de produit
        assertEquals(list.size(), 0);  


    }

}
