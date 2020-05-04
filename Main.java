import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // scale of probabilities
        /*
        0: Worst: 50%
        1: Bad: 25%
        2: Nuetral: 15%
        3: good: 7%
        4: Godsend: 3%
         uuhhh 7+3 =10 +15 = 25 => 100-25 = 75... 25 and 50
          The larger the quantity the higher the chances
         */
        //double[] probs = {0.5, 0.25, 0.15, 0.07, 0.03};
        //System.out.println("haha it works");

        //its been a hot second since I've coded java :0
       //reading to file
        Tea[] myTeas = new Tea[100]; // probably will never reach 100 so probably too much memory
        double[] weights = new double[100];
        int i = 0;
        try {
            File myFile = new File("tea_info.txt");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                if(data.equals("")){
                    System.out.println("empty");
                }else {
                    String[] parts = data.split("-", 3);
                    //System.out.println(parts[2]);
                    myTeas[i] = new Tea(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    if (myTeas[i].isEmpty()) {
                        i--;
                    }
                    weights[i] = myTeas[i].getQuantity()*myTeas[i].getProb();
                    System.out.println(data);
                    i++;
                }
            }
         //   System.out.println(i);
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        /*
        for(int j = 0; j<i;j++){
           // System.out.println(j);
            System.out.println(myTeas[j].toString()+"\n");
        }*/
        //COMMANDS
        /*
        tea: Gives you a tea
        print all: prints them all nicely
        remove tea [insert tea]: removes tea from
        quit: writes a new tea file and exits
        help: prints this screen
         */
        String help_Screen = "tea: Gives you a tea\n" +
                "print all: prints them all nicely\n" +
                "quit: writes a new tea file and exits\n" +
                "help: prints this screen\n";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter command:\n");
        String command = sc.nextLine();  // Read user input
        //System.out.println("Username is: " + userName);
        //sum of all weight
        int sum = 0;
        for (int k = 0; k < i; k++) {
            System.out.println(weights[k]);

            sum+= weights[k];
        }
        System.out.println("sum: "+ sum);
        while(!command.equals("quit")){
            if(command.equals("help")){
                System.out.println(help_Screen);
            }else if(command.equals("print all")) {
                for (int j = 0; j < i; j++) {
                    //System.out.println(j);
                    System.out.println(myTeas[j].toString() + "\n");
                }

            }else if(command.equals("tea")) {
                //random number
                double rando = Math.random() * sum;
                //go through and subtract;
                for (int j = 0; j < i; j++) {
                    // System.out.println(j);
                    if(rando<weights[j]){
                        System.out.println("Drink: "+myTeas[j].getName());
                        myTeas[j].drink();
                        break;

                    }else{
                        rando -= weights[j];
                    }

                }
            }

            System.out.println("Enter command\n");
            command = sc.nextLine();
        }
        //write to the file
        //scary plays
        FileWriter fw = new FileWriter("tea_info.txt",false);
        for (int j = 0; j < i; j++) {

            System.out.println(myTeas[j].fileString());
            fw.write(myTeas[j].fileString()+"\n");
            fw.flush();
        }

    }
    //writing to that file with new info

}
