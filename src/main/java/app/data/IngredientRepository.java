package app.data;

import app.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IngredientRepository extends JpaRepository<Ingredient, String> {}
