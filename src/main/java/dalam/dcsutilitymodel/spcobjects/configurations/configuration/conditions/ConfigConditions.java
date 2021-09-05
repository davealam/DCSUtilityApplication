package dalam.dcsutilitymodel.spcobjects.configurations.configuration.conditions;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;

public class ConfigConditions {
    @XmlElement(name = "Condition")
    private List<ConfigCondition> configConditionList;

    //Constructors
    public ConfigConditions() {
        this.configConditionList = new ArrayList<>();
    }

    //Methods
    public void addCondition(ConfigCondition configConditionToAdd) {
        configConditionList.add(configConditionToAdd);
    }

    public List<ConfigCondition> getConditionList() {
        return configConditionList;
    }
}
