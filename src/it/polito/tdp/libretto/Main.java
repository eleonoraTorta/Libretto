package it.polito.tdp.libretto;
	
import it.polito.tdp.libretto.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//creo un oggetto esplicito (loader) di tipo FXMLLoader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Libretto.fxml"));
			
			//creo la VISTA chiamando un metodo "vero" ( load() )  sull'oggetto loader (non uso il metodo statico )
			//cosi il loader mi carica la vista
			BorderPane root = (BorderPane)loader.load();
			
			//ottengo (non creo da zero) il CONTROLLER chiedendolo al loader
			LibrettoController controller = loader.getController();
			
			//creo il MODEL (importando la classe Model dall'altro package)
			Model model = new Model();
			controller.setModel(model);   //e passo al controller il Model appena creato
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
