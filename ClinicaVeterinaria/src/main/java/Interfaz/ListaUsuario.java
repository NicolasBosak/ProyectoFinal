package Interfaz;

class ListaUsuario {
    private String nombreV;
    private String aplellidoV;
    private int dia;
    private int mes;
    private int anio;
    private int ci;

        public ListaUsuario(String nombreV, String aplellidoV, int dia, int mes, int anio, int ci){
        this.nombreV = nombreV;
        this.aplellidoV = aplellidoV;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.ci = ci;
    }

    
    public String getNombreV() {
        return nombreV;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public String getAplellidoV() {
        return aplellidoV;
    }

    public void setAplellidoV(String aplellidoV) {
        this.aplellidoV = aplellidoV;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

}
