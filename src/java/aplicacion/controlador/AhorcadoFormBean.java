/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador;

import aplicacion.modelo.Ahocado;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alumno
 */
@ManagedBean
@ViewScoped
public class AhorcadoFormBean implements Serializable {
    private Ahocado ahorcado;
    private char letraIngresada;
    private String palabraIngresada;
    private boolean componenteDeshabilitador;

    /**
     * Creates a new instance of AhorcadoFormBean
     */
    public AhorcadoFormBean() {
        ahorcado=new Ahocado();
        componenteDeshabilitador=false;
    }
    public void empezarJuego(){
        getAhorcado().empezarJuego(palabraIngresada);
        setComponenteDeshabilitador(true);
        FacesContext facesContext=FacesContext.getCurrentInstance();
        //Captura los objetos de la vista deste la instancia actual
        facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Juego iniciado","Suerte"));//muestra el msj
        
    }
    public void controlarLetra(){
        boolean letraEncontrada=getAhorcado().buscarLetra(letraIngresada);
        FacesContext facesContext=FacesContext.getCurrentInstance();
        if(letraEncontrada==true){
            if (getAhorcado().juegoGanado()==true){
                
                 facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Fin del Juego","Ganaste :D"));
            
            }      
        }   
        else
            if (getAhorcado().getIntentos()== 0){
                 facesContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Fin del Juego","Perdiste! :c"));               
                 nuevoJuego();

            }
        
    }
    public void nuevoJuego(){
        setComponenteDeshabilitador(false);
        setPalabraIngresada(new String());
        setAhorcado(new Ahocado());
    }
    /**
     * @return the ahorcado
     */
    public Ahocado getAhorcado() {
        return ahorcado;
    }

    /**
     * @param ahorcado the ahorcado to set
     */
    public void setAhorcado(Ahocado ahorcado) {
        this.ahorcado = ahorcado;
    }

    /**
     * @return the letraIngresada
     */
    public char getLetraIngresada() {
        return letraIngresada;
    }

    /**
     * @param letraIngresada the letraIngresada to set
     */
    public void setLetraIngresada(char letraIngresada) {
        this.letraIngresada = letraIngresada;
    }

    /**
     * @return the palabraIngresada
     */
    public String getPalabraIngresada() {
        return palabraIngresada;
    }

    /**
     * @param palabraIngresada the palabraIngresada to set
     */
    public void setPalabraIngresada(String palabraIngresada) {
        this.palabraIngresada = palabraIngresada;
    }

    /**
     * @return the componenteDeshabilitador
     */
    public boolean isComponenteDeshabilitador() {
        return componenteDeshabilitador;
    }

    /**
     * @param componenteDeshabilitador the componenteDeshabilitador to set
     */
    public void setComponenteDeshabilitador(boolean componenteDeshabilitador) {
        this.componenteDeshabilitador = componenteDeshabilitador;
    }

    private void setImagen(String images005png) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the compononteDeshabilitador
     */
    
}
