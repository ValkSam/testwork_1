package valksam.trainwork.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Valk on 27.01.16.
 */

@Entity
@javax.persistence.Table(name = "TABLE_2")
public class Table_2 extends Table {
    @Column(name = "field2_1")
    private String field2_1;

    @Column(name = "field2_2")
    private Integer field2_2;

    @Column(name = "field2_3")
    private String field2_3;

    @Override
    public String toString() {
        return "Table_2{" +
                "field2_1='" + field2_1 + '\'' +
                ", field2_2='" + field2_2 + '\'' +
                ", field2_3='" + field2_3 + '\'' +
                '}';
    }
}
