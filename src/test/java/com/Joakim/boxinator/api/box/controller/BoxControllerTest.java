package com.Joakim.boxinator.api.box.controller;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
import com.Joakim.boxinator.api.box.repository.BoxRepository;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import com.Joakim.boxinator.api.box.service.BoxService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BoxControllerTest {

    private final BoxRepository repository = mock(BoxRepository.class);
    private final BoxService service = mock(BoxService.class);
    private BoxController controller = mock(BoxController.class);

    @BeforeEach
    void setUp() {
        controller = new BoxController(service);
    }

    @Test
    void getAllBoxes() {
        BoxResponseDto box = getBoxResponseDto();
        when(repository.getAllBoxes())
                .thenReturn(Stream.of(box).collect(Collectors.toList()));

        ResponseEntity<List<BoxResponseDto>> response =
                controller.getAllBoxes();
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
    }

    @Test
    void createBox() {
        Box box = getBox();
        when(repository.addBox(box)).thenReturn(box);

        ResponseEntity<Box> response = controller.createBox(box);
        assertThat(HttpStatus.CREATED).isEqualTo(response.getStatusCode());
    }

    private List<BoxResponseDto> getBoxList() {
        List<BoxResponseDto> boxList = new ArrayList<>();
        boxList.add(getBoxResponseDto());
        return boxList;
    }

    private Box getBox() {
        Box box = new Box();
        box.setId(1L);
        box.setWeight(99.5);
        box.setColor("#9c5454");
        box.setShippingCost(5);
        return box;
    }

    private BoxResponseDto getBoxResponseDto() {
        BoxResponseDto box = new BoxResponseDto();
        box.setName("Joakims box");
        box.setWeight(50.5);
        box.setColor("#9c5454");
        box.setShippingCost(50);
        return box;
    }
}