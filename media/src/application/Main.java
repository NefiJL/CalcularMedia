package application;
	
import com.ifsc.tds.controller.MediaController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Calcular a média!");
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			
			//carregando o arquivo de tela
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/com/ifsc/tds/view/MediaView.fxml"));
			Parent arquivoXML = loader.load();
			
			//atribuindo o arquivo XML para uma scene e atribuindo a janela (stage)
			Scene mediaScene = new Scene(arquivoXML);
			primaryStage.setScene(mediaScene);
			
			//carregando o controller da cena
			MediaController mediaController = loader.getController();
			
			primaryStage.setOnCloseRequest(e -> {

                if (mediaController.onCloseQuery()) {
                    System.exit(0);
                } else {
                    e.consume();
                }
            });
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
