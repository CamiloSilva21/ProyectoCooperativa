package com.example.ProyectoCooperativa.servicios;

import com.example.ProyectoCooperativa.entidades.Creditos;

import java.util.List;

public interface ServiceCreditos {

    //Método abstract para listar los creditos de la tabla creditos
    public List<Creditos> listarCreditos();

    //Método abstract para guardar objetos creditos de la clase creditos
    public Creditos guardarCreditos(Creditos creditos);

}
