import java.util.HashMap;

public class Driver {
    public static void main(String[] args){
        String database = "MyDB";
        String table = "MyTable";
        HashMap<String, Object[]> data = new HashMap<>();

        data.put("Id", new Object[]{1,2,3});
        data.put("Name", new Object[]{"Vivek", "Ram", "Shyam"});
        data.put("Dept", new Object[]{"CSE", "ECE", "Civil"});
        data.put("Roll", new Object[]{23, 56, 12});

        DatabaseService dbs = new DatabaseService();
        dbs.createDatabase(database);
        dbs.createTable(table);
        dbs.insertintoTable(data);
        dbs.printRecords(table);
        dbs.matchRecords("Name", "Vivek");
    }
}
