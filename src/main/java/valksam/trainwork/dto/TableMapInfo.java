package valksam.trainwork.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.collections.ObservableList;
import valksam.trainwork.model.Correspondence;

/**
 * Created by Valk on 27.01.16.
 */
@JsonAutoDetect
public class TableMapInfo {
    @JsonProperty("XlsFileName")
    private String XlsFileName;

    @JsonProperty("TableName")
    private String TableName;

    @JsonProperty("Correspondences")
    private ObservableList<Correspondence> correspondencesTable;

    public TableMapInfo() {
    }

    public TableMapInfo(String xlsFileName, String tableName, ObservableList<Correspondence> correspondencesTable) {
        XlsFileName = xlsFileName;
        TableName = tableName;
        this.correspondencesTable = correspondencesTable;
    }
}
