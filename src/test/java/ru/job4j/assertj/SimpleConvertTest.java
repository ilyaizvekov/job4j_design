package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).isNotEmpty()
                .hasSize(5)
                .contains("first", "second", "three")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("three", "four", "five")
                .doesNotContain("zero");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set =  simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).isNotEmpty()
                .hasSize(5)
                .contains("second", "three")
                .allMatch(e -> e.length() > 3);
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = Map.of("first", 1, "second", 2, "three", 3, "four", 4,
                "five", 5);
        simpleConvert.toMap(String.valueOf(map));
        assertThat(map).hasSize(5)
                .containsKeys("first", "three", "five")
                .containsValues(1, 3, 5)
                .doesNotContainKey("zero")
                .containsEntry("four", 4);

    }
}