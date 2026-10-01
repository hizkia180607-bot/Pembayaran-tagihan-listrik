package Sistem_Pembayaran_Listrik;
import java.util.Scanner;

public class LPascaBayar extends BasePin {
    private String TarifDaya;
    private float Tagihan;

    LPascaBayar(String NoRef, String TarifDaya, float Tagihan){
        super(NoRef); // Mengambil constructor induk
        this.TarifDaya = TarifDaya;
        this.Tagihan = Tagihan;
    }

    LPascaBayar(){
        super(); // Memanggil constructor kosong induk
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan tarif daya : ");
        this.TarifDaya = input.nextLine();
        System.out.print("Masukkan tagihan : ");
        this.Tagihan = input.nextFloat();
    }

    public String getTarifDaya() { return TarifDaya; }                  
    public void setTarifDaya(String tarifDaya) { TarifDaya = tarifDaya; } 
    public float getTagihan() { return Tagihan; }                      
    public void setTagihan(float tagihan) { Tagihan = tagihan; }       

    @Override
    void info(){
        System.out.println("Jenis tagihan anda adalah Pascabayar"); // Implementasi abstract method
    }
}