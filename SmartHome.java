import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmartHome{
    private static Map<String, Room> rooms = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSmart Home Automation System");
            System.out.println("1. Add Room");
            System.out.println("2. Add Device to Room");
            System.out.println("3. Control Device");
            System.out.println("4. Show Device Status");
            System.out.println("5. Show Device Usage");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    addDevice();
                    break;
                case 3:
                    controlDevice();
                    break;
                case 4:
                    showStatus();
                    break;
                case 5:
                    showUsage();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addRoom() {
        System.out.println("Select Room Type:");
        System.out.println("1. Bedroom");
        System.out.println("2. Hall");
        System.out.println("3. Kitchen");
        System.out.println("4. Washroom");
        System.out.print("Enter your choice: ");
        
        int roomChoice = scanner.nextInt();
        scanner.nextLine();
        String roomName = "";
        
        switch (roomChoice) {
            case 1:
                roomName = "Bedroom";
                break;
            case 2:
                roomName = "Hall";
                break;
            case 3:
                roomName = "Kitchen";
                break;
            case 4:
                roomName = "Washroom";
                break;
            default:
                System.out.println("Invalid choice! Room not added.");
                return;
        }
        
        rooms.put(roomName, new Room(roomName));
        System.out.println("Room " + roomName + " added.");
    }

    private static void addDevice() {
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();
        Room room = rooms.get(roomName);
        if (room != null) {
            System.out.print("Enter device name: ");
            String deviceName = scanner.nextLine();
            room.addDevice(deviceName);
        } else {
            System.out.println("Room not found!");
        }
    }

    private static void controlDevice() {
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();
        Room room = rooms.get(roomName);
        if (room != null) {
            System.out.print("Enter device name: ");
            String deviceName = scanner.nextLine();
            
            System.out.println("Select action:");
            System.out.println("1. Turn ON");
            System.out.println("2. Turn OFF");
            System.out.print("Enter your choice: ");
            
            int actionChoice = scanner.nextInt();
            scanner.nextLine();
            boolean turnOn = actionChoice == 1;
            
            room.controlDevice(deviceName, turnOn);
        } else {
            System.out.println("Room not found!");
        }
    }

    private static void showStatus() {
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();
        Room room = rooms.get(roomName);
        if (room != null) {
            room.showDevicesStatus();
        } else {
            System.out.println("Room not found!");
        }
    }

    private static void showUsage() {
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();
        Room room = rooms.get(roomName);
        if (room != null) {
            room.showDeviceUsage();
        } else {
            System.out.println("Room not found!");
        }
    }
}
