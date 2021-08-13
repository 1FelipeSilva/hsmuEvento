import java.io.PrintStream;
import java.util.Scanner;
//import java.sql.Date;
//import java.text.SimpleDateFormat;

public class CriarEventos{

    public static void main(String[] args) {
        CriarEventos programa = new CriarEventos();
        programa.executar();
    }

    private final Scanner entrada = new Scanner(System.in);
    private final PrintStream saida = System.out;

    public void executar() {

        escrever("Digite a quantidade de eventos que ocorrerão: \n");
        int qtEvento = lerInteiro();
        escrever("Quantidade de eventos: "+ Integer.toString("%.2f" + qtEvento));  
        