/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo;

import java.io.Serializable;

/**
 *
 * @author Alumno
 */
public class Calculadora implements Serializable {

    public Calculadora() {
    }
    
    public int sumar(int primerNumero, int segundoNumero){
       return primerNumero + segundoNumero;
}

    public int restar(int primerNumero, int segundoNumero){
        return primerNumero - segundoNumero;
    }
    
    public int dividir(int primerNumero, int segundoNumero){
        return primerNumero / segundoNumero;
    }
    
    public int multiplicar(int primerNumero, int segundoNumero){
        return primerNumero * segundoNumero;
    }
    
    public int potenciar(int primerNumero, int segundoNumero) {
        return (int) Math.pow(primerNumero, segundoNumero);
    }
    
}
