package valksam.trainwork.model;

import javax.persistence.*;

/**
 * Created by Valk on 27.01.16.
 */

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class Table {

    @Id
    @GeneratedValue
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
