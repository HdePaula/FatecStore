/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.fatecstore;

import br.com.fatec.fatecstore.PERSISTENCIA.Banco;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Henri
 */
public class Consulta_avancadaController implements Initializable {
    
    private void limpaCampos(){
        cbFiltro.getSelectionModel().clearSelection();
        txtFiltro.setText("");
    }
    
    @FXML
    private ComboBox<String> cbFiltro;

    @FXML
    private TextField txtFiltro;

    @FXML
    void btnLogout(ActionEvent event) {

    }

    @FXML
    void switchToCadastrarVendedor(ActionEvent event) {

    }

    @FXML
    void switchToCadastroProduto(ActionEvent event) {

    }

    @FXML
    void switchToEditarDados(ActionEvent event) {

    }

    @FXML
    void switchToMenu(ActionEvent event) {

    }

    @FXML
    void switchToVenda(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    
    // Método para exibir um alerta
    private void exibirAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Adicionar os itens na ComboBox cbFiltro
        ObservableList<String> items = FXCollections.observableArrayList(
                "ID", "CPF_CLIENTE", "MARCA_PRODUTO", "ID_VENDEDOR", "MODELO_PRODUTO", "QUANTIDADE", "VALOR_PRODUTO");
        cbFiltro.setItems(items);
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
    private void switchToVenda() throws IOException {
        App.setRoot("venda");
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
    private void btnPesquisar() throws IOException, SQLException {
        String coluna = cbFiltro.getValue(); // Obtém o valor selecionado na ComboBox
        String filtro = txtFiltro.getText(); // Obtém o valor do campo de filtro

        // Verifica se a coluna e o filtro foram especificados
        if (coluna != null && !coluna.isEmpty() && filtro != null && !filtro.isEmpty()) {
            try {
                // Conectar ao banco de dados
                Banco.conectar();
                
                Connection connection = Banco.obterConexao();

                // Consultar o banco de dados
                String sql = "SELECT * FROM VENDA WHERE " + coluna + " = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, filtro);

                ResultSet resultSet = statement.executeQuery();

                // Verifica se algum item foi encontrado
                if (resultSet.next()) {
                    // Item encontrado
                    // Faça o que for necessário com o resultado
                } else {
                    // Nenhum item encontrado
                    exibirAlerta("Nenhum item encontrado", "A pesquisa não retornou resultados.");
                }

                // Fechar recursos
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Tratar exceção
            }
        } else {
            // Valores não especificados
            exibirAlerta("Valores inválidos", "Por favor, selecione uma coluna e insira um valor de filtro.");
        }
        Banco.desconectar();
    }
    
    @FXML
    private void btnApagar() throws IOException {
        limpaCampos();
    }
}
