import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Atracoes {

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
    public static void escritor(String path) throws IOException{
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        buffWrite.write("Quinta - Sertanejo - Fred e Gustavo\n" +
                "\n" +
                "Sexta - Rock - Baú do Rock\n" +
                "\n" +
                "Sábado - Blues - Alvas\n" +
                "\n" +
                "Domingo - Samba - Os maias");
        buffWrite.close();
    }

    public static void main(String[] args) {
        String arq = "";
        //cria o arquivo caso não exista
        try {
            File myObj = new File("Atracoes.txt");
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

        //chama o metodo de ecritor, para escrever as atrações
        try{
            escritor(arq);
        }catch (IOException e){
            System.out.println("Erro ao escrever o arquivo: " + e);
        }

        String mensagem = "";

        // lê cada linha do arquivo e concatena em uma String
        try{
            String[] linhas = leitor(arq);
            mensagem = "Atrações da semana: \n";
            for (String linha : linhas){
                mensagem += linha + "\n";
            }
        }catch (IOException e){
            System.out.println("Erro ao ler o arquivo: " + e);
        }

        // mostra o resultado da String ja concatenada com os dados do arquivo que foi lido
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
