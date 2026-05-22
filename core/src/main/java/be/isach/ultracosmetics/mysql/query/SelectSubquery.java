package be.isach.ultracosmetics.mysql.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

public class SelectSubquery implements ClauseItem, InsertItem {
    private final String matchColumn;
    private final String foreignTable;
    private final String foreignColumn;
    private final Map<String,Object> where = new HashMap<>();

    public SelectSubquery(String matchColumn, String foreignTable, String foreignColumn) {
        this.matchColumn = matchColumn;
        this.foreignTable = foreignTable;
        this.foreignColumn = foreignColumn;
    }

    public SelectSubquery(String foreignTable, String foreignColumn) {
        this(null, foreignTable, foreignColumn);
    }

    public SelectSubquery where(String key, Object value) {
        where.put(key, value);
        return this;
    }

    @Override
    public String toSQL(List<Object> objects) {
        StringBuilder sb = new StringBuilder();
        if (matchColumn != null) {
            sb.append(matchColumn).append(" = ");
        }
        sb.append("(SELECT ").append(foreignColumn).append(" FROM ").append(foreignTable).append(" WHERE ");
        StringJoiner clause = new StringJoiner(" AND ");
        for (Entry<String,Object> entry : where.entrySet()) {
            clause.add(entry.getKey() + " = ?");
            objects.add(entry.getValue());
        }
        sb.append(clause).append(")");
        return sb.toString();
    }
}
