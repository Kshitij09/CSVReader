package csvreader.data;


import csvreader.impl.IRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvRow implements IRow<CsvField> {
    private ArrayList<CsvField> fields = new ArrayList<>();

    public CsvRow() { }

    public CsvRow(ArrayList<CsvField> fields) { this.fields.addAll(fields); }

    public CsvField get(int index) {
        return fields.get(index);
    }

    @Override
    public List<CsvField> getFields() {
        return Collections.unmodifiableList(fields);
    }

    public boolean add(String value) {
        return fields.add(CsvField.of(value));
    }

    public CsvField set(int index, String value) {
        CsvField oldValue = fields.get(index);
        fields.set(index, CsvField.of(value));
        return oldValue;
    }
}
