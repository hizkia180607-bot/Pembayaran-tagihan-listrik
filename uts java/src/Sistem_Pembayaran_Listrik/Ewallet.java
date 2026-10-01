package Sistem_Pembayaran_Listrik;
import java.util.Scanner;

public class Ewallet extends MetodeBayar{
    private String Email;

    Ewallet(String NoInvoice, String NamaBank, String NoRekening, String NoTelp, String Email){
        super(NoInvoice, NamaBank, NoRekening, NoTelp);
        this.Email = Email; // constructor dari Ewallet
    }

    Ewallet(){
        super();// constructor kosong induk
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan email anda : ");
        this.Email = input.nextLine(); //meminta input email
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    @Override
    void validation(Boolean validate){
        if (validate){
            System.out.println("Pembayaran menggunakan Ewallet berhasil divalidasi.");
        }//validasi berhasil
        else{
            return;//validasi batal
        }
    }
    
}
