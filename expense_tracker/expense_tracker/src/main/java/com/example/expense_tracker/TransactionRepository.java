package com.example.expense_tracker;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TransactionRepository {
    private final JdbcTemplate template;
    private final JdbcClient jdbcClient;

    public TransactionRepository(JdbcTemplate template, JdbcClient jdbcClient) {
        this.template = template;
        this.jdbcClient = jdbcClient;
    }

    public List<Income> findAll() {
        return jdbcClient.sql("SELECT * FROM Transaction")
                .query((rs, rowNum) -> new Income(
                        rs.getString("Username"),
                        rs.getInt("Monthly_Income"),
                        rs.getInt("Savings%"),
                        rs.getInt("Balance"),
                        rs.getInt("Budget")
                )).list();
    }

    public Transaction insert(Transaction tran) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql("INSERT INTO Transcation(Username, Amount, Category, Description, Date) VALUES (:Username, :Amount, :Category, :Description, :Date)")
                .params(Map.of(
                        "Username", tran.getUsername(),
                        "Amount", tran.getAmount(),
                        "Category", tran.getCategory(),
                        "Description", tran.getDesc()
                ))
                .update(keyHolder);
        return tran;
    }
    /*
    public Optional<Order> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM orders WHERE id = :id")
                .params(Map.of("id", id))
                .query((rs, rowNum) -> new Order(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("placed_time").toLocalDateTime(),
                        rs.getInt("total_amount"),
                        OrderStatus.valueOf(rs.getString("status"))
                ))
                .optional();
    }

    public Optional<Order> update(Integer id, Order order) {
        int updateCount = jdbcClient.sql("UPDATE orders SET name = :name, placed_time = :placed_time, total_amount = :total_amount, status = :status WHERE id = :id")
                .params(Map.of(
                        "id", id,
                        "name", order.getName(),
                        "placed_time", order.getPlacedTime(),
                        "total_amount", order.getTotalAmount(),
                        "status", order.getStatus().toString()
                ))
                .update();
        if (updateCount == 0) {
            return Optional.empty();
        }
        order.setId(id);
        return Optional.of(order);
    }

    public void deleteById(Integer id) {
        jdbcClient.sql("DELETE FROM orders WHERE id = :id")
                .params(Map.of("id", id))
                .update();
    }

    public void saveAll (Iterable<Order> orders) {
        orders.forEach(this::insert);
    }

    public long count() {
        return (Long) jdbcClient.sql("SELECT COUNT(*) FROM orders")
                .query()
                .singleValue();
    }*/
}
