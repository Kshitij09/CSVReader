package csvreader.impl;

import java.util.Collection;

public interface IFile<R extends IField<String>, T extends IRow<R>> {
    Collection<T> getRows();
}
