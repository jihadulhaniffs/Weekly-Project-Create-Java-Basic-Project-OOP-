
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Product product = new Product("Keyboard", 10);
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Produk : " + product.getName());
                    System.out.println("Stok : " + product.getStock() + " unit");
                    break;
                case 2:
                    System.out.print("Masukkan jumlah stok yang ditambahkan: ");
                    int addQuantity = scanner.nextInt();
                    boolean isAdded = product.addStock(addQuantity);
                    if (isAdded) {
                        System.out.println("Stok berhasil ditambahkan. Stok : " + product.getStock() + " unit.");
                    } else {
                        System.out.println("Input gagal. Jumlah harus bilangan bulat positif (> 0). Stok : " + product.getStock() + " unit.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan jumlah stok yang diambil: ");
                    int takeQuantity = scanner.nextInt();
                    if (takeQuantity <= 0) {
                        System.out.println("Input gagal. Jumlah harus bilangan bulat positif (> 0). Stok : " + product.getStock() + " unit.");
                    } else {
                        boolean isReduced = product.reduceStock(takeQuantity);
                        if (isReduced) {
                            System.out.println("Stok berhasil diambil. Stok : " + product.getStock() + " unit.");
                        } else {
                            System.out.println("Stok tidak cukup. Stok tersisa hanya " + product.getStock() + " unit.");
                        }
                    }
                    break;
                case 4:
                    simulateDailyStock(product, scanner);
                    break;
                case 0:
                    System.out.println("Program telah dihentikan.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu 1 - 4 sesuai kebutuhan.");
                    break;
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n=== Menu Pengelolaan Stok ===");
        System.out.println("1. Lihat stok");
        System.out.println("2. Tambah stok");
        System.out.println("3. Ambil stok");
        System.out.println("4. Simulasi stok harian");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void simulateDailyStock(Product product, Scanner scanner) {
        System.out.print("Masukkan jumlah hari simulasi: ");
        int totalDays = scanner.nextInt();
        System.out.print("Masukkan jumlah unit keluar per hari: ");
        int unitsPerDay = scanner.nextInt();

        if (totalDays <= 0 || unitsPerDay <= 0) {
            System.out.println("Input ditolak. Jumlah hari dan unit keluar per hari harus bilangan bulat positif (> 0).");
            System.out.println("Stok aktual tetap: " + product.getStock() + " unit.");
        } else {
            int simulatedStock = product.getStock();
            System.out.println("\n--- Hasil Simulasi Stok Harian (" + product.getName() + ") ---");
            System.out.println("Stok awal simulasi: " + simulatedStock + " unit");

            for (int day = 1; day <= totalDays; day++) {
                if (simulatedStock < unitsPerDay) {
                    System.out.println("Hari ke-" + day + ": Stok tidak cukup (sisa " + simulatedStock + " unit, dibutuhkan " + unitsPerDay + " unit). Simulasi dihentikan.");
                    break;
                } else {
                    simulatedStock -= unitsPerDay;
                    System.out.println("Hari ke-" + day + ": Sisa stok simulasi = " + simulatedStock + " unit");
                }
            }

            System.out.println("Stok : " + product.getStock() + " unit.");
        }
    }
}
