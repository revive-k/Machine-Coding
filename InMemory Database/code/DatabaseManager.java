import java.util.HashMap;

public class DatabaseManager {
    private HashMap<String, Database> databases;

    DatabaseManager(){
        this.databases = new HashMap<>();
    }

    public void createDB(String name){
        if(databases.containsKey(name)){
            System.out.println("Database with this name already exists");
            return;
        }
        Database db = new Database(name);
        databases.put(name, db);
        System.out.println("DB created.");
    }

    public void deleteDB(String name){
        if(!databases.containsKey(name)){
            System.out.println("Databse with this name doesn't exist");
            return;
        }
        databases.remove(name);
    }

    public HashMap<String, Database> getDatabases(){
        return databases;
    }
}
