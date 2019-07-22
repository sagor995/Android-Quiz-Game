package com.sa.agd.databasehelper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagor Ahamed on 8/14/2017.
 */

public class ProgrammingBangla {

    // declare list of Question objects
    List<Question> list = new ArrayList<>();
    MyDataBaseHelper progBanDataBaseHelper;


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



    public void initProgrammingBanglaQuestions(Context context) {



        progBanDataBaseHelper = new MyDataBaseHelper(context);
        list = progBanDataBaseHelper.getAllProgBanQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {

            progBanDataBaseHelper.addInitialProgBanQuestion(new Question(" % i _____ কোন ডেটা টাইপের জন্য ব্যবহৃত হয়?",
                    new String[]{ "char","int","float","double"}, "int","B",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("32-বিট সিস্টেমে কোন ডাটাটাইপ ৬৫০০০ সংখ্যা সংরক্ষণের জন্য সবচেয়ে বেশি উপযুক্ত?",
                    new String[]{"short","int","long","double"}, "short","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("একটি int ডাটা টাইপের সাইজ কি?",
                    new String[]{"৪ বাইটস","৮ বাইটস", "সিস্টেম / কম্পাইলারের উপর নির্ভর করে","নির্ধারণ করা যাবে না"}, "সিস্টেম / কম্পাইলারের উপর নির্ভর করে","C",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("#include কে বলা হয় ?",
                    new String[]{"Preprocessor directive","Inclusion directive","File inclusion directive","কোনটি না"}, "Preprocessor directive","A",""));
           /* progBanDataBaseHelper.addInitialProgBanQuestion(new Question("The function ____ obtains block of memory dynamically.",
                    new String[]{"calloc","malloc","Both A & B","free"}, "Both A & B","C",""));*/
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("Calloc () একটি স্টোরেজ রিটার্ন করে যা শুরু হয় ..... দিয়ে।",
                    new String[]{"শূন্য","নাল","কিছুই না","এক"}, "শূন্য","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("ফাংশন free(var), এখানে var হল:",
                    new String[]{"int","Pointer returned by malloc()","Pointer returned by calloc()","B & C দুটোই"}, "B & C দুটোই","D",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("সি তে একটি মেমরি deallocation এর সময় কোনটি ব্যবহার করা হয়?",
                    new String[]{"remove(p);","delete(p);","free(p);","terminate(p);"}, "free(p)","C",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("নিম্নলিখিতগুলির মধ্যে কোনটি  একটি Key অনুসন্ধানের জন্য সবচেয়ে দ্রুত ফলাফল ফেরত দেবে?",
                    new String[]{"Unsorted Array","Sorted Array","Sorted linked list","Binary Search Tree"}, "Binary Search Tree","D",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("নিম্নলিখিত কোনটি বৈধ ভ্যারিয়েবল নাম নয়?",
                    new String[]{"int _x3;","int x_3;","int 6_x;","int _3x;"}, "int 6_x;","C",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("সি তে সব কিওয়ার্ড ?",
                    new String[]{"ছোট হাতের অক্ষর","বড় হাতের অক্ষর","উটের পিঠের ন্যায় অক্ষর","কোনটি না"}, "Lower Case letters","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("নিম্নলিখিত কোনটি বৈধ সি ভ্যারিয়েবল নাম নয়?",
                    new String[]{"int number;","float rate;","int variable_count;","int $main;"}, "int $main;","D",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("কোনটি বৈধ সি এক্সপ্রেশন??",
                    new String[]{ "int my_num = 100,000;","int my_num = 100000;","int my num = 1000;","int $my_num = 10000;"}, "int my_num = 100000;","B",""));
            /*progBanDataBaseHelper.addInitialProgBanQuestion(new Question("কীওয়ার্ড 'break' কেবল ব্যবহার করা যাবে নাThe keyword ‘break’ cannot be simply used within:",
                    new String[]{"do-while","if-else","for","while"}, "if-else","B",""));*/
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("কোন কীওয়ার্ড লুপের বাইরে আসতে ব্যবহৃত হয় শুধুমাত্র ওই পুনরাবৃত্তির জন্য ?",
                    new String[]{ "break","continue","return","কোনটি না"}, "continue","B",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("এই কোডটি দ্বারা for(;;) অসীম লুপ বোঝানো হয়। এটি বাতিল করা যেতে পারে .........দ্বারা।",
                    new String[]{"break","exit(0)","abort()","সবগুলো"}, "break","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("C ++ এ কতগুলি ক্লাস আছে ?",
                    new String[]{"১","২","৩","৪"}, "২","B",""));
            /*progBanDataBaseHelper.addInitialProgBanQuestion(new Question("Which is used to define the member of a class externally?",
                    new String[]{ ":","::","#","কোনটি না"}, "::","B",""));*/
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("এই অপারেটরকে কি বলা হয় ?:  ?",
                    new String[]{ "conditional","relational","casting operator","কোনটি না"}, "conditional","A",""));
            /*progBanDataBaseHelper.addInitialProgBanQuestion(new Question("Where does the execution of the program starts?",
                    new String[]{"user-defined function","main function","void function","কোনটি না"}, "main function","B",""));*/
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("ফাংশন কল করার সময় কোনটি অধিক কার্যকর?",
                    new String[]{ "call by value","call by reference","call by pointer","কোনটি না"}, "call by reference","B",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("নিম্নলিখিত কোনটি একটি সঠিক ক্লাস লেখার নিয়ম ?",
                    new String[]{"class A { int x; };","class B { }","public class A { }","object A { int x; };"}, "class A { int x; };","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("C ++ প্রোগ্রামে ফিল্ড গুলো ডিফল্টভাবে ......... হয়",
                    new String[]{"protected","private","public","কোনটি না"}, "private","B",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("কন্সট্রাকটরগুলির রিটার্ন টাইপ কি?",
                    new String[]{"int","float","void","কোনটি না"}, "কোনটি না","D",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("কোন ক্লাসটি বেস ক্লাস ডিজাইনের জন্য ব্যাবহার করা হয়?",
                    new String[]{"abstract class","derived class","base class","কোনটি না"}, "abstract class","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("C ++ এ কত কম সংখ্যক ফাংশন উপস্থিত থাকর প্রয়োজন?",
                    new String[]{"০","১","২","৩"}, "১","B",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("একটি প্যারামিটার পাস করার কত উপায় আছে আছে c ++?",
                    new String[]{"১","২","৩","৪"}, "৩","C",""));
            /*progBanDataBaseHelper.addInitialProgBanQuestion(new Question("C ++ এ কতগুলি বিবৃতির ক্রম উপস্থিত রয়েছে? How many sequence of statements are present in c++?",
                    new String[]{"4","3","5","6"}, "5","C",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("সুইচ স্টেটমেন্টকে The switch statement is also called as?",
                    new String[]{"choosing structure","selective structure","certain structure","কোনটি না"}, "selective structure","B",""));*/
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("কতগুলি লুপ আছে?",
                    new String[]{"৪","২","৩","১"}, "৪","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("goto লেবেলের জন্য গন্তব্য বিবৃতি কোন লেবেল দ্বারা চিহ্নিত করা হয়?",
                    new String[]{"$","@","*",":"}, ":","D",""));
            /*progBanDataBaseHelper.addInitialProgBanQuestion(new Question("Which is used to keep the call by reference value as intact?",
                    new String[]{"static","const","absolute","কোনটি না"}, "const","B",""));*/
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("ডিফল্টভাবে কিভাবে c ++ এর মধ্যে মান পাস করা হয়?",
                    new String[]{ "call by value","call by reference","call by pointer","কোনটি না"}, "call by value","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("C ++ এর মধ্যে কত ধরনের রিটার্নিং মান আছে?",
                    new String[]{ "১","২","৩","৪"}, "৩","C",""));
            /*progBanDataBaseHelper.addInitialProgBanQuestion(new Question("Which of the following can derived class inherit?",
                    new String[]{"members","functions","both A & B","কোনটি না"}, "both A & B","C",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("Where does the return statement returns the execution of the program?",
                    new String[]{"main function","caller function","same function","কোনটি না"}, "caller function","B",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("How many types of guarantees are there in exception class can have?",
                    new String[]{"1","2","3","4"}, "3","C",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("To which does the function pointer point to?",
                    new String[]{ "variable","constants","function","absolute variables"}, "function","C",""));*/
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("জাভাতে ডাটা টাইপ শর্ট এর পরিসীমা কি?",
                    new String[]{ "-১২৮ থেকে ১২৭","-৩২৭৬৮ থেকে ৩২৭৬৭","-২১৪৭৪৮৩৬৪৮ থেকে ২১৪৭৪৮৩৬৪৭","কোনটি না"}, "-৩২৭৬৮ থেকে ৩২৭৬৭","B",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("জাভাতে ডাটা টাইপ বাইটের পরিসীমা কি?",
                    new String[]{ "-১২৮ থেকে ১২৭","-৩২৭৬৮ থেকে ৩২৭৬৭","-২১৪৭৪৮৩৬৪৮ থেকে ২১৪৭৪৮৩৬৪৭","কোনটি না"}, "-১২৮ থেকে ১২৭","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("নিম্নলিখিত কোনটি অ্যারিথমেটিক অপারেটরের অপারেন্ডস হতে পারে?",
                    new String[]{"Numeric","Boolean","Characters","Both B & C"}, "Both B & C","D",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("মডুলাস অপারেটর,%, এইগুলির মধ্যে কোনটিতে প্রয়োগ করা যায়?",
                    new String[]{"Integers","Floating–point numbers","Both A and B","কোনটি না"}, "Both A and B","C",""));
            /*progBanDataBaseHelper.addInitialProgBanQuestion(new Question("When does Exceptions in Java arises in code sequence?",
                    new String[]{"Run Time","Compilation Time","Can Occur Any Time","কোনটি না"}, "Run Time","A",""));*/
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("নিচের কোন কীওয়ার্ডটি এক্সেপশন হ্যান্ডলিং এর অংশ নয় ?",
                    new String[]{"try","finally","thrown","catch"}, "thrown","C",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("এক্সেপশন নিরীক্ষণ করতে নিচের কোন কীওয়ার্ডটি ব্যাবহার করা আবশ্যক ?",
                    new String[]{"try","finally","throw","catch"}, "try","A",""));
            /*progBanDataBaseHelper.addInitialProgBanQuestion(new Question("On applying Left shift operator, <<, on an integer bits are lost one they are shifted past which position bit?",
                    new String[]{"1","32","33","31"}, "31","D",""));*/
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("রিলেশনাল অপারেটরগুলির আউটপুট কি??",
                    new String[]{"Integer","Boolean","Characters","Double"}, "Boolean","B",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("ডাটা টাইপ অক্ষরের জন্য কোনটি কোডিং প্রকার ব্যবহৃত হয় জাভাতে?",
                    new String[]{"ASCII","ISO-LATIN-1","UNICODE","কোনটি না"}, "UNICODE","C",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("নিচের কোনটির অগ্রাধিকার সর্বোচ্চ",
                    new String[]{"()","++","*",">>"}, "()","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("কোন ক্লাসটি স্ট্রিং এবং স্ট্রিংবাফার ক্লাসের সুপারক্লাস?",
                    new String[]{"java.util","java.lang","ArrayList","কোনটি না"}, "java.lang","B",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("এই অপারেটরগুলির মধ্যে কোনটির সাহায্যে দুই বা ততোধিক স্ট্রিং অবজেক্ট সংযুক্ত করা যায়?",
                    new String[]{"+","+=","&","||"}, "+","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("এই কন্সট্রাকটরগুলির মধ্যে কোনটি একটি ফাঁকা স্ট্রিং অবজেক্ট তৈরি করতে ব্যবহৃত হয়?",
                    new String[]{"String()","String(void)","String(0)","কোনটি না"}, "String()","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("এই কীওয়ার্ডগুলির মধ্যে কোনটি জাভাতে ইন্টারফেস নির্ধারণ করতে ব্যবহৃত হয়?",
                    new String[]{ "interface","Interface","intf","Intf"}, "interface","A",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("নিচের কোনটি ব্যাবহার করা যেতে পারে একটা ক্লাসকে সম্পূর্ণরুপে Abstract ক্লাসে রুপান্তরের জন্য শুরু থেকে?",
                    new String[]{ "Objects","Packages","Interfaces","কোনটি না"}, "Interfaces","C",""));
            /*progBanDataBaseHelper.addInitialProgBanQuestion(new Question("Which of these is specified by a File object?",
                    new String[]{ "a file in disk","directory path","directory in disk","কোনটি না"}, "directory in disk","C",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question(" থ্রেড বন্ধ হওয়ার জন্য কোন মেথডটি অপেক্ষা করে ?",
                    new String[]{ "sleep()","isAlive()","join()","stop()"}, "join()","C",""));*/
            /*progBanDataBaseHelper.addInitialProgBanQuestion(new Question("Which of these method is used to explicitly set the priority of a thread?",
                    new String[]{ "set()","make()","setPriority()","makePriority()"}, "setPriority()","C",""));*/
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("নিচের কোন মেথডটি ব্যাবহার করা হয় একটি স্ট্রিং ভিতরে একটি নির্দিষ্ট অংশের সাথে অন্য একটি স্ট্রিং এর নির্দিষ্ট অংশ তুলনা করার জন্য ?",
                    new String[]{ "regionMatch()","match()","RegionMatches()","regionMatches()"}, "regionMatches()","D",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("নিচের কোনটি ক্লাসটি সুপার ক্লাস সব এক্সপোনেনশিয়াল টাইপ ক্লাসের?",
                    new String[]{ "String","RuntimeExceptions","Throwable","Cachable"}, "Throwable","C",""));
            progBanDataBaseHelper.addInitialProgBanQuestion(new Question("নিচের কোন ক্লাস  সব এক্সেপশনের সাথে সম্পর্কিত, যা ধরা যায় না?",
                    new String[]{"Error","Exception","RuntimeExecption","সবগুলো"}, "Error","A",""));



            list = progBanDataBaseHelper.getAllProgBanQuestionsList();//get list from database again

        }
    }
}
