package lab4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

        String csvFile = "/Users/AirLiq/Downloads/example-countries.csv";
        String line = "";
        String cvsSplitBy = ";";

        ArrayList<String[]> countryList = new ArrayList<String[]>();
        String getInfo (String search) {

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                while ((line = br.readLine()) != null) {

                    String[] country = line.split(cvsSplitBy);

                    countryList.add(country);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            String result = "";
            for (int i=0; i < countryList.size(); i++)
                if (countryList.get(i)[0].contentEquals(search)){
                    result = String.join(";",countryList.get(i));
                    break;
                }
            return result;
        }
}



