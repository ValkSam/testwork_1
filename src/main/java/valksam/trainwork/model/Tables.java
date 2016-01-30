package valksam.trainwork.model;

/**
 * Created by Valk on 27.01.16.
 */
public enum Tables {
    TABLE_10("valksam.trainwork.model.Table_10"),
    TABLE_20("valksam.trainwork.model.Table_20");

    private String className;
    Tables(String className) {
        this.className = className;
    }

    public String getClassName(){
        return className;
    }
}
