module br.edu.ifsp {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens br.edu.ifsp to javafx.fxml;
    exports br.edu.ifsp;
}
