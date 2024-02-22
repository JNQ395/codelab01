package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class odd1 {
    public static void main(String[] args) {

        //Scanner utk input dari pengguna
        Scanner masukan = new Scanner(System.in);

        //DateTimeFormatter utk format tanggal
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //input nama
        System.out.print("Nama : ");
        String nama = masukan.nextLine();

        // input jenis kelamin
        System.out.print("Jenis Kelamin (L/P) : ");
        String jenisklInput = masukan.nextLine();
        String jenisKelamin = jenisklInput.equalsIgnoreCase("P") ? "Perempuan" : "Laki-laki";

        //input tgl lahir
        System.out.print("Tanggal Lahir (yyyy-mm-dd) : ");
        String tglLahirInput = masukan.nextLine();

        boolean inputValid = false;

        //perulangan
        do {
            try {
                //input tgl lahir ke LocalDate dgn formatter
                LocalDate tglLahir = LocalDate.parse(tglLahirInput, formatter);

                //cek tanggal sekarang
                LocalDate tglSekarang = LocalDate.now();

                //hitung usia
                int usia = Period.between(tglLahir, tglSekarang).getYears();

                //hitung umur
                Period Kelahiran = Period.between(tglLahir, tglSekarang);

                // output
                System.out.println("\n//output");
                System.out.println("Nama : " + nama); //output nama
                System.out.println("Jenis Kelamin : " + jenisKelamin); //output kelamin
                System.out.println("Usia Anda : " + usia + " tahun " + Kelahiran.getMonths() + " bulan."); //output usia

                inputValid = true;
            } catch (Exception e) {
                tglLahirInput = masukan.nextLine();
            }
        } while (!inputValid);

        // Menutup Scanner
        masukan.close();
    }
}
