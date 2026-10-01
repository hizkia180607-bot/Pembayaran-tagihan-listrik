import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Sistem_Pembayaran_Listrik.*;

public class App {

    public static void BacaRiwayat() {
        System.out.println("--- RIWAYAT TRANSAKSI SEBELUMNYA ---");
        try {
            File myObj = new File("struk_asli/struk.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Belum ada riwayat transaksi.");
        }
        System.out.println("------------------------------------\n");
    }
    public static void main(String[] args) throws Exception {
        BacaRiwayat();
        Pembayaran pembayaran = new Pembayaran();
        pembayaran.struk();
    }
}
