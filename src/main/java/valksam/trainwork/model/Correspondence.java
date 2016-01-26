package valksam.trainwork.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Valk on 25.01.16.
 */
public class Correspondence {
    private StringProperty columnInFile;
    private StringProperty columnInDataTable;

    public Correspondence(String columnInFile) {
        this.columnInFile = new SimpleStringProperty(columnInFile);
        this.columnInDataTable = new SimpleStringProperty(columnInFile);
    }

    public StringProperty getColumnInFile() {
        return columnInFile;
    }

    public void setColumnInFile(String columnInFile) {
        this.columnInFile.set(columnInFile);
    }

    public StringProperty getColumnInDataTable() {
        return columnInDataTable;
    }

    public void setColumnInDataTable(String columnInDataTable) {
        this.columnInDataTable.set(columnInDataTable);
    }
}
