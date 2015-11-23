/**
 * Created by Andrea on 23/11/2015.
 */
public class Cobro {

    private String nombrePagador;
    private String nombreCobrador;
    private Float importe;
    private String concepto;

    public Cobro(String nPagador,String nCobrador,Float importes,String concept){
        this.nombreCobrador=nCobrador;
        this.nombrePagador=nPagador;
        this.importe=importes;
        this.concepto=concept;

    }

    public String getNombrePagador() {
        return nombrePagador;
    }

    public void setNombrePagador(String nombrePagador) {
        this.nombrePagador = nombrePagador;
    }

    public String getNombreCobrador() {
        return nombreCobrador;
    }

    public void setNombreCobrador(String nombreCobrador) {
        this.nombreCobrador = nombreCobrador;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }


}
