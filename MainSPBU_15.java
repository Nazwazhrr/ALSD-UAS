import java.util.Scanner;

public class MainSPBU_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianLinkedList_15 antrian = new AntrianLinkedList_15();
        double totalPendapatan = 0;
        QueueTransaksi_15 riwayat = new QueueTransaksi_15(100);

        int pilihan = -1; 
        do {
            System.out.println("\n--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("6. Lihat Total Pendapatan SPBU");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");

            String inputMenu = sc.nextLine();
            if (inputMenu.equals("0") || inputMenu.equals("1") || inputMenu.equals("2") ||
                inputMenu.equals("3") || inputMenu.equals("4") || inputMenu.equals("5")
                || inputMenu.equals("6")) {
                pilihan = Integer.parseInt(inputMenu); 
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka 0-6.");
                continue; 
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor: ");
                    String platNomor = sc.nextLine();
                    System.out.print("Masukkan Jenis Kendaraan: ");
                    String tipe = sc.nextLine();
                    System.out.print("Masukkan Merk: ");
                    String merk = sc.nextLine();
                    antrian.tambahAntrian(new Kendaraan_15(platNomor, tipe, merk));
                    break;
                case 2:
                    antrian.tampilkanAntrian();
                    break;
                case 3:
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + antrian.jumlahAntrian());
                    break;
                case 4:
                    Kendaraan_15 dilayani = antrian.layaniKendaraan();
                    if (dilayani != null) {
                        System.out.println("Petugas melayani " + dilayani.platNomor);
                        System.out.print("Masukkan Jenis BBM: ");
                        String namaBBM = sc.nextLine();
                        System.out.print("Masukkan Harga per liter: ");
                        double harga = sc.nextDouble();
                        System.out.print("Masukkan Jumlah liter: ");
                        double liter = sc.nextDouble();
                        sc.nextLine(); 
                        BBM_15 bbm = new BBM_15(namaBBM, harga);
                        TransaksiPengisian_15 t = new TransaksiPengisian_15(dilayani, bbm, liter);
                        riwayat.enqueue(t);
                        System.out.println(">> Transaksi berhasil dicatat.");

                        double total = harga * liter;
                        totalPendapatan += total;
                        System.out.printf(">> Total transaksi Rp%.2f\n", total);
                    
                    }
                    break;
                case 5:
                    riwayat.tampilkanTransaksi();
                    break;
                case 6:
                System.out.printf(">> Total pendapatan dari transaksi: Rp%.2f\n", totalPendapatan);
                break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);
    }
}
