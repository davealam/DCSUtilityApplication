package dalam.dcsutilitymodel.functionality;

import dalam.dcsutilitymodel.spcobjects.configurations.Configurations;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class DCSUtilityMarshaller {

    public DCSUtilityMarshaller() {}

    public static void marshallConfigurations(Configurations configurationsToMarshall, String marshallFilePath) {

        try {

            File updatedConfigurations = new File(marshallFilePath);
            JAXBContext updatedConfigurationsContext = JAXBContext.newInstance(Configurations.class);
            Marshaller marshaller = updatedConfigurationsContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(configurationsToMarshall, updatedConfigurations);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
