import java.util.Scanner;

public class SwimSchedule {
    public static void main(String[] args) {
        schedlue s= new schedlue();
        s.menu();
    }

}

class schedlue {

    public String[][] AnnasSchedules = new String[4][5];
    public String[][] JeffsSchedules = new String[4][5];
    public String[][] Individual = new String[4][5];

    public String[][] Group = new String[4][5];


    public schedlue() {
        JeffsSchedules[0][0] = "11-12";
        JeffsSchedules[1][0] = "12-1";
        JeffsSchedules[2][0] = "1-2";
        JeffsSchedules[3][0] = "2-3";

        JeffsSchedules[0][1] = "X";
        JeffsSchedules[1][1] = "_";
        JeffsSchedules[2][1] = "_";
        JeffsSchedules[3][1] = "X";

        JeffsSchedules[0][2] = "X";
        JeffsSchedules[1][2] = "X";
        JeffsSchedules[2][2] = "X";
        JeffsSchedules[3][2] = "X";

        JeffsSchedules[0][3] = "_";
        JeffsSchedules[1][3] = "X";
        JeffsSchedules[2][3] = "X";
        JeffsSchedules[3][3] = "X";

        JeffsSchedules[0][4] = "_";
        JeffsSchedules[1][4] = "X";
        JeffsSchedules[2][4] = "_";
        JeffsSchedules[3][4] = "_";

        AnnasSchedules[0][0] = "11-12";
        AnnasSchedules[1][0] = "12-1";
        AnnasSchedules[2][0] = "1-2";
        AnnasSchedules[3][0] = "2-3";

        AnnasSchedules[0][1] = "X";
        AnnasSchedules[1][1] = "_";
        AnnasSchedules[2][1] = "X";
        AnnasSchedules[3][1] = "X";

        AnnasSchedules[0][2] = "X";
        AnnasSchedules[1][2] = "X";
        AnnasSchedules[2][2] = "X";
        AnnasSchedules[3][2] = "_";

        AnnasSchedules[0][3] = "_";
        AnnasSchedules[1][3] = "_";
        AnnasSchedules[2][3] = "_";
        AnnasSchedules[3][3] = "X";

        AnnasSchedules[0][4] = "X";
        AnnasSchedules[1][4] = "X";
        AnnasSchedules[2][4] = "_";
        AnnasSchedules[3][4] = "X";
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter one of the following commands: ");
            System.out.println("p-Print schedules");
            System.out.println("s-Schedules a slot");
            System.out.println("f-Free a slot");
            System.out.println("i-Show slots available for individual lessons");
            System.out.println("g-Show slots available for group lessons");
            System.out.println("q-Quit");
            System.out.print("Command:");
            String userInput = input.nextLine();

            if (userInput.equals("p")) {
                printSchedules();

            } else if (userInput.equals("s")) {
                ScheduleASlot();
            } else if (userInput.equals("f")) {
                FreeASlot();
            }
            else if(userInput.equals("i")){
                individualLessons();
            }
            else if(userInput.equals("g")){
                groupLessons();
            }
            else if(userInput.equals("q")){
                System.exit(0);
            }
            else{
                System.out.println("***invalid option***");
                System.out.println("Please enter a valid option");
                System.out.println();
            }
        }
    }

    public void printSchedules() {

        System.out.println("Jeff:");
        System.out.printf("%13s%10s%10s%10s", "Mon", "Tue", "Wed", "Thu");
        System.out.println();


        for (int i = 0; i < JeffsSchedules.length; i++) {
            for (int j = 0; j < JeffsSchedules[i].length; j++) {
                System.out.printf("%-10s", JeffsSchedules[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Anna:");
        System.out.printf("%13s%10s%10s%10s", "Mon", "Tue", "Wed", "Thu");
        System.out.println();


        for (int i = 0; i < AnnasSchedules.length; i++) {
            for (int j = 0; j < AnnasSchedules[i].length; j++) {
                System.out.printf("%-10s", AnnasSchedules[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void ScheduleASlot() {
        Scanner input = new Scanner(System.in);
        System.out.print("Select instructor (1-Jeff, 2-Anna):");
        String instructor = input.nextLine();
        while(!(instructor.equals("1"))  && !(instructor.equals("2"))){
            System.out.println("Please Enter valid option:");
            System.out.print("Select instructor (1-Jeff, 2-Anna):");
             instructor = input.nextLine();
        }

        System.out.print("Select Day (1 - Mon, 2 - Tue, 3 - Wed, 4 - Thu):");
        int day = input.nextInt();
    while(day<1 || day>4){
        System.out.println("Please Enter valid option:");
        System.out.print("Select Day (1 - Mon, 2 - Tue, 3 - Wed, 4 - Thu):");
         day = input.nextInt();
    }
        System.out.print("Select Slot (1 - 11-12, 2 - 12-1, 3 - 1-2, 4 - 2-3):");
        int Slot = input.nextInt();
        while(Slot<1 || Slot>4){
            System.out.println("Please Enter valid option:");
            System.out.print("Select Slot (1 - 11-12, 2 - 12-1, 3 - 1-2, 4 - 2-3):");
            Slot = input.nextInt();
        }

        if (instructor.equals("1")) {
            JeffsSchedules[Slot - 1][day] = "X";
        } else if (instructor.equals("2")) {
            AnnasSchedules[Slot - 1][day] = "X";
        }
    }

    public void FreeASlot() {
        Scanner input = new Scanner(System.in);
        System.out.print("Select instructor (1-Jeff, 2-Anna):");
        String instructor = input.nextLine();

        System.out.print("Select Day (1 - Mon, 2 - Tue, 3 - Wed, 4 - Thu):");
        int day = input.nextInt();

        System.out.print("Select Slot (1 - 11-12, 2 - 12-1, 3 - 1-2, 4 - 2-3):");
        int Slot = input.nextInt();

        if (instructor.equals("1")) {
            JeffsSchedules[Slot - 1][day] = "_";
        } else if (instructor.equals("2")) {
            AnnasSchedules[Slot - 1][day] = "_";

        }
    }

    public void individualLessons() {
        //String[][] Individual = new String[4][5];
        for (int i = 0; i < AnnasSchedules.length; i++) {
            for (int j = 0; j < AnnasSchedules[i].length; j++) {
                    if ((AnnasSchedules[i][j].equals("X") && JeffsSchedules[i][j].equals("X"))) {
                    Individual[i][j] = "_";
                } else if ((AnnasSchedules[i][j].equals("X") && JeffsSchedules[i][j].equals("_"))) {
                    Individual[i][j] = "I";
                }
                    else if ((AnnasSchedules[i][j].equals("_") && JeffsSchedules[i][j].equals("X"))) {
                        Individual[i][j] = "I";
                    }
                    else if ((AnnasSchedules[i][j].equals("_") && JeffsSchedules[i][j].equals("_"))) {
                        Individual[i][j] = "I";
                    }
            }
        }
        Individual[0][0] = "11-12";
        Individual[1][0] = "12-1";
        Individual[2][0] = "1-2";
        Individual[3][0] = "2-3";
        System.out.printf("%13s%10s%10s%10s", "Mon", "Tue", "Wed", "Thu");
        System.out.println();
        for (int i = 0; i < Individual.length; i++) {
            for (int j = 0; j < Individual[i].length; j++) {
                System.out.printf("%-10s", Individual[i][j] + " ");
            }
            System.out.println();

            }
        }

    public void groupLessons() {

        for (int i = 0; i < AnnasSchedules.length; i++) {
            for (int j = 0; j < AnnasSchedules[i].length; j++) {
                if ((AnnasSchedules[i][j].equals("_") && JeffsSchedules[i][j].equals("_"))) {
                    Group[i][j] = "G";
                }
                else{
                    Group[i][j] = "_";
                }

            }
        }
        Group[0][0] = "11-12";
        Group[1][0] = "12-1";
        Group[2][0] = "1-2";
        Group[3][0] = "2-3";
        System.out.printf("%13s%10s%10s%10s", "Mon", "Tue", "Wed", "Thu");
        System.out.println();
        for (int i = 0; i < Group.length; i++) {
            for (int j = 0; j < Group[i].length; j++) {
                System.out.printf("%-10s", Group[i][j] + " ");
            }
            System.out.println();
        }
        }

}