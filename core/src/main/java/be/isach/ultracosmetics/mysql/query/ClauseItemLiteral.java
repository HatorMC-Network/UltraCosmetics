package be.isach.ultracosmetics.mysql.query;

import java.util.List;

public class ClauseItemLiteral implements ClauseItem {
    private final String column;
    private final Object value;

    public ClauseItemLiteral(String column, Object value) {
        this.column = column;
        this.value = value;
    }

    public String getColumn() {
        return column;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toSQL(List<Object> objects) {
        objects.add(value);
        return (column == null ? "" : column + " = ") + "?";
    }
}
