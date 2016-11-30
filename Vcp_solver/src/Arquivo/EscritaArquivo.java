package Arquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscritaArquivo {
    
    //construtor da classe
    public EscritaArquivo(String path) throws IOException
    {
        //define o caminho do arquivo para o objeto instaciado
        this.path = path;
        
        //invoca o metodo de busca do arquivo de saida
        procuraArq(this.path);
        
        if (!existe)
        {
            //instancia de arquivo
            File arq = new File(this.path);
            
            //perguntar para o vitor o pq de incluir IOException
            FileWriter fw = new FileWriter(arq);
            
            //escrita do cabecalho do arquivo 
            fw.write("INSTANCE");
            fw.write(9);
            fw.write("NODES");
            fw.write(9);
            fw.write("ARCS");
            fw.write(9);
            fw.write("SEED");
            fw.write(9);
            fw.write("METHOD");
            fw.write(9);
            fw.write("COVER");
            
            //fecha o arquivo
            fw.close();
        }
    }
    
//ATRIBUTOS*********************************************************************
    //local do arquivo
    private final String path;
    //booleano, indica se o arquivo existe ou nao existe
    boolean existe;
//******************************************************************************
    
//METODOS***********************************************************************
    //identifica se o arquivo ja existe
    private void procuraArq(String path)
    {
        //invoca o metodo exists, o mesmo procura o arquivo
        this.existe = new File(path).exists();
    }            
    //escreve no arquivo os parametros passados
    public void escrever(String instancia, String nos, String arestas,
            String semente, String metodo, String cobertura)
    {
        //tenta criar o File Writer
        try {
            //File Writer responsavel por adicionar novas linhas em um arquivo
            FileWriter arq = new FileWriter(path, true);
            
            //classe auxiliar de escrita
            BufferedWriter escritor = new BufferedWriter(arq);
            
            //linhas adicioandas            
            escritor.newLine();
            escritor.write(instancia);
            escritor.write(9);
            escritor.write(nos);
            escritor.write(9);
            escritor.write(arestas);
            escritor.write(9);
            escritor.write(semente);
            escritor.write(9);
            escritor.write(metodo);
            escritor.write(9);
            escritor.write(cobertura);
            escritor.write(9);
            
            //fecha o arquivo 
            escritor.close();
            arq.close();            
        } catch (IOException ex) {
            Logger.getLogger(EscritaArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//******************************************************************************
}
