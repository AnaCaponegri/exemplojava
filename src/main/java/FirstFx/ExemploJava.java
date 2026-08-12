package FirstFx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExemploJava extends Application {
        private static Stage stagePrincipal;

    @Override
    public void start(Stage stage) throws IOException {
        stagePrincipal = stage;
      stage.setTitle("Sistema de Usuários");
      trocarTela("/login.fxml", 470, 540);
      stage.setResizable(false);
      stage.show();
    }

   public static void trocarTela(String fxml, double largura, double altura) throws IOException {
    FXMLLoader loader = new FXMLLoader(ExemploJava.class.getResource(fxml));
    Parent raiz = loader.load();
    Scene scene = new Scene(raiz, largura, altura);

    stagePrincipal.setScene(scene);
    stagePrincipal.centerOnScreen();
}

    public static void main(String[] args) {
        launch(args);
    }
}
