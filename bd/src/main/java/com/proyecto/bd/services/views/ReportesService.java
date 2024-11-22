package com.proyecto.bd.services.views;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.views.LowProducts;
import com.proyecto.bd.entities.views.TopClients;
import com.proyecto.bd.entities.views.TopEmployyes;
import com.proyecto.bd.entities.views.TopProducts;
import com.proyecto.bd.repository.views.LowProductRepository;
import com.proyecto.bd.repository.views.TopClientsRepository;
import com.proyecto.bd.repository.views.TopEmployyesRepository;
import com.proyecto.bd.repository.views.TopProductRepository;

@Service
public class ReportesService {

    
    private final TopProductRepository topProductRepository;
    private final LowProductRepository lowProductRepository;
    private final TopClientsRepository topClientsRepository;
    private final TopEmployyesRepository topEmployyesRepository;
    

    public ReportesService(TopProductRepository topProductRepository, LowProductRepository lowProductRepository,
    TopClientsRepository topClientsRepository, TopEmployyesRepository topEmployyesRepository) {
        this.topProductRepository = topProductRepository;
        this.lowProductRepository = lowProductRepository;
        this.topClientsRepository = topClientsRepository;
        this.topEmployyesRepository = topEmployyesRepository;
    }

    public List<TopProducts> getTopProducts() {
        return topProductRepository.findAll();
    }

    public List<LowProducts> getLowProducts() {
        return lowProductRepository.findAll();
    }

    public List<TopClients> getTopClientes() {
        return topClientsRepository.findAll();
    }

    public List<TopEmployyes> getTopEmployyes() {
        return topEmployyesRepository.findAll();
    }
}
