package coffeemachine;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coffeemachine.tasks.CoffeeMachine;

public class CoffeeMachineApplication {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeMachine.class);

    /*Running test cases*/
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            logger.error("Input file name required");
        }
        final String filePath = "input1.json";
        File file = new File(CoffeeMachine.class.getClassLoader().getResource(filePath).getFile());
        String jsonInput = FileUtils.readFileToString(file, "UTF-8");
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance(jsonInput);
        coffeeMachine.process();
        coffeeMachine.reset();
    }
}
