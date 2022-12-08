package ua.lviv.iot;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.model.SolarPanel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolarPanelStorageTest {

private final SolarPanel obj1 = new SolarPanel("a", 12, 1234,13, "Lviv");
private final SolarPanel obj2 = new SolarPanel("b", 16,4567, 18, "Odesa");
private final SolarPanel obj3 = new SolarPanel("c", 17,7557, 11, "Ternopil");

    SolarPanelStorage sps = new SolarPanelStorage();
    @Test
    void create() {

        List<SolarPanel> list = Arrays.asList(obj2, obj1, obj3);
        sps.create(list);
        String readerEx = String.format("Example.csv");
        String readerRes = String.format("SolarPanel.csv");
        try {
            BufferedReader readerResult = new BufferedReader(new FileReader(readerRes));
            BufferedReader readerExample = new BufferedReader(new FileReader(readerEx));
            assertEquals(readerExample.readLine(), readerResult.readLine());
            assertNotEquals(null, readerResult.readLine());
            assertNotEquals(readerExample.readLine(), null);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getById() {
        List<SolarPanel> list = Arrays.asList(obj2, obj1, obj3);
        sps.create(list);
        assertEquals(list.get(0), sps.getById(1));
    }

    @Test
    void getAll() {
        List<SolarPanel> list = Arrays.asList(obj2, obj1, obj3);
        sps.create(list);
        assertEquals(list, sps.getAll());
    }

    @Test
    void delete() {
        List<SolarPanel> list = Arrays.asList(obj2, obj1, obj3);
        List<SolarPanel> list1 = Arrays.asList(obj1, obj3);
        sps.create(list);
        assertEquals(list1, sps.delete(1));

    }

    @Test
    void update() {
        List<SolarPanel> list = Arrays.asList(obj2, obj1, obj3);
        List<SolarPanel> list1 = Arrays.asList(obj1, obj1, obj3);
        sps.create(list);
        assertEquals(list1, sps.update(1,obj1));
    }
}