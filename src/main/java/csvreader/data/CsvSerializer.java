package csvreader.data;

import java.util.List;

public class CsvSerializer {
    private static final String NL = "\n\r";

    public static String toCsv(CsvFile csvFile) {
        StringBuilder sb = new StringBuilder();
        List<CsvRow> rows = csvFile.getRows();
        for (int i = 0; i < rows.size(); i++) {
            CsvRow row = rows.get(i);
            List<CsvField> fields = row.getFields();
            for (int j = 0; j < fields.size(); j++) {
                sb.append(fields.get(j));
                if (j + 1 < fields.size())
                    sb.append(",");
            }
            if (i + 1 < rows.size())
                sb.append(NL);
        }
        return sb.toString();
    }
}
