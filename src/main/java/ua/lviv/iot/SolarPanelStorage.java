package ua.lviv.iot;

import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.SolarPanel;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class SolarPanelStorage {

    List<SolarPanel> panels = new ArrayList<>() ;
    int id = 0;

    @PostConstruct
    private void init() throws IOException {
        File file = new File("SolarPanel.csv");
        file.createNewFile();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(SolarPanel.getHeader());
        }
    }
    public void create (List<SolarPanel> panels){
        try {
            File file = new File("SolarPanel.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            for (SolarPanel panel: panels) {
                panel.setId(++id);
                writer.write(panel.toCSV());
                this.panels.add(panel);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SolarPanel getById(int id){
        SolarPanel solarPanel = null;
        for ( int i = 0; i < panels.size(); i++){
            if (panels.get(i).getId() == id ){
                solarPanel = panels.get(i);
            }
        }
        return solarPanel;
    }

    public List<SolarPanel> getAll(){
        return panels;
    }

    public List<SolarPanel> delete ( int id ){
        for ( int i = 0; i < panels.size(); i++){
            if (panels.get(i).getId() == id ){
                panels.remove(panels.get(i));
            }
        }
        return panels;
    }

    public List<SolarPanel> open () {
        Scanner scFile = new Scanner("SolarPanel.csv");
        while (scFile.hasNext()) {
            String type = scFile.next();
            int power = scFile.nextInt();
            int battery = scFile.nextInt();
            int durationOfUse = scFile.nextInt();
            String location = scFile.next();
            panels.add(new SolarPanel(type, power, battery, durationOfUse, location));
        }
        return panels;
    }

    public List<SolarPanel> update (int id, SolarPanel solarPanel){
        for ( int i = 0; i < panels.size(); i++){
            if (panels.get(i).getId() == id) {
                solarPanel.setId(id);
                panels.set(i, solarPanel);
            }
        }
        return panels;
    }
}
