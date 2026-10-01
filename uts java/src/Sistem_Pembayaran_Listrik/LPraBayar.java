package Sistem_Pembayaran_Listrik;
import java.util.Scanner;

public class LPraBayar extends BasePin {
    private float NomToken;
    private String StroomToken;

    LPraBayar(String NoRef, float NomToken, String StroomToken){
        super(NoRef); // Mengambil constructor induk
        this.NomToken = NomToken; 
        this.StroomToken = StroomToken;
    }

    LPraBayar(){
        super(); // Memanggil constructor kosong induk
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nomor token : ");
        this.NomToken = input.nextFloat();
        input.nextLine();
        System.out.print("Masukkan stroom token : ");
        this.StroomToken = input.nextLine();
    }

    public float getNomToken() { return NomToken; }                      // Getter NomToken
    public void setNomToken(float nomToken) { NomToken = nomToken; }    // Setter NomToken
    public String getStroomToken() { return StroomToken; }              // Getter StroomToken
    public void setStroomToken(String stroomToken) { StroomToken = stroomToken; } // Setter StroomToken

    @Override
    void info(){
        System.out.println("Jenis tagihan anda adalah Prabayar"); // Implementasi abstract method
    }
}