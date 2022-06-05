package com.Joakim.boxinator.api.box.controller;

import com.Joakim.boxinator.api.box.controller.dto.BoxDto;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IBoxController {

    ResponseEntity<List<BoxDto>> getAllBoxes();

    ResponseEntity<BoxDto> createBox(@RequestBody BoxDto box);
}
