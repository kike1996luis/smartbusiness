
package Code;

public class Cell {
    
    Object[] column;
    int row;
    String function;
    String value;
    
    public Cell(Object[] column, int row, String function) {
        this.column = column;
        this.row = row;
        this.function = function;
    }
    
    public Object[] getColumn(){
        return column;
    }
    
    public int getRow() {
        return row;
    }
    
    public String getFunction() {
        return function;
    }
    
    public void setColumn(Object[] column) {
        this.column = column;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public void setFunction(String function) {
        this.function = function;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}
