import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int passwordLength = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if ("!@#$%^&*()_+{}[]:;<>,.?~\\-".contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }

        System.out.println("Password Strength Indicator:");
        String strengthIndicator = "";

        if (passwordLength > 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            strengthIndicator = "Strength: Strong";
        } else if (passwordLength >= 6) {
            strengthIndicator = "Strength: Medium";
        } else {
            strengthIndicator = "Strength: Weak";
        }

        System.out.println(strengthIndicator);
        System.out.println("Visual Indicator:");

        if (strengthIndicator.equals("Strength: Strong")) {
            System.out.println("██████████");
        } else if (strengthIndicator.equals("Strength: Medium")) {
            System.out.println("██████");
            System.out.println("Criteria missing for a Strong password:");

            if (passwordLength <= 8) {
                System.out.println("- Password should be at least 9 characters long.");
            }
            if (!hasUppercase) {
                System.out.println("- Password should include at least one uppercase letter.");
            }
            if (!hasLowercase) {
                System.out.println("- Password should include at least one lowercase letter.");
            }
            if (!hasDigit) {
                System.out.println("- Password should include at least one digit.");
            }
            if (!hasSpecialChar) {
                System.out.println("- Password should include at least one special character.");
            }
        } else if (strengthIndicator.equals("Strength: Weak")) {
            System.out.println("Visual Indicator: \n████");
            System.out.println("Criteria missing for a Medium password:");

            if (passwordLength < 6) {
                System.out.println("- Password should be at least 6 characters long.");
            }
            if (!hasUppercase) {
                System.out.println("- Password should include at least one uppercase letter.");
            }
            if (!hasLowercase) {
                System.out.println("- Password should include at least one lowercase letter.");
            }
            if (!hasDigit) {
                System.out.println("- Password should include at least one digit.");
            }
            if (!hasSpecialChar) {
                System.out.println("- Password should include at least one special character.");
            }
        }
    }
}
