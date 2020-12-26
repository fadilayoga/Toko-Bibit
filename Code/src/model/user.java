/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;
/**
 *
 * @author fadil
 */
public class user {
    private String query;
    private ResultSet rs;
    private Statement stmt;
    private static String IDUser;
    private static String Telp;
    
    
    public static void setIDUser(String id_user){
        user.IDUser = id_user;
    }
    public static String getIDUser(){
        return IDUser;
    }    
    public static void setTelp(String telp){
        user.Telp = telp;
    }
    public static String getTelp(){
        return Telp;
    }    
    private int CekMember(String username, String password){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        int data=0;
        try{
            stmt = connect.createStatement();
            query ="SELECT COUNT(id_user) FROM member where username='"+username+"'"
                    +" and password='"+password+"' ";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                data = rs.getInt(1);
            }
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return data;
    }
        private int CekAdmin(String username, String password){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        int data=0;
        try{
            stmt = connect.createStatement();
            query ="SELECT COUNT(username) FROM admin where username='"+username+"'"
                    +" and password='"+password+"' ";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                data = rs.getInt(1);
            }
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return data;
    }
        
        public String CekMember(String username){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data=null;
        try{
            stmt = connect.createStatement();
            query = "SELECT `id_user` FROM `member` WHERE `username` = '"+username+"'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                data = rs.getString(1);
            }
            rs.close();
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ ex.getMessage());
        }
        return data;
    }        
        public String CekAdmin(String username){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data=null;
        try{
            stmt = connect.createStatement();
            query = "SELECT `username` FROM `admin` WHERE `username` = '"+username+"'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                data = rs.getString(1);
            }
            rs.close();
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ ex.getMessage());
        }
        return data;
    }
        
    public int CekUser(String username, String password){
        user obj = new user();
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        int a=0;
        try{
            if(username.contains("adm")){
            a = obj.CekAdmin(username,password) + 0; //0 dan 1
            }else{
            a = obj.CekMember(username,password) + 2; //2 dan 3
            }
        }catch(Exception ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return a;
    }
    
    public String [][] getProfil(String id){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data[][]=null;
        try{
            stmt = connect.createStatement();
            query = "SELECT `username`, `nama_user`, `email`, `alamat`, `jenis_kelamin`,`telepon` "
                    + "FROM `member` WHERE id_user = '"+id+"'";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String [1000][jmlKolom];
            int r = 0;
            while(rs.next()){
                for(int c=0; c<jmlKolom; c++){
                    data[r][c]=rs.getString(c+1);
                }
                r++;
            }
            int jmlBaris = r;
            String [][] tmparray = data;
            data = new String[jmlBaris][jmlKolom];
            for(r=0; r<jmlBaris; r++){
                for(int c=0; c<jmlKolom; c++){
                    data[r][c] = tmparray[r][c];
                }
            }
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error: "+ ex.getMessage());
        }
        return data;
    }
    
    public String cekTelp(String id){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data=null;
        try{
            stmt = connect.createStatement();
            query = "SELECT `telepon` FROM `member` WHERE `id_user` = '"+id+"'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                data = rs.getString(1);
            }
            rs.close();
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ ex.getMessage());
        }
        return data;
    }        
}
