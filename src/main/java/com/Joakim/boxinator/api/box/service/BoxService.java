package com.Joakim.boxinator.api.box.service;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
import com.Joakim.boxinator.api.box.repository.BoxRepository;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxService implements IBoxService {

    private final BoxRepository repository;

    public BoxService(BoxRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BoxResponseDto> getAllBoxes() {
        return repository.getAllBoxes();
    }

    @Override
    public Box addBox(Box box) {
        return repository.addBox(box);
    }
}
