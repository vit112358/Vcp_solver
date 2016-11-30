/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Arquivo.LeituraArquivo;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Fellipe
 */
public class Grafo {
    /*boolean[] edge;
    boolean[] node;*/
    int[][] matriz;
    int grau;
    int num_nos;
    int id;//será usado no criterio de desempate  na busca de maior grau dentre os vertices
    
    public Map<Integer,Aresta> edges=new HashMap();//aresta-Mapeamento de arestas
    
    public Map<Integer,Vertice> nodes=new HashMap();//vertice-mapeamento de vertices
    
    /*Esta função inicializa a matriz de adjacencia e o conjunto de vertices
      e arestas
    */
    public void inicializar_dados(){
        int aux=1;//contador de ids, que será auto-incremento
                  //do id da aresta
        Vertice aux_origem,aux_destino;
        matriz=LeituraArquivo.getMatriz_grafo();//recebendo a matriz 
                                                //obtida na leitura
        
        /*contabiliza o grau dos nos dentro da matriz e 
        coloca no devido campo da estrutura vertice;
        */
        
        setNum_nos(LeituraArquivo.getNum_nos());
        for (int i=1;i<=LeituraArquivo.getNum_nos();i++){
            Vertice noh=new Vertice(i);
            grau=0;
            for (int j=i;i<=LeituraArquivo.getNum_nos();j++){
                if (matriz[i][j]==1){
                    grau=grau+1;    
                }
            }
            noh.setPertence(true);
            noh.setGrau(grau);
            nodes.put(i,noh);
        }
        
        //esse for trata da inserção inicial de arestas na estrutura grafos
        for (int i=1;i<=LeituraArquivo.getNum_nos();i++){
            for(int j=1;j<=LeituraArquivo.getNum_nos();j++){
                if((matriz[i][j]==1) && (i<=j)){
                    aux_origem=nodes.get(i);
                    aux_destino=nodes.get(j);
                    Aresta nova=new Aresta(aux,aux_origem,aux_destino);
                    /*instanciando nova aresta*/
                    nova.setPertence(true);
                    edges.put(aux, nova);
                    /*inserindo nova aresta na estrutura edges*/
                    aux++;//incrementando o id da aresta
                }
            }
        }
    }

    public int getNum_nos() {
        return num_nos;
    }

    public void setNum_nos(int num_nos) {
        this.num_nos = num_nos;
    }

    //retornando arestas
    public Map<Integer, Aresta> getEdges() {
        return edges;
    }
    
    //retornandoo arestas
    public Map<Integer, Vertice> getNodes() {
        return nodes;
    }
    
    //"apagando" arcos de um grafo posso apagar
    public void remove_arcos(int id_aresta){
        Aresta aux;
        
        aux=edges.get(id_aresta);
        
        aux.setPertence(false);
        edges.put(id_aresta, aux);
    }
    
    /*Como o nome diz esta funcção retorna o vertice de maior grau*/
    public Vertice retorna_maior_grau(int seed){
        int aux;//guardara o maior grau
        int random;
        Vertice auxiliar;//auxiliar para percorrer o mapa
        auxiliar=null;
        aux=0;
        
        Random gerador=new Random(seed);
        
        for (int i=0;i<nodes.size();i++){
            auxiliar=nodes.get(i);
            if (auxiliar.getGrau()>aux){
                aux=auxiliar.getGrau();
                id=auxiliar.getId();
            }else if ((auxiliar.getGrau()==aux) && (auxiliar.getId()!=id)){
                random=gerador.nextInt(1);
                if (random==1){
                    aux=auxiliar.getGrau();
                    id=auxiliar.getId();
                }
            }  
        }
        return auxiliar;
    }
}
