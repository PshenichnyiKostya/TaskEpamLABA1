package dao;

import bean.Client;
import bean.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLClientDao extends BaseMysql<Client> implements Dao<Client> {
    private static final String DB_URL = "jdbc:mysql://localhost:8889/epam";
    private static final String DB_USER = "kostya";
    private static final String DB_PASSWORD = "123";
    private final Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    private static final String CREATE = "INSERT INTO `client` (`id`,`name`, `pass`,`login`,`freemiles`,`discount`,`surname`,`gender`) VALUES (?,?,?,?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM `client` WHERE `id`=?";
    private static final String READ = "SELECT `id`,`name`, `pass`,`login`,`freemiles`,`discount`,`surname`,`gender` FROM `client` WHERE `id` = ? ";

    public SQLClientDao() throws SQLException {
    }

    @Override
    Client fillFieldsObject(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        setParam(client, resultSet);
        return client;
    }

    @Override
    void setFieldStatement(PreparedStatement statement, Client entity) throws SQLException {
        statement.setString(1, entity.getId());
        statement.setString(2, entity.getName());
        statement.setString(3, entity.getPass());
        statement.setString(4, entity.getLogin());
        statement.setDouble(5, entity.getFreeMiles());
        statement.setInt(6, entity.getDiscount());
        statement.setString(7, entity.getSurname());
        statement.setString(8, String.valueOf(entity.getGender()));

    }

    @Override
    List<Client> fillList(ResultSet resultSet) throws SQLException {
        List<Client> users = new ArrayList<>();
        Client user;
        while (resultSet.next()) {
            user = new Client();
            setParam(user, resultSet);
            users.add(user);
        }
        return users;
    }

    @Override
    void setParam(Client obj, ResultSet resultSet) throws SQLException {
        Gender gender = Gender.of(resultSet.getString("gender"));
        obj.setGender(gender);
        obj.setPass(resultSet.getString("pass"));
        obj.setLogin(resultSet.getString("login"));
        obj.setName(resultSet.getString("name"));
        obj.setSurname(resultSet.getString("surname"));
        obj.setDiscount(resultSet.getInt("discount"));
        obj.setFreeMiles(resultSet.getDouble("freemiles"));

    }

//    @Override
//    void setPrimary(PreparedStatement statement, Client entity) throws SQLException {
//
//    }

    @Override
    public void delete(Client obj) throws DaoException {
        String id = obj.getId();
        deleteByString(DELETE, id, connection);
    }

    @Override
    public void add(Client obj) throws DaoException {
        defaultCreate(CREATE, connection, obj);
    }

    @Override
    public Client get(String id) throws DaoException {
        String sql = READ;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            Client user = null;
            if (resultSet.next()) {
                user = new Client();
                setParam(user, resultSet);
            }
            return user;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException ignored) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException ignored) {
            }
        }
    }


}
