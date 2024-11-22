package com.proyecto.bd.controllers.views;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.bd.entities.views.LowProducts;
import com.proyecto.bd.entities.views.TopClients;
import com.proyecto.bd.entities.views.TopEmployyes;
import com.proyecto.bd.entities.views.TopProducts;
import com.proyecto.bd.services.views.ReportesService;


@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportesController {

    @Autowired
    private ReportesService rolesService;

    // Obtener todas las marcas
    @GetMapping("/topProducts")
    public List<TopProducts> getTopProducts() {
        return rolesService.getTopProducts();
    }

    @GetMapping("/lowProducts")
    public List<LowProducts> getLowProducts() {
        return rolesService.getLowProducts();
    }
    
    @GetMapping("/topClients")
    public List<TopClients> getTopClients() {
        return rolesService.getTopClientes();
    }
    
    @GetMapping("/topEmployees")
    public List<TopEmployyes> getTopEmployes() {
        return rolesService.getTopEmployyes();
    }
    


}
