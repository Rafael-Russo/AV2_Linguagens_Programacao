import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public class Media_Alunos {
    public static void main(String[] args) {
        //cria variaveis para armazenar valores
        double av1;
        double av2;
        double media;

        //tratamento de exeção para não dividir por 0
        try{
            //solicita o usuario para digitar as notas da AV1 e AV2
            av1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota da AV1: "));
            av2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota da AV2: "));
            media = (av1+av2)/2;
            JOptionPane.showMessageDialog(null, "A média é: " + media);
        }catch (ArithmeticException e){
            System.out.println("Não pode dividir por 0: " + e);
        }
    }
}
