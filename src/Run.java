/**
 * The Run program implements an applicaton that
 * simply get two matrixes and one phrase that contain
 * caculations of there .
 *
 * @author Azhdari Muhammad
 * @since 2018
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        // get first matrix from user :
        Scanner sc = new Scanner(System.in);
        String str = "start";
        ArrayList<String> xMatrix ;
        ArrayList<ArrayList<Integer>> xMatrixInt ;
        int cnt ;
        while (true) {
            System.out.println("Define matrix X : ");
            xMatrix = new ArrayList<String>();
            xMatrixInt = new ArrayList<ArrayList<Integer>>();
            cnt = 0;
            try {

                while (true) {

                    str = sc.nextLine();
                    if (str.equals(""))
                        break;
                    String[] temp = str.split(",");
                    //   System.out.println(temp.length);
                    xMatrixInt.add(new ArrayList<Integer>());
                    for (int i = 0; i < temp.length; i++) {
                        int tempInt = Integer.parseInt(temp[i]);
                        xMatrixInt.get(cnt).add(tempInt);
                    }
                    xMatrix.add(str);
                    cnt++;
                }
                break;
            } catch (Exception e) {
                System.out.println("wrong input .");
                continue;
            }
        }

            // get second matrix from user :
            System.out.println("Define matrix Y : ");
            str = "start";
            ArrayList<String> yMatrix = new ArrayList<String>();
            ArrayList<ArrayList<Integer>> yMatrixInt = new ArrayList<ArrayList<Integer>>();
            cnt = 0;
            while (true) {

                str = sc.nextLine();
                if (str.equals(""))
                    break;
                String[] temp = str.split(",");
                // System.out.println(temp.length);
                yMatrixInt.add(new ArrayList<Integer>());
                for (int i = 0; i < temp.length; i++) {
                    int tempInt = Integer.parseInt(temp[i]);
                    yMatrixInt.get(cnt).add(tempInt);
                }
                yMatrix.add(str);
                cnt++;
            }


     // get mainstring from user :
        int xIndex , yIndex , xFactor , yFactor ;
        char operator ;

        while (true) {

            System.out.println("Enter phrase : \n for example : 3X-(-3)Y . \n ** You can write () or not \n ** If your factor is 1 you must write it before X or Y for example 1X is valid and X is not valid . ");
            System.out.println(" ** You can write space between X and Y for example ' 3X  *  -4Y ' is valid .");
            System.out.println(" ** You can write X first or Y for example ' 3Y  - 3X ' is valid .  ");
            String mainString = new String();
            operator = ' ';
            mainString = sc.nextLine();
            mainString = mainString.replace("(", "");
            mainString = mainString.replace(")", "");
            mainString = mainString.replace(" ", "");
            xIndex = mainString.indexOf("X");
            yIndex = mainString.indexOf("Y");
            xFactor = 0;
            yFactor = 0;
          //  System.out.println(mainString);
            // System.out.println(yIndex);
            try {

                if (xIndex == -1)
                    xFactor = 0;

                if (yIndex == -1)
                    yFactor = 0;

                if (xIndex < yIndex) {
                    if (xIndex != -1) {
                        xFactor = Integer.parseInt(mainString.substring(0, xIndex));
                        operator = mainString.charAt(xIndex + 1);
                        //  System.out.println(operator);
                        yFactor = Integer.parseInt(mainString.substring(xIndex + 2, yIndex));
                    } else
                        yFactor = Integer.parseInt(mainString.substring(0, yIndex));

                } else {
                    if (yIndex != -1) {
                        operator = mainString.charAt(yIndex + 1);
                        xFactor = Integer.parseInt(mainString.substring(yIndex + 2, xIndex));
                        yFactor = Integer.parseInt(mainString.substring(0, yIndex));
                    } else
                        xFactor = Integer.parseInt(mainString.substring(0, xIndex));
                }
                break;
            } catch (Exception e) {
                System.out.println("wrong input .");
                continue;
            }
        }

     /*   System.out.println(yFactor);
        System.out.println(xFactor);
        System.out.println(operator); */

        Matrix x = new Matrix(xMatrixInt) ;
        Matrix y = new Matrix(yMatrixInt) ;
        x = x.numberMuti(xFactor) ;
        y = y.numberMuti(yFactor) ;
        System.out.println("Result  : ***\n");
        if (operator == '*') {
            Matrix s = x.multiplication(y);
            s.printMatrix();
        }
        else if (operator == '-') {
            Matrix s = x.sub(y) ;
            s.printMatrix();
        }
        else {
            Matrix s = x.sum(y) ;
            s.printMatrix();
        }

    }
}
