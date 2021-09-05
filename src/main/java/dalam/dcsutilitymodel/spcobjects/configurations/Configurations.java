package dalam.dcsutilitymodel.spcobjects.configurations;

import dalam.dcsutilitymodel.spcobjects.configurations.configuration.Configuration;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Configurations")
public class Configurations {

    //Elements
    @XmlElement(name = "Configuration")
    private List<Configuration> configurationList;

    //Attributes
    @XmlAttribute(name = "Version")
    private String version;

    //Constructors
    public Configurations() {
        this.configurationList = new ArrayList<>();
        //Static version value in constructor- MAY NEED TO CHANGE
        this.version = "5.2";
    }

    //Methods
    public void addConfiguration(Configuration configurationToAdd) {
        configurationList.add(configurationToAdd);
    }

    public List<Configuration> getConfigurationList() {
        return configurationList;
    }
}
