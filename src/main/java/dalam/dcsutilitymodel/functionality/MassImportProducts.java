package dalam.dcsutilitymodel.functionality;

import dalam.dcsutilitymodel.spcobjects.configurations.Configurations;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.Configuration;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.conditions.ConfigCondition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MassImportProducts {

    private BufferedReader csvFileReader;


    public ArrayList<Configuration> generateConfigurationListFromCSV(String filePathToCSV, String filePathToConfigurationTemplate) {

        //Create ArrayList to hold newly generated Configuration Objects based on CSV input
        ArrayList<Configuration> generatedConfigurationList = new ArrayList<>();

        //Use BufferedReader to parse CSV file and obtain tokens
        try {
            this.csvFileReader = new BufferedReader(new FileReader(filePathToCSV));

            String line;
            while((line = csvFileReader.readLine()) != null) {

                String[] suppliedParameters = line.split("~");

                //Create Configuration Object from supplied Template Configuration
                Configuration configurationToAdd =
                        DCSUtilityUnmarshaller.unmarshallConfiguration(filePathToConfigurationTemplate);

                //Modify template Object based on CSV supplied parameters

                //Set Configuration name (product description)
                configurationToAdd.
                        setName(suppliedParameters[0]);

                //Set Descriptor Item Value (chart name)
                configurationToAdd.
                        getDescriptor_Holder().
                        getDescriptorList().
                        get(1).
                        getItem().
                        setItemValue(suppliedParameters[1]);

                //Clear current Conditions from template Object
                configurationToAdd.getConditions_holder().getConditionList().clear();

                //Create new Condition Objects based on supplied parameter
                ConfigCondition firstConditionToAdd = new ConfigCondition(
                        suppliedParameters[2],
                        suppliedParameters[3],
                        suppliedParameters[4]);
                //Add first Condition
                configurationToAdd.getConditions_holder().addCondition(firstConditionToAdd);

                //Up to 3 Conditions can be added
                if(suppliedParameters.length > 5) {
                    ConfigCondition secondConditionToAdd = new ConfigCondition(
                            suppliedParameters[5],
                            suppliedParameters[6],
                            suppliedParameters[7]);
                    //Add second Condition
                    configurationToAdd.getConditions_holder().addCondition(secondConditionToAdd);
                }

                if(suppliedParameters.length > 8) {
                    ConfigCondition thirdConditionToAdd = new ConfigCondition(
                            suppliedParameters[8],
                            suppliedParameters[9],
                            suppliedParameters[10]);
                    //Add third Condition
                    configurationToAdd.getConditions_holder().addCondition(thirdConditionToAdd);

                }

                //Add modified Configuration to return list
                generatedConfigurationList.add(configurationToAdd);

            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return generatedConfigurationList;
    }

    public Configurations returnAppendedConfigurationsFile(ArrayList<Configuration> configurationList, String filePathToConfigurations) {

        //Create Configurations Object from supplied file path, append configurationList
        Configurations modifiedConfigurations =
                DCSUtilityUnmarshaller.unmarshallConfigurations(filePathToConfigurations);

        for(Configuration configurationToAdd : configurationList) {
            modifiedConfigurations.addConfiguration(configurationToAdd);
        }

        return modifiedConfigurations;
    }

    public Configurations returnNewConfigurationsFile(ArrayList<Configuration> configurationList) {

        Configurations newConfigurations = new Configurations();

        for(Configuration configurationToAdd : configurationList) {
            newConfigurations.addConfiguration(configurationToAdd);
        }

        return newConfigurations;
    }


}
