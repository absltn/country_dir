package lab4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

        String csvFile = "/Users/AirLiq/Downloads/simplemaps-worldcities-basic.csv";
        String line = "\n";
        String cvsSplitBy = ",";

        ArrayList<String[]> countryList = new ArrayList<String[]>();
        String[] getInfo (String search) {

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] country = line.split(cvsSplitBy);

                    countryList.add(country);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] result = new String[1];
            for (int i=0; i < countryList.size(); i++)
                if (countryList.get(i)[5] == search) {
                    result = countryList.get(i);
                    break;
                }
            return result;
        }
}



