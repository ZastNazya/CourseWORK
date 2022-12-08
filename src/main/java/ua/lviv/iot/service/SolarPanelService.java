package ua.lviv.iot.service;

import ua.lviv.iot.model.SolarPanel;

import java.util.List;

public interface SolarPanelService {
 SolarPanel getById (int id);

 List<SolarPanel> getAll();
 List<SolarPanel> delete (int id);
 List<SolarPanel> update (int id, SolarPanel solarPanel);
 void create (List<SolarPanel> list);
}
