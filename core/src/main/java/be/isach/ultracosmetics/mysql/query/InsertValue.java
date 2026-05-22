package be.isach.ultracosmetics.mysql.query;

public class InsertValue extends ClauseItemLiteral implements InsertItem {

    public InsertValue(Object value) {
        super(null, value);
    }
}
