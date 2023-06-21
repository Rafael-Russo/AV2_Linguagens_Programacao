package ui;

import domain.Doce;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    //metodo para ler o arquivo
    public static String[] leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        List<String> linhas = new ArrayList<>();
        String linha = "";
        while (true) {
            if (linha != null){
                linha = buffRead.readLine();
                linhas.add(linha);
            }else {
                break;
            }
        }
        buffRead.close();
        return linhas.toArray(new String[0]);
    }

    //metodo para escrever o arquivo
    public static void escritor(String path, List<Doce>doces) throws IOException{
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        for (Doce doce : doces){
            buffWrite.write(doce.getNome()+ "/" + doce.getQnt() + "\n");
        }
        buffWrite.close();
    }

    public static void main(String[] args) {
        String arq = "";
        int opcao = 0;
        List<Doce> doces = new ArrayList<>();
        String mensagem = "";

        //cria o arquivo caso não exista
        try {
            File myObj = new File("Estoque_Doces.txt");
            arq = myObj.getAbsolutePath();
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        while (opcao != 3){
            opcao = Integer.parseInt( JOptionPane.showInputDialog("Escolha uma opção: \n 1- Adicionar Doce \n 2- Ver Estoque \n 3- Sair"));
            switch (opcao){
                case 1:
                    Doce d = new Doce();
                    d.setNome(JOptionPane.showInputDialog("Digite o Nome do Doce: "));
                    d.setQnt(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de Doces: ")));
                    doces.add(d);
                    break;
                case 2:
                    try{
                        escritor(arq, doces);
                        mensagem = "Estoque de doces: \n\n";
                        for (String linha : leitor(arq)){
                            mensagem+=linha+"\n";
                        }
                        JOptionPane.showMessageDialog(null, mensagem);
                    }catch (IOException e){
                        System.out.println("Erro: " + e);
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("opção inválida");
                    break;
            }
        }


    }
}
