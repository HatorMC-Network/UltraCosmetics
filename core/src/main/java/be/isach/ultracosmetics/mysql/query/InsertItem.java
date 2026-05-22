package be.isach.ultracosmetics.mysql.query;

import java.util.List;

public interface InsertItem {
    public String toSQL(List<Object> objects);
}
