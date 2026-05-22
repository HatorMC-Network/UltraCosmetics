package be.isach.ultracosmetics.mysql.query;

public class InnerJoin {
    private final String remoteTable;
    private final String localColumn;
    private final String remoteColumn;

    public InnerJoin(String remoteTable, String localColumn, String remoteColumn) {
        this.remoteTable = remoteTable;
        this.localColumn = localColumn;
        this.remoteColumn = remoteColumn;
    }

    public InnerJoin(String table, String column) {
        this(table, column, column);
    }

    public String toSQL(String localTable) {
        return "INNER JOIN " + remoteTable + " on " + localTable + "." + localColumn + " = " + remoteTable + "." + remoteColumn;
    }
}
