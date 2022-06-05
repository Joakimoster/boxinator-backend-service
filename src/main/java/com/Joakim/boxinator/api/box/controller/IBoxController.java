package com.Joakim.boxinator.api.box.controller;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IBoxController {

    ResponseEntity<List<BoxResponseDto>> getAllBoxes();

    ResponseEntity<Box> createBox(@RequestBody Box box);
}
