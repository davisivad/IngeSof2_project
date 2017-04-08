package com.example.fpuna.myfirstapp.Entidades;

/**
 * Created by Hiroshi on 06/04/2017.
 */
public class Hijos {

    int id;
    String nombreapellido;
    String fecha_nacimiento;
    String sexo;

    public int getId(){
        return id;
    }

    public void setId(int i){
        this.id = id;
    }

    public String getNombreapellido(){
        return nombreapellido;
    }

    public void setNombreapellido(String nombreapellido){
        this.nombreapellido = nombreapellido;
    }

    public String getFecha_nacimiento(){
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento){
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo(){
        return sexo;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    @Override
    public String toString(){
        return nombreapellido + " " + fecha_nacimiento + " " + sexo;
    }


}
