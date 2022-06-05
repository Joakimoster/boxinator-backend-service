package com.Joakim.boxinator.api.box.service;

import com.Joakim.boxinator.api.box.controller.dto.BoxDto;
import com.Joakim.boxinator.api.box.repository.BoxRepository;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxService implements IBoxService {

    private final BoxRepository repository = new BoxRepository();

    @Override
    public List<BoxDto> getAllBoxes() {
        return repository.getAllBoxes();
    }

    @Override
    public BoxDto addBox(BoxDto box) {
        return repository.addBox(box);
    }
}
