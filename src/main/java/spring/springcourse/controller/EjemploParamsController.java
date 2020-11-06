package spring.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/index")
    public String index(){
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name="texto", defaultValue = "Hi") String texto, Model model){
        model.addAttribute("resultado","El texto enviado es: "+ texto);
        return "params/ver";

    }

    @GetMapping("/multi-params")
    public String param(@RequestParam() String saludo, @RequestParam() Integer numero, Model model){
        model.addAttribute("resultado","El texto enviado es: "+ saludo + " y el numero es: "+ numero );
        return "params/ver";

    }

    //The old way, don´t use
    @GetMapping("/multi-request")
    public String param(HttpServletRequest request, Model model){
        String saludo = request.getParameter("saludo");
        Integer numero = Integer.parseInt(request.getParameter("numero"));

        model.addAttribute("resultado","El texto enviado es: "+ saludo + " y el numero es: "+ numero );
        return "params/ver";

    }

}
