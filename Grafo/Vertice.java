package Grafo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fellipe
 */
public class Vertice {
    
    private int id;
    private boolean pertence;

    public boolean isPertence() {
        return pertence;
    }

    public void setPertence(boolean pertence) {
        this.pertence = pertence;
    }
    private int grau;
    
    public Vertice(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }
}
