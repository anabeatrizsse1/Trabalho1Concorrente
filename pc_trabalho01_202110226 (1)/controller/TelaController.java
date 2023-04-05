/* ***************************************************************
* Autor............: Ana Beatriz Silva e Silva
* Matricula........: 202110226
* Inicio...........: 06/02/2023
* Ultima alteracao.: 17/02/2023
* Nome.............: Sistema de Faturamento
* Funcao...........: Um sistema que retorna o faturamento que voce ganhou ou ainda deseja ganhar 
                     dentro de uma venda                     
****************************************************************** */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import model.Calculo;

public class TelaController implements Initializable {

  @FXML
  private TextField valorInicial, valorGastos, valorFinal;// TextField dos valores que vao receber 

  @FXML
  private Label mensagemResultado, mensagemFeedback; // Label que ira mostrar o resultado

  @FXML
  private ToggleGroup grupo;

  @FXML
  private ChoiceBox<String> opcao; //ChoiceBox para escolher o item que deseja calcular

  @FXML
  RadioButton botao10, botao20, botao30, botao40, botao50; // declarando os botoes do RadionButton para o usuario
                                                           // escolher

  public int radioButtonSelecionado() { // inicio do metodo que implementa o RadioButton
    if (botao10.isSelected()) { // botao10 eh o valor correspondente a 10%
      return 10; // return 10 que vai ser utilizado no momento do calculo
    }
    if (botao20.isSelected()) { // botao20 eh o valor correspondente a 20%
      return 20; // return 20 que vai ser utilizado no momento do calculo
    }
    if (botao30.isSelected()) { // botao30 eh o valor correspondente a 30%
      return 30; // return 30 que vai ser utilizado no momento do calculo
    }
    if (botao40.isSelected()) { // botao40 eh o valor correspondente a 40%
      return 40; // return 40 que vai ser utilizado no momento do calculo
    }
    return 50; // return 560 que vai ser utilizado no momento do calculo
  } // fim do metodo

  @FXML
  public void botaoEnter() { // declarando botaoEnter
    double compra, gastos, venda;
    int lucro;

    String item = opcao.getValue();

    if (item == null) { 
      erro("Campo em Branco ", "Eh necessario selecionar um item ");
      // se o o usuario deixar a caixa de escolha em branco, sera enviado esse alerta
      return;
    } 

    try { 
      compra = Double.parseDouble(valorInicial.getText());
    } catch (Exception e) {
      erro("Campo em Branco ", "Digite um valor no campo 'VALOR DA COMPRA' ");
      // se o usuario deixar o campo 'Valor de Compra' sem nada, aparecerá essa
      // mensagem de alerta
      return;
    } 
    try { 
      gastos = Double.parseDouble(valorGastos.getText());
    } catch (Exception e) {
      erro("Campo em Branco ", "Digite um valor no campo 'GASTOS' ");
      // se o usuario deixar o campo 'Gastos' sem nada, aparecerá essa mensagem de
      // alerta
      return;
    } 
    try { 
      venda = Double.parseDouble(valorFinal.getText());
    } catch (Exception e) {
      erro("Campo em Branco ", "Digite um valor no campo 'VALOR DE VENDA' ");
      // se o usuario deixar o campo 'Valor de Venda' sem nada, aparecerá essa
      // mensagem de alerta
      return;
    } 

    lucro = this.radioButtonSelecionado(); // a variavel que recebe o lucro que o usuario deseja obter

    calcular(item, compra, venda, gastos, lucro); // chama o metodo calcular e passa seus parametros

  } // fim do metodo

  private void calcular(String item, double compra, double venda, double gastos, int lucro) {
    Calculo calculos = new Calculo(item, compra, venda, gastos, lucro);
    // intanciando o objeto e passa os parametros

    double faturamento = calculos.calcularFaturamento(); // a variavel faturamento recebera os calculos do
                                                         // metodo calcularFaturamento da classe Calculo
    String analise = calculos.analise(); // a variavel analise receberá o calcalos do metodo analise da classe calculo

    mensagemResultado.setText("Seu Faturamento: " + faturamento);// mensagem com o resultado do faturamento
    mensagemFeedback.setText("Feedback " + analise); // mensagem com a analise feita no metodo 'analise'

  }

  private void erro(String titulo, String mensagem) { // metodo 'erro' que ira mostrar a mensagem de erro
    Alert errorAlert = new Alert(AlertType.ERROR);

    errorAlert.setHeaderText(titulo);
    errorAlert.setContentText(mensagem);
    errorAlert.showAndWait();
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    String nomesItens[] = { "Casa", "Automovel" }; // variaveis da ChoiceBox sendo implementada
    opcao.getItems().addAll(nomesItens); // variaveis da ChoiceBox sendo adicionada

    mensagemFeedback.setText("");
    mensagemResultado.setText("");
  }
}