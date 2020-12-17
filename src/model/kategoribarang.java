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
public class kategoribarang {
    private String query;
    private ResultSet rs;
//    private ResultSet rs_c;
    private Statement stmt;    
//    private Statement stmt_c;
//    private int jumBaris;
    
    public String [][] getKategori(){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data [][] = null;
        try{
            stmt = connect.createStatement();
            //ambil data
            query = "SELECT *"
                    + " from `kategori` "
                    + " order by `id_kategori`";
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
    
    public String [][] CariDataKategori(String kategori){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data [][] = null;
        try{
            stmt = connect.createStatement();
            query = "SELECT *"
                    +"FROM kategori where nama_kategori "
                    +"LIKE '%"+kategori+"%' order by nama_kategori";
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
    
    public void TambahDataKategori(String id, String kategori){
//        jumBaris = 0;
        koneksi kon = new koneksi ();
        Connection connect = kon.koneksiDatabase();
        try{
            stmt = connect.createStatement();
            query = "insert into kategori "
                    + "(id_kategori, nama_kategori) "
                    + " values ('"+id+"','"+kategori+"')";
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
    
    public void UpdateDataKategori(String id, String kategori){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        try{
            stmt = connect.createStatement();
            query = "update kategori set nama_kategori='"+kategori+"' "
                    + " where id_kategori ='"+id+"' ";
            stmt.executeUpdate(query);
            
            stmt.close();
            connect.close();            
        }catch(SQLException ex){
            System.out.println("Error : "+ ex.getMessage());
        }
    }
    
    public String getDataKategori(String id){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        String data=null;
        try{
            stmt = connect.createStatement();
            query = "SELECT nama_kategori FROM kategori "
                    + "where id_kategori = '"+id+"'";
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
    
    public void HapusDataKategori (String id){
        koneksi kon = new koneksi();
        Connection connect = kon.koneksiDatabase();
        try{
            stmt = connect.createStatement();
            query = "DELETE FROM kategori WHERE `id_kategori` = '"+id+"'";
            stmt.executeUpdate(query);
            
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.err.println("Eror :" +ex.getMessage());
        }
    }
}
