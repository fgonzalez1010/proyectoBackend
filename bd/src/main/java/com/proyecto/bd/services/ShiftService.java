package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.proyecto.bd.entities.Shift;
import com.proyecto.bd.repository.ShiftRepository;

@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;

    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

   
     public List<Shift> getAllShift() {
        return shiftRepository.findAll();
    }

     public Optional<Shift> getShiftById(Long id) {
        return shiftRepository.findById(id);
    }

    public Shift createShift(Shift shift) {
        return shiftRepository.save(shift);
    }


     public Shift updateShift(Long id, Shift updatedShift) {
        return shiftRepository.findById(id)
                .map(existingShift -> {
                    existingShift.setStartTime(updatedShift.getStartTime());
                    return shiftRepository.save(existingShift);
                }).orElseThrow(() -> new RuntimeException("Shift not found with id: " + id));
    }

    public void deleteShift(Long id) {
        if (shiftRepository.existsById(id)) {
            shiftRepository.deleteById(id);
        } else {
            throw new RuntimeException("shift not found with id: " + id);
        }
    }
}
