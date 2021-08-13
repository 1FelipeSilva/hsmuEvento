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
        escrever("Quantidade de eventos: "+ Integer.toString(qtEvento));  
        Evento[] meusEventos = new Evento[qtEvento];
        //escrever(Integer.toString(ev.length));
        for (int i = 0; i < meusEventos.length; i++) {  
            
            escrever("Digite o nome do " + (i + 1) + "° evento \n");
            String nameEvento = lerTexto();

            //Início, preenche informações do responsável.            
            escrever("Digite o nome do(a)  responsável do evento " + nameEvento + ": \n");
            String nomeRes = lerTexto();

            escrever("Digite o contato do(a)  responsável do evento " + nameEvento + ": \n");
            String telefoneRes = lerTexto();

            escrever("Digite o valor/hora do(a)  responsável do evento " + nameEvento + ": \n");
            float valorHoraRes = lerDecimal();
            
            Responsavel responsavel = new Responsavel(nomeRes, telefoneRes, valorHoraRes);
            //Fim, preenche informações do responsável.

            escrever("Digite a data de início do evento " + nameEvento + ": \n");
            String dInicio = lerTexto();

            escrever("Digite a data de final do evento " + nameEvento + ": \n");
            String dFinal = lerTexto();

            escrever("Digite a carga horária do evento " + nameEvento + ": \n");
            float cargaHorariaEv = lerDecimal();

            float valorGastoResp = valorHoraRes * cargaHorariaEv;

            //Início, preenche informações da lista de palestra.

            escrever("Digite a quantidade de palestra que ocorrerão no evento " + nameEvento + ": \n");
            int qtPalestra = lerInteiro();

            ListaPalestra[] minhasPalestra = new ListaPalestra[qtPalestra];
            for (int n = 0; n < minhasPalestra.length; n++) {

                escrever("Digite o tiulo da "  + (n + 1) + "° palestra do evento " + nameEvento + ": \n");
                String titulo = lerTexto();

                escrever("Digite a descrição da palestra" + titulo + "do evento " + nameEvento + ": \n");
                String descricao = lerTexto();

                escrever("Digite o horário inicial da palestra" + titulo + "do evento " + nameEvento + ": \n");
                String horarioIn = lerTexto();

                escrever("Digite carga horária da palestra" + titulo + "do evento " + nameEvento + ": \n");
                float cargaHoraria = lerDecimal();

                //Início, preenche informações do palestrante.
        
                escrever("Digite o nome do palestrante da palestra" + titulo + "do evento " + nameEvento + ": \n");
                String nomePal = lerTexto();

                escrever("Digite o telefone do palestrante da palestra" + titulo + "do evento " + nameEvento + ": \n");
                String telefonePal = lerTexto();

                escrever("Digite o valor/hora do palestrante da palestra" + titulo + "do evento " + nameEvento + ": \n");
                float valorHoraPal = lerDecimal();
                
                Palestrante palestrante = new Palestrante(nomePal, telefonePal, valorHoraPal);

                float valorGastPal = cargaHoraria * valorHoraPal;
                //Fim, preenche informações do palestrante.
            
                ListaPalestra listaPalestra = new ListaPalestra(titulo, descricao, horarioIn, cargaHoraria, palestrante, valorGastPal);
                minhasPalestra[n] = listaPalestra;
                
            }
            
            Evento evento = new Evento(nameEvento, responsavel, dInicio, dFinal, cargaHorariaEv, valorGastoResp, minhasPalestra);
            meusEventos[i] = evento;  
        
        }

        
        


        for(int m = 0; m < meusEventos.length; m++){
            float maior = 0, menor = 0;
            Palestrante maiorPalestrante = new Palestrante();
            Palestrante menorPalestrante = new Palestrante();
            escrever("Resumo do evento: " + meusEventos[m].nameEvento + "\n");
            escrever("Gastos com o responsável: " + meusEventos[m].valorGastoResp + "\n");
            float valorTotalPal = 0;
            for(int n = 0; n < meusEventos[m].listaPalestra.length; n++){
                valorTotalPal += meusEventos[m].listaPalestra[n].valorGastPal;
                escrever("Valor total da palestra" + meusEventos[m].listaPalestra[n].titulo +": "+ meusEventos[m].listaPalestra[n].valorGastPal + "\n");
                if(maior < meusEventos[m].listaPalestra[n].valorGastPal){
                    maiorPalestrante = new Palestrante(meusEventos[m].listaPalestra[n].palestrante.nomePal, meusEventos[m].listaPalestra[n].palestrante.telefonePal, meusEventos[m].listaPalestra[n].palestrante.valorHoraPal );
                    maior = meusEventos[m].listaPalestra[n].valorGastPal;
                }
            }
            menor = maior;
            for(int n = 0; n < meusEventos[m].listaPalestra.length; n++){
                if(menor > meusEventos[m].listaPalestra[n].valorGastPal){
                    menorPalestrante = new Palestrante(meusEventos[m].listaPalestra[n].palestrante.nomePal, meusEventos[m].listaPalestra[n].palestrante.telefonePal, meusEventos[m].listaPalestra[n].palestrante.valorHoraPal );
                    menor = meusEventos[m].listaPalestra[n].valorGastPal;
                }
            }
            //maior palest
            escrever("Dados do palestrante com o maior valor gasto: \n");
            escrever("Nome: " + maiorPalestrante.nomePal + "\n"); 
            escrever("Telefone: " + maiorPalestrante.telefonePal + "\n"); 
            escrever("Valor por hora: R$" + maiorPalestrante.valorHoraPal + " %.2f \n"); 
            //menor palest
            escrever("Dados do palestrante com o menor valor gasto: \n");
            escrever("Nome: " + menorPalestrante.nomePal + "\n"); 
            escrever("Telefone: " + menorPalestrante.telefonePal + "\n"); 
            escrever("Valor por hora: R$" + menorPalestrante.valorHoraPal + "\n");

            escrever("Valor total das palestras: R$" + valorTotalPal + "\n");
            escrever("__________________________________________________________");

        }        
    }
    private void escrever(String mensagem) {
        saida.print(mensagem);
    }

    private int lerInteiro() {
        return Integer.parseInt(lerTexto());
    }
    
    private float lerDecimal() {
        return Float.parseFloat(lerTexto());
    }

    private String lerTexto() {
        return entrada.nextLine();
    }
}