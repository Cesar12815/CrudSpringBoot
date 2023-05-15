package com.example.CrudSpringBoot.controler;

import com.example.CrudSpringBoot.modelo.RegistrodeCarro;
import com.example.CrudSpringBoot.modelo.Vehiculo;
import com.example.CrudSpringBoot.service.VehiculoService;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParqueaderoCOntroler {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/vehiculos")
    public String listarVehiculos(Model model) {
        List<Vehiculo> vehiculos = vehiculoService.listar();
        model.addAttribute("vehiculos", vehiculos);
        return "listarVehiculos";
    }

    @GetMapping("/crear-vehiculo")
    public String mostrarFormularioCrearVehiculo(Model model) {
        Vehiculo vehiculo = new Vehiculo();
        model.addAttribute("vehiculo", vehiculo);
        return "formularioCrearVehiculo";
    }

    @PostMapping("/crear-vehiculo")
    public String crearVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo) {
        vehiculoService.guardar(vehiculo);
        return "redirect:/recibo-vehiculo?id=" + vehiculo.getId();
    }

    @GetMapping("/recibo-vehiculo")
    public String mostrarReciboVehiculo(@RequestParam("id") int id, Model model) {
        Optional<Vehiculo> optionalVehiculo = vehiculoService.buscarPorId(id);
        if (optionalVehiculo.isPresent()) {
            Vehiculo vehiculo = optionalVehiculo.get();
            model.addAttribute("vehiculo", vehiculo);
            return "reciboVehiculo";
        } else {
            return "redirect:/error";
        }
    }

    @PostMapping("/registrar-carro")
    public String registrarCarro(@RequestParam("placa") String placa,
                                 @RequestParam("modelo") String modelo,
                                 @RequestParam("hora_entrada") LocalTime horaEntrada,
                                 @RequestParam(value = "hora_salida", required = false) LocalTime horaSalida) {
        // Crear un nuevo objeto RegistrodeCarro con los datos enviados desde el formulario
        RegistrodeCarro nuevoRegistro = new RegistrodeCarro(placa, modelo, horaEntrada, horaSalida);

        // Guardar el objeto RegistrodeCarro en la base de datos usando el servicio correspondiente
        vehiculoService.registrarCarro(nuevoRegistro);

        // Redirigir al usuario a la pági   na de recibo, pasando el ID del carro recién creado en la URL
        return "redirect:/recibo-carro?id=" + nuevoRegistro.getId();
    }

    @GetMapping("/recibo-carro")
    public String mostrarReciboCarro(@RequestParam("id") Long id, Model model) {
        // Buscar el objeto RegistrodeCarro correspondiente al ID proporcionado en la base de datos
        Optional<RegistrodeCarro> optionalRegistro = vehiculoService.buscarRegistroPorId(id);
        if (optionalRegistro.isPresent()) {
            RegistrodeCarro registro = optionalRegistro.get();

            // Agregar el objeto RegistrodeCarro al modelo para que se pueda mostrar en la plantilla de recibo
            model.addAttribute("registro", registro);

            // Devolver la vista de recibo de carro
            return "reciboCarro";
        } else {
            // Si el ID no corresponde a ningún objeto RegistrodeCarro en la base de  datos, redirigir al usuario a una página de error
            return "redirect:/error";
        }
    }


    @GetMapping("/buscar-vehiculo")
        public String mostrarFormularioBuscarVehiculo(Model model) {
            String placa = "";
            model.addAttribute("placa", placa);
            return "formularioBuscarVehiculo";
        }

        @PostMapping("/buscar-vehiculo")
        public String buscarVehiculo (@RequestParam("placa") String placa, Model model){
            Optional<Vehiculo> optionalVehiculo = vehiculoService.buscarPorPlaca(placa);
            if (optionalVehiculo.isPresent()) {
                Vehiculo vehiculo = optionalVehiculo.get();
                model.addAttribute("vehiculo", vehiculo);
                return "resultadoBuscarVehiculo";
            } else {
                return "redirect:/vehiculos";
            }
        }

        @GetMapping("/editar-vehiculo/{id}")
        public String mostrarFormularioEditarVehiculo ( @PathVariable("id") int id, Model model){
            Optional<Vehiculo> optionalVehiculo = vehiculoService.buscarPorId(id);
            if (optionalVehiculo.isPresent()) {
                Vehiculo vehiculo = optionalVehiculo.get();
                model.addAttribute("vehiculo", vehiculo);
                return "formularioEditarVehiculo";
            } else {
                return "redirect:/error";
            }
        }

        @PostMapping("/editar-vehiculo")
        public String editarVehiculo (@ModelAttribute("vehiculo") @Validated Vehiculo vehiculo, BindingResult
        bindingResult){
            if (bindingResult.hasErrors()) {
                return "formularioEditarVehiculo";
            } else {
                vehiculoService.guardar(vehiculo);
                return "redirect:/vehiculos";
            }
        }
    }

