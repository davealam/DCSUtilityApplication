package dalam.dcsutilitymodel.spcobjects.configurations.configuration.conditions;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public class ConfigCondition {

    //Elements
    @XmlElement(name = "Value1")
    private String value1;

    @XmlElement(name = "Value2")
    private String value2;

    @XmlElement(name = "Evaluation")
    private String evaluation;

    //Attributes
    @XmlAttribute(name = "Type")
    private String type;

    //Constructors
    public ConfigCondition(String type, String value1, String value2, String evaluation) {
        this.type = type;
        this.value1 = value1;
        this.value2 = value2;
        this.evaluation = evaluation;
    }

    public ConfigCondition() {}

    //Setters


    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
