public class QueueTransaksi_15 {
    TransaksiPengisian_15[] data;
    int front, rear, size, capacity;

    public QueueTransaksi_15(int capacity) {
        this.capacity = capacity;
        data = new TransaksiPengisian_15[capacity];
        front = rear = size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(TransaksiPengisian_15 datatransaksi) {
        if (isFull()) {
            System.out.println("Queue transaksi penuh!");
            return;
        }
        data[rear] = datatransaksi;
        rear = (rear + 1) % capacity;
        size++;
    }

    public void tampilkanTransaksi() {
        if (isEmpty()) {
            System.out.println("Tidak ada transaksi.");
            return;
        }

        System.out.println("-- Riwayat Transaksi --");
        int idx = front;

        for (int i = 0; i < size; i++) {
            TransaksiPengisian_15 datatransaksi = data[idx];
            System.out.println("Plat : " + datatransaksi.kendaraan.platNomor);
            System.out.println("Tipe : " + datatransaksi.kendaraan.tipe);
            System.out.println("Merk : " + datatransaksi.kendaraan.merk);

            double total = datatransaksi.totalBayar;
            double diskon = 0;
            if (datatransaksi.liter >= 20) {
                diskon = total * 0.05;
            }
            double totalSetelahDiskon = total - diskon;

            System.out.println("BBM  : " + datatransaksi.bbm.namBBM);
            System.out.println("Liter: " + datatransaksi.liter);
            System.out.printf("Total Sebelum Diskon : Rp%.2f\n", total);
            if (diskon > 0) {
                System.out.printf("Diskon 5%%             : Rp%.2f\n", diskon);
            }
            System.out.printf("Total Setelah Diskon  : Rp%.2f\n", totalSetelahDiskon);
            System.out.println("----------------------------------------");

            idx = (idx + 1) % capacity;
        }
    }
}
