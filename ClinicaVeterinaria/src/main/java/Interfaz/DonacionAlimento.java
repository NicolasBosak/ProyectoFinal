package Interfaz;

public class DonacionAlimento{
    private int alimentoDonado;
    private int diaDonacion;
    private int mesDonacion;
    private int anioDonacion;
    private boolean donaciones;
    private int capacidadAlmacen = 1000;

    public DonacionAlimento(int alimentoDonado, int diaDonacion, int mesDonacion, int anioDonacion, boolean donaciones) {
        this.alimentoDonado = alimentoDonado;
        this.diaDonacion = diaDonacion;
        this.mesDonacion = mesDonacion;
        this.anioDonacion = anioDonacion;
        this.donaciones = donaciones;
    }
    public int getAlimentoDonado() {
        return alimentoDonado;
    }

    public void setAlimentoDonado(int alimentoDonado) {
        this.alimentoDonado = alimentoDonado;
    }

    public int getDiaDonacion() {
        return diaDonacion;
    }

    public void setDiaDonacion(int diaDonacion) {
        this.diaDonacion = diaDonacion;
    }

    public int getMesDonacion() {
        return mesDonacion;
    }

    public void setMesDonacion(int mesDonacion) {
        this.mesDonacion = mesDonacion;
    }

    public int getAnioDonacion() {
        return anioDonacion;
    }

    public void setAnioDonacion(int anioDonacion) {
        this.anioDonacion = anioDonacion;
    }

    public boolean isDonaciones() {
        return donaciones;
    }

    public void setDonaciones(boolean donaciones) {
        this.donaciones = donaciones;
    }

    public int getCapacidadAlmacen() {
        return capacidadAlmacen;
    }

    public void setCapacidadAlmacen(int capacidadAlmacen) {
        this.capacidadAlmacen = capacidadAlmacen;
    }
}
