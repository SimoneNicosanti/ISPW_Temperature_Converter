package com.example.temperatureconverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML private Button convertButton ;
    @FXML private TextField startValueField ;
    @FXML private RadioButton farStart ;
    @FXML private RadioButton kelvStart ;
    @FXML private RadioButton celsStart ;
    @FXML private RadioButton farEnd ;
    @FXML private RadioButton kelvEnd ;
    @FXML private RadioButton celsEnd ;

    @FXML private Label finalValueLabel ;



    @FXML
    public void onConvertClicked() {
        try{
            Double startValue = Double.parseDouble(startValueField.getText()) ;
            if (farStart.isSelected()) farhenitConvert(startValue) ;
            else if (kelvStart.isSelected()) kelvinConverter(startValue) ;
            else celsiusConverter(startValue) ;
        }
        catch (NumberFormatException numberFormatException) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Errore in scrittura del valore iniziale!!") ;
            alert.showAndWait() ;
        }
    }

    private void celsiusConverter(Double startValue) {
        Double finalValue = startValue ;
        if (farEnd.isSelected()) finalValue = startValue * (9.0 / 5) + 32 ;
        else if (kelvEnd.isSelected()) finalValue = startValue + 273.15 ;

        finalValueLabel.setText(finalValue.toString());
    }

    private void kelvinConverter(Double startValue) {
        Double finalValue = startValue ;
        if (farEnd.isSelected()) finalValue = startValue * (9.0 / 5) - 459.67 ;
        else if (celsEnd.isSelected()) finalValue = startValue - 273.15 ;

        finalValueLabel.setText(finalValue.toString());
    }

    private void farhenitConvert(Double startValue) {
        Double finalValue = startValue ;
        if (celsEnd.isSelected()) finalValue = (5.0 / 9) * (startValue - 32) ;
        else if (kelvEnd.isSelected()) finalValue = (5.0 / 9) * startValue + 255.37 ;

        finalValueLabel.setText(finalValue.toString());
    }
}