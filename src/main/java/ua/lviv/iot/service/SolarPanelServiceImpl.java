package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.SolarPanelStorage;
import ua.lviv.iot.model.SolarPanel;

import java.util.List;

@Service
public class SolarPanelServiceImpl implements SolarPanelService {

    private SolarPanelStorage solarPanelStorage;
    
    @Autowired
    public SolarPanelServiceImpl(SolarPanelStorage solarPanelStorage) {
        this.solarPanelStorage = solarPanelStorage;
    }


    @Override
    public SolarPanel getById(int id) {
        return solarPanelStorage.getById(id);
    }

    @Override
    public List<SolarPanel> getAll() {
        return solarPanelStorage.getAll();
    }

    @Override
    public List<SolarPanel> delete(int id) {
        return solarPanelStorage.delete(id);
    }

    @Override
    public List<SolarPanel> update(int id, SolarPanel solarPanel) {
        return solarPanelStorage.update(id, solarPanel);
    }

    @Override
    public void create(List<SolarPanel> list) {
        solarPanelStorage.create(list);
    }
}
