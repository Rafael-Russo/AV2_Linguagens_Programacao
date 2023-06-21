import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public class Horario_Dentista {
    public static void main(String[] args) {
        // cria variaveis e inicializa algumas delas

        String diaSemana = "";
        Integer disponiveis;
        Integer marcados;

        // switch e variavel para validar se o dia da semana digitado é válido
        int diaValidar = 0;

        while (diaValidar == 0){
            diaSemana = JOptionPane.showInputDialog("Digite o dia da semana desejado");
            switch (diaSemana){
                case "Segunda-feira":
                    diaValidar = 2;
                    break;
                case "Terça-feira":
                    diaValidar = 3;
                    break;
                case "Quarta-feira":
                    diaValidar = 4;
                    break;
                case "Quinta-feira":
                    diaValidar = 5;
                    break;
                case "Sexta-feira":
                    diaValidar = 6;
                    break;
                case "Sábado":
                    diaValidar = 7;
                    break;
                case "Domingo":
                    diaValidar = 1;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Dia Inválido!");
                    diaValidar = 0;
                    break;
            }
        }

        //cria JOptionPane para receber o valor dos dias disponiveis
        disponiveis = Integer.parseInt(JOptionPane.showInputDialog("Numero de horarios disponiveis: "));

        //atribuo um valor para os dias marcados para entrar na condição do while validando se o numero de horarios marcados é válido
        marcados = disponiveis + 10;
        while (marcados > disponiveis || marcados < 0){
            marcados = Integer.parseInt(JOptionPane.showInputDialog("Numero de horarios marcados: "));
            if (marcados < disponiveis && marcados < 0){
                JOptionPane.showMessageDialog(null, "Horarios marcados inválidos");
            }
        }

        // cria JOptionPane para mostrar os resultados
        JOptionPane.showMessageDialog(null, "Na " +diaSemana+ " restam " + (disponiveis-marcados) + " horarios disponiveis" );
    }
}
