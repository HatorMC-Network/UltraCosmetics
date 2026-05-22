package be.isach.ultracosmetics.mysql.column;

import java.util.UUID;

public class UUIDColumn extends Column<UUID> {

    public UUIDColumn(String name, String properties) {
        super(name, properties, UUID.class);
    }

    public UUIDColumn(String name) {
        this(name, "BINARY(16) NOT NULL");
    }

    public UUIDColumn() {
        this("uuid");
    }
}
