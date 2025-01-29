package app.model;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import app.model.Ingredient;
import app.model.Ingredient.Type;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortolla", Type.WRAP));
        ingredientMap.put("BEEF", new Ingredient("BEEF", "Beef", Type.PROTEIN));
        ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", Type.SAUCE));
        ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Type.CHEESE));
        ingredientMap.put("LTCE", new Ingredient("LTCE", "Lettuce", Type.VEGGIES));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
