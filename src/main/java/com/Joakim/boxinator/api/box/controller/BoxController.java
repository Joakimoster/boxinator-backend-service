package com.Joakim.boxinator.api.box.controller;

import com.Joakim.boxinator.api.box.repository.entity.Box;
import com.Joakim.boxinator.api.box.service.BoxService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/box/v1")
public class BoxController implements IBoxController {

    private final BoxService service;

    public BoxController(BoxService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/boxes")
    public ResponseEntity<List<Box>> getAllBoxes() {
        return new ResponseEntity<>(service.getAllBoxes(), HttpStatus.OK);
    }

    //Todo
    @Override
    @PostMapping("/box")
    public ResponseEntity<Box> createBox(@RequestBody Box box) {
        return new ResponseEntity<>(service.addBox(box), HttpStatus.CREATED);
    }
}
