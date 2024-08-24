package com.example.expense_tracker;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    private final IncomeRepository Repository;

    public IncomeService(IncomeRepository Repository) {
        this.Repository = Repository;
    }

    public List<Home> getAllOrders(String user) {
        return this.Repository.findAll(user);
    }
    public String  updateOrder(int in, int sa, String user) {
        return this.Repository.update (in,sa,user);
    }

    public String createNewTransaction(String am, String cg, String desc, String user) {
        int amount=this.Repository.insert(am, cg, desc,user);
        List<Balance> bal = this.Repository.bal(user);
        Balance balc = bal.get(0);
        int balance = balc.getBal();
        return this.Repository.updatebal(amount,balance,user);
    }

    public List<Transaction> getAllTrans(String user) {
        return this.Repository.findAllTrans(user) ;
    }

    public Login getPass(String user) {try {
        Login l1 = (Repository.findPass(user)).get(0);
        return l1;
    }catch (IndexOutOfBoundsException e) {
        return new Login("","");
    }
    }
    public String getreport(String user){
        return this.Repository.report(user);
    }
    public List<Report> findrep(String user){
        return  this.Repository.getrep(user);
    }

    public String delTran(int id,String user){
        return this.Repository.deleteTran(id,user);
    }

}