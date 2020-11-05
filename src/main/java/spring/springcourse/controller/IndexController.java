package spring.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.springcourse.models.Usuario;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping( {"/","/index", "/home" })
    public String index(Model model){
        model.addAttribute("titulo", "hola spring Framework!");
        return "index";

    }

    @RequestMapping("/perfil")
        public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("fran");
        usuario.setApellido("reyes");
        usuario.setEmail("fran@live.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil de usuario:".concat(usuario.getNombre()));

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){
        model.addAttribute("titulo","listado de usuarios");
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Francisco","Reyes","aresfrt@live.com"));
        usuarios.add(new Usuario("Antonio","Guzman","antonio@live.com"));
        usuarios.add(new Usuario("Sofia","Perez","sofia@live.com"));
        usuarios.add(new Usuario("Pedro","Tornado","tornado@live.com"));

        return usuarios;

    }

}
