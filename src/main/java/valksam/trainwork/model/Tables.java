package valksam.trainwork.model;

/**
 * Created by Valk on 27.01.16.
 */
public enum Tables {
    TABLE_1("valksam.trainwork.model.Table_1"),
    TABLE_2("valksam.trainwork.model.Table_2");

    private String className;
    Tables(String className) {
        this.className = className;
    }

    public String getClassName(){
        return className;
    }
}
