import java.util.ArrayList;
import java.util.HashMap;

public class Table {
    private String tableName;
    private HashMap<String, Row> rows;

    public Table(String name){
        this.tableName = name;
        this.rows = new HashMap<>();
    }

    public String getName(){
        return tableName;
    }

    public void setName(String name){
        this.tableName = name;
    }

    public HashMap<String, Row> getRows(){
        return rows;
    }

    public void setRows(HashMap<String, Row> rows){
        this.rows = rows;
    }

    public boolean validateInput(HashMap<String, Object> columnsMap){
        for(var item : columnsMap.entrySet()){
            var v = item.getValue();
            var inputtype = v.getClass().getSimpleName();
            if(!inputtype.equals("Integer") && !inputtype.equals("String")){
                System.out.println("Input value should be Integer or String");
                return false;
            }
            if(inputtype.equals("String")){
                if(String.valueOf(v).length()>20){
                    System.out.println("Input value length should be less than 20");
                    return false;
                }
            }
            if(inputtype.equals("Integer")){
                int intval = (int)v;
                if(intval<-1024 || intval>1024){
                    System.out.println("Input value should be in range: -1024 to 1024");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean insert(String rowId, HashMap<String, Object> columnsMap){
        if (rows.containsKey(rowId)) {
            System.out.println("Duplicate primary key : " + " Insertion failed");
            return false;
        }
        var isValid = validateInput(columnsMap);
        if(!isValid){
            System.out.println("Input invalid");
            return false; 
        }
        Row row = new Row(rowId, columnsMap);
        rows.put(rowId, row);
        System.out.println("Row inserted.");
        return true;
    }

    public void updateRecord(String rowId, HashMap<String, Object> columnsMap){
        if (!rows.containsKey(rowId)) {
            System.out.println("RowId doesn't exist.");
            return;
        }
        Row row = rows.get(rowId);
        columnsMap.forEach((k,v)->{
            row.getColumnValueMap().put(k,v);
        });
        System.out.println("Row updated.");
    }

    public HashMap<String, Object> getSingleRecord(String rowId){
        return rows.get(rowId).getColumnValueMap();
    }

    public ArrayList<HashMap<String, Object>> getAllRecords(){
        ArrayList<HashMap<String, Object>> result  = new ArrayList<>();
        ArrayList<Row> rowonly = new ArrayList<>();
        rows.forEach((k,v)->{
            rowonly.add(v);
        });
        for(Row r : rowonly){
            result.add(r.getColumnValueMap());
        }
        return result;
    }

    public void deleteRecord(String rowId){
        if(!rows.containsKey(rowId)){
            System.out.println("RowId doesn't exist.");
            return;
        }
        rows.remove(rowId);
    }
}
