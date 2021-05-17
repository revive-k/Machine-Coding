import java.util.HashMap;

public class DatabaseService {
    private DatabaseManager dbmanager;
    private Database db;
    private Table tb;
    private static String dbname;
    private static String tbname;

    public void selectDatabase(String dbname){
        DatabaseService.dbname = dbname;
    }

    public void selectTable(String tbname){
        DatabaseService.tbname = tbname;
    }

    public void createDatabase(String name){
        dbmanager = new DatabaseManager();
        dbmanager.createDB(name);
        dbname = name;
    }

    public void createTable(String name){
        db = dbmanager.getDatabases().get(dbname);
        db.createTable(name);
        tbname = name;
    }

    public void deleteTable(String name){
        db = dbmanager.getDatabases().get(dbname);
        db.deleteTable(name);
    }

    public void insertintoTable(HashMap<String, Object[]> data){
        db = dbmanager.getDatabases().get(dbname);
        tb = db.getTables().get(tbname);
        int tablesize = tb.getRows().size();
        int datasize = data.entrySet().iterator().next().getValue().length;
        for(int i=0;i<datasize;i++){
            HashMap<String, Object> row = new HashMap<>();
            int j = i;
            data.forEach((k,v)->{
                row.put(k, v[j]);
            });
            var isInserted = tb.insert(String.valueOf(tablesize), row);
            if(!isInserted){
                return;
            }
            tablesize++;
        }
    }

    public void printRecords(String tableName){
        db = dbmanager.getDatabases().get(dbname);
        tb = db.getTables().get(tableName);
        var records = tb.getAllRecords();
        System.out.println("---- Printing table ---- " + tableName);
        for(var item : records){
            System.out.println(item);
        }
    }

    public void matchRecords(String column, Object value){
        System.out.println("---- Matching record --- ");
        db = dbmanager.getDatabases().get(dbname);
        tb = db.getTables().get(tbname);
        int tbsize = tb.getRows().size();
        for(int i=0;i<tbsize;i++){
            var record = tb.getSingleRecord(String.valueOf(i));
            if(record.containsKey(column) && record.get(column)==value){
                System.out.println(record);
            }
        }
    }
}
