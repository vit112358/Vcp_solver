/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;


/**
 *
 * @author Fellipe
 */

public class Aresta {
    
    private int id;
    private boolean pertence;

    public boolean isPertence() {
        return pertence;
    }

    public void setPertence(boolean pertence) {
        this.pertence = pertence;
    }
    private Vertice origem;
    private Vertice destino;

    public Aresta(int id, Vertice origem, Vertice destino) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }    
}
