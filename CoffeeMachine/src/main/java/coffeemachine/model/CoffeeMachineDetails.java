package coffeemachine.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoffeeMachineDetails {

    @JsonProperty("machine")
    private Machine machine;

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }


}
