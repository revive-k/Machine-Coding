import java.util.HashMap;

public class Database {
    private String dbName;
    private HashMap<String, Table> tables;

    public Database(String name){
        this.dbName = name;
        this.tables = new HashMap<>();
    }

    public String getDbName(){
        return dbName; 
    }

    public void setDbName(String name){
        this.dbName = name;
    }

    public HashMap<String, Table> getTables(){
        return tables;
    }

    public void setTables(HashMap<String, Table> tables){
        this.tables = tables;
    }

    public void createTable(String tableName){
        if(tables.containsKey(tableName)){
            System.out.println("Table with this name already exists");
            return;
        }
        Table table = new Table(tableName);
        tables.put(tableName, table);
        System.out.println("Table created.");
    }

    public void deleteTable(String tableName){
        if(!tables.containsKey(tableName)){
            System.out.println("Table with this name doesn't exist");
            return;
        }
        tables.remove(tableName);
    }
}
