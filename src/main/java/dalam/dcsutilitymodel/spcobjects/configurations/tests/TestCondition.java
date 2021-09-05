package dalam.dcsutilitymodel.spcobjects.configurations.tests;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class TestCondition {

    //Attributes
    @XmlAttribute(name = "Evaluation")
    private String evaluation;

    @XmlAttribute(name = "Include")
    private String include;

    @XmlAttribute(name = "Enabled")
    private String enabled;

    //Values
    @XmlValue
    private String conditionValue;

    //Constructors
    public TestCondition(String evaluation, String include, String enabled) {
        this.evaluation = evaluation;
        this.include = include;
        this.enabled = enabled;
        this.conditionValue = "";
    }

    public TestCondition() {}
}
