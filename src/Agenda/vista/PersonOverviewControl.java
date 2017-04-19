/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda.vista;

import Agenda.MainApp;
import Agenda.modelo.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author Jose
 */
public class PersonOverviewControl {
    @FXML
    private TableView<Person> personaTable;
    @FXML
    private TableColumn<Person, String> NombreColumn;
    @FXML
    private TableColumn<Person, String> ApellidoColumn;

    @FXML
    private Label NombreLabel;
    @FXML
    private Label ApellidoLabel;
    @FXML
    private Label EmpresaLabel;
    @FXML
    private Label DireccionLabel;
    @FXML
    private Label CiudadLabel;
    @FXML
    private Label EmailLabel;
    @FXML
    private Label TelefonoLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewControl() {
    }
    
/**
 * Fills all text fields to show details about the person.
 * If the specified person is null, all text fields are cleared.
 * 
 * @param person the person or null
 */
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            NombreLabel.setText(person.getNombre());
            ApellidoLabel.setText(person.getApellido());
            EmpresaLabel.setText(person.getEmpresa());
            DireccionLabel.setText(person.getDireccion());
            CiudadLabel.setText(person.getCiudad());
            EmailLabel.setText(person.getEmail());
            TelefonoLabel.setText(person.getTelefono());

            // TODO: We need a way to convert the birthday into a String! 
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
            NombreLabel.setText("");
            ApellidoLabel.setText("");
            EmpresaLabel.setText("");
            DireccionLabel.setText("");
            CiudadLabel.setText("");
            EmailLabel.setText("");
            TelefonoLabel.setText("");
        }
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        NombreColumn.setCellValueFactory(cellData -> cellData.getValue().NombreProperty());
        ApellidoColumn.setCellValueFactory(cellData -> cellData.getValue().ApellidoProperty());
        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personaTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personaTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personaTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            JOptionPane.showMessageDialog(null, "No se eligio nada");
        }
    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personaTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // Nothing selected.
            Dialogs.create()
                .title("No Selection")
                .masthead("No Person Selected")
                .message("Please select a person in the table.")
                .showWarning();
        }
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personaTable.setItems(mainApp.getPersonData());
    }
}
