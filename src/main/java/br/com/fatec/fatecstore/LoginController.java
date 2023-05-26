package br.com.fatec.fatecstore;

import javafx.fxml.FXML;
import java.io.IOException;

public class LoginController {

    @FXML
    private void switchToCadastroUsuario() throws IOException {
        App.setRoot("cadastro_usuario");
    }
    
    @FXML
    private void btnLogin() throws IOException {
        App.setRoot("menu");
    }
}
