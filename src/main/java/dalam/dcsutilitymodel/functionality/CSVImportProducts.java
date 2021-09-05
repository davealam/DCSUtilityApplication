package dalam.dcsutilitymodel.functionality;

import dalam.dcsutilitymodel.spcobjects.configurations.Configurations;
import dalam.dcsutilitymodel.spcobjects.configurations.configuration.Configuration;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.util.ArrayList;

public class CSVImportProducts {

    private BufferedReader csvReader;

    //Method to reads CSV file and returns list of Configuration objets to be added to Configurations
    public ArrayList<Configuration> parseCSV(String filePathToCSV, String filePathToTemplate) {

        ArrayList<Configuration> configurationToBeAddedList = new ArrayList<>();

        try {

            //Utilize BufferedReader to parse CSV file and obtain name, itemValue, and value2
            this.csvReader = new BufferedReader(new FileReader(filePathToCSV));
            String line;
            while((line = csvReader.readLine()) != null) {
                Configuration configurationToAdd = new Configuration();

                //Unmarshall template XML for each iteration and modify values
                configurationToAdd = generateConfigurationTemplate(filePathToTemplate);

                String[] suppliedParameters = line.split(",");

                //Extract name token from CSV and set configurationTemplate name
                configurationToAdd.setName(suppliedParameters[0]);

                //Extract itemValue token from CSV and set configurationTemplate itemValue
                configurationToAdd.
                        getDescriptor_Holder().
                        getDescriptorList().
                        get(1).
                        getItem().
                        setItemValue(suppliedParameters[1]);

                //Extract conditionsValue token from CSV and set configurationTemplate value2
                configurationToAdd.
                        getConditions_holder().
                        getConditionList().
                        get(1).
                        setValue2(suppliedParameters[2]);

                //Add modified Configuration to configurationToBeAddedList
                configurationToBeAddedList.add(configurationToAdd);

                for(int i = 0; i < configurationToBeAddedList.size(); i++) {
                    System.out.println("List contents: " + configurationToBeAddedList.get(i));
                }

            }

            //Return ArrayList of Configuration objects to be added to Configurations
            return configurationToBeAddedList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Configuration generateConfigurationTemplate(String filePathToConfigTemplate) {

        try {
            File config = new File(filePathToConfigTemplate);
            JAXBContext configJAXBContext = JAXBContext.newInstance(Configuration.class);
            Unmarshaller unmarshaller = configJAXBContext.createUnmarshaller();

            return ((Configuration) unmarshaller.unmarshal(config));

        } catch(JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Configurations addConfigToConfigs(ArrayList<Configuration> configurationToBeAddedList,
                                             Configurations modifiedConfigurations) {

        for(Configuration configuration : configurationToBeAddedList) {
            modifiedConfigurations.addConfiguration(configuration);
        }

        return modifiedConfigurations;

    }

}
