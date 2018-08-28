package com.example.desarollo.myapplication3;

import java.sql.Date;

public class Empleado {


    private String nombre;
    private String PHTD;



    public Empleado(String nombre, String PHTD){

        this.nombre = nombre;
        this.PHTD = PHTD;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPHTD() {
        return PHTD;
    }


    public void setPHTD(String PHTD) {
        this.PHTD = PHTD;
    }
}
