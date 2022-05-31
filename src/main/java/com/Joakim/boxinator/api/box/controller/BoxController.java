package com.Joakim.boxinator.api.box.controller;

import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/box/v1")
public class BoxController implements IBoxController {


    //Todo
    @Override
    public ResponseEntity<List<Box>> getAllBoxes() {
        return null;
    }

    //Todo
    @Override
    public ResponseEntity<Box> createBox(Box box) {
        return null;
    }
}
