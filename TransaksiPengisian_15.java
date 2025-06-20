public class TransaksiPengisian_15{
    Kendaraan_15 kendaraan;
    BBM_15 bbm;
    double liter;
    double totalBayar;

    public TransaksiPengisian_15(Kendaraan_15 kendaraan, BBM_15 bbm, double liter) {
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.liter = liter;
        this.totalBayar = bbm.hargaPerLiter * liter;
    }
}
  