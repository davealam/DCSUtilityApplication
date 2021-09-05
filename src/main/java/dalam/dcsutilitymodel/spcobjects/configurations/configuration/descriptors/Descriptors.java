package dalam.dcsutilitymodel.spcobjects.configurations.configuration.descriptors;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;

public class Descriptors {

    //Elements
    @XmlElement(name = "Descriptor")
    private List<Descriptor> descriptorList;

    //Constructors
    public Descriptors() {
        this.descriptorList = new ArrayList<>();
    }

    //Methods
    public void addDescriptor(Descriptor descriptorToAdd) {
        descriptorList.add(descriptorToAdd);
    }

    public List<Descriptor> getDescriptorList() {
        return descriptorList;
    }

}
