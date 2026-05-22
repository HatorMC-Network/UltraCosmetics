package be.isach.ultracosmetics.mysql.column;

public class VirtualUUIDColumn extends Column<String> {

    public VirtualUUIDColumn(String sourceColumn) {
        super("uuid_text", "char(36) GENERATED ALWAYS AS (insert(insert(insert(insert(hex(" + sourceColumn + "),9,0,'-'),14,0,'-'),19,0,'-'),24,0,'-')) VIRTUAL", String.class);
    }

    public VirtualUUIDColumn() {
        this("uuid");
    }
}
