package valksam.trainwork.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import valksam.trainwork.model.Correspondence;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Valk on 25.01.16.
 */
public class DataStorage {
    public static final ObservableList<Correspondence> correspondencesTable = FXCollections.observableArrayList();
    public static final Map<Integer, String> columnsMap = new TreeMap<>();
    public static final Correspondence correspondence = new Correspondence("");

}
