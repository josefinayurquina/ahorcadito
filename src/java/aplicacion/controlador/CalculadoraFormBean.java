/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador;

import aplicacion.modelo.Calculadora;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alumno
 */
@ManagedBean
@ViewScoped
public class CalculadoraFormBean implements Serializable {
    private String mantisa;
    private Calculadora calculadora;
    

    public CalculadoraFormBean(String mantisa, Calculadora calculadora) {
        this.mantisa = mantisa;
        this.calculadora = calculadora;
    }
          

    public CalculadoraFormBean() {
  mantisa = new String();
        calculadora = new Calculadora();
  
    }
    
    
    
    /**
     * Creates a new instance of CalculadoraFormBean
     */
    

    /**
     * @return the mantisa
     */
    public String getMantisa() {
        return mantisa;
    }

    /**
     * @param mantisa the mantisa to set
     */
    public void setMantisa(String mantisa) {
        this.mantisa = mantisa;
    }

    /**
     * @return the calculadora
     */
    public Calculadora getCalculadora() {
        return calculadora;
    }

    /**
     * @param calculadora the calculadora to set
     */
    public void setCalculadora(Calculadora calculadora) {
        this.calculadora = calculadora;
    }
    
    public void realizarOperacion(){
        int primerNumero = 0;
        int segundoNumero = 0;
        char operadorSeleccionado = ' ';
        for(int i=0;i<mantisa.length();i++){
            char caracterExtraido = mantisa.charAt(i);
            if(caracterExtraido == '+' ||
                    (caracterExtraido == '-' && i!=0 ) ||
                    caracterExtraido == 'x' ||
                    caracterExtraido == '/' ||
                            caracterExtraido == '^'){
                       primerNumero = Integer.parseInt(mantisa.substring(0, i));
                       segundoNumero = Integer.parseInt(mantisa.substring(i+1));
                       operadorSeleccionado = caracterExtraido;
            }
        }
    
    
    int resultadoOperacion = 0;
    switch (operadorSeleccionado){
        case '+':{
           
            resultadoOperacion = 
                    calculadora.sumar(primerNumero,segundoNumero);
            break;
        }
        
        case '-':{
            resultadoOperacion =
                    calculadora.restar(primerNumero, segundoNumero);
            break;
        }
        
        case 'x':{
            
            resultadoOperacion =
                    calculadora.multiplicar(primerNumero, segundoNumero);
            break;
        }
        
        case '/':{
            resultadoOperacion =
                    calculadora.dividir(primerNumero, segundoNumero);
            break;
        }
        
        case '^':{
            resultadoOperacion =
                    calculadora.potenciar(primerNumero, segundoNumero);
            break;
        }
    }
    mantisa = mantisa + "="+resultadoOperacion;
    }
    
    public void registrarValorBoton(){
        FacesContext facesContext =
                FacesContext.getCurrentInstance();
        String valorSeleccionado =
                facesContext.getExternalContext().getRequestParameterMap().get("valorPresionado");
        mantisa = mantisa + valorSeleccionado;
        
    }
    
    public void borrarDatos(){
        calculadora = new Calculadora();
        setMantisa(new String());
    }
    
}
    
    
        
        
    

