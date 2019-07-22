package com.sa.agd.databasehelper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagor Ahamed on 8/14/2017.
 */

public class PhysicsBangla {
    // declare list of Question objects
    List<Question> list = new ArrayList<>();
    MyDataBaseHelper phyBanDataBaseHelper;


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



    public void initPhysicsBanglaQuestions(Context context) {



        phyBanDataBaseHelper = new MyDataBaseHelper(context);
        list = phyBanDataBaseHelper.getAllPhyBanQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {

            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("নিউক্লিয়ার সাইজের ইউনিট কি?",
                    new String[]{ "ফার্মি","অ্যাংস্ট্রম","নিউটন","টেসলা"}, "ফার্মি","A","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("আলোক বর্ষের ইউনিট কি ?",
                    new String[]{ "সময়","দুরুত্ত","আলো","আলো এর তীব্রতা"}, "দুরুত্ত","B","এটা হয়ত OptionC"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question(" সূর্য থেকে  আমাদের কাছে আলো পৌঁছেতে সময় লাগে ...",
                    new String[]{"২ মিনিট","৪ মিনিট", "৮ মিনিট","১৬ মিনিট"}, "৮ মিনিট","C","এটা হয়ত OptionB"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question(" প্যাসকেলের ইউনিট হল",
                    new String[]{"তরঙ্গ","চাপ","ফ্রিকোয়েন্সি","পরিবাহিতা"}, "চাপ","B","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question(" লোহা / ধাতু বিদ্যুতের ভাল পরিবাহী কারন হল ...",
                    new String[]{"ফ্রী  ইলেকট্রন থাকে","উচ্চ গলনাঙ্ক আছে","কোনটি না","উপরের সবগুলি"}, "ফ্রী  ইলেকট্রন থাকে","A","এটা হয়ত OptionB"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("রেকটিফায়ার কি রূপান্তরে ব্যাবহার করা হয়? ",
                    new String[]{"ডিসি থেকে এসি","এসি থেকে ডিসি","উচ্চ ভোল্ট থেক কম ভোল্ট","কম ভোল্ট থেকে  উচ্চ ভোল্ট"}, "এসি থেকে ডিসি","B","এটা হয়ত OptionB"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("বাতাসে শব্দ তরঙ্গ হল",
                    new String[]{"অনুপ্রস্থ","অনুদৈর্ঘ্য","ইলেক্ট্রোম্যাগনেটিক","সমবর্তিত"}, "অনুদৈর্ঘ্য","B","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("একটি বার চুম্বকের কেন্দ্রে চুম্বকত্ব হল",
                    new String[]{"সর্বনিম্ন","সর্বাধিক","শূন্য","সর্বনিম্ন বা সর্বোচ্চ"}, "শূন্য","C","এটা হয়ত OptionC"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("একটি তরঙ্গের নিম্নলিখিত বৈশিষ্ট্যের মধ্যে কোনটি স্বাধীন অন্যগুলো থেকে ...",
                    new String[]{"প্রশস্ততা","বেগ","তরঙ্গদৈর্ঘ্য","ফ্রিকোয়েন্সি"}, "প্রশস্ততা","A","এটা হয়ত OptionB"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("২০ হার্জ ফ্রিকোয়েন্সির নিচের শব্দকে বলা হয়",
                    new String[]{"অডিও শব্দসমূহ","অবশ্রব্য","অতিস্বনক","সুপারসনিকস"}, "অবশ্রব্য","B","এটা হয়ত OptionC"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("জড়তার ভ্রামক হল ",
                    new String[]{"ভেক্টর","স্কেলার","phasor","টেন্সর"}, "টেন্সর","D","এটা হয়ত OptionB"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("এক হাজার মাইক্রন সমান",
                    new String[]{"১০-^৩মি.","১০-^৬মি.","১০-^৯মি.","১০-^১২মি."}, "১০-^৩মি.","A","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("শব্দ কোন মাধ্যমে দ্রুততম গতিতে ভ্রমণ করে",
                    new String[]{"ইস্পাত","পানি","বায়ু","ভ্যাকুয়াম"}, "ইস্পাত","A","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("আলো কোন মাধ্যমে দ্রুততম গতিতে ভ্রমণ করে",
                    new String[]{"গ্লাস","পানি","হাইড্রোজেন","ভ্যাকুয়াম"}, "ভ্যাকুয়াম","D","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("লাইট এমিটিং ডায়োড (LED) অভিনব ইলেকট্রনিক ডিভাইসগুলিতে ব্যবহৃত হয়",
                    new String[]{"এক্স-রে","অতিবেগুনী আলো","দৃশ্যমান আলো","রেডিও তরঙ্গ"}, "দৃশ্যমান আলো","C","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("অপটিক্যাল ফাইবার কাজ করে",
                    new String[]{"প্রতিসরণের নীতির উপর","মোট অভ্যন্তরীণ প্রতিফলনের উপর","বিক্ষিপ্ত","ব্যতিচার"}, "মোট অভ্যন্তরীণ প্রতিফলনের উপর","B","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("সুপারসনিক বিমান ...... গতির সাথে উড়ে",
                    new String[]{"শব্দের গতি থেকে কম","শব্দের","শব্দের গতি থেকে বেশী","আলোর"}, "শব্দের গতি থেকে বেশী","C","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("এক ওয়াট-ঘন্টা সমতুল্য",
                    new String[]{"৬.৩ x ১০^৩ জুল","৬.৩ এক্স ১০-^৭ জুল","৩.৬ x ১০^৩ জুল","৩.৬ x ১০-^৩ জুল"}, "৩.৬ x ১০^৩ জুল","C","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("রেডিও কার্বন ডেটিং কৌশলটি ব্যবহার করে বয়স হিসেব করা হয়",
                    new String[]{"শিলা","স্মৃতিস্তম্ভ","মাটি","জীবাশ্ম"}, "জীবাশ্ম","D","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("নীচের থেকে ভেক্টরটি রাশি চিহ্নিত করুন",
                    new String[]{"তাপ","কৌণিক ভরবেগ","টাইম","কাজ"}, "কৌণিক ভরবেগ","B","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("এক ন্যানোমিটার সমান",
                    new String[]{"১০-^৬মি.","১০-^৮মি.","১০-^৯মি.","১০-^৫মি." }, "১০-^৯মি.","C","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("নূন্যতম সংখ্যক অসম ভেক্টর যা শূন্য ফলাফল দিতে পারে",
                    new String[]{"দুই","তিন","চার","চার থেকে অধিক"}, "তিন","B","এটা হয়ত OptionA"));
            phyBanDataBaseHelper.addInitialPhyBanQuestion(new Question("শব্দ তীব্রতার আছে",
                    new String[]{"একটি বস্তু অস্তিত্ব","একটি বিষয় অস্তিত্ব","অস্তিত্ব নেই","উভয় ক এবং খ "}, "একটি বস্তু অস্তিত্ব","A","এটা হয়ত OptionA"));



            list = phyBanDataBaseHelper.getAllPhyBanQuestionsList();//get list from database again

        }
    }

}
