/**
 * Entry point for the application.
 * Initializes and launches the budgeting system.
 */
import java.util.*;

public class Main {
    private static final IUserRepository repository = new FileUserRepository();  // ✅ Initialized here
    private static final AuthService authService = new AuthService(repository);
    private static final List<Transaction> transactions = new ArrayList<>();
    private static final Budget budget = new Budget(new String[]{"Food", "Transport", "Entertainment"}, "Monthly", 1000.0);
    private static final Budgetcalculator calculator = new Budgetcalculator();
    private static final ReminderService reminderService = new ReminderService(new EmailNotifier());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserData currentUser = null;

        while (true) {
            System.out.println("\n1. Sign Up\n2. Log In\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String user = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter password: ");
                String pass = scanner.nextLine();
                boolean success = authService.register(new UserData(user, email, pass));
                System.out.println(success ? "Registered successfully!" : "Username already exists.");
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String user = scanner.nextLine();
                System.out.print("Enter password: ");
                String pass = scanner.nextLine();
                if (authService.login(user, pass)) {
                    System.out.println("Login successful.");
                    currentUser = new UserData(user, "", pass);
                    showDashboard(scanner);
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else {
                System.out.println("Exiting app.");
                break;
            }
        }
    }

    private static void showDashboard(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Dashboard ---");
            System.out.println("1. Add Income\n2. Add Expense\n3. View Budget Status\n4. Generate Report\n5. Set Reminder\n6. Logout");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter amount: ");
                    double incomeAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter category: ");
                    String incomeCat = scanner.nextLine();
                    System.out.print("Enter source: ");
                    String source = scanner.nextLine();
                    transactions.add(new Income(incomeAmount, new Date(), incomeCat, source));
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter category: ");
                    String expenseCat = scanner.nextLine();
                    System.out.print("Enter type: ");
                    String type = scanner.nextLine();
                    transactions.add(new Expense(expenseAmount, new Date(), expenseCat, type));
                    // REMOVE THIS LINE ↓↓↓
                    // budget.update(expenseAmount);
                    break;

                case 3:
                    double totalExpenses = transactions.stream()
                            .filter(t -> t instanceof Expense)
                            .mapToDouble(Transaction::getAmount).sum();
                    double remaining = calculator.calculateRemaining(budget, totalExpenses);
                    System.out.println("Remaining Budget: $" + remaining);
                    if (calculator.checkLimit(budget, totalExpenses))
                        System.out.println("You have exceeded your budget!");
                    break;
                case 4:
                    Map<String, Double> data = new HashMap<>();
                    for (Transaction t : transactions) {
                        data.put(t.getCategory(), data.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
                    }
                    ReportData reportData = new ReportData("This Month", data);
                    ReportGenerator generator = new ReportGenerator();
                    System.out.println(generator.generate(reportData));
                    break;
                case 5:
                    System.out.print("Enter reminder message: ");
                    String msg = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    reminderService.setReminder(msg, email);
                    break;
                case 6:
                    System.out.println("Logging out.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
