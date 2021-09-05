package dalam.dcsutilitymodel.spcobjects.configurations.configuration.timers;

import jakarta.xml.bind.annotation.XmlElement;

public class RetryTime {
    //Elements
    @XmlElement(name = "TimePeriod")
    private TimePeriod timePeriod;

    //Constructors

    public RetryTime(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    public RetryTime(){}
}
