package com.example.ProyectoCooperativa.repositorio;

import com.example.ProyectoCooperativa.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCliente extends JpaRepository<Cliente,String> {

}
