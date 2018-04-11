
package naivgationdrawer.Interface;

import naivgationdrawer.Entite.Categories;
import java.util.ArrayList;
import java.util.List;


public interface ICategories {
     public boolean ajouterCategorie(Categories C);
     public boolean modifierCategorie(Categories C);
     public boolean supprimerCategorie(Categories Categorie);
     ArrayList<Categories> afficher();
     ArrayList <Categories> select();
     ArrayList <Categories> list();
     public List<Categories> listar();
     public boolean alterar(Categories Categorie);
      Categories buscar(Categories Categorie);
    
}
