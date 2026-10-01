package Sistem_Pembayaran_Listrik;
import java.util.Scanner;

public abstract class MetodeBayar {
    private String NoInvoice, NamaBank, NoRekening, NoTelp;

    MetodeBayar(String NoInvoice, String NamaBank, String NoRekening, String NoTelp){
        this.NoInvoice = NoInvoice;
        this.NamaBank = NamaBank;
        this.NoRekening = NoRekening;
        this.NoTelp = NoTelp;
    }

    MetodeBayar(){
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Nomor Invoice: ");
        this.NoInvoice = input.nextLine();

        System.out.print("Masukkan Nama Bank: ");
        this.NamaBank = input.nextLine();

        System.out.print("Masukkan Nomor Rekening: ");
        this.NoRekening = input.nextLine();

        System.out.print("Masukkan Nomor Telepon: ");
        this.NoTelp = input.nextLine();
    }

    public String getNoInvoice() {
        return NoInvoice;
    }
    public void setNoInvoice(String noInvoice) {
        NoInvoice = noInvoice;
    }
    public String getNamaBank() {
        return NamaBank;
    }
    public void setNamaBank(String namaBank) {
        NamaBank = namaBank;
    }
    public String getNoRekening() {
        return NoRekening;
    }
    public void setNoRekening(String noRekening) {
        NoRekening = noRekening;
    }
    public String getNoTelp() {
        return NoTelp;
    }
    public void setNoTelp(String noTelp) {
        NoTelp = noTelp;
    }

    abstract void validation(Boolean validate); // Abstract method validasi

}
