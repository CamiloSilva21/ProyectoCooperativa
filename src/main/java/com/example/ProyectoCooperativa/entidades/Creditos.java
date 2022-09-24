package com.example.ProyectoCooperativa.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Creditos {

    @Id
    private int codigo;
    @Column(name = "monto_Prestamo", nullable = false)
    private int montoPrestamo;
    @Column(name = "plazo_Prestamo", nullable = false)
    private int plazoPrestamo;
    @Column(name = "fecha_Desembolso", nullable = false)
    private Date fechaDesembolso;

    @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="documento_Cliente")
        Cliente cliente;

    @ManyToOne
        @JoinColumn(name="codigo_lineasDeCredito")
        LineasDeCredito lineasDeCredito;

    public Creditos(int codigo, int montoPrestamo, int plazoPrestamo, Date fechaDesembolso, Cliente cliente, LineasDeCredito lineasDeCredito) {
        this.codigo = codigo;
        this.montoPrestamo = montoPrestamo;
        this.plazoPrestamo = plazoPrestamo;
        this.fechaDesembolso = fechaDesembolso;
        this.cliente = cliente;
        this.lineasDeCredito = lineasDeCredito;
    }

    public Creditos(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(int montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public int getPlazoPrestamo() {
        return plazoPrestamo;
    }

    public void setPlazoPrestamo(int plazoPrestamo) {
        this.plazoPrestamo = plazoPrestamo;
    }

    public Date getFechaDesembolso() {
        return fechaDesembolso;
    }

    public void setFechaDesembolso(Date fechaDesembolso) {
        this.fechaDesembolso = fechaDesembolso;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LineasDeCredito getLineasDeCredito() {
        return lineasDeCredito;
    }

    public void setLineasDeCredito(LineasDeCredito lineasDeCredito) {
        this.lineasDeCredito = lineasDeCredito;
    }
}
