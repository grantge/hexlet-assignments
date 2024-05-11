package exercise.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.zaxxer.hikari.HikariDataSource;
import exercise.model.Product;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductsRepository extends BaseRepository {

    // BEGIN
    public static void save(Product product) throws SQLException  {

        String sql = "INSERT INTO products (title, price) VALUES (?, ?)";

        try (var connection = BaseRepository.dataSource.getConnection()) {

            var preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                product.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Product> find(Long id) throws SQLException {

        String sql = "SELECT * FROM products WHERE id = '" + id + "' ";

        try (var connection = BaseRepository.dataSource.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet result;
            result = statement.executeQuery(sql);
            if (result.next()) {
                String title = result.getString("title");
                int price = result.getInt("price");

                Product product = new Product(title, price);
                product.setId(id);
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public static List<Product> getEntities() throws SQLException {

        String sql = "SELECT * FROM products";

        try (var connection = BaseRepository.dataSource.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet result;
            result = statement.executeQuery(sql);
            var products = new ArrayList<Product>();
            while (result.next()) {
                Long id = result.getLong("id");
                String title = result.getString("title");
                int price = result.getInt("price");

                Product product = new Product(title, price);
                product.setId(id);
                products.add(product);
            }
            return products;
        }
    }
    // END
}
