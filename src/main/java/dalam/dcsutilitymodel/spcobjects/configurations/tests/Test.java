package dalam.dcsutilitymodel.spcobjects.configurations.tests;

import jakarta.xml.bind.annotation.XmlElement;

public class Test {

    //Elements
    @XmlElement(name = "Group")
    private String group;

    @XmlElement(name = "Item")
    private String item;

    @XmlElement(name = "Value")
    private String value;

    @XmlElement(name = "DefectCode")
    private String defectCode;

    @XmlElement(name = "Condition")
    private TestCondition testCondition;

    @XmlElement(name = "ProductionRate")
    private String productionRate;

    //Constructors
    public Test(String group, String item, String value, String defectCode, TestCondition testCondition, String productionRate) {
        this.group = group;
        this.item = item;
        this.value = value;
        this.defectCode = defectCode;
        this.testCondition = testCondition;
        this.productionRate = productionRate;
    }

    public Test() {}

    //To String
    @Override
    public String toString() {
        return item;
    }
}
