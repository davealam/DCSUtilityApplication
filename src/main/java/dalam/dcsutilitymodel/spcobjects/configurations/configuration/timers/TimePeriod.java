package dalam.dcsutilitymodel.spcobjects.configurations.configuration.timers;

import jakarta.xml.bind.annotation.XmlElement;

public class TimePeriod {

    //Elements
    @XmlElement(name = "Frequency")
    private Frequency frequency;

    @XmlElement(name = "Duration")
    private Duration duration;

    //Constructors
    public TimePeriod(Frequency frequency, Duration duration) {
        this.frequency = frequency;
        this.duration = duration;
    }

    public TimePeriod() {}
}
