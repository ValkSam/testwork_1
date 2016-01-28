package valksam.trainwork.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Valk on 27.01.16.
 */

@Entity
@javax.persistence.Table
public class Table_2 implements Table {
    @Column(name = "field2_1")
    private String field1_1;

    @Column(name = "field2_2")
    private String field1_2;

    @Column(name = "field2_3")
    private String field1_3;
}
