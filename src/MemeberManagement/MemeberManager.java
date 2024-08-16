package MemeberManagement;

import java.util.ArrayList;
import java.util.Scanner;

class Member {
    int memberId;
    String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public void memberDetails() {
        System.out.println("MemberId: " + memberId);
        System.out.println("Name: " + name);
    }
}


public class MemeberManager {
    private static ArrayList<Member> members = new ArrayList<>();
    private static int memberCount = 0;


    public static void addMember(String name, int id) {
        members.add(new Member(id, name));
    }

    public static int findMemberById(int memberId) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).memberId == memberId) {
                return i;
            }
        }
        return -1;  // Member not found
    }

    public static void displayMemberDetails(int memberIndex) {
        if (memberIndex >= 0 && memberIndex < members.size()) {
            Member member = members.get(memberIndex);
            System.out.println("Member ID: " + member.memberId);
            System.out.println("Name: " + member.name);
        } else {
            System.out.println("Invalid member index.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, memberId;
        String name;

        do {
            System.out.println("\nMember Management System");
            System.out.println("1. Add Member");
            System.out.println("2. Find Member by ID");
            System.out.println("3. Display Member Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Member Name: ");
                    name = scanner.nextLine();
                    addMember(name, memberId);
                    break;
                case 2:
                    System.out.print("Enter Member ID to find: ");
                    memberId = scanner.nextInt();
                    int index = findMemberById(memberId);
                    if (index != -1) {
                        System.out.println("Member found at index: " + index);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Member Index to display details: ");
                    int memberIndex = scanner.nextInt();
                    displayMemberDetails(memberIndex);
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }


}
