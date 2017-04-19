/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda.modelo;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *
 * @author Jose
 */
public class Person {

    private final StringProperty Nombre;
    private final StringProperty Apellido;
    private final StringProperty Empresa;
    private final StringProperty Direccion;
    private final StringProperty Ciudad;
    private final StringProperty Email;
    private final StringProperty Telefono;

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param Nombre
     * @param Apellido
     */
    public Person(String Nombre, String Apellido) {
        this.Nombre = new SimpleStringProperty(Nombre);
        this.Apellido = new SimpleStringProperty(Apellido);

        // Some initial dummy data, just for convenient testing.
        this.Empresa = new SimpleStringProperty("Varto Enterprise");
        this.Direccion = new SimpleStringProperty("Sargento Silva 123");
        this.Ciudad = new SimpleStringProperty("Puerto Montt");
        this.Email = new SimpleStringProperty("arnoldovargas1981@gmail.com");
        this.Telefono = new SimpleStringProperty("+56981369181");
    }

    public String getNombre() {
        return Nombre.get();
    }

    public void setNombre(String Nombre) {
        this.Nombre.set(Nombre);
    }

    public StringProperty NombreProperty() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido.get();
    }

    public void setApellido(String Apellido) {
        this.Apellido.set(Apellido);
    }

    public StringProperty ApellidoProperty() {
        return Apellido;
    }

    public String getEmpresa() {
        return Empresa.get();
    }

    public void setEmpresa(String Empresa) {
        this.Empresa.set(Empresa);
    }

    public StringProperty EmpresaProperty() {
        return Empresa;
    }

    public String getDireccion() {
        return Direccion.get();
    }

    public void setDireccion(String Direccion) {
        this.Direccion.set(Direccion);
    }

    public StringProperty DireccionProperty() {
        return Direccion;
    }

    public String getCiudad() {
        return Ciudad.get();
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad.set(Ciudad);
    }

    public StringProperty CiudadProperty() {
        return Ciudad;
    }
    
    public String getEmail() {
        return Email.get();
    }

    public void setEmail(String Email) {
        this.Email.set(Email);
    }

    public StringProperty EmailProperty() {
        return Email;
    }
    
    public String getTelefono() {
        return Telefono.get();
    }

    public void setTelefono(String Telefono) {
        this.Telefono.set(Telefono);
    }

    public StringProperty TelefonoProperty() {
        return Telefono;
    }
}
