package dalam.dcsutilitymodel.spcobjects.configurations.tests;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;

public class Tests {
    @XmlElement(name = "Test")
    private List<Test> testList;

    //Constructors
    public Tests() {
        this.testList = new ArrayList<>();
    }

    //Methods
    public void addTest(Test testToAdd) {
        testList.add(testToAdd);
    }

    public List<Test> getTestList() {
        return testList;
    }
}
