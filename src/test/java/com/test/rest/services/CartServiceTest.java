package com.test.rest.services;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.rest.models.Cart;
import com.test.rest.models.CartProduct;
import com.test.rest.models.Product;
import com.test.rest.populates.StartPopulate;


@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class CartServiceTest {
	
	@MockBean
	private StartPopulate startPopulate;
	
    private CartService cartService;

    private ProductService productService;
    
    private static Cart cartSaved ;
    
    
    @Autowired
    public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    
    @Test
    public void a_addProductToCartTest() {

        // cas 1 : créer un nouveau panier
        Cart cart =  new Cart();
        cart= cartService.saveOrUpdate(cart);
        assertNotNull(cart);
        assertTrue(cart.getId()>0);
        
        Product product = new Product();
        product.setDesignation("product1");
        product.setDescription("Junit Product Test");
        product.setPrice(20.0);
        product.setImageUrl("Test image url");

        //enregistrer le produit
        product = productService.saveOrUpdate(product);
        
        //Vérifier que le produit est enregistré
        assertNotNull(product);
        assertTrue(product.getId()>0);

        //enregistrer le panier
       cartSaved = cartService.addProductToCart(cart, product, 1);
       
       //vérifier que le panier est enregistré
       assertNotNull(cartSaved);
       assertTrue(cartSaved.getId()>0);
       
       //vérifier que le panier contient un cartproduct avec le bon panier et le bon produit
       assertNotNull(cartSaved.getCartProducts());
       assertEquals(cartSaved.getCartProducts().size(),1);
       assertNotNull(cartSaved.getCartProducts().get(0).getProduct());
       assertNotNull(cartSaved.getCartProducts().get(0).getProduct().getId());
       assertEquals(cartSaved.getCartProducts().get(0).getProduct().getId(),product.getId());
       
    }
    @Test
    public void a_removeProductFromCartTest() {
    	//recuperer cartProduct du produit à enlever du panier
    	CartProduct cartProduct = cartSaved.getCartProducts().get(0);
    	
    	//enlever le produit du panier
    	cartSaved = cartService.removeProductFromCart(cartProduct);
    	
    	//vérifier que le panier ne contient plus le produit
    	assertTrue(cartSaved.getCartProducts().isEmpty());
    	

       
    }



}
