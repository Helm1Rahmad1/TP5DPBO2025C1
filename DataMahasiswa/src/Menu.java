import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {
    public static void main(String[] args) {
        // buat object window
        Menu window = new Menu();

        // atur ukuran window
        window.setSize(480, 560);

        // letakkan window di tengah layar
        window.setLocationRelativeTo(null);
        // isi window
        window.setContentPane(window.mainPanel);
        // ubah warna background
        window.getContentPane().setBackground(Color.white);

        // tampilkan window
        window.setVisible(true);

        // agar program ikut berhenti saat window diclose
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // index baris yang diklik
    private int selectedIndex = -1;
    // list untuk menampung semua mahasiswa
    private ArrayList<Mahasiswa> listMahasiswa;

    private Database database;

    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox<String> jenisKelaminComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JLabel tempatTinggalLabel;
    private JRadioButton anakKostRadioButton;
    private JRadioButton PPRadioButton;
    private JRadioButton asramaRadioButton;
    private ButtonGroup tempatTinggalGroup;

    // constructor
    public Menu() {
        // inisialisasi listMahasiswa
        listMahasiswa = new ArrayList<>();

        database = new Database();

        // inisialisasi button group untuk radio button
        tempatTinggalGroup = new ButtonGroup();
        tempatTinggalGroup.add(anakKostRadioButton);
        tempatTinggalGroup.add(PPRadioButton);
        tempatTinggalGroup.add(asramaRadioButton);

        // set default selected radio button
        anakKostRadioButton.setSelected(true);

        // isi tabel mahasiswa
        mahasiswaTable.setModel(setTable());

        // ubah styling title
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        // atur isi combo box
        String[] jenisKelaminData = {"", "Laki-laki", "Perempuan"};
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel<>(jenisKelaminData));

        // sembunyikan button delete
        deleteButton.setVisible(false);

        // saat tombol add/update ditekan
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1) {
                    insertData();
                } else {
                    updateData();
                }
            }
        });

        // saat tombol delete ditekan
        deleteButton.addActionListener(e -> {
            deleteData();
        });

        // saat tombol cancel ditekan
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        // saat salah satu baris tabel ditekan
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // ubah selectedIndex menjadi baris tabel yang diklik
                selectedIndex = mahasiswaTable.getSelectedRow();

                // simpan value textfield dan combo box
                String selectedNim = mahasiswaTable.getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getValueAt(selectedIndex, 2).toString();
                String selectedJenisKelamin = mahasiswaTable.getValueAt(selectedIndex, 3).toString();
                String tempatTinggal = mahasiswaTable.getValueAt(selectedIndex, 4).toString();

                // ubah isi textfield dan combo box
                nimField.setText(selectedNim);
                namaField.setText(selectedNama);
                jenisKelaminComboBox.setSelectedItem(selectedJenisKelamin);

                // set radio button sesuai dengan tempatTinggal
                if (tempatTinggal.equals("Anak Kost")) {
                    anakKostRadioButton.setSelected(true);
                } else if (tempatTinggal.equals("PP (Pulang Pergi)")) {
                    PPRadioButton.setSelected(true);
                } else if (tempatTinggal.equals("Asrama")) {
                    asramaRadioButton.setSelected(true);
                }

                // ubah button "Add" menjadi "Update"
                addUpdateButton.setText("Update");
                // tampilkan button delete
                deleteButton.setVisible(true);
            }
        });
    }

    // Fungsi untuk mendapatkan tempat tinggal yang dipilih dari radio button
    private String getSelectedTempatTinggal() {
        if (anakKostRadioButton.isSelected()) {
            return "Anak Kost";
        } else if (PPRadioButton.isSelected()) {
            return "PP (Pulang Pergi)";
        } else if (asramaRadioButton.isSelected()) {
            return "Asrama";
        }
        return "Anak Kost"; // default
    }

    public final DefaultTableModel setTable() {
        // tentukan kolom tabel
        Object[] column = {"No", "NIM", "Nama", "Jenis Kelamin", "Tempat Tinggal"};

        // buat objek tabel dengan kolom yang sudah dibuat
        DefaultTableModel temp = new DefaultTableModel(null, column);

        try {
            ResultSet resultSet = database.selectQuery("SELECT * FROM mahasiswa");

            int i = 0;
            while (resultSet.next()) {
                Object[] row = new Object[5];

                row[0] = i + 1;
                row[1] = resultSet.getString("nim");
                row[2] = resultSet.getString("nama");
                row[3] = resultSet.getString("jenis_kelamin");
                row[4] = resultSet.getString("tempat_tinggal");

                temp.addRow(row);
                i++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error mengambil data: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        return temp;
    }

    public void insertData() {
        // ambil value dari textfield dan combobox
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenis_kelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String tempat_tinggal = getSelectedTempatTinggal();

        // Validasi input
        if (nim.isEmpty() || nama.isEmpty() || jenis_kelamin.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Data tidak lengkap!\n" +
                            "Harap lengkapi semua kolom:\n" +
                            "- NIM\n" +
                            "- Nama\n" +
                            "- Jenis Kelamin",
                    "Kesalahan Pengisian", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Cek apakah NIM sudah ada di database
        try {
            ResultSet rs = database.selectQuery("SELECT * FROM mahasiswa WHERE nim = '" + nim + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(null,
                        "NIM sudah terdaftar!\n" +
                                "Mahasiswa dengan NIM " + nim + " sudah ada dalam database.\n" +
                                "Silakan gunakan NIM yang berbeda.",
                        "NIM Duplikat", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal memeriksa ketersediaan NIM.\n" +
                            "Terjadi kesalahan pada sistem database.\n" +
                            "Detail error: " + e.getMessage(),
                    "Kesalahan Sistem", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insert data ke database
        String sql = "INSERT INTO mahasiswa (nim, nama, jenis_kelamin, tempat_tinggal) " +
                "VALUES ('" + nim + "', '" + nama + "', '" +
                jenis_kelamin + "', '" + tempat_tinggal + "')";

        database.insertUpdateDeleteQuery(sql);

        // Refresh tabel
        mahasiswaTable.setModel(setTable());

        // Bersihkan form
        clearForm();

        // Feedback
        JOptionPane.showMessageDialog(null,
                "Data mahasiswa berhasil ditambahkan!\n" +
                        "NIM: " + nim + "\n" +
                        "Nama: " + nama,
                "Berhasil Ditambahkan", JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateData() {
        // ambil data dari form
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenis_kelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String tempat_tinggal = getSelectedTempatTinggal();

        // Validasi input
        if (nim.isEmpty() || nama.isEmpty() || jenis_kelamin.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Data tidak lengkap!\n" +
                            "Harap lengkapi semua kolom:\n" +
                            "- NIM\n" +
                            "- Nama\n" +
                            "- Jenis Kelamin",
                    "Kesalahan Pengisian", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Cek apakah NIM sudah digunakan oleh mahasiswa lain
        try {
            String currentNim = mahasiswaTable.getValueAt(selectedIndex, 1).toString();
            ResultSet rs = database.selectQuery("SELECT * FROM mahasiswa WHERE nim = '" + nim + "'");

            if (rs.next() && !nim.equals(currentNim)) {
                JOptionPane.showMessageDialog(null,
                        "NIM sudah digunakan oleh mahasiswa lain!\n" +
                                "NIM " + nim + " telah terdaftar untuk mahasiswa berbeda.\n" +
                                "Silakan gunakan NIM yang unik.",
                        "Konflik NIM", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal memperbarui data mahasiswa.\n" +
                            "Terjadi kesalahan pada sistem database.\n" +
                            "Detail error: " + e.getMessage(),
                    "Kesalahan Sistem", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update data di database
        String sql = "UPDATE mahasiswa SET nim = '" + nim + "', " +
                "nama = '" + nama + "', " +
                "jenis_kelamin = '" + jenis_kelamin + "', " +
                "tempat_tinggal = '" + tempat_tinggal + "' " +
                "WHERE nim = '" + mahasiswaTable.getValueAt(selectedIndex, 1) + "'";

        database.insertUpdateDeleteQuery(sql);

        // Refresh tabel
        mahasiswaTable.setModel(setTable());

        // Bersihkan form
        clearForm();

        // Feedback
        JOptionPane.showMessageDialog(null,
                "Data mahasiswa berhasil diperbarui!\n" +
                        "NIM: " + nim + "\n" +
                        "Nama: " + nama,
                "Berhasil Diperbarui", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deleteData() {
        if (selectedIndex != -1) {
            String nim = mahasiswaTable.getValueAt(selectedIndex, 1).toString();

            // Konfirmasi sebelum menghapus
            int response = JOptionPane.showConfirmDialog(this,
                    "Apakah Anda yakin ingin menghapus data ini?",
                    "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                // Hapus data dari database
                String sql = "DELETE FROM mahasiswa WHERE nim = '" + nim + "'";
                database.insertUpdateDeleteQuery(sql);

                // Refresh tabel
                mahasiswaTable.setModel(setTable());

                // Bersihkan form
                clearForm();

                // Feedback
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!",
                        "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void clearForm() {
        // kosongkan semua texfield dan combo box
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedItem("");
        anakKostRadioButton.setSelected(true);

        // ubah button "Update" menjadi "Add"
        addUpdateButton.setText("Add");

        // sembunyikan button delete
        deleteButton.setVisible(false);

        // ubah selectedIndex menjadi -1 (tidak ada baris yang dipilih)
        selectedIndex = -1;
    }
}