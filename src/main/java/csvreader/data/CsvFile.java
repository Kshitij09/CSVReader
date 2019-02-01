package csvreader.data;

import csvreader.impl.IFile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class CsvFile implements IFile<CsvField, CsvRow> {
    private ArrayList<CsvRow> rows = new ArrayList<>();

    public CsvFile() { }

    public CsvFile(ArrayList<CsvRow> rows) {
        this.rows.addAll(rows);
    }

    public boolean add(CsvRow row) {
        return rows.add(row);
    }

    public CsvRow get(int index) {
        return rows.get(index);
    }

    public List<CsvField> getColumn(int index) {
        List<CsvField> column = new ArrayList<>();
        rows.forEach(csvRow -> column.add(csvRow.get(index)));
        return column;
    }

    public void addAll(Collection<CsvRow> rows) {
        this.rows.addAll(rows);
    }

    public List<CsvRow> getRows() {
        return Collections.unmodifiableList(rows);
    }

    @Override
    public String toString() {
        return CsvSerializer.toCsv(this);
    }
}