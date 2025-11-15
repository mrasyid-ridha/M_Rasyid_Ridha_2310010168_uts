package controller;

import java.util.ArrayList;
import javax.swing.JTextArea;
import model.Resep;

public class ResepController {

    private final ArrayList<Resep> daftarResep = new ArrayList<>();
    private final JTextArea txtDaftar;

    public ResepController(JTextArea txtDaftar) {
        this.txtDaftar = txtDaftar;
    }

    public void tambahResep(String nama, String bahan, String langkah) {
        if (nama.isEmpty()) return;
        daftarResep.add(new Resep(nama, bahan, langkah));
        tampilkanResep();
    }

    public void ubahResep(int index, String nama, String bahan, String langkah) {
        if (index >= 0 && index < daftarResep.size()) {
            Resep resep = daftarResep.get(index);
            resep.setNama(nama);
            resep.setBahan(bahan);
            resep.setLangkah(langkah);
            tampilkanResep();
        }
    }

    public void hapusResep(int index) {
        if (index >= 0 && index < daftarResep.size()) {
            daftarResep.remove(index);
            tampilkanResep();
        }
    }

    public void tampilkanResep() {
        txtDaftar.setText("");
        int i = 1;
        for (Resep resep : daftarResep) {
            txtDaftar.append(i + ". " + resep.getNama() + "\n");
            txtDaftar.append("Bahan: " + resep.getBahan() + "\n");
            txtDaftar.append("Langkah: " + resep.getLangkah() + "\n\n");
            i++;
        }
    }
}
