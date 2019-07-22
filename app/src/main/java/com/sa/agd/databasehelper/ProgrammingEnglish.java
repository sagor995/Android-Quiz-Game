package com.sa.agd.databasehelper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagor Ahamed on 8/14/2017.
 */

public class ProgrammingEnglish {

    // declare list of Question objects
    List<Question> list = new ArrayList<>();
    MyDataBaseHelper progEngDataBaseHelper;


    public int getLength(){
        return list.size();
    }




    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }


    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num);
    }


    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }

    public String getHalfHelpLine(int a){return list.get(a).getHalfHelpLine();}
    public String getHintHelpLine(int a){return list.get(a).getHintHelpLine();}



    public void initProgrammingEnglishQuestions(Context context) {



        progEngDataBaseHelper = new MyDataBaseHelper(context);
        list = progEngDataBaseHelper.getAllProgEngQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {

            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("The format identifier ‘%i’ is also used for _____ data type?",
                    new String[]{ "char","int","float","double"}, "int","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which data type is most suitable for storing a number 65000 in a 32-bit system?",
                    new String[]{"short","int","long","double"}, "short","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("What is the size of an int data type?",
                    new String[]{"4 Bytes","8 Bytes","Depends on the system/compiler","Cannot be determined"}, "Depends on the system/compiler","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("#include is called",
                    new String[]{"Preprocessor directive","Inclusion directive","File inclusion directive","None of the mentioned"}, "Preprocessor directive","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("The function ____ obtains block of memory dynamically.",
                    new String[]{"calloc","malloc","Both A & B","free"}, "Both A & B","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("calloc() returns a storage that is initialized to.....",
                    new String[]{"Zero","Null","Nothing","One"}, "Zero","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("In function free(var), var is a:",
                    new String[]{"int","Pointer returned by malloc()","Pointer returned by calloc()","Both B & C"}, "Both B & C","D",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which one is used during memory deallocation in C?",
                    new String[]{"remove(p);","delete(p);","free(p);","terminate(p);"}, "free(p)","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of the following will return a result most quickly for searching a given key?",
                    new String[]{"Unsorted Array","Sorted Array","Sorted linked list","Binary Search Tree"}, "Binary Search Tree","D",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of the following is not a valid variable name declaration?",
                    new String[]{"int _x3;","int x_3;","int 6_x;","int _3x;"}, "int 6_x;","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("All keywords in C are in?",
                    new String[]{"Lower Case letters","Upper Case letters","Camel Case letters","None"}, "Lower Case letters","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of the following is not a valid C variable name?",
                    new String[]{"int number;","float rate;","int variable_count;","int $main;"}, "int $main;","D",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which is valid C expression?",
                    new String[]{ "int my_num = 100,000;","int my_num = 100000;","int my num = 1000;","int $my_num = 10000;"}, "int my_num = 100000;","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("The keyword ‘break’ cannot be simply used within:",
                    new String[]{"do-while","if-else","for","while"}, "if-else","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which keyword is used to come out of a loop only for that iteration?",
                    new String[]{ "break","continue","return","None of the mentioned"}, "continue","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("The following code ‘for(;;)’ represents an infinite loop. It can be terminated by.",
                    new String[]{"break","exit(0)","abort()","All of the mentioned"}, "break","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("How many kinds of classes are there in c++?",
                    new String[]{"1","2","3","4"}, "2","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which is used to define the member of a class externally?",
                    new String[]{ ":","::","#","none of the mentioned"}, "::","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("What is this operator called ?:  ?",
                    new String[]{ "conditional","relational","casting operator","none of the mentioned"}, "conditional","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Where does the execution of the program starts?",
                    new String[]{"user-defined function","main function","void function","none of the mentioned"}, "main function","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which is more effective while calling the functions?",
                    new String[]{ "call by value","call by reference","call by pointer","none of the mentioned"}, "call by reference","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of the following is a valid class declaration?",
                    new String[]{"class A { int x; };","class B { }","public class A { }","object A { int x; };"}, "class A { int x; };","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("The fields in the class in c++ program are by default",
                    new String[]{"protected","private","public","none of the mentioned"}, "private","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("What is the return type of constructors?",
                    new String[]{"int","float","void","None of the mentioned"}, "None of the mentioned","D",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which class is used to design the base class?",
                    new String[]{"abstract class","derived class","base class","None of the mentioned"}, "abstract class","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("How many minimum number of functions are need to be presented in c++?",
                    new String[]{"0","1","2","3"}, "1","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("How many ways of passing a parameter are there in c++?",
                    new String[]{"1","2","3","4"}, "3","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("How many sequence of statements are present in c++?",
                    new String[]{"4","3","5","6"}, "5","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("The switch statement is also called as?",
                    new String[]{"choosing structure","selective structure","certain structure","none of the mentioned"}, "selective structure","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("How many types of loops are there?",
                    new String[]{"4","2","3","1"}, "4","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("The destination statement for the goto label is identified by what label?",
                    new String[]{"$","@","*",":"}, ":","D",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which is used to keep the call by reference value as intact?",
                    new String[]{"static","const","absolute","none of the mentioned"}, "const","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("By default how the value are passed in c++?",
                    new String[]{ "call by value","call by reference","call by pointer","none of the mentioned"}, "call by value","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("How many types of returning values are present in c++?",
                    new String[]{ "1","2","3","4"}, "3","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of the following can derived class inherit?",
                    new String[]{"members","functions","both A & B","None of the mentioned"}, "both A & B","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Where does the return statement returns the execution of the program?",
                    new String[]{"main function","caller function","same function","none of the mentioned"}, "caller function","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("How many types of guarantees are there in exception class can have?",
                    new String[]{"1","2","3","4"}, "3","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("To which does the function pointer point to?",
                    new String[]{ "variable","constants","function","absolute variables"}, "function","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("What is the range of data type short in Java?",
                    new String[]{ "-128 to 127","-32768 to 32767","-2147483648 to 2147483647","None of the mentioned"}, "-32768 to 32767","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("What is the range of data type byte in Java?",
                    new String[]{ "-128 to 127","-32768 to 32767","-2147483648 to 2147483647","None of the mentioned"}, "-128 to 127","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of the following can be operands of arithmetic operators?",
                    new String[]{"Numeric","Boolean","Characters","Both B & C"}, "Both B & C","D",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Modulus operator, %, can be applied to which of these?",
                    new String[]{"Integers","Floating–point numbers","Both A and B","None of the mentioned"}, "Both A and B","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("When does Exceptions in Java arises in code sequence?",
                    new String[]{"Run Time","Compilation Time","Can Occur Any Time","None of the mentioned"}, "Run Time","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these keywords is not a part of exception handling?",
                    new String[]{"try","finally","thrown","catch"}, "thrown","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these keywords must be used to monitor for exceptions?",
                    new String[]{"try","finally","throw","catch"}, "try","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("On applying Left shift operator, <<, on an integer bits are lost one they are shifted past which position bit?",
                    new String[]{"1","32","33","31"}, "31","D",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("What is the output of relational operators?",
                    new String[]{"Integer","Boolean","Characters","Double"}, "Boolean","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these coding types is used for data type characters in Java?",
                    new String[]{"ASCII","ISO-LATIN-1","UNICODE","None of the mentioned"}, "UNICODE","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these have highest precedence?",
                    new String[]{"()","++","*",">>"}, "()","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these class is superclass of String and StringBuffer class?",
                    new String[]{"java.util","java.lang","ArrayList","None of the mentioned"}, "java.lang","B",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these operators can be used to concatenate two or more String objects?",
                    new String[]{"+","+=","&","||"}, "+","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these constructors is used to create an empty String object?",
                    new String[]{"String()","String(void)","String(0)","None of the mentioned"}, "String()","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these keywords is used to define interfaces in Java?",
                    new String[]{ "interface","Interface","intf","Intf"}, "interface","A",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these can be used to fully abstract a class from its implementation?",
                    new String[]{ "Objects","Packages","Interfaces","None of the Mentioned"}, "Interfaces","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these is specified by a File object?",
                    new String[]{ "a file in disk","directory path","directory in disk","None of the mentioned"}, "directory in disk","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these method waits for the thread to treminate?",
                    new String[]{ "sleep()","isAlive()","join()","stop()"}, "join()","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these method is used to explicitly set the priority of a thread?",
                    new String[]{ "set()","make()","setPriority()","makePriority()"}, "setPriority()","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these methods is used to compare a specific region inside a string with another specific region in another string?",
                    new String[]{ "regionMatch()","match()","RegionMatches()","regionMatches()"}, "regionMatches()","D",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these is a super class of all exceptional type classes?",
                    new String[]{ "String","RuntimeExceptions","Throwable","Cachable"}, "Throwable","C",""));
            progEngDataBaseHelper.addInitialProgEngQuestion(new Question("Which of these class is related to all the exceptions that cannot be caught?",
                    new String[]{"Error","Exception","RuntimeExecption","All of the mentioned"}, "Error","A",""));






            list = progEngDataBaseHelper.getAllProgEngQuestionsList();//get list from database again

        }
    }
}
