package dalam.dcsutilitymodel.functionality;

import dalam.dcsutilitymodel.spcobjects.configurations.Configurations;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class DCSUtilityUnmarshaller {

    //Constructors
    public DCSUtilityUnmarshaller() {}

    public Configurations unmarshallConfigurations(String configurationsFilePath) {
        try {
            //Unmarshall and read from Configs XML
            File configurations = new File(configurationsFilePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Configurations.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            //Return unmarshalled Configurations object
            return (Configurations) unmarshaller.unmarshal(configurations);

        }catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
