package dalam.dcsutilitymodel.spcobjects.configurations.configuration.datasource;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

public class Datasource {

    //DataSource Elements
    @XmlElement(name = "DSN")
    private String dsn;

    //DataSource Attributes
    @XmlAttribute(name = "SourceType")
    private String sourceType;

    //Constructor
    public Datasource(String dsn, String sourceType) {
        this.dsn = dsn;
        this.sourceType = sourceType;
    }

    public Datasource() {}
}
