module br.com.fatec.fatecstore {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.fatec.fatecstore to javafx.fxml;
    exports br.com.fatec.fatecstore;
}
