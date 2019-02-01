package csvreader.data;

import csvreader.impl.IField;

public class CsvField implements IField<String> {
    private String value;

    private CsvField(String value) {
        this.value = value;
    }

    static CsvField of(String value) {
        return new CsvField(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
