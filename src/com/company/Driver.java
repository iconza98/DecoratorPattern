package com.company;
import com.company.decorators.FilterOutput;
import com.company.decorators.LineOutput;
import com.company.decorators.NumberedOutput;
import com.company.decorators.TeeOutput;
import com.company.predicates.ContainsComment;
import com.company.predicates.ContainsDigit;
import java.io.*;
import java.util.ArrayList;

public class Driver {

    public ArrayList<String> lineArray = new ArrayList<String>();

    public static void main(String[] args) {

        Driver driver = new Driver();
        /*
        System.out.print("Please Enter the name of the file: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String file = br.readLine();
            driver.readFile(file);

        } catch (Exception e){
            System.err.println("ERROR: Could not find file");
        }
        */
        // prompt for decorators
        //driver.displayMenu();

        driver.readFile("decorator.dat");

        Writer writer = new PrintWriter(System.out);
        StreamOutput so = new StreamOutput(writer);
        Output out = new FilterOutput(new NumberedOutput(so), new ContainsDigit());

        /*
        // Should use a Interface handle, then instatiate each decorator
        Output out = so;
        out = new LineOutput(out);
        out = new NumberedOutput(out);
         */
        for(String s: driver.lineArray){
            out.write(s);
        }

        try{
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }



    } // END OF MAIN


    public void readFile(String fileName){
        String line;
        ArrayList<String> array = new ArrayList<String>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            while ((line = br.readLine()) != null) {
                if(!line.equals("")) {
                    array.add(line);
                }
            }

            this.lineArray = array;

        } catch (FileNotFoundException e){
            System.err.println("ERROR: File not found");

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void displayMenu(){

        boolean flag = true;


        Writer writer = new PrintWriter(System.out);
        StreamOutput so = new StreamOutput(writer);
        Output out = null;

        while (flag) {
            System.out.println("Please enter what decorators you would like to use then press enter:");
            System.out.println("1 : Line Output");
            System.out.println("2 : Numbered Output");
            System.out.println("3 : Tee Output");
            System.out.println("4 : Filtered Output: Contains a Digit");
            System.out.println("5 : Filtered Output: Contains a  '#' Comment");
            System.out.println("6 : Finish and Print to Screen");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int choice = -1;
            try {
                String input = br.readLine();
                choice = Integer.parseInt(input);

            } catch (Exception e){
                System.err.println("ERROR: Could not read input");
            }


            switch (choice){
                case 1:
                     out = new LineOutput(out);
                    break;
                case 2:
                    out = new NumberedOutput(out);
                    break;
                case 3:
                    System.out.println("Enter the filename you would like to output the files to:");
                    String filename = "";
                    try {
                        filename = br.readLine();
                    } catch (Exception e){
                        System.err.println("ERROR: Could not read input");
                    }

                    TeeOutput t =  new TeeOutput(out);
                    t.setFileName(filename);
                    out = t;
                    break;
                case 4:
                    out = new FilterOutput(out, new ContainsDigit());
                    break;
                case 5:
                    out = new FilterOutput(out, new ContainsComment());
                    break;
                case 6: flag = false;
                    break;
                default:{flag = false;}break;
            } // end of switch
        } // end of while  




        try {
            for(String s: lineArray){
                out.write(s);
                so.write(out);
            }
            writer.close();
        } catch (IOException e){
            System.err.println("IO EXCEPTION");
        }


    }


}
