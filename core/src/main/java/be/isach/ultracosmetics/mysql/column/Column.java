package be.isach.ultracosmetics.mysql.column;

import be.isach.ultracosmetics.mysql.tables.TableInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Column<T> implements TableInfo {
    private final String name;
    private final String properties;
    private final Class<T> type;

    // columnSize for use with String type
    public Column(String name, String properties, Class<T> type) {
        this.name = name;
        this.properties = properties;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toSQL() {
        return name + " " + properties;
    }

    public Class<T> getTypeClass() {
        return type;
    }

    public Object getValue(ResultSet result) throws SQLException {
        if (type == Integer.class) {
            return result.getInt(name);
        } else if (type == Boolean.class) {
            return result.getBoolean(name);
        } else if (type == String.class) {
            return result.getString(name);
        } else if (type == UUID.class) {
            byte[] bytes = result.getBytes(name);
            if (bytes.length != 16) {
                throw new RuntimeException("Binary from database was wrong length: " + bytes.length);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                sb.append(String.format("%02X", bytes[i]));
                if (i == 3 || i == 5 || i == 7 || i == 9) {
                    sb.append('-');
                }
            }
            return UUID.fromString(sb.toString());
        } else {
            throw new RuntimeException("No getter for class " + type.getName());
        }
    }
}
