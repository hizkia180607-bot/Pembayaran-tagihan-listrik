package Sistem_Pembayaran_Listrik;
import java.util.Scanner;

public class LNonTaglis extends BasePin{
    private String Keterangan;
    private float BiayaLayanan;

    LNonTaglis(String NoRef, String Keterangan, float BiayaLayanan){
        super(NoRef); // Mengambil constructor induk
        this.Keterangan = Keterangan;
        this.BiayaLayanan = BiayaLayanan;
    }

    LNonTaglis(){
        super(); // Memanggil constructor kosong induk
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan keterangan : ");
        this.Keterangan = input.nextLine();
        System.out.print("Masukkan biaya layanan : ");
        this.BiayaLayanan = input.nextFloat();
    }

    public String getKeterangan() { return Keterangan; }
    public void setKeterangan(String keterangan) { Keterangan = keterangan; }
    public float getBiayaLayanan() { return BiayaLayanan; }
    public void setBiayaLayanan(float biayaLayanan) { BiayaLayanan = biayaLayanan; }

    @Override
    void info(){
        System.out.println("Jenis tagihan anda adalah nontaglis"); // Implementasi abstract method
    }
}