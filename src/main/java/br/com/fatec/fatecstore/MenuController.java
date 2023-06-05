/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.fatecstore;

import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Henri
 */
public class MenuController implements Initializable {
    
    @FXML
    private Button btnCadastrarVendedor;

    @FXML
    private Button btnConsultaAvancada;

    @FXML
    private Button btnCadastrarProduto;

    @FXML
    private Button btnVendas;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnEditarDados;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void switchToCadastroProduto() throws IOException {
        App.setRoot("cadastro_produto");
    }
    
    @FXML
    private void btnLogout() throws IOException {
        App.setRoot("login");
    }
    
}
