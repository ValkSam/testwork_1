package valksam.trainwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Valk on 27.01.16.
 */
@Entity
@javax.persistence.Table
public class Table_1 implements Table {
    @Column(name = "field1_1")
    private String field1_1;

    @Column(name = "field1_2")
    private String field1_2;

    @Column(name = "field1_3")
    private String field1_3;

    
}
