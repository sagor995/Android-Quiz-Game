package com.sa.agd.databasehelper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagor Ahamed on 8/17/2017.
 */

public class RandomBangla {

    // declare list of Question objects
    List<Question> list = new ArrayList<>();
    MyDataBaseHelper randBanDataBaseHelper;


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



    public void initRandomBanlishQuestions(Context context) {



        randBanDataBaseHelper = new MyDataBaseHelper(context);
        list = randBanDataBaseHelper.getAllRandBanQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {

            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("% i _____ কোন ডেটা টাইপের জন্য ব্যবহৃত হয়?",
                    new String[]{"char","int","float","double"}, "int","B",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("একটি int ডাটা টাইপের সাইজ কি?",
                    new String[]{"৪ বাইটস","৮ বাইটস", "সিস্টেম / কম্পাইলারের উপর নির্ভর করে","নির্ধারণ করা যাবে না"}, "সিস্টেম / কম্পাইলারের উপর নির্ভর করে","C",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("কোনটি বৈধ সি এক্সপ্রেশন??",
                    new String[]{"int my_num = 100,000;","int my_num = 100000;","int my num = 1000;","int $my_num = 10000;"}, "int my_num = 100000;","B",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("ফাংশন কল করার সময় কোনটি অধিক কার্যকর?",
                    new String[]{"call by value","call by reference","call by pointer","কোনটি না"}, "call by reference","B",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("এই কীওয়ার্ডগুলির মধ্যে কোনটি জাভাতে ইন্টারফেস নির্ধারণ করতে ব্যবহৃত হয়?",
                    new String[]{"interface","Interface","intf","Intf"}, "interface","A",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("জাভাতে ডাটা টাইপ বাইটের পরিসীমা কি?",
                    new String[]{"-১২৮ থেকে ১২৭","-৩২৭৬৮ থেকে ৩২৭৬৭","-২১৪৭৪৮৩৬৪৮ থেকে ২১৪৭৪৮৩৬৪৭","কোনটি না"}, "-১২৮ থেকে ১২৭","A",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("আলোক বর্ষের ইউনিট কি ?",
                    new String[]{ "সময়","দুরুত্ত","আলো","আলো এর তীব্রতা"}, "দুরুত্ত","B","এটা হয়ত OptionC"));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question(" লোহা / ধাতু বিদ্যুতের ভাল পরিবাহী কারন হল ...",
                    new String[]{"ফ্রী  ইলেকট্রন থাকে","উচ্চ গলনাঙ্ক আছে","কোনটি না","উপরের সবগুলি"}, "ফ্রী  ইলেকট্রন থাকে","A","এটা হয়ত OptionB"));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("শব্দ কোন মাধ্যমে দ্রুততম গতিতে ভ্রমণ করে",
                    new String[]{"ইস্পাত","পানি","বায়ু","ভ্যাকুয়াম"}, "ইস্পাত","A","এটা হয়ত OptionA"));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("এক ওয়াট-ঘন্টা সমতুল্য",
                    new String[]{"৬.৩ x ১০^৩ জুল","৬.৩ এক্স ১০-^৭ জুল","৩.৬ x ১০^৩ জুল","৩.৬ x ১০-^৩ জুল"}, " ৩.৬ x ১০^৩ জুল","C","এটা হয়ত OptionA"));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("এক ন্যানোমিটার সমান",
                    new String[]{"১০-^৬মি.","১০-^৮মি.","১০-^৯মি.","১০-^৫মি." }, "১০-^৯মি.","C","এটা হয়ত OptionA"));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question(" ধনাত্মক পূর্ণসংখ্যার সেট _________ ।",
                    new String[]{"অসীম","সসীম","সাবসেট","খালি"}, "অসীম","A",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("৪৫×১৫ ফিট হলের মেঝে মেরামতের জন্য ৪৫৭০৳ ব্যয় করা হয়েছে এর মেঝে মেরামত খরচ হয়। প্রতি বর্গ ফুটে  মেরামতের খরচ কত?",
                    new String[]{"৫.২৭৳","৬.৭৭৳","৮.৪৮৳","৭.১০৳"}, "৬.৭৭৳","B",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("২৭৪৪ এর ঘনমূল হল",
                    new String[]{ "১১","১৩","১৪","১৭"}, "১৪","C",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("ওমেগা এর প্রতীক কি?",
                    new String[]{"€","π","Ω","∞"}, "Ω","C",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("সিলিন্ডারের আয়তন ৭০০সেমি^২ হলে, এবং ১৫সেমি এর উচ্চতা হলে,  সিলিন্ডারটির ব্যাস হল-",
                    new String[]{"২৪সেমি^২","৭.৭১সেমি^২","৯.৫৭সেমি^২","১২.২৩সেমি^২"}, "৭.৭১সেমি^২","B",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question(" \"ওএস\" কম্পিউটার সংক্ষেপ সাধারণত মানে হল",
                    new String[]{"ওপেন সফটওয়্যার","অপারেটিং সিস্টেম","অপটিক্যাল সেন্সর","অর্ডার অফ সিগনিফিকেন্স"}, "অপারেটিং সিস্টেম","B",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("\".MOV\" এক্সটেনশনটি সাধারণত কোন ধরণের ফাইলের জন্য?",
                    new String[]{"ইমেজ ফাইল", "অ্যানিমেশন / মুভি ফাইল", "অডিও ফাইল", "এমএস অফিস ডকুমেন্ট"}, "অ্যানিমেশন / মুভি ফাইল","B",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("\".TMP\" এক্সটেনশনটি সাধারণত কোন ধরণের ফাইলের জন্য?",
                    new String[]{"কম্প্রেসেড আর্কাইভ ফাইল", "ইমেজ ফাইল", "টেম্পোরারি ফাইল", "অডিও ফাইল"}, "টেম্পোরারি ফাইল","",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("\".JPG\" এক্সটেনশনটি সাধারণত কোন ধরণের ফাইলের জন্য?",
                    new String[]{"সিস্টেম ফাইল", "অ্যানিমেশন / মুভি ফাইল", "এমস এনকার্টা ডকুমেন্ট", "ইমেজ ফাইল"}, "ইমেজ ফাইল","D",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("\".TXT\" এক্সটেনশনটি সাধারণত কোন ধরণের ফাইলের জন্য?",
                    new String[]{"টেক্সট ফাইল", "ইমেজ ফাইল", "অডিও ফাইল", "অ্যাডোবি অ্যাক্রোব্যাট ফাইল"}, "টেক্সট ফাইল","A",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("নিম্নলিখিত কোনটিতে পেন্সিল ব্যবহার করা হয়?",
                    new String[]{"গ্রাফাইট","সিলিকন","কাঠকয়লা","ফসফরাস"}, "গ্রাফাইট","A",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("মানুষের রক্তের প্রধান বাফার সিস্টেম হল",
                    new String[]{"H2CO3 - HCO3","H2CO3 - CO32-","CH3COOH - CH3COO-","NH2CONH2 - NH2CONH+"}, "H2CO3 - HCO3","A",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("বায়ুমণ্ডলে সবচেয়ে বেশি বিরল গ্যাস হল",
                    new String[]{"হিলিয়াম", "জেনন", "নিয়ম", "আর্গন"}, "আর্গন","",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("মানুষ দ্বারা ব্যবহৃত প্রথম ধাতু ছিল",
                    new String[]{"লোহা","তামা","স্বর্ণ","ব্রোঞ্জ"}, "তামা","B",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("অ্যালুমিনিয়াম সবচেয়ে গুরুত্বপূর্ণ আকরিক ",
                    new String[]{"বক্সাইট","ম্যাগনেটাইট","মূল্যবান্ আকরিক লৌহবিশেষ","মোনাজাইট"}, "বক্সাইট","A",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("\"FET\" ট্রানজিস্টর এক প্রকার, তার পুরো নাম হল ________ ইফেক্ট ট্রানজিস্টার ...?",
                    new String[]{"ফিল্ড", "ফ্যাক্টর", "ফ্ল্যাশ", "ফোর্স"}, "ফিল্ড","A",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("কমপ্যাক্ট ডিস্ক, (মূল সিডি স্পেসিফিকেশনের মতে) সঙ্গীত কত মিনিট ধরে রাখে?",
                    new String[]{"৭৪ মিনিট", "৫৬ মিনিট", "৬০ মিনিট", "৯০ মিনিট"}, "৭৪ মিনিট","A",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("\"সিডি\" কম্পিউটার সংক্ষেপ সাধারণত মানে?",
                    new String[]{"কমান্ড ডেসক্রিপশন", "চেঞ্জ ডাটা", "কপি ডেনসিটি", "কমপ্যাক্ট ডিস্ক"}, "কমপ্যাক্ট ডিস্ক","D",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("\".BAK\" এক্সটেনশনটি সাধারণত কোন ধরণের ফাইলের জন্য?",
                    new String[]{"ব্যাকআপ ফাইল", "অডিও ফাইল", "অ্যানিমেশন / মুভি ফাইল", "এমস এনকার্টা ডকুমেন্ট"}, "ব্যাকআপ ফাইল","A",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("\".BAT\" এক্সটেনশনটি সাধারণত কোন ধরণের ফাইলের জন্য?",
                    new String[]{"কম্প্রেসেড আর্কাইভ ফাইল", "সিস্টেম ফাইল", "অডিও ফাইল", "ব্যাকআপ ফাইল"}, "সিস্টেম ফাইল","B",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("\"ডিবি\" কম্পিউটার সংক্ষেপ সাধারণত মানে?",
                    new String[]{"ডাটাবেস", "ডাবল বাইট", "ডেটা ব্লক", "ড্রাইভার বুট"}, "ডাটাবেস","A",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("গ্যালিলিও কি আবিষ্কার করেছেন?",
                    new String[]{"ব্যারোমিটার","ট্রেন্ডলুম ঘড়ি","মাইক্রোস্কোপ","থার্মোমিটার"}, "থার্মোমিটার","D",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("কি অনুসন্ধান এটি পরীক্ষা যখন অনেক মৃত্যুর ঘটাচ্ছে?",
                    new String[]{"ডিনামাইট","মই","একটি রেস কার","প্যারাশুট"}, "প্যারাশুট","D",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("গ্র্যামোফোন কে আবিষ্কার করেছেন?",
                    new String[]{"মাইকেল ফ্যারাডে","তাপমান যন্ত্রবিশেষ","স্যার আলেকজান্ডার গ্রাহাম বেল","টমাস আলভা এডিসন"}, "টমাস আলভা এডিসন","D",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("Yo-yo কোথায় উদ্ভাবিত হয়েছিল?",
                    new String[]{"ফ্রান্স","যুক্তরাষ্ট্র","ফিলিপাইন","ইংল্যান্ড"}, "ফিলিপাইন","C",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("'কে ইলেকট্রিক জেনারেটর আবিষ্কার করলেন?",
                    new String[]{"স্যার আলেকজান্ডার গ্রাহাম বেল","মাইকেল ফ্যারাডে","আলফ্রেড বি নোবেল","টমাস আলভা এডিসন"}, "মাইকেল ফ্যারাডে","C",""));
            randBanDataBaseHelper.addInitialRandBanQuestion(new Question("ডায়নামাইট কে আবিষ্কার করেছেন?",
                    new String[]{"স্যার আলেকজান্ডার গ্রাহাম বেল","বেঞ্জামিন ফ্রাঙ্কলিন","টমাস আলভা এডিসন","আলফ্রেড বি নোবেল"}, "আলফ্রেড বি নোবেল","D",""));



            list = randBanDataBaseHelper.getAllRandBanQuestionsList();//get list from database again

        }
    }
}
