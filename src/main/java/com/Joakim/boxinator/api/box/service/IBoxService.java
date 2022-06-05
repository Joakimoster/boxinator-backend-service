package com.Joakim.boxinator.api.box.service;

import com.Joakim.boxinator.api.box.controller.dto.BoxDto;
import com.Joakim.boxinator.api.box.repository.entity.Box;

import java.util.List;

public interface IBoxService {

    List<BoxDto> getAllBoxes();

    BoxDto addBox(BoxDto box);
}
