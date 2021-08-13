public class Evento{

    public String nameEvento, dInicio, dFinal;
    public Responsavel responsavel;
    public float cargaHorariaEv, valorGastoResp;
    public ListaPalestra[] listaPalestra;
    
    Evento(String nameEvento, Responsavel responsavel, String dInicio, String dFinal, float cargaHorariaEv, float valorGastoResp, ListaPalestra[] listaPalestra) {
        
        this.nameEvento = nameEvento;
        this.dInicio = dInicio;
        this.dFinal = dFinal;
        this.cargaHorariaEv = 0;
        this.valorGastoResp = valorGastoResp;
        this.listaPalestra =listaPalestra;
       
        
    }        
}
