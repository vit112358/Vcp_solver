/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivo;

/* Importando bibliotecas de leitura
 */
import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.FileWriter;(escrita)
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.StringTokenizer;
//=======================

/**
 *
 * @author Vitor
 */
public class LeituraArquivo {

static int[][] matriz_grafo; 
static String nome_Arquivo;
static int linhas = 0;
static int num_nos;
static int num_arcos;

public static boolean Leitura_Arquivo(String Caminho){
    boolean erro=false; //verifica erro, iniciado como falso, ou seja, nao há erro
    String linha;
    int l,c;//Strings que servirao para ver onde será colocada o 1 ou o 0 na matriz binaria matriz_grafo
    boolean aux1;//ve se a leitura foi feita certa e sai do laço
    aux1=false;
    String diretorio;
    diretorio=Caminho;
    while (erro==false){
        if (diretorio==null){
            erro=true;//erro de caminho nao digitado
        }else if (diretorio.equals("") || (diretorio.equals(" "))){//erro de caminho digitado caso aperte espaço
                erro=true;
            }else{
                String auxiliar = diretorio.substring(diretorio.length()-4, diretorio.length());
                //verificar se é .txt
                if (auxiliar.equals(".txt")){
                    try{
                        //Abrindo um arquivo para leitura
                        FileReader arquivo = new FileReader(diretorio);
			BufferedReader lerArquivo = new BufferedReader(arquivo);
                        linha = lerArquivo.readLine();
                        StringTokenizer Token0 = new StringTokenizer(linha," ");
                        String caracter=Token0.nextToken();
                        String word=Token0.nextToken();
                        num_nos=Integer.parseInt(Token0.nextToken());
                        num_arcos=Integer.parseInt(Token0.nextToken());
                        Integer n_linhas=num_nos;
                        matriz_grafo = new int [n_linhas][n_linhas];//intanciando uma matriz quadrada binaria
                        Integer ligaçoes=Integer.parseInt(Token0.nextToken());
                        for(int i=0;i<(n_linhas);i++){
                            linha=lerArquivo.readLine();
                            StringTokenizer Token2 = new StringTokenizer(linha," ");
                            word=Token2.nextToken();
                            l=Integer.parseInt(Token2.nextToken());
                            c=Integer.parseInt(Token2.nextToken());
                            matriz_grafo[l][c]=1;
                        }
                        //terminando de preencher a matriz com zeros
                        for (int i=0;i<(n_linhas);i++){
                            for (int j=0;j<(n_linhas);j++){
                                if (matriz_grafo[i][j]!=1){
                                    matriz_grafo[i][j]=0;
                                }
                            }
                        }
                        arquivo.close();
                        aux1=true;
                        erro=false;
                    }catch(IOException e){
                        erro=false;
                        aux1=false;
                    }
                }else {
                    erro=false;
                    aux1=false;
                }
        }        
    }       
    return aux1;
}

public static int[][] getMatriz_grafo() {
    return matriz_grafo;
}

public static int getLinhas() {
    return linhas;
}

    public static int getNum_nos() {
        return num_nos;
    }

    public static int getNum_arcos() {
        return num_arcos;
    }

}