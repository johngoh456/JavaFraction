package com.company;
import java.util.Scanner;
//class for addtion and subtraction
class additionSubtraction {
    int newnum;
    int newden;
    int n1_1;
    int n2_1;
    //call method addition with attributes num1,den1,num2 den2.
    public void addition(int num1, int den1, int num2, int den2) {
        if (den1 == den2) {
            newnum = num1 + num2; // if denominator same add numerator1 and numerator2 direcly.
            newden = den1; //denominator stand the same if both are same.
        } else {
            newden = den1 * den2; //if denominator is different, multiply each other to become the same denominator , so both numerator can add together
            n1_1 = num1 * den2;// if denominator 1 change, numerator1 have to multiply the same factor.
            n2_1 = num2 * den1;// if denominator 2 change, numerator 2 have to multiply the same factor.
            newnum = n1_1 + n2_1;// sum up the two changed numerator1 and 2.
        }
    }
    //call method addition with attributes num1,den1,num2,den2.
    public int subtraction(int num1,int den1,int num2,int den2){
        num1 = num1*den2; //numerator 1 have to be the same with denominator 1 hence multiply by the same factor.
        num2 = num2*den1;// numerator 2 have to be the same with denominator 2 hence multiply by the same factor.
        newnum = num1-num2; //after making it the same , subtract each other to have the output.
        return newnum;
    }
}
//class of multiplication and division

class multiplicationDivision {
    int newnum;
    int newden;
    //create method for multiplication, // basic multiplication

    public void multiplication(int num1, int den1, int num2, int den2) {
        newnum= num1*num2; //numerator1 multiply by numerator2 to get the result.
        newden= den1*den2;//denominator1 multiply by denominator 2 to get the result.

    }
//create method for division
    public void division(int num1, int den1, int num2, int den2){
       newnum = num1*den2;//numerator 1 multiply by denominator2 to get the result.
       newden = den1*num2;//numerator 2 multiply by denominator 1 to get the result.
    }

}
//class for reducing the form
class reduceForm{
    int newnum;
    int newden;
    boolean negative;
    //create method for reduce form.
    public void reducefor(int rednum,int redden){
        if (rednum<0&&redden<0){// if both numerator and denominator are neagtive change to positive
            rednum= -rednum;
            redden = -redden;
        }
        if (rednum>redden){
            for(int i=rednum;i>0;i--){
                if(rednum%i==0 && redden% i ==0){
                    newnum=rednum/i;
                    newden=redden/i;

                    break;
                }
            }
        }
        //finding the gcd, but dividing commmon largernumber.
        else if(redden>rednum){
            for(int i=redden;i>0;i--){
                if(rednum%i==0 && redden% i ==0){
                    newnum=rednum/i;
                    newden=redden/i;

                    break;
                }
            }
        }
    }
}
public class Main {
//main class and main method

