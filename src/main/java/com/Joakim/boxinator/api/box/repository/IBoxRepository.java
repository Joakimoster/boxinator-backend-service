package com.Joakim.boxinator.api.box.repository;

import com.Joakim.boxinator.api.box.controller.dto.BoxDto;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBoxRepository {

    List<BoxDto> getAllBoxes();

    BoxDto addBox (BoxDto box);
}
