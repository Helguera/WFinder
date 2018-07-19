/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.ArrayList;

/**
 *
 * @author Sociograph
 */
public class Fichero {
    
    private String nombre;
    private String ruta;
    private ArrayList<String> resultados = new ArrayList<>();
    
    public Fichero(){
        
    }
    
    public Fichero(String nombre, String ruta){
        this.nombre = nombre;
        this.ruta = ruta;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setRuta(String ruta){
        this.ruta = ruta;
    }
    
    public void addResultado(String resultado){
        resultados.add(resultado);
    }
    
    public void getResultado(int i){
        resultados.get(i);
    }
    
    public void isResultado(String resultado){
        resultados.contains(resultado);
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuta() {
        return ruta;
    }   
}
