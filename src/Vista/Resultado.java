/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Sociograph
 */
public class Resultado {

    private int index;
    private String nom_fichero;
    private String resultado;
    private String ruta_carpeta;

    public Resultado(int index, String nom_fichero, String ruta_carpeta, String resultado) {
        this.index = index;
        this.nom_fichero = nom_fichero;
        this.ruta_carpeta = ruta_carpeta;
        this.resultado = resultado;
    }

    public int getIndex() {
        return index;
    }

    public String getNom_fichero() {
        return nom_fichero;
    }

    public String getResultado() {
        return resultado;
    }

    public String getRuta_carpeta() {
        return ruta_carpeta;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setNom_fichero(String nom_fichero) {
        this.nom_fichero = nom_fichero;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setRuta_carpeta(String ruta_carpeta) {
        this.ruta_carpeta = ruta_carpeta;
    }
}
