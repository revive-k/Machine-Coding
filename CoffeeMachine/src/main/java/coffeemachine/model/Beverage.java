package coffeemachine.model;

import java.util.Map;

public class Beverage {
    private String name;
    private Map<String, Integer> ingredientQuantityMap;

    public Beverage(String name, Map<String, Integer> ingredientQuantityMap) {
        this.setName(name);
        this.setIngredientQuantityMap(ingredientQuantityMap);
    }

    public Map<String, Integer> getIngredientQuantityMap() {
        return ingredientQuantityMap;
    }

    public void setIngredientQuantityMap(Map<String, Integer> ingredientQuantityMap) {
        this.ingredientQuantityMap = ingredientQuantityMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
