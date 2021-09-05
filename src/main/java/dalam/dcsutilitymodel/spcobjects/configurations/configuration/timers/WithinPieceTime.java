package dalam.dcsutilitymodel.spcobjects.configurations.configuration.timers;

import jakarta.xml.bind.annotation.XmlElement;

public class WithinPieceTime {

    //Elements
    @XmlElement(name = "TimePeriod")
    private TimePeriod timePeriod;

    //Constructors
    public WithinPieceTime(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    public WithinPieceTime() {}
}
