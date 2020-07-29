
package Graphics;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RenderCelda extends JLabel implements TableCellRenderer {

    int Row,Columns;
    public void setRow(int Row){
        this.Row=Row;
    }
    public void setColumns(int Columns){
        this.Columns=Columns;
    }
    public RenderCelda() {
        //setOpaque(true); // Permite que se vea el color en la celda del JLabel
    }
    
    public void cellsBackToNormal(){
        this.Row = -9999;
        this.Columns = -9999;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        if(Row == -9999 && Columns == -9999){
            setForeground(Color.black); // Una condicion arbitraria solo para pintar el JLabel que esta en la celda.
            setText(String.valueOf(value)); // Se agrega el valor que viene por defecto en la celda
        } else {
            if((row == Row)&& (column == Columns)){
                setForeground(Color.red); // Una condicion arbitraria solo para pintar el JLabel que esta en la celda.
                setText(String.valueOf(value)); // Se agrega el valor que viene por defecto en la celda
            }
        }
        return this;
    }
 }
