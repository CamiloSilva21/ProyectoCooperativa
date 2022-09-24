package com.example.ProyectoCooperativa.servicios;

import com.example.ProyectoCooperativa.entidades.Usuario;
import com.example.ProyectoCooperativa.repositorio.RepositoryUsuario;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServicieUsuario {
    private RepositoryUsuario repositoryUsuario;

    public ServicieUsuario(RepositoryUsuario repositoryUsuario) {
        this.repositoryUsuario = repositoryUsuario;
    }

    //Es el dato que va llegar y se va almacenar para ser guardado en la tabla usuario
    public Usuario guardarUsuario(Usuario usuario){
        return this.repositoryUsuario.save(usuario);
    }

    //Método para buscar a un usuario por el email aplicando el método que se creo el repositorio
    public Usuario buscarUsuarioPorEmail(String email){
        return this.repositoryUsuario.findByEmail(email);
    }

    //Método para obtener los datos de la persona que se esta registrando
    public Usuario obtenerUsuario(Map<String,Object> datoUsuario ){
        String email= (String) datoUsuario.get("email");
        Usuario usuario= buscarUsuarioPorEmail(email);

        //Si el usuario no se ha registrado entonces se hará dentro de la base de datos para eso es la condición
        if(usuario==null){
            String nombre= (String) datoUsuario.get("nickname");
            String image = (String)  datoUsuario.get("picture");
            String correo = (String) datoUsuario.get("email");

            Usuario user = new Usuario(correo,image,nombre);
            return guardarUsuario(user);
        }
        System.out.println(usuario.getEmail());
        return usuario;
    }
}

