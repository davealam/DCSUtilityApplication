package dalam.dcsutilitymodel.spcobjects.configurations.configuration.descriptors;

import jakarta.xml.bind.annotation.XmlElement;

public class Descriptor {

    //Elements
    @XmlElement(name = "Type")
    private String type;

    @XmlElement(name = "Group")
    private String group;

    @XmlElement(name = "Item")
    private Item item;

    //Constructors
    public Descriptor(String type, String group, Item item) {
        this.type = type;
        this.group = group;
        this.item = item;
    }

    public Descriptor() {}

    //Getters
    public Item getItem() {
        return item;
    }
}
