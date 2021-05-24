package coffeemachine.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;

public class Machine {
    @JsonProperty("outlets")
    private Outlet outlets;

    @JsonProperty("total_items_quantity")
    private HashMap<String, Integer> ingredientQuantityMap;

    @JsonProperty("beverages")
    private HashMap<String, HashMap<String, Integer>> beverages;

    public Outlet getOutlets() {
        return outlets;
    }

    public HashMap<String, HashMap<String, Integer>> getBeverages() {
        return beverages;
    }

    public HashMap<String, Integer> getIngredientQuantityMap() {
        return ingredientQuantityMap;
    }

    public void setIngredientQuantityMap(HashMap<String, Integer> ingredientQuantityMap) {
        this.ingredientQuantityMap = ingredientQuantityMap;
    }

    public void setBeverages(HashMap<String, HashMap<String, Integer>> beverages) {
        this.beverages = beverages;
    }

    public void setOutlets(Outlet outlets) {
        this.outlets = outlets;
    }

}
