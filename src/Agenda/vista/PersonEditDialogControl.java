/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda.vista;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;

import Agenda.modelo.Person;
/**
 *
 * @author Jose
 */
public class PersonEditDialogControl {

    @FXML
    private TextField NombreField;
    @FXML
    private TextField ApellidoField;
    @FXML
    private TextField EmpresaField;
    @FXML
    private TextField DireccionField;
    @FXML
    private TextField CiudadField;
    @FXML
    private TextField EmailField;
    @FXML
    private TextField TelefonoField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        NombreField.setText(person.getNombre());
        ApellidoField.setText(person.getApellido());
        EmpresaField.setText(person.getEmpresa());
        DireccionField.setText(person.getDireccion());
        CiudadField.setText(person.getCiudad());
        EmailField.setText(person.getEmail());
        TelefonoField.setText(person.getTelefono());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setNombre(NombreField.getText());
            person.setApellido(ApellidoField.getText());
            person.setEmpresa(EmpresaField.getText());
            person.setDireccion(DireccionField.getText());
            person.setCiudad(CiudadField.getText());
            person.setEmail(EmailField.getText());
            person.setTelefono(TelefonoField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (NombreField.getText() == null || NombreField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (ApellidoField.getText() == null || ApellidoField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (EmpresaField.getText() == null || EmpresaField.getText().length() == 0) {
            errorMessage += "No valid street!\n"; 
        }
        
        if (DireccionField.getText() == null || DireccionField.getText().length() == 0) {
            errorMessage += "No valid street!\n"; 
        }

        if (CiudadField.getText() == null || CiudadField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n"; 
        } 

        if (EmailField.getText() == null || EmailField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }

        if (TelefonoField.getText() == null || TelefonoField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Dialogs.create()
                .title("Invalid Fields")
                .masthead("Please correct invalid fields")
                .message(errorMessage)
                .showError();
            return false;
        }
    }
}
