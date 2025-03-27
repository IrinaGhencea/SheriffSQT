package ase.en.sqt.View;

import ase.en.sqt.Controllers.Sheriff;
import ase.en.sqt.Models.DispatcherType;
import ase.en.sqt.Models.Request;

import java.util.Scanner;

public class cli {
    public void begin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Sheriff name: ");
        String name = sc.nextLine();
        System.out.print("Sheriff tenure (years): ");
        int tenure = Integer.parseInt(sc.nextLine());
        System.out.print("Max queue size: ");
        int max = Integer.parseInt(sc.nextLine());

        Sheriff sheriff = new Sheriff(name, tenure, max);

        while (true) {
            System.out.println("\n1. Create dispatcher\n2. List dispatchers\n3. Update dispatcher\n4. Delete dispatcher\n5. Add request\n6. Resolve request\n7. Transform request\n8. Print queue\n0. Exit");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Dispatcher ID: ");
                    String id = sc.nextLine();
                    System.out.print("Dispatcher Address: ");
                    String addr = sc.nextLine();
                    System.out.print("Dispatcher Type (REGULAR, EMERGENCY, CRISIS): ");
                    DispatcherType type = DispatcherType.valueOf(sc.nextLine().toUpperCase());


                }
                case 2 -> sheriff.listDispatchers();
                case 3 -> {
                    System.out.print("Dispatcher ID to update: ");
                    String id = sc.nextLine();
                    System.out.print("New Address: ");
                    String newAddr = sc.nextLine();
                    sheriff.updateDispatcher(id, newAddr);
                }

                default -> System.out.println("Invalid input");
            }
        }
    }
}
