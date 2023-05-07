/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Loyola01
 */
public class Carga {

    private double coeficiente;
    private double exponente;

    public Carga() {
    }

    public Carga(double coeficiente, double exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }

    public double getCoe() {
        return coeficiente;
    }

    public double getExp() {
        return exponente;
    }
}
