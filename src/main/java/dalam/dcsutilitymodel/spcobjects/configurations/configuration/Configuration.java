package dalam.dcsutilitymodel.spcobjects.configurations.configuration;

import dalam.dcsutilitymodel.spcobjects.configurations.Feedbacks;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.conditions.ConfigCondition;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.conditions.ConfigConditions;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.datasource.Datasource;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.descriptors.Descriptor;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.descriptors.Descriptors;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.subgroupsize.SubgroupSize;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.timers.Timers;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.trigger.Trigger;
import dalam.dcsutilitymodel.spcobjects.configurations.tests.Test;
import dalam.dcsutilitymodel.spcobjects.configurations.tests.Tests;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Configuration")
public class Configuration {

    //Root Elements
    @XmlElement(name = "DataSource")
    private Datasource datasource;

    @XmlElement(name = "SubgroupSize")
    private SubgroupSize subgroupSize;

    @XmlElement(name = "Timers")
    private Timers timers;

    @XmlElement(name = "Trigger")
    private Trigger trigger;

    @XmlElement(name = "Descriptors")
    private Descriptors descriptors;

    @XmlElement(name = "Tests")
    private Tests tests;

    @XmlElement(name = "Conditions")
    private ConfigConditions configConditions;

    @XmlElement(name = "Feedbacks")
    private Feedbacks feedbacks;

    //Root Attributes
    @XmlAttribute(name = "Name")
    private String name;

    @XmlAttribute(name = "State")
    private String state;

    @XmlAttribute(name = "Version")
    private String version;

    @XmlAttribute(name = "ProgID")
    private String progID;

    @XmlAttribute(name = "RunMode")
    private String runMode;

    //Constructors
    public Configuration() {}

    public Configuration(Datasource datasource,
                         SubgroupSize subgroupSize,
                         String name,
                         Timers timers,
                         Trigger trigger,
                         String state,
                         String version,
                         String progID,
                         String runMode)
    {
        this.datasource = datasource;
        this.subgroupSize = subgroupSize;
        this.name = name;
        this.timers = timers;
        this.trigger = trigger;
        this.descriptors = new Descriptors();
        this.state = state;
        this.version = version;
        this.progID = progID;
        this.runMode = runMode;
        this.tests = new Tests();
        this.configConditions = new ConfigConditions();
        this.feedbacks = new Feedbacks();
    }

    public void addTest(Test testToAdd) {
        tests.addTest(testToAdd);
    }

    public void addDescriptor(Descriptor descriptorToAdd) {
        descriptors.addDescriptor(descriptorToAdd);
    }

    public void addConditions(ConfigCondition configConditionToAdd) {
        configConditions.addCondition(configConditionToAdd);
    }


    //Getters
    public Tests getTests() {
        return tests;
    }

    public Descriptors getDescriptor_Holder() {
        return descriptors;
    }

    public ConfigConditions getConditions_holder() {
        return configConditions;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
