module com.infaq.infaqmasjidplus {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.infaq.infaqmasjidplus to javafx.fxml;
    exports com.infaq.infaqmasjidplus;
}