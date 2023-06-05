package br.com.fatec.fatecstore;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.event.ActionEvent;

public class LoginController {

    
    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label title;

        
    @FXML
    private void switchToCadastroUsuario() throws IOException {
        App.setRoot("cadastro_usuario");
    }
    
    @FXML
    private void btnLogin() throws IOException {
        App.setRoot("menu");
    }
}
    
    
