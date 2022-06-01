package com.Joakim.boxinator.api.box.repository;

import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBoxRepository {

    List<Box> getAllBoxes();

    Box addBox (Box box);
}
