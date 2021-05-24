package coffeemachine.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Outlet {
    @JsonProperty("count_n")
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
