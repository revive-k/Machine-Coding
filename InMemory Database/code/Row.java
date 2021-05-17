import java.util.HashMap;

public class Row{
    private String rowId;
    private HashMap<String, Object> columnValueMap;
    
    public Row(String rowId, HashMap<String, Object> columnValueMap){
        this.rowId = rowId;
        this.columnValueMap = columnValueMap;
    }

    public String getRowId(){
        return rowId;
    }

    public void setRowId(String rowId){
        this.rowId = rowId;
    }

    public HashMap<String, Object> getColumnValueMap(){
        return columnValueMap;
    }

    public void setColumnValueMap(HashMap<String, Object> columnValueMap){
        this.columnValueMap = columnValueMap;
    }
}