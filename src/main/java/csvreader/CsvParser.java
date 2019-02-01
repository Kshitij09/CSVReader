package csvreader;
import csvreader.data.CsvFile;
import csvreader.data.CsvRow;

import java.io.*;

class CsvParser {
    private static final char DELIMITER = ',';

    static CsvFile read(File file) throws FileNotFoundException {
        return read(new FileReader(file));
    }

    static CsvFile read(String csvString) {
        return read(new StringReader(csvString));
    }

    private static CsvFile read(Reader reader) {
        BufferedReader bufferedReader = new BufferedReader(reader);
        CsvFile file = new CsvFile();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                file.add(processLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private static CsvRow processLine(String line) {
        boolean insideQuote = false;
        StringBuilder sb = new StringBuilder();
        CsvRow row = new CsvRow();

        boolean isQuote;
        boolean isDelimiter;
        for (char ch : line.toCharArray()) {
            isQuote = ch == '\"';
            isDelimiter = ch == DELIMITER;
            if (isQuote)
                insideQuote = !insideQuote;
            else if (!isDelimiter || insideQuote)
                sb.append(ch);
            else {
                row.add(sb.toString().trim());
                sb = new StringBuilder();
            }
        }
        return row;
    }
}
