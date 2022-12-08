package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.SolarPanel;
import ua.lviv.iot.service.SolarPanelService;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api")
class SolarPanelController {
    private final SolarPanelService solarPanelService;

    @Autowired
    SolarPanelController(SolarPanelService solarPanelService) {
        this.solarPanelService = solarPanelService;
    }

    @GetMapping
    public ResponseEntity<List<SolarPanel>> getAll() {
        List<SolarPanel> solarPanels = solarPanelService.getAll();
        return new ResponseEntity<>(solarPanels, OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SolarPanel> getById(@PathVariable("id") Integer id) {
        SolarPanel solarPanel = solarPanelService.getById(id);
        return new ResponseEntity<>(solarPanel, OK);
    }

    @PostMapping
    public ResponseEntity<?> createSolarPanel(@RequestBody List<SolarPanel> entity) {
        solarPanelService.create(entity );
        return new ResponseEntity<>(CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody SolarPanel entity) {
        solarPanelService.update(id, entity);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        solarPanelService.delete(id);
        return new ResponseEntity<>(OK);
    }
}