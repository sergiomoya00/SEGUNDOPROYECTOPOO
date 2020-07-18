/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author jabre
 */
@ManagedBean
@RequestScoped
public class login {
    
    //Atributos necesarios para los metodos de la clase LogIn
    public void setType(String type) {
        this.type = type;
    }
    private String email;
    private String password;
    private String type;
    
    //Constructor vacío de la clase LogIn
    
    public login() {
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }
    
    public void mensaje(){
    FacesMessage fm= new FacesMessage("Bienvenido "+ email);
    FacesContext fc= FacesContext.getCurrentInstance();
    fc.addMessage(null, fm);
    }
}
