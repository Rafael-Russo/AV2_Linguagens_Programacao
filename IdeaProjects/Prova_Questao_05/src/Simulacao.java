import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulacao {
    public static String geraHora() {
        Random random = new Random();
        int hora = random.nextInt(11) + 11; // Entre 11 e 21
        int minuto = 00;
        String horarioFormatado = String.format("%02d:%02d", hora, minuto);
        return horarioFormatado;
    }

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
    public static void escritor(String path, String[]linhas) throws IOException{
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        for (String linha : linhas){
            buffWrite.write(linha + "\n");
        }
        buffWrite.close();
    }

    public static void main(String[] args) {
        String arqMinas = "";
        //cria o arquivo clubes de MG caso não exista
        try {
            File myObj = new File("Minas.txt");
            arqMinas = myObj.getAbsolutePath();
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] minas = new String[2];
        minas[0] = "Cruzeiro";
        minas[1] = "Atletico";

        try{
            escritor(arqMinas, minas);
        }catch (IOException e){
            System.out.println(e);
        }


        String arqSP = "";
        //cria o arquivo clubes de SP caso não exista
        try {
            File myObj = new File("SP.txt");
            arqSP = myObj.getAbsolutePath();
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] sp = new String[2];
        sp[0] = "Santos";
        sp[1] = "São Paulo";

        try{
            escritor(arqSP, sp);
        }catch (IOException e){
            System.out.println(e);
        }


        String arqConfronto = "";
        try {
            File myObj = new File("Confronto.txt");
            arqConfronto = myObj.getAbsolutePath();
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            String[] times1 = leitor(arqMinas);
            String[] times2 = leitor(arqSP);

            BufferedWriter writer = new BufferedWriter(new FileWriter(arqConfronto));
            for (int i = 0; i < minas.length; i++) {
                String confronto = times1[i] + " x " + times2[i];
                String horario = geraHora();
                String linha = confronto + " " + horario;
                writer.write(linha + "\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
