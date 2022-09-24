package com.example.ProyectoCooperativa.servicios;

import com.example.ProyectoCooperativa.entidades.Cliente;
import com.example.ProyectoCooperativa.repositorio.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ServiceImplementCliente implements ServiceCliente {

    @Autowired
    private RepositoryCliente repositoryCliente;

    @Override
    public List<Cliente> listarClientes() {

        return repositoryCliente.findAll();
    }

    @Override
    public Cliente guardarClientes(Cliente cliente) {
        return repositoryCliente.save(cliente); //Se le pasa como parametro el objeto más no la clase (Revisar interfaz Servicio cliente)
    }

    @Override
    public Cliente consultaClientesForId(String documento) {
        return repositoryCliente.findById(documento).get();
    }

    @Override
    public Cliente actualizarClientes(Cliente cliente) {
        return repositoryCliente.save(cliente);
    }

    @Override
    public void eliminarClientesPorId(String documento) {
        repositoryCliente.deleteById(documento);
    }

    @Override
    public Cliente actualizarPorId(String documento, Map<Object, Object> objectMap) {

        Cliente cliente = repositoryCliente.findById(documento).get(); //Buscar la llave primaria de la clase
        objectMap.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Cliente.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, cliente,value);
        });
        return repositoryCliente.save(cliente);


    }
}
