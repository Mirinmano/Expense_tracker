package com.example.expense_tracker;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class IncomeRepository {
    private final JdbcTemplate template;
    private final JdbcClient jdbcClient;

    public IncomeRepository(JdbcTemplate template, JdbcClient jdbcClient) {
        this.template = template;
        this.jdbcClient = jdbcClient;
    }

    public List<Home> findAll(String user) {
        return jdbcClient.sql("SELECT Monthly_Income,`Savings%`,Balance,Budget,Username,Password,DOB,Name,Phone,Email FROM income natural join user WHERE Username=:user").param("user",user)
                .query((rs, rowNum) -> new Home(
                        rs.getInt("Monthly_Income"),
                        rs.getInt("Savings%"),
                        rs.getInt("Balance"),
                        rs.getInt("Budget"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getDate("DOB"),
                        rs.getString("Name"),
                        rs.getString("Phone"),
                        rs.getString("Email")
                )).list();
    }

    public String update(int in, int sa, String user) {
        int saving = (sa*in)/100;
        int updateCount = jdbcClient.sql("UPDATE Income SET Monthly_Income = :mincome, `Savings%` = :sav, Balance = :Bal, Budget = :Bal WHERE Username = :username")
                .params(Map.of(
                        "mincome", in,
                        "sav",saving,
                        "Bal",(in-saving),
                        "username",user))
                .update();
        if (updateCount == 0) {
            return "Error";
        }else{
            jdbcClient.sql("DELETE FROM transaction WHERE Username=:username").param("username",user).update();
        }
        return "success";
    }
    public int insert(String am,String cg, String desc,String user) {
        jdbcClient.sql("INSERT INTO transaction(Username, Amount, Category, Description) VALUES (:username, :am, :cg, :desc)")
                .params(Map.of(
                        "am", am,
                        "cg", cg,
                        "desc", desc,
                        "username",user
                ))
                .update();
        return Integer.parseInt(am);
    }

    public List<Transaction> findAllTrans(String user) {
        return jdbcClient.sql("SELECT * FROM transaction WHERE Username = :username ").param("username",user)
                .query((rs, rowNum) -> new Transaction(
                        rs.getString("Username"),
                        rs.getDouble("Amount"),
                        rs.getString("Category"),
                        rs.getString("Description"),
                        rs.getDate("Date"),
                        rs.getInt("tran_id")
                )).list();
    }
    public String updatebal(int amount, int bal, String user){
        int updateCount = jdbcClient.sql("UPDATE income SET Balance = :balance WHERE Username = :username")
                .params(Map.of("balance",(bal-amount),
                        "username",user))
                .update();
        if (updateCount == 0) {
            return "Error";
        }
        return "transaction_com";
    }

    public List<Balance> bal(String user){
        return jdbcClient.sql("SELECT Balance FROM Income WHERE Username=:username").param("username",user)
                .query((rs, rowNum)->new Balance(rs.getInt("Balance"))).list();
    }

    public List<Login> findPass(String user) {
        return jdbcClient.sql("SELECT Username, Password FROM user WHERE Username=:username")
                .param("username",user)
                .query((rs, rowNum)->new Login(rs.getString("Username"),rs.getString("Password")))
                .list();
    }
    public String deleteTran(int id,String user){
        double amount = ((jdbcClient.sql("SELECT Amount FROM transaction WHERE tran_id=:id").param("id",id)
                .query((rs,rowNum)->new Transaction(rs.getDouble("Amount"))).list()).get(0)).getAmount();
        jdbcClient.sql("UPDATE income SET Balance = Balance+:amount WHERE Username=:user").params(Map.of(
                "amount",amount,"user",user
        )).update();
        int row = jdbcClient.sql("DELETE FROM transaction WHERE tran_id=:id").param("id",id).update();
        if(row>0){
            return "del_suc";
        }else{
            return "error";
        }
    }
    public String report(String user){
        jdbcClient.sql("DELETE FROM report where Month=MONTH(CURDATE()) and Year=YEAR(CURDATE())").update();
        int total = (int) ((jdbcClient.sql("SELECT SUM(Amount) 's' FROM transaction WHERE Username=:user and MONTH(date)=MONTH(curdate()) and year(date)=year(CURDATE())")
                .param("user",user).query((rs,rowNum)->new Transaction(rs.getDouble("s"))
                        ).list()).get(0)).getAmount();
        detail d= (jdbcClient.sql("select user.Username,income.balance,income.budget,income.Monthly_Income FROM income natural join user WHERE Username=:user")
                .param("user",user)
                .query((rs,rowNum)->new detail(
                        rs.getString("Username"),rs.getInt("balance"),
                        rs.getInt("budget"),rs.getInt("Monthly_Income")
                )).list()).get(0);
        int row = jdbcClient.sql("insert into report(Username, balance, budget, income, Month, Year,tot_ex) values (:user,:bal,:bud,:in,Month(CURDATE()),YEAR(CURDATE()),:ex)")
                .params(Map.of(
                        "user",d.getUser(),
                        "bal",d.getBalance(),
                        "bud",d.getBudget(),
                        "in",d.getIncome(),
                        "ex",total
                )).update();
        if(row>0){
            return "gen";
        }else{
            return "error";
        }
    }
    public List<Report> getrep(String user){
        return jdbcClient.sql("SELECT * FROM report WHERE Username=:username")
                .param("username",user)
                .query((rs, rowNum)-> new Report(
                    rs.getInt("report_id"),
                        rs.getDate("date"),
                        rs.getInt("balance"),
                        rs.getInt("budget"),
                        rs.getInt("income"),
                        rs.getInt("tot_ex"),
                        rs.getString("Month"),
                        rs.getString("Year")
                ))
                .list();
    }

}
