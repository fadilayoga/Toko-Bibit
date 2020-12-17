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
public class trans_brg {
    private String query;
    private ResultSet rs;
    private Statement stmt;
    private static String jumlah;
    private static String harga;
    
    public static void setJumlah(String jml, String hrg){
        jumlah = jml;
        harga = hrg;
    }
    
    public String [][] getBarang(){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data [][] = null;
        try{
            stmt = connect.createStatement();
            //ambil data
            query = "SELECT `id_barang`,`nama_barang`,`harga`"
                    + " from `barang` "
                    + " order by `id_barang`";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String[1000][jmlKolom];
            int r = 0;
            while(rs.next()){
                for(int c=0; c<jmlKolom; c++){
                    data[r][c]= rs.getString(c+1);
                }
                r++;
            }
            int jmlBaris = r;
            String [][] tmparray = data;
            data = new String[jmlBaris][jmlKolom];
            for(r=0; r<jmlBaris; r++){
                for(int c=0; c<jmlKolom; c++){
                    data[r][c] = tmparray [r][c];
                }
            }
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return data;
    }
    public String [][] getDataBarang(String id_brg){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data [][] = null;
        try{
            stmt = connect.createStatement();
            //ambil data
            query = "SELECT `nama_barang`,`harga`"
                    + " from `barang` where id_barang = '"+id_brg+"'"
                    + " order by `id_barang`";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String[1000][jmlKolom];
            int r = 0;
            while(rs.next()){
                for(int c=0; c<jmlKolom; c++){
                    data[r][c]= rs.getString(c+1);
                }
                r++;
            }
            int jmlBaris = r;
            String [][] tmparray = data;
            data = new String[jmlBaris][jmlKolom];
            for(r=0; r<jmlBaris; r++){
                for(int c=0; c<jmlKolom; c++){
                    data[r][c] = tmparray [r][c];
                }
            }
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return data;
    }
    
    public void keranjang(String id_user, String id_barang, String jumlah){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        try{
            stmt = connect.createStatement();
            query="INSERT INTO `transaksi` (`id_user`, `id_barang`, `jumlah`) "
                    + "VALUES ('"+id_user+"','"+id_barang+"', '"+jumlah+"')";
            stmt.executeUpdate(query);
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }
    
    public String getID_Barang(String nm_brg, String harga){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data=null;
        try{
            stmt = connect.createStatement();
            query = "SELECT `id_barang` FROM `barang` "
                    + "WHERE nama_barang = '"+nm_brg+"' and harga = '"+harga+"'";
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
    
    public String [][] Transaksi_User(String id_brg){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data [][] = null;
        try{
            stmt = connect.createStatement();
            //ambil data
            query = "SELECT `barang`.`nama_barang`,`harga`,`transaksi`.`jumlah` "
                    + "FROM `barang` INNER JOIN transaksi "
                    + "ON barang.id_barang = transaksi.id_barang "
                    + "WHERE id_user = '"+id_brg+"'";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String[1000][jmlKolom];
            int r = 0;
            while(rs.next()){
                for(int c=0; c<jmlKolom; c++){
                    data[r][c]= rs.getString(c+1);
                }
                r++;
            }
            int jmlBaris = r;
            String [][] tmparray = data;
            data = new String[jmlBaris][jmlKolom];
            for(r=0; r<jmlBaris; r++){
                for(int c=0; c<jmlKolom; c++){
                    data[r][c] = tmparray [r][c];
                }
            }
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return data;
    }
    
    public int hitung_total(){        
        int total_akhir = Integer.parseInt(harga) * Integer.parseInt(jumlah);
        return total_akhir;
    }
    
    public String [][] show_sup(){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data [][] = null;
        try{
            stmt = connect.createStatement();
            //ambil data
            query = "SELECT `member`.`id_user`,`transaksi`.`id_barang`,`barang`.`nama_barang`,`transaksi`.`jumlah` "
                    + "FROM `member`,`barang`,`transaksi`"
                    + "WHERE `transaksi`.`id_user` = `member`.`id_user` "
                    + "AND `transaksi`.`id_barang` = `barang`.`id_barang`";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String[1000][jmlKolom];
            int r = 0;
            while(rs.next()){
                for(int c=0; c<jmlKolom; c++){
                    data[r][c]= rs.getString(c+1);
                }
                r++;
            }
            int jmlBaris = r;
            String [][] tmparray = data;
            data = new String[jmlBaris][jmlKolom];
            for(r=0; r<jmlBaris; r++){
                for(int c=0; c<jmlKolom; c++){
                    data[r][c] = tmparray [r][c];
                }
            }
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
        return data;
    }
}
