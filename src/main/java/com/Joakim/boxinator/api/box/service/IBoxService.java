package com.Joakim.boxinator.api.box.service;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
import com.Joakim.boxinator.api.box.repository.entity.Box;

import java.util.List;

public interface IBoxService {

    List<BoxResponseDto> getAllBoxes();

    Box addBox(Box box);
}
