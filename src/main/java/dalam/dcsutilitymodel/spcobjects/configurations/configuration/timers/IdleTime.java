package dalam.dcsutilitymodel.spcobjects.configurations.configuration.timers;

import jakarta.xml.bind.annotation.XmlElement;

public class IdleTime {
    //Elements
    @XmlElement(name = "TimePeriod")
    private TimePeriod timePeriod;

    //Constructors

    public IdleTime(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    public IdleTime(){}

}
