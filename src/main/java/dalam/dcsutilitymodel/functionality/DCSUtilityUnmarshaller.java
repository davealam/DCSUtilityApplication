package dalam.dcsutilitymodel.functionality;

import dalam.dcsutilitymodel.spcobjects.configurations.Configurations;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.Configuration;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class DCSUtilityUnmarshaller {

    //Constructors
    public DCSUtilityUnmarshaller() {}

    public static Configurations unmarshallConfigurations(String configurationsFilePath) {
        try {
            //Unmarshall and read from Configurations XML
            File configurations = new File(configurationsFilePath);
            JAXBContext configurationsContext = JAXBContext.newInstance(Configurations.class);
            Unmarshaller configurationsUnmarshaller = configurationsContext.createUnmarshaller();

            //Cast and return unmarshalled Configurations Object
            return (Configurations) configurationsUnmarshaller.unmarshal(configurations);

        }catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Configuration unmarshallConfiguration(String configurationFilePath) {
        try {
            //Unmarshall and read from Configuration XML
            File configuration = new File(configurationFilePath);
            JAXBContext configurationContext = JAXBContext.newInstance(Configuration.class);
            Unmarshaller configurationUnmarshaller = configurationContext.createUnmarshaller();

            //Cast and return unmarshalled Configuration Object
            return (Configuration) configurationUnmarshaller.unmarshal(configuration);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
