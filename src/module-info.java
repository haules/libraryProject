module myProject {

    requires java.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires mysql.connector.java;
    requires  java.sql;

    opens com.MainControl;
}