package dalam.dcsutilitymodel.spcobjects.configurations.configuration.timers;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public class Timers {

    //Timers Attributes
    @XmlAttribute(name = "TimersEnabled")
    private String timersEnabled;

    //Timers Elements
    @XmlElement(name = "SubgroupTime")
    private SubgroupTime subgroupTime;

    @XmlElement(name = "WithinPieceTime")
    private WithinPieceTime withinPieceTime;

    @XmlElement(name = "RetryTime")
    private RetryTime retryTime;

    @XmlElement(name = "IdleTime")
    private IdleTime idleTime;



    //Constructors
    public Timers(String timersEnabled,
                  SubgroupTime subgroupTime,
                  WithinPieceTime withinPieceTime,
                  RetryTime retryTime,
                  IdleTime idleTime)
    {
        this.timersEnabled = timersEnabled;
        this.subgroupTime = subgroupTime;
        this.withinPieceTime = withinPieceTime;
        this.retryTime = retryTime;
        this.idleTime = idleTime;
    }

    public Timers() {}
}
