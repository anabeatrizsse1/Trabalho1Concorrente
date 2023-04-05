/* ***************************************************************
* Autor............: Ana Beatriz Silva e Silva
* Matricula........: 202110226
* Inicio...........: 06/02/2023
* Ultima alteracao.: 17/02/2023
* Nome.............: Sistema de Faturamento
* Funcao...........: Um sistema que retorna o faturamento que voce ganhou ou ainda deseja ganhar 
                     dentro de uma venda                     
****************************************************************** */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.TelaController;

public class Principal extends Application {



  
  public static Parent root;
  public static Stage stage = new Stage();

  @Override
  public void start(Stage stage) throws Exception {
    root = FXMLLoader.load(getClass().getResource("/view/tela.fxml"));
    Scene scene = new Scene(root);
    Principal.stage.setTitle("Faturamento");
    Principal.stage.getIcons().add(new Image("/view/icon-faturamento.png"));
    Principal.stage.setScene(scene);
    Principal.stage.setResizable(false);
    Principal.stage.sizeToScene();
    Principal.stage.centerOnScreen();
    Principal.stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
