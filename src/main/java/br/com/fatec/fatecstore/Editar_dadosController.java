/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.fatecstore;

import br.com.fatec.fatecstore.DAO.ProdutoDAO;
import br.com.fatec.fatecstore.MODEL.Produto;
import br.com.fatec.fatecstore.PERSISTENCIA.Banco;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Henri
 */
public class Editar_dadosController implements Initializable {
    
    @FXML
    private ComboBox<String> cbModelo;

    @FXML
    private ComboBox<String> cbMarca;
    
    @FXML
    private TextField txtValor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Banco.conectar();
        } catch (SQLException ex) {
            Logger.getLogger(Editar_dadosController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
        String sql = "SELECT DISTINCT marca FROM PRODUTO";
        Statement statement = Banco.obterConexao().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // Criar lista para armazenar os valores de marca
        List<String> marcas = new ArrayList<>();
        while (resultSet.next()) {
            String marca = resultSet.getString("marca");
            marcas.add(marca);
        }
        // Alimentar a ComboBox com os valores de marca
        cbMarca.setItems(FXCollections.observableArrayList(marcas));

        // Fechar recursos
        resultSet.close();
        statement.close();

        // Configurar o ouvinte de propriedade para a combobox de marca
        cbMarca.valueProperty().addListener((observable, oldValue, newValue) -> {
            // Limpar a seleção da combobox de modelo
            cbModelo.getSelectionModel().clearSelection();

            // Obter os modelos da marca selecionada
            List<String> modelos = obterModelosDaMarca(newValue);

            // Atualizar os itens da combobox de modelo
            cbModelo.setItems(FXCollections.observableArrayList(modelos));
        });

    } catch (SQLException e) {
        e.printStackTrace();
        // Tratar a exceção adequadamente
    }
        
        try {
            Banco.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Editar_dadosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private List<String> obterModelosDaMarca(String marca) {
        // Aqui você pode implementar a lógica para obter os modelos da marca selecionada
        // Consultar o banco de dados ou utilizar uma fonte de dados existente

        // Exemplo de implementação fictícia
        List<String> modelos = new ArrayList<>();
        if (marca.equals("NIKE")) {
            modelos.add("Air Max");
            modelos.add("Free Run");
        } else if (marca.equals("ADIDAS")) {
            modelos.add("Superstar");
            modelos.add("Stan Smith");
        }
        return modelos;
    }
    
    @FXML
    private void switchToCadastroProduto() throws IOException {
        App.setRoot("cadastro_produto");
    }
    
    @FXML
    private void switchToVenda() throws IOException {
        App.setRoot("venda");
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
    private void switchToMenu() throws IOException {
        App.setRoot("menu");
    }
    
    @FXML
    private void btnLogout() throws IOException {
        App.setRoot("login");
    }
    
    private void limpaCampos(){
        cbMarca.getSelectionModel().clearSelection();
        cbModelo.getSelectionModel().clearSelection();
        txtValor.setText("");
    }
    
    @FXML
    private void btnGravar() throws IOException {
        if (txtValor.getText().isEmpty() || cbMarca.getSelectionModel().isEmpty() || cbModelo.getSelectionModel().isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("PREENCHA TODOS OS CAMPOS");
            alerta.setHeaderText("INFORMACOES");
            alerta.setContentText("Preencha Todos os campos!");
            alerta.showAndWait();
        }else{
            limpaCampos();
        }
    }
    
    @FXML
    private void btnApagar() throws IOException {
        limpaCampos();
    }
}
