package valksam.trainwork.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import valksam.trainwork.model.Correspondence;

/**
 * Created by Valk on 27.01.16.
 */
@JsonAutoDetect
public class MappingInfoItem {
    @JsonProperty("source")
    private String source;

    @JsonProperty("destination")
    private String destination;

    public MappingInfoItem() {
    }

    public MappingInfoItem(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }
}
