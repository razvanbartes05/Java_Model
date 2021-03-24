import Controller.ApplicationController;
import Repository.Clasa1FileRepository;
import Repository.Clasa1Repository;
import Repository.Clasa2FileRepository;
import Repository.Clasa2Repository;
import Services.Service;
import Services.ServicesException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MainFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Window.fxml"));
            Parent root = loader.load();
            ApplicationController ctrl = loader.getController();
            ctrl.setService(getService());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Application");
            primaryStage.show();
        }catch(Exception e){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setContentText("Error while starting app "+e);
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    static Service getService() throws ServicesException {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("Application.properties"));
            String clasa1FileName=properties.getProperty("FirstFile");
            if (clasa1FileName==null){
                clasa1FileName="Clasa1.txt";
                System.err.println("File not found. Using default "+clasa1FileName);
            }
            String clasa2FileName=properties.getProperty("SecondFile");
            if (clasa2FileName==null){
                clasa2FileName="Clasa2.txt";
                System.err.println("File not found. Using default "+clasa2FileName);
            }
            Clasa1Repository c1Repo = new Clasa1FileRepository(clasa1FileName);
            Clasa2Repository c2Repo = new Clasa2FileRepository(clasa2FileName, c1Repo);
            return new Service(c1Repo, c2Repo);
        }catch (IOException ex){
            throw new ServicesException("Error starting app "+ex);
        }
    }
}
