package br.com.fatec.fatecstore;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToCadastro_usuario() throws IOException {
        App.setRoot("cadastro_usuario");
    }
}
