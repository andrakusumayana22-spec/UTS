// Class induk
class Kendaraan {
    private String merk;
    private String model;
    private String nomorPlat;
    private int hargaSewa;

    // Constructor
    Kendaraan(String merk, String model, String nomorPlat, int hargaSewa) {
        this.merk = merk;
        this.model = model;
        this.nomorPlat = nomorPlat;
        this.hargaSewa = hargaSewa;
    }

    // Getter untuk membaca merk
    String getMerk() {
        return merk;
    }

    // Getter untuk membaca model
    String getModel() {
        return model;
    }

    // Setter untuk mengubah harga sewa
    void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    // Method untuk menampilkan informasi kendaraan
    void tampilkanInfo() {
        System.out.println("Merk        : " + merk);
        System.out.println("Model       : " + model);
        System.out.println("Nomor Plat  : " + nomorPlat);
        System.out.println("Harga Sewa  : Rp" + hargaSewa + " / hari");
    }

    // Overloading
    void tampilkanInfo(String tambahan) {
        tampilkanInfo();
        System.out.println("Catatan     : " + tambahan);
    }

    // Method yang akan di-override
    void tampilkanKarakteristik() {
        System.out.println("Kendaraan ini dapat disewa.");
    }
}


// Class turunan Mobil
class Mobil extends Kendaraan {

    // Constructor
    Mobil(String merk, String model, String nomorPlat, int hargaSewa) {
        super(merk, model, nomorPlat, hargaSewa);
    }

    // Overriding
    @Override
    void tampilkanKarakteristik() {
        System.out.println("Mobil cocok digunakan untuk perjalanan bersama.");
    }
}


// Class turunan Motor
class Motor extends Kendaraan {

    // Constructor
    Motor(String merk, String model, String nomorPlat, int hargaSewa) {
        super(merk, model, nomorPlat, hargaSewa);
    }

    // Overriding
    @Override
    void tampilkanKarakteristik() {
        System.out.println("Motor cocok digunakan untuk perjalanan yang praktis.");
    }
}


// Class Pelanggan
class Pelanggan {
    private String nama;
    private String noHp;

    // Constructor
    Pelanggan(String nama, String noHp) {
        this.nama = nama;
        this.noHp = noHp;
    }

    // Method untuk menampilkan data pelanggan
    void tampilkanData() {
        System.out.println("Nama        : " + nama);
        System.out.println("No. HP      : " + noHp);
    }

    // Method untuk menyewa kendaraan
    void sewa(Kendaraan kendaraan) {
        System.out.println(
            nama + " menyewa " +
            kendaraan.getMerk() + " " +
            kendaraan.getModel()
        );
    }
}


// Class utama
public class Main {
    public static void main(String[] args) {

        // Membuat objek Mobil
        Mobil mobil = new Mobil(
            "Toyota",
            "Avanza",
            "DK 1234 AB",
            350000
        );

        // Membuat objek Motor
        Motor motor = new Motor(
            "Honda",
            "Scoopy",
            "DK 5678 CD",
            100000
        );

        // Membuat objek Pelanggan
        Pelanggan pelanggan = new Pelanggan(
            "Budi",
            "081234567890"
        );


        System.out.println("=== DATA PELANGGAN ===");
        pelanggan.tampilkanData();


        System.out.println("\n=== INFO MOBIL ===");
        mobil.tampilkanInfo();


        System.out.println("\n=== INFO MOTOR ===");
        motor.tampilkanInfo("Helm disediakan");


        System.out.println("\n=== OVERRIDING ===");
        mobil.tampilkanKarakteristik();
        motor.tampilkanKarakteristik();


        System.out.println("\n=== ENCAPSULATION ===");
        System.out.println("Merk mobil (getter): " + mobil.getMerk());

        motor.setHargaSewa(120000);

        System.out.println("Harga motor setelah diubah:");
        motor.tampilkanInfo();


        System.out.println("\n=== PELANGGAN MENYEWA ===");
        pelanggan.sewa(mobil);
        pelanggan.sewa(motor);
    }
}