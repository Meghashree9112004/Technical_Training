import java.util.Scanner;
import java.util.regex.Pattern;

public class IPAddressValidators {

    // Regular expression pattern to validate IPv4 addresses
    private static final String IPV4_PATTERN =
            "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$";

    public static boolean isValidIPv4(String ip) {
        // Check if the IP matches the basic IPv4 pattern
        if (!Pattern.matches(IPV4_PATTERN, ip)) {
            return false;
        }

        // Split the IP address into individual segments
        String[] parts = ip.split("\\.");

        for (String part : parts) {
            // Leading zero check (excluding "0" itself)
            if (part.length() > 1 && part.startsWith("0")) {
                return false;
            }

            // Convert the segment to an integer
            int num = Integer.parseInt(part);

            // Check if the number is within the valid range of 0-255
            if (num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Scanner object to take user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompting user for input
        System.out.print("Enter an IPv4 address: ");
        String ipAddress = scanner.nextLine();
        
        // Checking if the entered IP is valid
        if (isValidIPv4(ipAddress)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        // Closing scanner to prevent resource leak
        scanner.close();
    }
}
