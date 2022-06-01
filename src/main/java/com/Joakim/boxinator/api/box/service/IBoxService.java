package com.Joakim.boxinator.api.box.service;

import com.Joakim.boxinator.api.box.repository.entity.Box;

import java.util.List;

public interface IBoxService {

    List<Box> getAllBoxes();

    Box addBox(Box box);
}
