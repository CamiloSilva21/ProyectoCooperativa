package com.example.ProyectoCooperativa.controlador;

import com.example.ProyectoCooperativa.entidades.Cliente;
import com.example.ProyectoCooperativa.entidades.Usuario;
import com.example.ProyectoCooperativa.servicios.ServiceImplementCliente;
import com.example.ProyectoCooperativa.servicios.ServicieUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerCliente {

    @Autowired
    private ServicieUsuario servicieUsuario;
    @Autowired
    private ServiceImplementCliente serviceImplementCliente;

    public ControllerCliente(ServicieUsuario servicieUsuario) {
        this.servicieUsuario = servicieUsuario;
    }

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal OidcUser principal) {
        if(principal!=null){

            Usuario usuario = this.servicieUsuario.obtenerUsuario(principal.getClaims());
            System.out.println(principal.getClaims());
            model.addAttribute("usuario",usuario);
        }
        return "index";
    }


    //Método que permite mostrar todos los clientes en la tabla de los clientes
    @GetMapping("/cliente")
    public String listar(Model model){
        model.addAttribute("clientes",this.serviceImplementCliente.listarClientes());
        return ("tableCliente");
    }

    //Méotodo que permite consultar al cliente por medio de su documento
    @GetMapping("/{documento}")
    public Cliente consultarPorId(@PathVariable("documento") String documento){
        return serviceImplementCliente.consultaClientesForId(documento);
    }


    //Método que permite realizar la redirección hacia el formulario de registro de un nuevo cliente
    @GetMapping("cliente/registrar")
    public String registroFormulario(Model model){
        model.addAttribute("clienteinsertar", new Cliente());
        return ("FormCliente");
    }

    @PostMapping("cliente/guardar")
    public String insertar(@Validated Cliente cliente){
        serviceImplementCliente.guardarClientes(cliente);
        return "redirect:/cliente";
    }

    //---------------------------------------------------------

    @GetMapping("cliente/actualizar/{documento}")
    public String formularioActualizar(@PathVariable("documento") String documento, Model model){
        Cliente cliente = serviceImplementCliente.consultaClientesForId(documento);
        model.addAttribute("clienteactualizar", cliente);
        return "FrmUpdate";
    }

    @PostMapping("/cliente/actualizar")
    public String actualizar(Cliente cliente){
        serviceImplementCliente.actualizarClientes(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/cliente/eliminar/{documento}")
    public String eliminarPorId(@PathVariable("documento") String documento){
        serviceImplementCliente.eliminarClientesPorId(documento);
        return "redirect:/cliente";
    }

    /*@PatchMapping("/{documento}")
    public Cliente actualizarPorId(@PathVariable("documento")String documento, @RequestBody Map<Object, Object> objectMap){
        return  serImpCliente.actualizarPorId(documento, objectMap);
    }*/

}
