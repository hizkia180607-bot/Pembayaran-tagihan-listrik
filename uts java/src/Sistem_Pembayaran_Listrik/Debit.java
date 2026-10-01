package Sistem_Pembayaran_Listrik;
import java.util.Scanner;

public class Debit extends MetodeBayar{
    private String JenisKartu;

    Debit(String NoInvoice, String NamaBank, String NoRekening, String NoTelp, String JenisKartu){
        super(NoInvoice, NamaBank, NoRekening, NoTelp);
        this.JenisKartu = JenisKartu; // constructor 
    }

    Debit(){
        super();// memanggil constructor induk
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jenis kartu : "); // minta input jenis kartu
        this.JenisKartu = input.nextLine();
    }

    public String getJenisKartu() {
        return JenisKartu;
    }
    public void setJenisKartu(String jenisKartu) {
        JenisKartu = jenisKartu;
    }

    @Override
    void validation(Boolean validate){
        if (validate){
            System.out.println("Pembayaran menggunakan debit berhasil divalidasi."); // validasi berhasil
        }
        else{
            return;
        }// validasi betal
    }

}
