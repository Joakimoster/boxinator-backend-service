package com.Joakim.boxinator.api.box.repository;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBoxRepository {

    List<BoxResponseDto> getAllBoxes();

    Box addBox (Box box);
}
