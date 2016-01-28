package valksam.trainwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Valk on 27.01.16.
 */
@Entity
@javax.persistence.Table(name="TABLE_1")
public class Table_1 extends Table {
    @Column(name = "field1_1")
    private String field1_1;

    @Column(name = "field1_2")
    private String field1_2;

    @Column(name = "field1_3")
    private String field1_3;

    @Override
    public String toString() {
        return "Table_1{" +
                "field1_1='" + field1_1 + '\'' +
                ", field1_2='" + field1_2 + '\'' +
                ", field1_3='" + field1_3 + '\'' +
                '}';
    }
}
