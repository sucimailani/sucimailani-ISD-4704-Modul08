import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Mahasiswa {
    private String nim;
    private String kelas;
    private String nama;
    private ArrayList<Integer> nilai;

    public Mahasiswa(String nim, String kelas, String nama) {
        this.nim = nim;
        this.kelas = kelas;
        this.nama = nama;
        this.nilai = new ArrayList<Integer>();
    }

    public String getNim() {
        return nim;
    }

    public String getKelas() {
        return kelas;
    }

    public String getNama() {
        return nama;
    }

    public void tambahNilai(int nilai) {
        this.nilai.add(nilai);
    }

    public ArrayList<Integer> getNilai() {
        return nilai;
    }

    public double hitungRataRata() {
        if (nilai.size() == 0) return 0;
        int total = 0;
        for (int nilai : nilai) {
            total += nilai;
        }
        return (double) total / nilai.size();
    }

    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama + ", Kelas: " + kelas + ", Nilai: " + nilai.toString() + ", Rata-rata: " + hitungRataRata();
    }
}

class DataMahasiswa {
    private Map<String, Mahasiswa> dataMahasiswa;

    public DataMahasiswa() {
        dataMahasiswa = new HashMap<String, Mahasiswa>();
    }

    public void tambahMahasiswa(String nim, String kelas, String nama) {
        Mahasiswa mahasiswa = new Mahasiswa(nim, kelas, nama);
        dataMahasiswa.put(nim, mahasiswa);
    }

    public void hapusMahasiswa(String nim) {
        if (dataMahasiswa.containsKey(nim)) {
            dataMahasiswa.remove(nim);
            System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    public void tambahNilaiMahasiswa(String nim, int nilai) {
        if (dataMahasiswa.containsKey(nim)) {
            dataMahasiswa.get(nim).tambahNilai(nilai);
            System.out.println("Nilai " + nilai + " berhasil ditambahkan untuk mahasiswa dengan NIM " + nim + ".");
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    public void tampilkanSemuaNilai() {
        System.out.println("Data Nilai Mahasiswa:");
        for (Mahasiswa mahasiswa : dataMahasiswa.values()) {
            System.out.println(mahasiswa.toString());
        }
    }
}

public class jurnal08 {
    public static void main(String[] args) {
        DataMahasiswa dataMahasiswa = new DataMahasiswa();

        dataMahasiswa.tambahMahasiswa("12345", "A", "John Doe");
        dataMahasiswa.tambahNilaiMahasiswa("12345", 85);
        dataMahasiswa.tambahNilaiMahasiswa("12345", 90);

        dataMahasiswa.tambahMahasiswa("67890", "B", "Jane Smith");
        dataMahasiswa.tambahNilaiMahasiswa("67890", 75);
        dataMahasiswa.tambahNilaiMahasiswa("67890", 80);
        dataMahasiswa.tambahNilaiMahasiswa("67890", 85);

        dataMahasiswa.tampilkanSemuaNilai();
    }
}
