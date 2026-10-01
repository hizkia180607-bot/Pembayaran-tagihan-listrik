package Sistem_Pembayaran_Listrik;
import java.util.Scanner;


public class Kredit extends MetodeBayar{
    private String DurasiPembayaran;

    Kredit(String NoInvoice, String NamaBank, String NoRekening, String NoTelp, String DurasiPembayaran){
        super(NoInvoice, NamaBank, NoRekening, NoTelp);
        this.DurasiPembayaran = DurasiPembayaran; // constructor class kredit
    }

    Kredit(){
        super(); //constructor kosong induk
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan durasi pembayaran : ");
        this.DurasiPembayaran = input.nextLine();
    }

    public String getDurasiPembayaran() {
        return DurasiPembayaran;
    }
    public void setDurasiPembayaran(String durasiPembayaran) {
        DurasiPembayaran = durasiPembayaran;
    }

    @Override
    void validation(Boolean validate){
        if (validate){
            System.out.println("Pembayaran menggunakan kredit berhasil divalidasi.");
        }//validasi berhasil
        else{
            return; // validasi batal
        }
    }


}
