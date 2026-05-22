package be.isach.ultracosmetics.mysql.column;

import be.isach.ultracosmetics.mysql.tables.TableInfo;

public class Constraint implements TableInfo {
    private final String constraint;

    public Constraint(String constraint) {
        this.constraint = constraint;
    }

    @Override
    public String toSQL() {
        return constraint;
    }

}
