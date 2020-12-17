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
public class databarang {
    private String query;
    private ResultSet rs;
    private Statement stmt;
//    private ResultSet rs_c;
//    private Statement stmt_c;
//    private int jumBaris;
    
    public String [][] getDataBarang(){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data [][] = null;
        try{
            stmt = connect.createStatement();
            //ambil data
            query = "SELECT * FROM `barang`";
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
    
    public String [] getListKategori(){
        String data[] = null;
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        try{
            stmt = connect.createStatement();
            query = "SELECT *"
                    + " FROM kategori order by id_kategori ";
            rs = stmt.executeQuery(query);
//            ResultSetMetaData meta = rs.getMetaData();
//            int jmlKolom = meta.getColumnCount();
            data = new String[1000];
            int r = 0;
            while(rs.next()){
                String id = rs.getString(1);
                String nama = rs.getString(2);
                String list = id+"-"+nama;
                    data[r] = list;
                    r++;
            }
            int jmlBaris = r;
            String [] tmparray = data;
            data = new String[jmlBaris];
            for(r=0; r<jmlBaris; r++){
                data[r] = tmparray[r];
            }
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ ex.getMessage());
        }
        return data;
    }
    
    public String [][] CariDataBarang(String barang){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data [][] = null;
        try{
            stmt = connect.createStatement();
            query = "SELECT *"
                    +"FROM barang where nama_barang "
                    +"LIKE '%"+barang+"%' order by nama_barang";
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
            System.out.println("Error : "+ex.getMessage());
        }
        return data;
    }
    
    public void TambahDataBarang(String id, String kategori, String harga, String id_kategori){
//        jumBaris = 0;
        koneksi kon = new koneksi ();
        Connection connect = kon.koneksiDatabase();
        try{
            stmt = connect.createStatement();
            query = "insert into barang "
                    + "(id_barang, nama_barang, harga, id_kategori) "
                    + " values ('"+id+"','"+kategori+"','"+harga+"','"+id_kategori+"')";           
            stmt.executeUpdate(query);
//            stmt_c = connect.createStatement();
//            rs_c = stmt_c.executeQuery("SELECT COUNT(*) FROM `barang`");
//            while (rs_c.next()){
//                jumBaris = rs_c.getInt(1);
//            }
            stmt.close();
//            stmt_c.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ ex.getMessage());
        }
//        return jumBaris;
    }
    
    public String [][] getDataBarang(String id_barang){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data [][] = null;
        try{
            stmt = connect.createStatement();
            query = "SELECT `barang`.*, `kategori`.`nama_kategori` "
                    + "FROM `barang` INNER JOIN `kategori` "
                    + "ON `barang`.`id_kategori` = `kategori`.`id_kategori`"
                    + "WHERE id_barang = "+id_barang;
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String[1000][jmlKolom];
            int r = 0;
            while(rs.next()){
                for(int c=0; c<jmlKolom; c++){
                    data [r][c] = rs.getString(c+1);
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
            System.out.println("Error : "+ ex.getMessage());
        }
        return data;
    }
    
    public void HapusDataBarang (String id){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        try{
            stmt = connect.createStatement();
            query = "DELETE FROM barang WHERE `id_barang` = '"+id+"'";
            stmt.executeUpdate(query);            
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.err.println("Eror :" +ex.getMessage());
        }
    }
    
    public void editBarang(String id_barang, String nama_barang, String harga, String kodekategori){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        try{
            stmt = connect.createStatement();
            query="update barang set `id_kategori` = '"+kodekategori+"',"
                 +" `nama_barang` = '"+nama_barang+"',"
                 +" `harga` = '"+harga+"'"
                 +" where `id_barang` = '"+id_barang+"'";
            stmt.executeUpdate(query);
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
}
}
