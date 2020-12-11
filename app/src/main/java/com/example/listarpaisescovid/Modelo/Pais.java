package com.example.listarpaisescovid.Modelo;

public class Pais {
    private String nombre;
    private int totalConfirmados;
    private int totalMuertes;
    private int totalRecuperados;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalConfirmados() {
        return totalConfirmados;
    }

    public void setTotalConfirmados(int totalConfirmados) {
        this.totalConfirmados = totalConfirmados;
    }

    public int getTotalMuertes() {
        return totalMuertes;
    }

    public void setTotalMuertes(int totalMuertes) {
        this.totalMuertes = totalMuertes;
    }

    public int getTotalRecuperados() {
        return totalRecuperados;
    }

    public void setTotalRecuperados(int totalRecuperados) {
        this.totalRecuperados = totalRecuperados;
    }
}
