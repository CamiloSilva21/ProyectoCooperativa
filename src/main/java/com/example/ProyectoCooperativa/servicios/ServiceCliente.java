package com.example.ProyectoCooperativa.servicios;

import com.example.ProyectoCooperativa.entidades.Cliente;

import java.util.List;
import java.util.Map;

public interface ServiceCliente {

    //Método abstract para listar los clientes de la tabla
    public List<Cliente>listarClientes();

    //Método abstract para guardar objetos cliente de la clase Cliente
    public Cliente guardarClientes(Cliente cliente);

    //Método abstract para consultar los clientes por medio de la primary key
    public Cliente consultaClientesForId(String documento);

    //Método abstract para actualizar los clientes a través de un objeto de la clase Cliente
    public Cliente actualizarClientes(Cliente cliente);

    //Método abstract para eliminar un cliente de la entidad Cliente
    public void eliminarClientesPorId(String documento);

    public Cliente actualizarPorId(String documento, Map<Object,Object> objectMap);

}
