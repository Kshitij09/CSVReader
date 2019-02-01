package csvreader.impl;

import java.util.Collection;

public interface IRow<T extends IField<?>> {
    Collection<T> getFields();
}
