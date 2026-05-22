package be.isach.ultracosmetics.mysql.query;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handy dandy functional interface for processing
 * ResultSets where each implementation does not have
 * to catch SQLException itself.
 *
 * @param <T> result type
 */
@FunctionalInterface
public interface ResultGetter<T> {
    T process(ResultSet result) throws SQLException;
}
