package br.com.fatec.fatecstore;

import java.io.IOException;
import javafx.fxml.FXML;

public class Cadastro_usuarioController {

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
}