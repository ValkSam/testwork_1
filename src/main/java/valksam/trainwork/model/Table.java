package valksam.trainwork.model;

import javax.persistence.*;

/**
 * Created by Valk on 27.01.16.
 */

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
