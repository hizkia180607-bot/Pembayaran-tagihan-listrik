package Sistem_Pembayaran_Listrik;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Pembayaran implements Cetak {
    private String Nama, IdPel, TglTrans;
    private float BiayaAdm, Nominal;
    private MetodeBayar Metode;
    private BasePin BasePin;

    public Pembayaran(String Nama, float Nominal, String IdPel, String TglTrans, float BiayaAdm, MetodeBayar Metode,
            BasePin BasePin) {
        this.Nama = Nama;
        this.Nominal = Nominal;
        this.IdPel = IdPel;
        this.TglTrans = TglTrans;
        this.BiayaAdm = BiayaAdm;
        this.Metode = Metode;
        this.BasePin = BasePin;
    } //constructor

    Pembayaran() {

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama anda : ");
        this.Nama = input.nextLine(); // input nama

        System.out.print("Masukkan nominal transaksi anda  : ");
        this.Nominal = input.nextFloat(); // input nominal transaksi

        input.nextLine();

        System.out.print("Masukkan ID Pelanggan: ");
        this.IdPel = input.nextLine();// input id pelanggan

        System.out.print("Masukkan Tanggal Transaksi: ");
        this.TglTrans = input.nextLine();// input tanggal transaksi

        System.out.println("Masukkan jenis tagihan yang ingin dibayar : ");
        System.out.println("1. PraBayar ");
        System.out.println("2. PascaBayar ");
        System.out.println("3. NonTaglis ");
        int pilihan = input.nextInt();// menginput pilihan BasePin
        input.nextLine();
        if (pilihan == 1) { //pilihan 1
            LPraBayar jenis = new LPraBayar();
            jenis.info();
            this.BasePin = jenis;//pilihan 2
        } else if (pilihan == 2) {
            LPascaBayar jenis = new LPascaBayar();
            jenis.info();
            this.BasePin = jenis;
        } else if (pilihan == 3) {//pilihan 3
            LNonTaglis jenis = new LNonTaglis();
            jenis.info();
            this.BasePin = jenis;
        } else {
            System.out.println("pilihan tidak valid");
        }

        System.out.println("Pilih metode bayar yang ingin anda gunakan : ");
        System.out.println("1. Debit ");
        System.out.println("2. Kredit ");
        System.out.println("3. Ewallet ");
        int pilihan2 = input.nextInt();// input pilihan metode bayar
        input.nextLine();
        if (pilihan2 == 1) {
            Debit metode = new Debit();
            System.out.println("Apakah anda ingin menggunakan debit sebagai metode pembayaran? ");
            System.out.println("0. Setuju ");
            System.out.println("1. Batal");
            int validasi = input.nextInt();
            input.nextLine();
            if (validasi == 0) {
                metode.validation(true);
            } else {
                metode.validation(false);
            }
            this.Metode = metode;
            this.BiayaAdm = 2500;
        } else if (pilihan2 == 2) {
            Kredit metode = new Kredit();
            System.out.println("Apakah anda ingin menggunakan kredit sebagai metode pembayaran? ");
            System.out.println("0. Setuju ");
            System.out.println("1. Batal");
            int validasi = input.nextInt();
            input.nextLine();
            if (validasi == 0) {
                metode.validation(true);
            } else {
                metode.validation(false);
            }
            this.Metode = metode;
            this.BiayaAdm = 4000;
        } else if (pilihan2 == 3) {
            Ewallet metode = new Ewallet();
            System.out.println("Apakah anda ingin menggunakan Ewallet sebagai metode pembayaran? ");
            System.out.println("0. Setuju ");
            System.out.println("1. Batal");
            int validasi = input.nextInt();
            input.nextLine();
            if (validasi == 0) {
                metode.validation(true);
            } else {
                metode.validation(false);
            }
            this.Metode = metode;
            this.BiayaAdm = 2000;
        } else {
            System.out.println("pilihan tidak valid");
        }
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public float getNominal() {
        return Nominal;
    }

    public void setNominal(float nominal) {
        Nominal = nominal;
    }

    public String getIdPel() {
        return IdPel;
    }

    public void setIdPel(String idPel) {
        IdPel = idPel;
    }

    public String getTglTrans() {
        return TglTrans;
    }

    public void setTglTrans(String tglTrans) {
        TglTrans = tglTrans;
    }

    public float getBiayaAdm() {
        return BiayaAdm;
    }

    public void setBiayaAdm(float biayaAdm) {
        BiayaAdm = biayaAdm;
    }

    public MetodeBayar getMetode() {
        return Metode;
    }

    public void setMetode(MetodeBayar metode) {
        Metode = metode;
    }

    public BasePin getBasePin() {
        return BasePin;
    }

    public void setBasePin(BasePin basePin) {
        BasePin = basePin;
    }

    public float hitungTotal() {
        return this.Nominal + this.BiayaAdm;
    }

    @Override
    public void struk() throws Exception {

        if (this.BasePin == null) {
            System.out.println("Gagal mencetak struk: Jenis tagihan belum ditentukan.");
            return;
        }

        // Sinkronisasi nominal transaksi
        if (this.BasePin instanceof LPascaBayar) {

            LPascaBayar pasca = (LPascaBayar) this.BasePin;

            if (this.Nominal <= 0 && pasca.getTagihan() > 0) {
                this.Nominal = pasca.getTagihan();
            } else if (pasca.getTagihan() <= 0 && this.Nominal > 0) {
                pasca.setTagihan(this.Nominal);
            }

        } else if (this.BasePin instanceof LPraBayar) {

            LPraBayar pra = (LPraBayar) this.BasePin;

            if (this.Nominal <= 0 && pra.getNomToken() > 0) {
                this.Nominal = pra.getNomToken();
            } else if (pra.getNomToken() <= 0 && this.Nominal > 0) {
                pra.setNomToken(this.Nominal);
            }

        } else if (this.BasePin instanceof LNonTaglis) {

            LNonTaglis nonTaglis = (LNonTaglis) this.BasePin;

            if (this.Nominal <= 0 && nonTaglis.getBiayaLayanan() > 0) {
                this.Nominal = nonTaglis.getBiayaLayanan();
            } else if (nonTaglis.getBiayaLayanan() <= 0 && this.Nominal > 0) {
                nonTaglis.setBiayaLayanan(this.Nominal);
            }
        }

        float totalPembayaran = hitungTotal();

        String noInvoice = "-";
        String tglTrans = "-";
        String idPel = "-";
        String nama = "-";
        String noRef = "-";
        String metodeBayarStr = "-";

        if (this.Metode != null) {
            if (this.Metode.getNoInvoice() != null) {
                noInvoice = this.Metode.getNoInvoice();
            }

            if (this.Metode instanceof Kredit) {
                metodeBayarStr = "Kartu Kredit";
            } else if (this.Metode instanceof Debit) {
                metodeBayarStr = "Debit";
            } else if (this.Metode instanceof Ewallet) {
                metodeBayarStr = "Ewallet";
            }
        }

        if (this.TglTrans != null) {
            tglTrans = this.TglTrans;
        }

        if (this.IdPel != null) {
            idPel = this.IdPel;
        }

        if (this.Nama != null) {
            nama = this.Nama;
        }

        if (this.BasePin.getNoRef() != null) {
            noRef = this.BasePin.getNoRef();
        }

        String content = "";

        // =========================================
        // PASCA BAYAR
        // =========================================
        if (this.BasePin instanceof LPascaBayar) {

            LPascaBayar pasca = (LPascaBayar) this.BasePin;

            String tarifDaya = "-";

            if (pasca.getTarifDaya() != null) {
                tarifDaya = pasca.getTarifDaya();
            }

            content = "==================================================\n"
                    + "             STRUK PEMBAYARAN LISTRIK\n"
                    + "==================================================\n\n"
                    + "Status Transaksi : TRANSAKSI BERHASIL\n\n"

                    + "No. Invoice      : " + noInvoice + "\n"
                    + "Tanggal Transaksi: " + tglTrans + "\n"
                    + "Kategori Produk  : Listrik PLN\n\n"

                    + "--------------------------------------------------\n"
                    + "DETAIL PRODUK\n"
                    + "--------------------------------------------------\n\n"

                    + "Jenis Layanan    : Tagihan Listrik\n"
                    + "IDPEL            : " + idPel + "\n"
                    + "Nama             : " + nama + "\n"
                    + "Tarif/Daya       : " + tarifDaya + "\n"
                    + "Tagihan          : Rp" + this.Nominal + "\n"
                    + "No Ref           : " + noRef + "\n\n"

                    + "--------------------------------------------------\n"
                    + "RINCIAN PEMBAYARAN\n"
                    + "--------------------------------------------------\n\n"

                    + "Biaya Admin      : Rp" + this.BiayaAdm + "\n"
                    + "Metode Pembayaran: " + metodeBayarStr + "\n"
                    + "Total Pembayaran : Rp" + totalPembayaran + "\n"

                    + "==================================================\n";
        }

        // =========================================
        // PRA BAYAR
        // =========================================
        else if (this.BasePin instanceof LPraBayar) {

            LPraBayar pra = (LPraBayar) this.BasePin;

            String stroomToken = "-";

            if (pra.getStroomToken() != null) {
                stroomToken = pra.getStroomToken();
            }

            content = "==================================================\n"
                    + "             STRUK PEMBELIAN TOKEN\n"
                    + "==================================================\n\n"
                    + "Status Transaksi : TRANSAKSI BERHASIL\n\n"

                    + "No. Invoice      : " + noInvoice + "\n"
                    + "Tanggal Transaksi: " + tglTrans + "\n"
                    + "Kategori Produk  : Token Listrik\n\n"

                    + "--------------------------------------------------\n"
                    + "DETAIL PRODUK\n"
                    + "--------------------------------------------------\n\n"

                    + "Jenis Layanan    : Token Listrik\n"
                    + "IDPEL            : " + idPel + "\n"
                    + "Nama             : " + nama + "\n"
                    + "Nominal Token    : Rp" + this.Nominal + "\n"
                    + "Stroom Token     : " + stroomToken + "\n"
                    + "No Ref           : " + noRef + "\n\n"

                    + "--------------------------------------------------\n"
                    + "RINCIAN PEMBAYARAN\n"
                    + "--------------------------------------------------\n\n"

                    + "Biaya Admin      : Rp" + this.BiayaAdm + "\n"
                    + "Metode Pembayaran: " + metodeBayarStr + "\n"
                    + "Total Pembayaran : Rp" + totalPembayaran + "\n"

                    + "==================================================\n";
        }

        // =========================================
        // NON TAGLIS
        // =========================================
        else if (this.BasePin instanceof LNonTaglis) {

            LNonTaglis nonTaglis = (LNonTaglis) this.BasePin;

            String keterangan = "-";

            if (nonTaglis.getKeterangan() != null) {
                keterangan = nonTaglis.getKeterangan();
            }

            content = "==================================================\n"
                    + "             STRUK PEMBAYARAN\n"
                    + "==================================================\n\n"
                    + "Status Transaksi : TRANSAKSI BERHASIL\n\n"

                    + "No. Invoice      : " + noInvoice + "\n"
                    + "Tanggal Transaksi: " + tglTrans + "\n"
                    + "Kategori Produk  : Layanan PLN\n\n"

                    + "--------------------------------------------------\n"
                    + "DETAIL PRODUK\n"
                    + "--------------------------------------------------\n\n"

                    + "Jenis Layanan    : Layanan Non-Taglis\n"
                    + "IDPEL            : " + idPel + "\n"
                    + "Nama             : " + nama + "\n"
                    + "Keterangan       : " + keterangan + "\n"
                    + "Biaya Layanan    : Rp" + this.Nominal + "\n"
                    + "No Ref           : " + noRef + "\n\n"

                    + "--------------------------------------------------\n"
                    + "RINCIAN PEMBAYARAN\n"
                    + "--------------------------------------------------\n\n"

                    + "Biaya Admin      : Rp" + this.BiayaAdm + "\n"
                    + "Metode Pembayaran: " + metodeBayarStr + "\n"
                    + "Total Pembayaran : Rp" + totalPembayaran + "\n"

                    + "==================================================\n";
        }

        else {
            System.out.println("Gagal mencetak struk: Jenis tagihan tidak dikenali.");
            return;
        }

        // =========================================
        // SIMPAN KE FILE
        // =========================================

        System.out.println(file.getAbsolutePath());
        File file = new File("src/Sistem_Pembayaran_Listrik/struk_asli/struk.txt");

        if (new File("Sistem_Pembayaran_Listrik/struk_asli/struk.txt").exists()) {
            file = new File("Sistem_Pembayaran_Listrik/struk_asli/struk.txt");
        }

        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try (FileWriter fw = new FileWriter(file, true)) {

            if (file.length() > 0) {
                fw.write(System.lineSeparator());
                fw.write(System.lineSeparator());
            }

            fw.write(content);

            System.out.println(content);
            System.out.println("Struk berhasil ditambahkan ke " + file.getPath());

        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

}
