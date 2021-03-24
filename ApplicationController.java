package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import Model.Clasa1;
import Services.Service;
import Services.ServicesException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ApplicationController {

    @FXML
    private Button AddButton1, AddButton2, ViewButton1, ViewButton2;

    @FXML
    private ListView ListView1, ListView2;

    //connection to services
    private Service service;

    public ApplicationController(){

    }

    public void setService(Service service){
        this.service=service;
    }

}
