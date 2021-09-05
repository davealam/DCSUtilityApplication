package dalam.dcsutilitymodel.spcobjects.configurations.configuration.trigger;

import jakarta.xml.bind.annotation.XmlElement;

public class Trigger {

    //Elements
    @XmlElement(name = "Conditions")
    private TriggerConditions triggerConditions;

    //Constructors
    public Trigger(TriggerConditions triggerConditions) {
        this.triggerConditions = triggerConditions;
    }

    public Trigger() {}
}
