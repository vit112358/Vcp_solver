//******************************************************************************
//******************************************************************************
//  Vcp_solver                                                             
//******************************************************************************
//  Autores                                                                   
//  Fellipe Eduardo Peixto da Rocha, numero de matricula: 15276                      
//  Vitor Fernandes, numero de matricula: 0016084                                            
//******************************************************************************
//  (Instrucoes de compilacao)                                                
//  VERIFIQUE A VERSAO DA SUA JVM!!!
//  INFO (utilizado nesse trabalho)
//  java version "1.8.0_111"//
//  Java(TM) SE Runtime Environment (build 1.8.0_111-b14)
//  Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)
//  
//  O CAMINHO (PATH) DA APLICACAO NO PODE CONTER CARACTERES ESPECIAIS
//  
//******************************************************************************
//  Desenvolvido na IDE NetBeans 8.2                                          
//******************************************************************************
//  data: 22/11/2016                                                          
//  Essa classe e a principal, aqui sao chamadas as classes colaboradoras.    
//  Os parametros sao repassados por linha de comando.                        
//******************************************************************************
//  (cabecalho funcoes auxliares)                                             
//  (procedimentos implementados)                                             
//******************************************************************************
//******************************************************************************

import Arquivo.*;
import Grafo.*;
import PCV.PCV;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Vcp_solver {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static Map<Integer,Vertice> conjunto=new HashMap();
    
    public static void main(String[] args) throws IOException {
        
        //semente geradora de numeros aleatorios, informado por linha de comando
        int semente = Integer.valueOf(args[0]);
        
        //respectivo caracter informado por linha de comando 
        //que indica metodo a ser utilizado
        // a - para metodo aproximado, g - para metodo guloso
        String metodo = args[1];
        
        //nome do arquivo de entrada informado por linha de comando
        String ArqEntrada = args[2];
        
        //nome do arquivo de saida, informado por linha de comando
        String ArqSaida = args[3];
                
        //escrita do arquivo 
        EscritaArquivo arqSaida = new EscritaArquivo(ArqSaida);
        arqSaida.escrever(ArqEntrada, "QUANTIDADE DE NOS!", 
                "QUANTIDADE DE ARCOS!",Integer.toString(semente), metodo, 
                "COBERTURA!");
        
        System.out.println("Vertex\tCover\tSolver");
        System.out.println("======\t======\t======");
        System.out.println();
        System.out.println("Nodes:\t(NOS)");
        System.out.println("Arcs:\t(ARCOS)");
        System.out.println();
        System.out.println("Seed:\t"+semente);
        
        /*If que verifica o erro de Leitura, caso de erro não faz nada*/
        if (Arquivo.LeituraArquivo.Leitura_Arquivo(ArqEntrada)){
            Grafo grafo=new Grafo();
            
            grafo.inicializar_dados();
            
            if (metodo=="g")
            {
                System.out.println("Method:\tGreedy");
                
                conjunto=PCV.Greedy(grafo, semente);
                
            }else if (metodo=="a")
                {
                    System.out.println("Method:\tAproximado");
                    
                    conjunto=PCV.Aprox_Vertex_cover(grafo, semente);
                }else System.out.println("Invalido!");//apagar
        }else System.out.println("Erro de Leitura!");
    
        System.out.println("Input:\t"+ArqEntrada);
        System.out.println("Output:\t"+ArqSaida);
        System.out.println();
        System.out.println("Cover:\t"+conjunto);
        System.out.println();
        System.out.println("Cardinlidade do Conjunto:\t" + Integer.toString(conjunto.size()));
        System.out.println("End of Processing");
        System.out.println();
    }
    
}
