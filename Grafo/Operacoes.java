package Grafo;

import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;
//import java.util.Set;
//import Grafo.Vertice;

public class Operacoes {
    
    //private Map<Integer,Vertice> conjunto_uniao=new HashMap<Integer,Vertice>();
    
    static int aux=1;
    
    //passando um ou dois vertices para poderem ser adicionados durante a execu-
    //ção dos métodos
    /*o metodo uniao entre conjuntos adiciona um vertice dentro de um conjunto
        de vertices
    */
    public static  Map<Integer,Vertice> Uniao_conjunto(Map<Integer,Vertice> conjunto_uniao,Vertice node1,Vertice node2){
    
        if ((conjunto_uniao.containsValue(node1)==false) && (node2==null)){
            conjunto_uniao.put(aux,node1);
            aux++;
        }else 
            if ((conjunto_uniao.containsValue(node1)==false) && (node2!=null)){
                conjunto_uniao.put(aux,node1);
                aux++;
                conjunto_uniao.put(aux,node2);
                aux++;
            }
        return conjunto_uniao;
    }
    
    /*Buscando um item de um conjunto de Vertices*/
    public static Vertice Sel_Vertice(Map<Integer,Vertice> conjunto,int id){
        return conjunto.get(id);
    }
    
    /*Buscando um item de um conjunto de Arestas*/
    public static Aresta Sel_Aresta(Map<Integer,Aresta> conjunto_de_arestas, int id_aresta){
        return conjunto_de_arestas.get(id_aresta);
    }
    
    /*Buscando um conjunto de vertices que incidem numa origem e em um destino*/
    public static Map<Integer,Aresta> Seleciona_arestas(Map<Integer,Aresta>conjunto_arestas, Vertice Origem, Vertice Destino){
        Map<Integer,Aresta> resultado=new HashMap();
        Aresta aux;
        int contador=0;
        for (int i=1;(conjunto_arestas.size()<=i);i++){
            aux=conjunto_arestas.get(i);
            if (((aux.getOrigem()==Origem) || (aux.getDestino()==Destino)) 
                    && (aux.isPertence()==true)){
                contador++;
                resultado.put(contador, aux);
            }
        }
        
        return resultado;
    }
    
    /*retornando um elemento do conjunto de Vertices*/
    public static int retorna_card_vertices(Map<Integer,Vertice> conjunto){
        return conjunto.size();
    }
    
    /*retornando um elemento do conjunto de Arestas*/
    public static int retorna_card_arestas(Map<Integer,Vertice> conjunto_arestas){
        return conjunto_arestas.size();
    }
    
    /*metodo responsavel para retirar do conjunto cada arco que incida em um
      vertice de origem e destino de arco 
    */
    public static Map<Integer,Aresta> dif_aresta(Map<Integer,Aresta> conjunto1, 
            Map<Integer,Aresta> conjunto2){
        for (int i=1;(conjunto2.size()<=i);i++){//conjunto2 é o conjunto a ser comparado
            for (int j=1;(conjunto1.size()<=j);j++){//conjunto1 é o "universo"
                if (conjunto2.containsValue(conjunto1.get(j))){
                    conjunto1.remove(j);
                }
            }
        }
        
        return conjunto1;
    }
    
    public static Map<Integer,Aresta> dif_vertice(Map<Integer,Aresta> conjunto1,
            Vertice vertice){
        
        /*aux para auxiliar a comparação casa o arco esteja partindo
        ou incidindo no vertice de maior grau
        */
        Aresta aresta;
        
        for (int i=1;conjunto1.size()<=i;i++){
            aresta=conjunto1.get(i);
            if((aresta.getDestino()==vertice) || (aresta.getOrigem()==vertice)){
                conjunto1.remove(i);
            }
        }
        
        return conjunto1;
    }
    
}
