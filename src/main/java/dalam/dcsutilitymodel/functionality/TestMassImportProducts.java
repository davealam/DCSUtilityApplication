package dalam.dcsutilitymodel.functionality;

import dalam.dcsutilitymodel.spcobjects.configurations.Configurations;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.Configuration;

import java.util.ArrayList;

public class TestMassImportProducts {

    public static void main(String[] args) {
        MassImportProducts massImportProducts = new MassImportProducts();

        ArrayList<Configuration> configurationList = massImportProducts.generateConfigurationListFromCSV(
                "C:\\Users\\alam\\Desktop\\massaddtrial\\CSVTrial.csv",
                "C:\\Users\\alam\\Desktop\\massaddtrial\\ConfigTemplate.xml");

        System.out.println("Test generateConfigurationFromCSV() successful");

        Configurations modifiedConfigurations = massImportProducts.returnAppendedConfigurationsFile(
                configurationList,
                "C:\\Users\\alam\\Desktop\\massaddtrial\\FullConfigs.xml");

        DCSUtilityMarshaller.marshallConfigurations(
                modifiedConfigurations,
                "C:\\Users\\alam\\Desktop\\massaddtrial\\ModifiedConfigs.xml");

        System.out.println("Test returnAppendedConfigurationsFile() successful");

        Configurations newConfigurations = massImportProducts.returnNewConfigurationsFile(configurationList);
        DCSUtilityMarshaller.marshallConfigurations(
                newConfigurations,
                "C:\\Users\\alam\\Desktop\\massaddtrial\\NonAppend.xml");

        System.out.println("Test returnNewConfigurationsFile() successful");



    }

}
