package be.isach.ultracosmetics.mysql.column;

import java.util.StringJoiner;

public class UniqueConstraint extends Constraint {

    public UniqueConstraint(String... columns) {
        super(joinColumns(columns));
    }

    private static String joinColumns(String[] columns) {
        if (columns == null || columns.length < 2) {
            throw new IllegalArgumentException("Unique constraint requires at least two columns!");
        }
        StringJoiner sj = new StringJoiner(", ", "UNIQUE KEY (", ")");
        for (String column : columns) {
            sj.add(column);
        }
        return sj.toString();
    }
}
