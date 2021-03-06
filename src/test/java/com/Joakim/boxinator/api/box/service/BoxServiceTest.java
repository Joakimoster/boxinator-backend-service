package com.Joakim.boxinator.api.box.service;

import com.Joakim.boxinator.api.box.controller.dto.BoxResponseDto;
import com.Joakim.boxinator.api.box.repository.BoxRepository;
import com.Joakim.boxinator.api.box.repository.entity.Box;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BoxServiceTest {

    private final BoxRepository repository = mock(BoxRepository.class);
    private BoxService service = mock(BoxService.class);

    private List<BoxResponseDto> boxList;

    @BeforeEach
    void setUp() {
        service = new BoxService(repository);
        this.boxList = new ArrayList<>();
        boxList = getBoxList();
    }

    @Test
    void getAllBoxes() {
        when(repository.getAllBoxes()).thenReturn(boxList);
        assertThat(service.getAllBoxes()).isEqualTo(boxList);
    }

    @Test
    void addBox() {
        Box box = getBox();
        service.addBox(box);

        ArgumentCaptor<Box> boxArgumentCaptor =
                ArgumentCaptor.forClass(Box.class);
        verify(repository).addBox(boxArgumentCaptor.capture());

        Box capturedBox = boxArgumentCaptor.getValue();
        assertThat(capturedBox).isEqualTo(box);
    }

    @Test
    void canCalculateCorrectShippingCostWhenChinaIsBoxDestination() {
        Box box = new Box();
        box.setName("Test box");
        box.setWeight(50);
        box.setCountry("CHINA");
        box.setShippingCost(service.calculateShippingCost(box.getWeight(), box.getCountry()));
        assertThat(box.getShippingCost()).isEqualTo(service.calculateShippingCost(50, "CHINA"));
    }

    @Test
    void canCalculateCorrectShippingCostWhenBrazilIsBoxDestination() {
        Box box = new Box();
        box.setName("Test box");
        box.setWeight(10);
        box.setCountry("BRAZIL");
        box.setShippingCost(service.calculateShippingCost(box.getWeight(), box.getCountry()));
        assertThat(box.getShippingCost()).isEqualTo(service.calculateShippingCost(10, "BRAZIL"));
    }

    @Test
    void canCalculateCorrectShippingCostWhenSwedenIsBoxDestination() {
        Box box = new Box();
        box.setName("Test box");
        box.setWeight(33);
        box.setCountry("SWEDEN");
        box.setShippingCost(service.calculateShippingCost(box.getWeight(), box.getCountry()));
        assertThat(box.getShippingCost()).isEqualTo(service.calculateShippingCost(33, "SWEDEN"));
    }

    @Test
    void canCalculateCorrectShippingCostWhenAustraliaIsBoxDestination() {
        Box box = new Box();
        box.setName("Test box");
        box.setWeight(79);
        box.setCountry("AUSTRALIA");
        box.setShippingCost(service.calculateShippingCost(box.getWeight(), box.getCountry()));
        assertThat(box.getShippingCost()).isEqualTo(service.calculateShippingCost(79, "AUSTRALIA"));
    }

    private List<BoxResponseDto> getBoxList() {
        List<BoxResponseDto> boxList = new ArrayList<>();
        boxList.add(getBoxResponseDto());
        return boxList;
    }

    private BoxResponseDto getBoxResponseDto() {
        BoxResponseDto box = new BoxResponseDto();
        box.setWeight(50.5);
        box.setColor("#9c5454");
        box.setShippingCost(100);
        return box;
    }

    private Box getBox() {
        Box box = new Box();
        box.setId(1L);
        box.setWeight(99.5);
        box.setColor("#9c5454");
        box.setCountry("CHINA");
        box.setShippingCost(service.calculateShippingCost(box.getWeight(), box.getCountry()));
        return box;
    }
}