package be.isach.ultracosmetics.mysql.column;

public class ForeignKeyConstraint extends Constraint {

    public ForeignKeyConstraint(String column, String foreignTable, String foreignColumn) {
        // Don't use quotes on column name, this is sometimes used with multiple columns
        super("FOREIGN KEY (" + column + ") REFERENCES " + foreignTable + "(" + foreignColumn + ")");
    }

}
