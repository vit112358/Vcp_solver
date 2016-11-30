/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCV;

import Grafo.Aresta;
import Grafo.Grafo;
import Grafo.Operacoes;
import Grafo.Vertice;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
        

/**
 *
 * @author Fellipe
 */
public class PCV {
    //
    
    private static Map<Integer, Vertice> cobertura_vertices = new HashMap<>();
    private static Map<Integer, Aresta> Conjunto_arestas = new HashMap<>();
    private static Map<Integer, Vertice> cobertura_vertices_Final = new HashMap<>();

    public Map<Integer, Vertice> getCobertura_vertices() {
        return cobertura_vertices;
    }

    public void setCobertura_vertices(Map<Integer, Vertice> cobertura_vertices) {
        this.cobertura_vertices = cobertura_vertices;
    }

    public Map<Integer, Vertice> getCobertura_vertices_Final() {
        return cobertura_vertices_Final;
    }

    public void setCobertura_vertices_Final(Map<Integer, Vertice> cobertura_vertices_Final) {
        this.cobertura_vertices_Final = cobertura_vertices_Final;
    }
    
    //Algortimo de cobertura de vertice metodo aproximado    
    public static Map<Integer,Vertice> Aprox_Vertex_cover(Grafo grafo, int seed)
    {
        int    random;
        Aresta aresta;
        Map<Integer,Aresta> conjunto=new HashMap();
        //cobertura_vertices.clear();
        
        Random gerador=new Random(seed);
        Conjunto_arestas=grafo.getEdges();
        while (!Conjunto_arestas.isEmpty())
        {
            /*Escolhendo uma aresta aleatória*/
            random=gerador.nextInt(grafo.getNum_nos());
            if (random == 0){
                random=1;
            }
            aresta=Operacoes.Sel_Aresta(grafo.getEdges(), random);
            
            /*adicionando um novo vertice à cobertura*/
            cobertura_vertices_Final=Operacoes.Uniao_conjunto
        (cobertura_vertices_Final, aresta.getDestino(), aresta.getOrigem());
            
            
            /*montando o conjunto de arestas que incidem em um
            vertice_destino ou vertice_origem para poder excluir
            */
            conjunto=Operacoes.Seleciona_arestas(Conjunto_arestas, 
                    aresta.getOrigem(),aresta.getDestino());
            
            /*realizando a operação de diferença
            entre o conjunto de arestas e o conjunto de arcos que incidem nos
            vertices da aresta declarada
            */
            Conjunto_arestas=Operacoes.dif_aresta(Conjunto_arestas, conjunto);
        }
        return cobertura_vertices_Final;
    }

    public static Map<Integer,Vertice> Greedy(Grafo grafo, int seed){
        int contador=0;
        Vertice vertice;
        Map<Integer,Aresta> conjunto_aresta=new HashMap();//conjunto de arestas
        Map<Integer,Vertice> conjunto_vertice=new HashMap();//conjunto de vertices
        Map<Integer,Vertice> conjunto=new HashMap();/*conjunto dos arcos
                                                     incidentes em vertice               
                                                    */
        
        cobertura_vertices_Final.clear();//pode ser apagado, para fins
                                         //de não duplicação está sendo usado
        
        conjunto_aresta=grafo.getEdges();
        conjunto_vertice=grafo.getNodes();
        
        while(!conjunto_aresta.isEmpty()){
            
            /*pegando o vertice de maior grau*/
            vertice=grafo.retorna_maior_grau(seed);
            
            /*removendo um vertice de maior grau*/
            conjunto_vertice.remove(vertice.getId());
            
            contador++;
            conjunto.put(contador, vertice);
            
            /*removendo as arestas incidente no vertice de maior grau*/
            conjunto_aresta=Operacoes.dif_vertice(conjunto_aresta, vertice);
        }
                                         
        return cobertura_vertices_Final;
    }

}
