package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void whenTypeEqualsDefault() {
        Box box = new Box(9, 1);
        assertThat(box.whatsThis()).isEqualTo("Unknown object");
    }

    @Test
    void whenEdgeLessThanZero() {
        Box box = new Box(4, -11);
        assertThat(box.whatsThis()).isEqualTo("Unknown object");
    }

    @Test
    void whenNumberOfVerticesEqualsFour() {
        Box box = new Box(4, 5);
        assertThat(box.getNumberOfVertices()).isEqualTo(4);
    }

    @Test
    void whenNumberOfVerticesEqualsOne() {
        Box box = new Box(1, 5);
        assertThat(box.getNumberOfVertices()).isEqualTo(-1);
    }

    @Test
    void whenIsExistSphere() {
        Box box = new Box(4, 5);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void whenIsExistCube() {
        Box box = new Box(8, 5);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void  areaSphereWithAnErrorOfTenPercent() {
        Box box = new Box(0, 2);
        assertThat(box.getArea()).isCloseTo(50.24d, Percentage.withPercentage(0.1d));
    }

    @Test
    void  cubeArea() {
        Box box = new Box(8, 10);
        assertThat(box.getArea()).isEqualTo(600.0d);
    }
}