/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.fatecstore;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Henri
 */
public class VendaController implements Initializable {
    
    @FXML
    private ComboBox<?> cbMarca;

    @FXML
    private ComboBox<?> cbModelo;

    @FXML
    private Label lbValor;

    @FXML
    private TextField txtCPFCliente;

    @FXML
    private TextField txtIDVendedor;

    @FXML
    private TextField txtQuantidade;

    /**
     * Initializes the controller class.
     */
    
    private void limpaCampos(){
        txtCPFCliente.setText("");
        txtIDVendedor.setText("");
        txtQuantidade.setText("");
        cbMarca.getSelectionModel().clearSelection();
        cbModelo.getSelectionModel().clearSelection();
        lbValor.setText("---");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToCadastroProduto() throws IOException {
        App.setRoot("cadastro_produto");
    }
    
    @FXML
    private void switchToEditarDados() throws IOException {
        App.setRoot("editar_dados");
    }
    
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }
    
    @FXML
    private void switchToConsultaAvancada() throws IOException {
        App.setRoot("consulta_avancada");
    }
    
    @FXML
    private void switchToCadastrarVendedor() throws IOException {
        App.setRoot("cadastrar_vendedor");
    }
    
    @FXML
    private void btnLogout() throws IOException {
        App.setRoot("login");
    }
    
    @FXML
    private void btnConfirmar() throws IOException {
        
        this.limpaCampos();
    }
    
    @FXML
    private void btnCancelar() throws IOException {
        this.limpaCampos();
    }
}
