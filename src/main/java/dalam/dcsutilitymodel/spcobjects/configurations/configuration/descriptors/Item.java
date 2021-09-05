package dalam.dcsutilitymodel.spcobjects.configurations.configuration.descriptors;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

public class Item {

    //Attributes
    @XmlAttribute(name = "Prompt")
    private String prompt;

    //Values
    @XmlValue
    private String itemValue;

    //Constructors
    public Item(String prompt, String itemValue) {
        this.prompt = prompt;
        this.itemValue = itemValue;
    }

    public Item() {}

    //Setters

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
}
