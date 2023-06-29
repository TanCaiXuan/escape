module com.caixuan.assignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.caixuan.assignment to javafx.fxml;
    exports com.caixuan.assignment;
}