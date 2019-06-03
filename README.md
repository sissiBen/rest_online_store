# rest_online_store
C'est un API REST implémenté avec Spring Boot qui permet de faire les scénarios suivants: 
• Afficher un catalogue de produits (rest/product/productsbycatalog/{catalogId})
• Afficher le détail d’un produit (rest/product/productsbyid/{productId})
• Ajouter un produit au panier (rest/cart/addproduct)
• Enlever un produit du panier (rest/cart/removeproduct)
• Afficher le contenu du panier (rest/cart/cartdetails/{cartId})
• Connexion et déconnexion à un compte utilisateur

En supposant qu'un produit ne peut appartenir qu'à un seul catalogue et qu'un panier (Cart) peut avoir 0 ou plusieurs produits, 
et un produit peut être ajouté à 0 ou plusieurs paniers.

H2 est l'SGBD utilisé (in memory)

Au lancement de l'application quelques données sont populé dans la classe "StartPopulate" pour pouvoir effectuer quelques tests.

Pour la connexion à un compte utilisateur veuillez utiliser  ( username:admin, password: admin), à part la modification du username et du mot de pass
l'autoconfiguration de spring security est utilisé

Il y'a quelques examples de tests unitaire et d'intégration: ProductControllerTest, CartServiceTest, ProductServiceTest

Il y'a des améliorations possibles dans le futur  comme :
 ajouter des webservice pour la CRUD de produits,des catalogues ...
 Gerer les commandes 
 Gerer les utilisateurs,les roles et la création d'un panier pour chaque utilisateur ajouté.
 Faire des tests unitaires et d'integrations pour tous les services.
