/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.AccountDTO;

/**
 *
 * @author linh2
 */
public class AccountDAO {

    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;

    public ArrayList<AccountDTO> getListAccounts() {
        try {
            String query = "select * from account";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<AccountDTO> list = new ArrayList<>();
            while (rs.next()) {
                AccountDTO a = new AccountDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public AccountDTO login(String username, String password) {
        try {
            String query = " select * from account \n"
                    + "where username =? and password =?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                AccountDTO acc = new AccountDTO(rs.getString(2), rs.getString(3));
                return acc;
            }
        } catch (Exception e) {
        }
        return null;
    }



    public static AccountDTO checkAccountExist(String username) {
        try {
            String query = "select * from account \n"
                    + "where username = ?;";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new AccountDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void register(String username, String pass, String email, String phone) {
        try {
            String query = "insert into account\n"
                            + "values(?,?,?,?,0)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
