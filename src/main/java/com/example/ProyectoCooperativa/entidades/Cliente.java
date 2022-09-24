package com.example.ProyectoCooperativa.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Clientes")
public class Cliente {

    @Id //Indicar que el atributo continuo (documento) es la primary key
    private String documento;
    @Column(nullable = false,length = 30)
    private String nombres,apellidos;
    @Column(nullable = false, length = 50, unique = true)
    private String correo;
    @Column(nullable = false, length = 15)
    private String celular;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Creditos> creditos;

    public Cliente(String documento, String nombres, String apellidos, String correo, String celular) {
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
    }

    public Cliente(){

    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
