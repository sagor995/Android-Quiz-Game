package com.sa.agd.databasehelper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagor Ahamed on 8/14/2017.
 */

public class MathBangla {

    // declare list of Question objects
    List<Question> list = new ArrayList<>();
    MyDataBaseHelper mathBanDataBaseHelper;


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



    public void initMathBanglaQuestions(Context context) {



        mathBanDataBaseHelper = new MyDataBaseHelper(context);
        list = mathBanDataBaseHelper.getAllMathBanQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {

            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question(" ধনাত্মক পূর্ণসংখ্যার সেট _________ ।",
                    new String[]{"অসীম","সসীম","সাবসেট","খালি"}, "অসীম","A",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("x + x (xx) এর মান, যখন x = ২ হয়: ",
                    new String[]{"১০","১৮","১৪","৬৪"}, "১৪","C",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("সমীকরণ ৬a = ৫ - ৯a সমাধান করলে, a এর  মান হবে,",
                    new String[]{"১/৩","১/৫","২/৫","১/২"}, "১/৩","A",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("সমীকরণ c^৩-৩৪৩ = 0 সমাধান করলে, 'c' এর মান হবে",
                    new String[]{"১০","১৫","৭","৫"}, "৭","C",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("যদি সিলিন্ডারের ব্যাস ৬সেমি হয় এবং তার উচ্চতা ১২ সেমি হয় তাহলে সিলিন্ডারের আয়তন হবে, ",
                    new String[]{"৮০৪.৩৫২সেমি^৩","৪৫২.৬সেমি^৩","৩৩৯.২৯সেমি^৩","২৫২.২সেমি^৩"}, "৩৩৯.২৯সেমি^৩","C",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("সিলিন্ডারের আয়তন ৭০০সেমি^২ হলে, এবং ১৫সেমি এর উচ্চতা হলে,  সিলিন্ডারটির ব্যাস হল-",
                    new String[]{"২৪সেমি^২","৭.৭১সেমি^২","৯.৫৭সেমি^২","১২.২৩সেমি^২"}, "৭.৭১সেমি^২","B",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("যদি একটি সিলিন্ডারের ব্যাস ৫সেমি হয় এবং সিলিন্ডারের ভলিউম ৪০০সেমি^৩ হয় তাহলে সিলিন্ডার উচ্চতা- ",
                    new String[]{"৪০সেমি।","২৫সেমি।","৩৩সেমি।","২০সেমি।"}, "২০সেমি।","D",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("যদি একটা হ্যান্ডব্যাগের মূল্য হয় ১৫০৳ এবং এটি বিক্রি হয় ৯০৳ তাহলে ডিসকাউন্টের পরিমান কত ?",
                    new String[]{"৪০%","৩০%","৩৫%","২৫%"}, "৪০%","A",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("নিম্নলিখিত মূলদ সংখ্যা গুলো, ৬/৯, ৮/১২ এবং ৭/১৫ বিয়োগ করলে, উত্তর হবে",
                    new String[]{"২৪/৪৫","২১/৪৫","২২/৪৫","২৩/৪৫"}, "২১/৪৫","B",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("দশমিকের মধ্যে ৬ এর ঘন মূল হল",
                    new String[]{"১.৮১","২.০৮","৩.০৮","৪.৫"}, "১.৮১","A",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("সূত্র ১⁄w = ১⁄x + ১⁄y + ১⁄z বিবেচনা করে,  যদি x = ১০, y = ২০, এবং z = ১৫ হয় তাহলে,  ১/w এর মান হবে-",
                    new String[]{"১৩/৫০","১৩/৬০","৫০/১৩","৬০/১৩"}, "১৩/৬০","B",""));
            /*mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("সূত্র a = bc + cd + f + g⁄bcd বিবেচনা করে, যদি b = ২, c = ৩, d = -৩, f = ১, g = -২ হয় তাহলে, 'a' এর মান হবে",
                    new String[]{"৪/৯","২/৯","২/৭","১/৪"}, "২/৯","B",""));*/
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("ওমেগা এর প্রতীক কি?",
                    new String[]{"€","π","Ω","∞"}, "Ω","C",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("সরল করুন: ১৮০ ÷ (৫ + ৫ x ৮) - ৪ ",
                    new String[]{"২","৫","০","৬" }, "০","C",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("বৃহত্তম দুটি সংখ্যার  মৌলিক সংখ্যা কি?",
                    new String[]{ "৯৬","৯৭","৯৮","৯৯"}, "৯৭","B",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("১৮, ১৭, ১৯, ১৬ ও ২১ এর গড় মান কত?",
                    new String[]{ "২০","২১.৫","১৮.২","১৯.৪" }, "১৮.২","C",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("১০৫ মিনিটে কত ঘন্টা?",
                    new String[]{ "১.৫ ঘন্টা","১.৩০ ঘন্টা","১.৭৫ ঘন্টা","১.৮ ঘন্টা" }, "১.৭৫ ঘন্টা","C",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("১০^-২ মানে",
                    new String[]{"মিলি","সেন্টি","মাইক্রো","ডেসি"}, "মিলি","A",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("২১৯৭ এর ঘনমূল হল",
                    new String[]{ "১১","১৩","১৯","১৭"}, "১৩","B",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("প্রথম ৫০ টি স্বাভাবিক সংখ্যার গড়",
                    new String[]{ "২৫.৩০","২৫.৫","২৫.০০","১২.২৫"}, "২৫.৫","B",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("১.৫: ২.৫ এর সহজতম ফর্ম হল ...............",
                    new String[]{ "৬: ১০","১৫: ২৫","০.৭৫: ১.২৫","৩:৫"}, "৩:৫","D",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("৪৫×১৫ ফিট হলের মেঝে মেরামতের জন্য ৩৫৪০৳ ব্যয় করা হয়েছে এর মেঝে মেরামত খরচ হয়। প্রতি বর্গ ফুটে  মেরামতের খরচ কত?",
                    new String[]{"৫.২৪৳","৬৭.০০৳","৩২.৪৮৳","৪২.১০৳"}, "৫.২৪৳","A",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("যদি ১৮ কোন সংখ্যার ৪০% হয়, তাহলে সংখ্যাটি কী?",
                    new String[]{"৪১","৪৮","৪৫","৪৩"}, "৪৫","C",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("যদি Δ এটা মানে প্রথম সংখ্যাকে দ্বিতীয় সংখ্যা দ্বারা গুণ, তাহলে (৩ Δ ৫) Δ ৩ =?",
                    new String[]{"২৫","৪৫","৩০","৩১"}, "৪৫","B",""));
            mathBanDataBaseHelper.addInitialMathBanQuestion(new Question("এমন সংখ্যা যা মৌলিক বা যৌগিক নয় ......",
                    new String[]{"০","১","৩","২"}, "১","B",""));



            list = mathBanDataBaseHelper.getAllMathBanQuestionsList();//get list from database again

        }
    }
}
