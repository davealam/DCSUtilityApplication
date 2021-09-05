package dalam.dcsutilitymodel.functionality;

import dalam.dcsutilitymodel.spcobjects.configurations.Configurations;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.Configuration;

import java.util.ArrayList;

public class TestMassAddNewProducts {

    public static final String CSV_FILEPATH = "lib/needToAddSPC.csv";
    public static final String CONFIGURATIONS_FILEPATH = "lib/fullConfigs.xml";
    public static final String CONFIG_TEMPLATE_FILEPATH = "lib/config.xml";

    public TestMassAddNewProducts(){}

    public void testMethod() {

        //Create new CSVImportProducts instance
        CSVImportProducts csvImportProducts = new CSVImportProducts();

        //Parse CSV, use Config template, and generate ArrayList of Configuration values to be added to Configurations
        ArrayList<Configuration> configurationToBeAddedList=
                csvImportProducts.parseCSV(CSV_FILEPATH, CONFIG_TEMPLATE_FILEPATH);

        //Unmarshall Configurations and obtain object
        DCSUtilityUnmarshaller dcsUtilityUnmarshaller = new DCSUtilityUnmarshaller();
        Configurations configurationsToBeModified =
                dcsUtilityUnmarshaller.unmarshallConfigurations(CONFIGURATIONS_FILEPATH);

        //Add full Arraylist of Config to Configs
        Configurations modifiedConfigurations =
                csvImportProducts.addConfigToConfigs(configurationToBeAddedList, configurationsToBeModified);

        //Marshall updatedConfigs
        DCSUtilityMarshaller dcsUtilityMarshaller = new DCSUtilityMarshaller();
        dcsUtilityMarshaller.marshallConfigurations(modifiedConfigurations, "DCSUtility_Updated_Configs.xml");
    }
}
