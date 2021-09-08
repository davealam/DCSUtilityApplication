package dalam.dcsutilitymodel.functionality;

import dalam.dcsutilitymodel.spcobjects.configurations.Configurations;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.Configuration;

public class StandardizeTests {

    public Configurations standardize(String filePathToTemplateConfiguration, String filePathToConfigurationsToModify) {

        //Unmarshall and generate Template Configuration Object
        DCSUtilityUnmarshaller dcsUtilityUnmarshaller = new DCSUtilityUnmarshaller();
        Configuration templateConfiguration =
                dcsUtilityUnmarshaller.unmarshallConfiguration(filePathToTemplateConfiguration);

        //Unmarshall and obtain Configurations Object
        Configurations configurationsToModify = dcsUtilityUnmarshaller.
                unmarshallConfigurations(filePathToConfigurationsToModify);

        //Clear existing Test List and swap in list from Configuration Template
        for(Configuration configuration : configurationsToModify.getConfigurationList()) {
            configuration.getTests().getTestList().clear();
            configuration.getTests().getTestList().addAll(templateConfiguration.getTests().getTestList());
        }

        return configurationsToModify;

    }

}
