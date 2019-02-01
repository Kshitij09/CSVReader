package csvreader;


import csvreader.data.CsvFile;
import csvreader.data.CsvRow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * CSVReader is a simple, minimal CSV library
 * with static methods for reading and creating CSV files
 */
public class CSVReader {


    public static CsvFile read(File file) throws FileNotFoundException {
        return CsvParser.read(file);
    }

    public static CsvFile read(String csvString) {
        return CsvParser.read(csvString);
    }

    public static Builder build() {
        return new CSVReader.Builder();
    }

    public static class Builder {
        ArrayList<CsvRow> rows = new ArrayList<>();

        public Builder newRow() {
            rows.add(new CsvRow());
            return this;
        }

        public Builder append(String value) {
            rows.get(rows.size() - 1)
                    .add(value);
            return this;
        }

        public CsvFile create() {
            return new CsvFile(rows);
        }
    }
}
/*
*       File file = new File(CsvParser.class.getResource("sample.csv").getFile());
        try {
            CsvFile csvFile = CsvParser.read(file);
            System.out.println(CsvSerializer.toCsv(csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
* */