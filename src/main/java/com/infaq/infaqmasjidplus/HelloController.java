package com.infaq.infaqmasjidplus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton; // Tambahkan deklarasi tombol


    @FXML
    private void loginButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();


        if (username.equals("user") && password.equals("password")) {
            System.out.println("Login berhasil!");


            navigateToHomePage(event);
        } else {
            System.out.println("Login gagal. Coba lagi.");
        }
    }

    private void navigateToHomePage(ActionEvent event) {
        try {
            // Load FXML file for the home page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent homePage = loader.load();

            // Set up the new stage
            Stage stage = new Stage();
            stage.setTitle("Home Page");
            stage.setScene(new Scene(homePage));

            // Close the current stage (login stage)
            ((Stage) loginButton.getScene().getWindow()).close();

            // Show the new stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading home.fxml: " + e.getMessage());
        }
    }
    @FXML
    private Label saldoLabel;

    @FXML
    private Label saldoLabel1;
    @FXML
    private Label saldoLabel2;
    @FXML
    private Label saldoLabel3;
    @FXML
    private Label InvoiceLabel;
    @FXML
    private TextField topUpField;
    @FXML
    private Label topUpStatusLabel;
    private double saldo = 0.0;

    @FXML
    private void topUpButtonAction() {
        try {
            double topUpAmount = Double.parseDouble(topUpField.getText());
            saldo += topUpAmount;
            updateSaldoLabel();
            double saldoTopUpSuccess = topUpAmount;
            System.out.println("Saldo berhasil di-top up: " + topUpAmount);
            topUpStatusLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
            topUpStatusLabel.setText("Top-up berhasil");
        } catch (NumberFormatException e) {
            System.out.println("Masukkan jumlah top up yang valid.");
            // Tambahkan logika penanganan kesalahan input.
        }
    }

    private void updateSaldoLabel() {
        saldoLabel.setText("Saldo: " + saldo);
        saldoLabel1.setText("Saldo: " + saldo);
        saldoLabel2.setText("Saldo: " + saldo);
        saldoLabel3.setText("Saldo: " + saldo);

    }
    @FXML
    private TabPane tabPane;

    @FXML
    private Tab masjidTab;

    @FXML
    private Tab yatimTab;

    @FXML
    private Tab qurbanTab;

    @FXML
    private void tabButtonTab() {
        // Metode topUpButtonAction yang sudah ada
    }

    @FXML
    private void masjidButtonAction() {
        // Pilih tab "Masjid" saat tombol "Masjid" diklik
        tabPane.getSelectionModel().select(masjidTab);
    }

    @FXML
    private void yatimButtonAction() {
        // Metode yatimButtonAction yang sudah ada
        tabPane.getSelectionModel().select(yatimTab);
    }

    @FXML
    private void qurbanButtonAction() {
        // Metode qurbanButtonAction yang sudah ada
        tabPane.getSelectionModel().select(qurbanTab);

    }
    @FXML
    private Label infaqStatusLabel;

    @FXML
    private void tombolRp10000Action() {
        kurangiSaldoMasjid(10000);
    }

    @FXML
    private void tombolRp20000Action() {
        kurangiSaldoMasjid(20000);
    }

    @FXML
    private void tombolRp50000Action() {
        kurangiSaldoMasjid(50000);
    }

    @FXML
    private void tombolRp100000Action() {
        kurangiSaldoMasjid(100000);
    }

    private void kurangiSaldoMasjid(double jumlah_masjid) {
        if (saldo >= jumlah_masjid) {
            saldo -= jumlah_masjid;
            updateSaldoLabel();
            saldoLabel1.setText("Rp " + saldo); // Update label saldo pada tab Masjid
            infaqStatusLabel.setText("Infaq berhasil: Rp " + jumlah_masjid);
            System.out.println("Saldo Masjid berhasil dikurangi: " + jumlah_masjid);
            gantinvoice(jumlah_masjid);
        } else {
            System.out.println("Saldo tidak mencukupi.");
            infaqStatusLabel.setText("Infaq gagal. Saldo tidak mencukupi.");
            gantinvoice(jumlah_masjid);
        }
        }
    @FXML
    private TextField namaField; // Tambahkan deklarasi TextField untuk input nama

    @FXML
    private TextField alamatField; // Tambahkan deklarasi TextField untuk input alamat

    @FXML
    private void buttonSayaSiapBerinfaqAction(ActionEvent event) {
        String nama = namaField.getText();
        String alamat = alamatField.getText();


        if (nama.isEmpty() || alamat.isEmpty()) {
            System.out.println("Nama dan alamat harus diisi.");

            return;
        }
        simpanNamaAlamat(nama, alamat);
    }
    private void simpanNamaAlamat(String nama, String alamat) {
        System.out.println("Nama: " + nama + ", Alamat: " + alamat);
    }

    @FXML
    private void tombolRp15000Yatim() {
        kurangiSaldoYatim(15000);
    }

    @FXML
    private void tombolRp200000Yatim() {
        kurangiSaldoYatim(200000);
    }

    @FXML
    private void tombolRp1000000Yatim() {
        kurangiSaldoYatim(1000000);
    }

    @FXML
    private void tombolRp100000Yatim() {
        kurangiSaldoYatim(100000);
    }
    @FXML
    private Label infaqStatusLabelYatim;
    private void kurangiSaldoYatim(double jumlah_yatim) {
        if (saldo >= jumlah_yatim) {
            saldo -= jumlah_yatim;
            updateSaldoLabel();
            saldoLabel1.setText("Rp " + saldo); // Update label saldo pada tab Masjid
            System.out.println("Saldo Yatim berhasil dikurangi: " + jumlah_yatim);
            infaqStatusLabelYatim.setText("Infaq berhasil: Rp" + jumlah_yatim );
            gantinvoice(jumlah_yatim);
        } else {
            System.out.println("Saldo tidak mencukupi.");
            infaqStatusLabelYatim.setText("Infaq gagal" );
            gantinvoice(jumlah_yatim);
        }
    }

    @FXML
    private void tombolRp4000000Qurban() {
        kurangiSaldoQurban(4000000);
    }

    @FXML
    private void tombolRp4500000Qurban() {
        kurangiSaldoQurban(4500000);
    }

    @FXML
    private void tombolRp20000000Qurban() {
        kurangiSaldoQurban(20000000);
    }

    @FXML
    private void tombolRp50000000Qurban() {
        kurangiSaldoQurban(50000000);

    }
    @FXML
    private Label infaqStatusLabelQurban;
    private void kurangiSaldoQurban(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            updateSaldoLabel();
            saldoLabel1.setText("Rp " + saldo);
            System.out.println("Saldo Qurban berhasil dikurangi: " + jumlah);
            infaqStatusLabelQurban.setText("Qurban berhasil: Rp" +jumlah );
            gantinvoice(jumlah);

        } else {
            System.out.println("Saldo tidak mencukupi.");
            infaqStatusLabelQurban.setText("Qurban berhasil" );
            gantinvoice(jumlah);
        }
    }

    @FXML
    private void gantinvoice(double jumlah) {
        InvoiceLabel.setText(""+ jumlah);
    }

    @FXML
    private Label infaqLabel;

    @FXML
    private void gantiinfaq(double jumlah) {
        infaqLabel.setText(""+ jumlah);
    }



}
