package ua.lviv.iot.model;
import lombok.Data;

@Data
public class SolarPanel {
    private String type;

    private Integer id;
    private Integer power;
    private Integer battery;
    private Integer durationOfUse;
    private String location;

    public SolarPanel(String type, Integer power, Integer battery, Integer durationOfUse, String location) {
        this.type = type;
        this.power = power;
        this.battery = battery;
        this.durationOfUse = durationOfUse;
        this.location = location;
    }

    public static String getHeader(){
        return ( "id, type, power, battery, duration_of_use, location\n");
    }
    public String toCSV(){
        return String.format("%s, %s %s %s %s %s\n", id, type, power, battery, durationOfUse, location);
    }

}
