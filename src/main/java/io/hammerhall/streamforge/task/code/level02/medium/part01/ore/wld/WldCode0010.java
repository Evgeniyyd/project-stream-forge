package io.hammerhall.streamforge.task.code.level02.medium.part01.ore.wld;

import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.task.Base;
import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Задание: Построить индекс «континент → список стран».")
public class WldCode0010 extends Base {

    /**
     * Задание: Построить индекс «континент → список стран».
     * <p>
     * Описание: необходимо построить карту, ключом которой является название континента,
     * а значением — список стран этого континента.
     * <p>
     * Порядок стран внутри группы соответствует порядку обхода исходной коллекции.
     *
     * @param countries список стран
     * @return индекс «континент → список стран этого континента»
     */
    public Map<String, List<Country>> task(@NonNull Collection<Country> countries) {
   return countries.stream()
           .collect(Collectors.groupingBy(Country::getContinent));
    }

    @Test
    void runTask() {
        Collection<Country> countries = countries();

        Map<String, List<Country>> index = task(countries);

        assertNotNull(index);
        assertTrue(task(List.of()).isEmpty());
        index.forEach((continent, list) -> {
            assertFalse(continent.isBlank());
            assertFalse(list.isEmpty());
        });

        index.forEach((continent, list) -> System.out.println(continent + ": " + list.size()));
    }
}
