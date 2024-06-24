/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class database {
    private String database = "2210010303";
    private String username = "root";
    private String password = "";

    public Connection konekdb;

    public database() {
        try {
            String url = "jdbc:mysql://localhost/" + this.database;
            Class.forName("com.mysql.jdbc.Driver");
            konekdb = DriverManager.getConnection(url, username, password);
            System.out.println("Database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void simpanuser(String userid, String username, String email, String password) {
        try {
            String SQL = "INSERT INTO user (user_id, username, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, userid);
            perintah.setString(2, username);
            perintah.setString(3, email);
            perintah.setString(4, password);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Disimpan");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ubahuser(String userid, String username, String email, String password) {
        try {
            String SQL = "UPDATE user SET username = ?, email = ?, password = ? WHERE user_id = ?";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, username);
            perintah.setString(2, email);
            perintah.setString(3, password);
            perintah.setString(4, userid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Diubah");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void hapususer(String userid) {
        try {
            String SQL = "DELETE FROM user WHERE user_id = ?";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, userid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void simpanartikel(String artikelid, String kontenid, String titel) {
        try {
            String SQL = "INSERT INTO artikel (artikel_id, konten_id, titel) VALUES (?, ?, ?)";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, artikelid);
            perintah.setString(2, kontenid);
            perintah.setString(3, titel);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Disimpan");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ubahartikel(String artikelid, String kontenid, String titel) {
        try {
            String SQL = "UPDATE artikel SET konten_id = ?, titel = ? WHERE artikel_id = ?";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, kontenid);
            perintah.setString(2, titel);
            perintah.setString(3, artikelid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Diubah");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void hapusartikel(String artikelid) {
        try {
            String SQL = "DELETE FROM artikel WHERE artikel_id = ?";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, artikelid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpankomentar(String komentarid, String komentar) {
        try {
            String SQL = "INSERT INTO komentar (komentar_id, komentar) VALUES (?, ?, ?, ?,)";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, komentarid);
            perintah.setString(2, komentar);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Disimpan");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

 public void ubahkomentar(String komentarid, String komentar) {
    try {
        String SQL = "UPDATE komentar SET komentar = ? WHERE komentar_id = ?";
        PreparedStatement perintah = konekdb.prepareStatement(SQL);
        perintah.setString(1, komentar);
        perintah.setString(2, komentarid);
        perintah.executeUpdate();
        System.out.println("Data Berhasil Diubah");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


    public void hapuskomentar(String komentarid) {
        try {
            String SQL = "DELETE FROM komentar WHERE komentar_id = ?";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, komentarid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void simpankategori(String kategoriid, String kategoriname) {
        try {
            String SQL = "INSERT INTO kategori (kategori_id, kategori_name) VALUES (?, ?)";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, kategoriid);
            perintah.setString(2, kategoriname);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Disimpan");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

 public void ubahkategori(String kategoriid, String kategoriname) {
    try {
        String SQL = "UPDATE kategori SET kategori_name = ? WHERE kategori_id = ?";
        PreparedStatement perintah = konekdb.prepareStatement(SQL);
        perintah.setString(1, kategoriname);
        perintah.setString(2, kategoriid);
        perintah.executeUpdate();
        System.out.println("Data Berhasil Diubah");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


    public void hapuskategori(String kategoriid) {
        try {
            String SQL = "DELETE FROM kategori WHERE kategori_id = ?";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, kategoriid);
            perintah.executeUpdate();
            System.out.println("Data Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void cariuser(String userid) {
        try {
            String SQL = "SELECT * FROM user WHERE user_id = ?";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, userid);
            ResultSet data = perintah.executeQuery();
            while (data.next()) {
                System.out.println("USER_ID: " + data.getString("user_id"));
                System.out.println("USERNAME: " + data.getString("username"));
                System.out.println("EMAIL: " + data.getString("email"));
                System.out.println("PASSWORD: " + data.getString("password"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void datauser() {
        try {
            Statement stmt = konekdb.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM user ORDER BY user_id ASC");
            while (baris.next()) {
                System.out.println(baris.getString("user_id") + " | " +
                                   baris.getString("username") + " | " +
                                   baris.getString("email") + " | " +
                                   baris.getString("password"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void dataartikel() {
        try {
            Statement stmt = konekdb.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM artikel ORDER BY artikel_id ASC");
            while (baris.next()) {
                System.out.println(baris.getString("artikel_id") + " | " +
                                   baris.getString("konten_id") + " | " +                                
                                   baris.getString("titel"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void cariartikel(String artikelid) {
        try {
            String SQL = "SELECT * FROM artikel WHERE artikel_id = ?";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, artikelid);
            ResultSet data = perintah.executeQuery();
            while (data.next()) {
                System.out.println("artikel_id: " + data.getString("artikel_id"));
                System.out.println("konte_id: " + data.getString("konten_id"));
                System.out.println("titel: " + data.getString("titel"));  
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
        public void carikomentar(String komentarid) {
        try {
            String SQL = "SELECT * FROM komentar WHERE komentar_id = ?";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, komentarid);
            ResultSet data = perintah.executeQuery();
            while (data.next()) {
                System.out.println("komentar_id: " + data.getString("komentar_id"));
                System.out.println("komentar: " + data.getString("komentar"));               
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void datakomentar() {
        try {
            Statement stmt = konekdb.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM komentar ORDER BY komentar_id ASC");
            while (baris.next()) {
                System.out.println(baris.getString("komentar_id") + " | " +                      
                                   baris.getString("koemntar"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
        public void carikategori(String kategoriid) {
        try {
            String SQL = "SELECT * FROM kategori WHERE kategori_id = ?";
            PreparedStatement perintah = konekdb.prepareStatement(SQL);
            perintah.setString(1, kategoriid);
            ResultSet data = perintah.executeQuery();
            while (data.next()) {
                System.out.println("kategori_id: " + data.getString("kategori_id"));
                System.out.println("kategori_name: " + data.getString("kategori_name"));            
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void datakategori() {
        try {
            Statement stmt = konekdb.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM kategori ORDER BY kategori_id ASC");
            while (baris.next()) {
                System.out.println(baris.getString("kategori_id") + " | " +      
                                   baris.getString("kategori_name"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    
    }
}
