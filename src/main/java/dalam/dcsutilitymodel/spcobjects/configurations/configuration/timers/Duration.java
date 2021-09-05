package dalam.dcsutilitymodel.spcobjects.configurations.configuration.timers;

import jakarta.xml.bind.annotation.XmlAttribute;

public class Duration {

    //Attributes
    @XmlAttribute(name = "Enabled")
    private String enabled;

    @XmlAttribute(name = "Unit")
    private String unit;

    @XmlAttribute(name = "Interval")
    private String interval;

    //Constructor
    public Duration(String enabled, String unit, String interval) {
        this.enabled = enabled;
        this.unit = unit;
        this.interval = interval;
    }

    public Duration() {}
}
