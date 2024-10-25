package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.ProductLine;
import com.proyecto.bd.repository.LineRepository;

@Service
public class LineService {

     private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public List<ProductLine> getAllLines() {
        return lineRepository.findAll();
    }

    public Optional<ProductLine> getLineById(Long id) {
        return lineRepository.findById(id);
    }

    public ProductLine createLine(ProductLine brand) {
        return lineRepository.save(brand);
    }


    public void deleteLine(Long id) {
        if (lineRepository.existsById(id)) {
            lineRepository.deleteById(id);
        } else {
            throw new RuntimeException("Brand not found with id: " + id);
        }
    }
}
