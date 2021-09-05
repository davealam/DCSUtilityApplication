package dalam.dcsutilitymodel.functionality;

import dalam.dcsutilitymodel.spcobjects.configurations.Configurations;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.Configuration;

public class TestTemplateBasedProductCleanUp {

    public static final String TEXAS_CONFIG_TEMPLATE_FILEPATH = "C:\\Users\\alam\\Desktop\\TexasData\\Single.xml";
    public static final String TEXAS_CONFIGURATIONS_FILEPATH = "C:\\Users\\alam\\Desktop\\TexasData\\FullConfigs.xml";
    public static final String DCSUTILITY_UPDATED_CONFIGS_TEXAS =
            "C:\\Users\\alam\\Desktop\\TexasData\\DCSUtility_Updated_Configs_Texas.xml";

    public static void main(String[] args) {
        DCSUtilityUnmarshaller dcsUtilityUnmarshaller = new DCSUtilityUnmarshaller();

        Configurations texasUnmarshalledConfigurations =
                dcsUtilityUnmarshaller.unmarshallConfigurations(TEXAS_CONFIGURATIONS_FILEPATH);

        CSVImportProducts csvImportProducts = new CSVImportProducts();
        Configuration texasConfigTemplate =
                csvImportProducts.generateConfigurationTemplate(TEXAS_CONFIG_TEMPLATE_FILEPATH);

        for (Configuration configuration : texasUnmarshalledConfigurations.getConfigurationList()) {
            configuration.getTests().getTestList().clear();
            configuration.getTests().getTestList().addAll(texasConfigTemplate.getTests().getTestList());
        }

        DCSUtilityMarshaller dcsUtilityMarshaller = new DCSUtilityMarshaller();
        String confirmation =
                dcsUtilityMarshaller.
                        marshallConfigurations(texasUnmarshalledConfigurations, DCSUTILITY_UPDATED_CONFIGS_TEXAS);

        System.out.println(confirmation);
    }

}
