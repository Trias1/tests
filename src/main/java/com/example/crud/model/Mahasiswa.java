package com.example.crud.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_mahasiswa")
public class Mahasiswa {
    @Id
    @Column(name = "nim")
    private Long nim;
    @Column(name = "nama")
    private String nama;
    @Column(name = "uname", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "alamat")
    private String alamat;


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Long getNim() {
        return nim;
    }

    public void setNim(Long nim) {
        this.nim = nim;
    }
}
