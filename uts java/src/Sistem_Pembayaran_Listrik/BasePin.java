package Sistem_Pembayaran_Listrik;
import java.util.Scanner;


public abstract class BasePin {
    private String NoRef; // Variabel disembunyikan

    // Constructor dengan parameter (akses terbatas dalam package)
    BasePin(String NoRef){
        this.NoRef = NoRef; 
    }

    // Constructor kosong (meminta input otomatis)
    BasePin(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan no referensi : ");
        this.NoRef = input.nextLine();
    }

    // Mengambil nilai NoRef
    public String getNoRef() {
        return NoRef;
    }

    // Mengubah nilai NoRef
    public void setNoRef(String noRef) {
        NoRef = noRef;
    }

    // Wajib diisi oleh class anak (inheritance)
    abstract void info();
}