    public static void main(String[] args) {
        //initialise all the variables that will be use in main method, so it would be easy to use .
        String fraction2 ="";
        String[]firstsplit;
        String[]secondsplit;
        String replace="";
        int num1=0;
        int num2=0;
        int den1=0;
        int den2=0;
        boolean negative=false;
        int counterDivider=0;
        int counternegative=0;
        int countermul=0;
        int counteradd=0;
        boolean lastChar=false;
        int answer[] = new int[10];
        int newnum =0;
        int newden =0;
        int countillegal=0;

        //create object for additionsubtraction class,multiplicationdivision class, reduceform class.


        additionSubtraction addSubtr=new additionSubtraction();
        multiplicationDivision multidiv= new multiplicationDivision();
        reduceForm redfom = new reduceForm();
        Scanner in = new Scanner(System.in);
        //enter while loop here so that user have 3 tries to input fraction.after 3 input there will be no chance.
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(("you will only have 3 tries ,once you failed to enter a correct operator"));
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("enter your fraction:");
        String fraction = in.nextLine();
        fraction=fraction.replaceAll(" ",""); // replace all spacebar to nothing, so that it will be easy to split in later method.
        for(int i=0;i<fraction.length();i++){
            if (fraction.charAt(i)=='/'){
                counterDivider = counterDivider +1;
            }
            if (fraction.charAt(i)=='-'){
                counternegative = counternegative +1;
            }
            if (fraction.charAt(i)=='+'){
                counteradd = counteradd +1;
            }
            if (fraction.charAt(i)=='*'){
                countermul = countermul +1;
            }

        }
        // if enter wrong operator it will trigger.
        if (fraction.charAt(fraction.length()-1)=='+'||fraction.charAt(fraction.length()-1)=='-'||fraction.charAt(fraction.length()-1)=='*'||fraction.charAt(fraction.length()-1)=='/'){
            lastChar = true;
        }

        while(fraction.matches(".[a-zA-Z]+.")||lastChar==true||(counteradd<1&&countermul<1&&counternegative<1&&counterDivider<2)||counteradd>1||countermul>1||(counteradd>0&&countermul>0)||fraction.contains("--")||fraction.contains("-/")||fraction.contains("-*")||(fraction.contains("-+"))||(fraction.contains("++"))||(fraction.contains("+-"))||(fraction.contains("+*"))||(fraction.contains("+/"))||(fraction.contains("*+"))||(fraction.contains("*-"))||(fraction.contains("*/"))||(fraction.contains("**"))||(fraction.contains("/+"))||((fraction.contains("/-")&&counternegative>5))||(fraction.contains("/*"))||(fraction.contains("//"))||(counterDivider>3)||(counternegative>5)||(counterDivider<2)){
            countillegal= countillegal + 1;

            if (countillegal>2){
                System.out.println("Invalid input.");
                System.out.println("You have no more chance.");
                System.exit(0);
            }

            System.out.println("Invalid input");
            System.out.print("Please enter again : ");
            fraction = in.nextLine();
            counterDivider=0;
            counternegative=0;
            for(int i=0;i<fraction.length();i++){
                if (fraction.charAt(i)=='/'){
                    counterDivider = counterDivider +1;
                }
                if (fraction.charAt(i)=='-'){
                    counternegative = counternegative +1;
                }
                if (fraction.charAt(i)=='+'){
                    counteradd= counteradd +1;
                }
                if (fraction.charAt(i)=='*'){
                    countermul = countermul +1;
                }
            }
        }
        //subtraction part is complicated.
        //at this part i repalce all "(" ")" . and i use two split to split.
        //first time i split the divider.
        //second time i split the ")""("
        //i will use an example to explain this part.
        //lets say -3/4-(-1/4), please look below texts  to see explanation
        if(fraction.contains("+")==false && fraction.contains("*")==false && counterDivider==2){ //condition for only two divider and only subtraction inside the input.
            // lets say  -3/4-(-1/4), it has no +, * and only two divider hence activate the AND operator entering this part.
            if (fraction.contains("(")||fraction.contains(")")){
                // -3/4-(-1/4) have both "(",")" hence activate this condition as well.

                firstsplit = fraction.split("[/]");
                //first split the divier. it will become firstsplit[0]=-3,firstsplit[1]=4-(—1, firstsplit[2]= 4).
                for(int i = 0; i <firstsplit.length;i++){
                    //use for loop to loop each firstsplit[]
                    if (firstsplit[i].contains("-(-")||firstsplit[i].contains("-(")||firstsplit[i].contains(")-")){
                        //use if condition to replace -( to (, ) to nothing, )- to ),-(- to (-
                        // in the example  firstsplit[0]=-3 has no ( ,so ignore.
                        // in the example firstsplit[1]=4-(-1 replace to4(-1.
                        // in the example firstsplit[2]=4 , so ignore.
                        firstsplit[i]=firstsplit[i].replace("-(", "(");

                        if(firstsplit[i].contains(")-")==false){
                            firstsplit[i]=firstsplit[i].replace(")", "");
                        }
                        firstsplit[i]=firstsplit[i].replace(")-", ")");
                        firstsplit[i]=firstsplit[i].replace("-(-", "(-");
                        replace = firstsplit[i];
                        // this is for no negative numerator and denominator. our example dont workhere
                    }else if(firstsplit[i].contains("(")||fraction.contains(")")){
                        firstsplit[i]=firstsplit[i].replace("(", "");
                        firstsplit[i]=firstsplit[i].replace(")", "");
                    }


                }


                secondsplit = replace.split("[()]");
                //split the second time in ourexample it will replace 4(-1 to 4 and -1, hence second split[0]=den1, split[1]=num2
                secondsplit[0]=secondsplit[0].replace(")-", "");
                //register already complete replaced and splited , firstsplit[0]=num1, firstsplit[2]=den2
                //register already complete replace and splited , second split[0]=den1, split[1]=num2.
                num1 = Integer.parseInt(firstsplit[0]);
                den2 = Integer.parseInt(firstsplit[2]);
                den1 = Integer.parseInt(secondsplit[0]);
                num2 = Integer.parseInt(secondsplit[1]);


            }
            //this part for fractions that have no blacket. example like 4/5-3/5 will trigger here
            else if(fraction.contains("(")==false||fraction.contains(")")==false){
                firstsplit = fraction.split("/");
                if (firstsplit[1].charAt(0)=='-'){
                    negative = true;
                    firstsplit[1] = firstsplit[1].substring(1);
                }
                secondsplit = firstsplit[1].split("[-]");
                if (negative==true){
                    secondsplit[0]= "-" + secondsplit[0];
                }
                //convert from string to integer. and store each splitted numbers to integer.

                num1 = Integer.parseInt(firstsplit[0]);
                den2 = Integer.parseInt(firstsplit[2]);
                den1 = Integer.parseInt(secondsplit[0]);
                num2 = Integer.parseInt(secondsplit[1]);

            }
            System.out.println(" numerator 1 = "+ num1);
            System.out.println(" denominator 1 = "+ den1);
            System.out.println(" numerator 2 = "+ num2);
            System.out.println(" denominator 2 = "+ den2);
            //call subtraction method here for calculation
            addSubtr.subtraction(num1, den1, num2, den2);
            newnum = addSubtr.newnum;
            newden = den1 * den2;//calculate new denominator.
            System.out.println("Answer:" + newnum + "/" + newden);
            // call reduce method to find the simplest form. by dividing itself by GCD.
            redfom.reducefor(newnum, newden);
            newnum = redfom.newnum;
            newden = redfom.newden;
            System.out.println("Reduced form:" + newnum + "/" + newden);
            System.exit(0); //system after all the subtraction and simplification done.
        }
        // method for addition multiplication and division.
        fraction2 = fraction;// store original input.
        fraction = fraction.replace(" ","");
        fraction = fraction.replace("(","");
        fraction = fraction.replace(")","");

        firstsplit = fraction.split("[/+*]");// split / + * operators and divider
        // same as above convert each string to integer.
        num1 = Integer.parseInt(firstsplit[0]);
        den1 = Integer.parseInt(firstsplit[1]);
        num2 = Integer.parseInt(firstsplit[2]);
        den2 = Integer.parseInt(firstsplit[3]);

        System.out.println(" numerator1 = "+ num1);
        System.out.println(" denominator 1 = "+ den1);
        System.out.println(" numerator 2 = "+ num2);
        System.out.println(" denominator 2 = "+ den2);

        if(fraction2.contains("+")){//condition to call in addition method
            addSubtr.addition(num1,den1,num2,den2);// call in addition method
            newnum= addSubtr.newnum;//retrieve result from the class
            newden= addSubtr.newden;

        }
        else if(fraction2.contains("*")){//condition to call in multiplication method
            multidiv.multiplication(num1,den1,num2,den2);//retrieve result from the class
            newnum = multidiv.newnum;//retrieve result from the class
            newden = multidiv.newden;
        }
        else if (fraction2.contains("*")==false ||fraction2.contains("+")==false){//condition for division problem

            multidiv.division(num1,den1,num2,den2);//call division.
            newnum = multidiv.newnum;//retrieve result from the class
            newden = multidiv.newden;

        }

        System.out.println("Answer:" + newnum + "/" + newden);// display the original answer first

        if(newnum!=newden){ //show 1 if numerator = denominator
            redfom.reducefor(newnum, newden);///call simplification method
            newnum = redfom.newnum;//retrieve reduced result from class
            newden = redfom.newden;
            System.out.println("Reduced form:" + newnum + "/" + newden);//show the reduced result.
        }
        else{
            System.out.println("Reduced form: 1");//show the reduced result.
        }

    }
}
