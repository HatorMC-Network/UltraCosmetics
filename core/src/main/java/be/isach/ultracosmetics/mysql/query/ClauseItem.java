package be.isach.ultracosmetics.mysql.query;

import java.util.List;

public interface ClauseItem {
    public String toSQL(List<Object> objects);
}
