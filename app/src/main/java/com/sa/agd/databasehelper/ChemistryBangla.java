package com.sa.agd.databasehelper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagor Ahamed on 8/14/2017.
 */

public class ChemistryBangla {

    // declare list of Question objects
    List<Question> list = new ArrayList<>();
    MyDataBaseHelper cheBanDataBaseHelper;


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



    public void initChemistryBanglaQuestions(Context context) {



        cheBanDataBaseHelper = new MyDataBaseHelper(context);
        list = cheBanDataBaseHelper.getAllCheBanQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {

            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("নিম্নলিখিত গুলোর মধ্যে সবচেয়ে ইলেকট্রনগ্যাভ্যাট উপাদান হল",
                    new String[]{"সোডিয়াম","ব্রোমিন","ফ্লোরিন","অক্সিজেন"}, "ফ্লোরিন","C",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("নিম্নলিখিত কোনটিতে পেন্সিল ব্যবহার করা হয়?",
                    new String[]{"গ্রাফাইট","সিলিকন","কাঠকয়লা","ফসফরাস"}, "গ্রাফাইট","A",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("নীচের কোনটি একটি অ ধাতু যা কক্ষ তাপমাত্রায় তরল থাকে?",
                    new String[]{"ফসফরাস","ব্রোমিন","ক্লোরিন","হিলিয়াম"}, "ব্রোমিন","B",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("নিম্নলিখিত ধাতুর মধ্যে কোনটি অন্য ধাতুগুলির সাথে একটি মিশ্রণ তৈরি করে?",
                    new String[]{"টিন","পারদ","সীসা","দস্তা"}, "পারদ","B",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("মানুষের রক্তের প্রধান বাফার সিস্টেম হল",
                    new String[]{"H2CO3 - HCO3","H2CO3 - CO32-","CH3COOH - CH3COO-","NH2CONH2 - NH2CONH+"}, "H2CO3 - HCO3","A",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("সবচেয়ে সাধারণ ব্যবহৃত ধোলাই এজেন্ট হল",
                    new String[]{"এলকোহল","কার্বন-ডাই-অক্সাইড","ক্লোরিন","সোডিয়াম ক্লোরিন"}, "ক্লোরিন","C",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("একটি হাইড্রোজেন পরমাণুর নিউক্লিয়াস .........দিয়ে গঠিত",
                    new String[]{"১টি প্রোটন","১টি প্রোটন + ২টি নিউট্রন","১টি নিউট্রন","১টি ইলেক্ট্রন" }, "১টি প্রোটন","A",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("বায়ুমণ্ডলে সবচেয়ে বেশি বিরল গ্যাস হল",
                    new String[]{"হিলিয়াম", "জেনন", "নিয়ম", "আর্গন"}, "আর্গন","",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("CO2 এর মোল সংখ্যা কত যা অক্সিজেনের 16 গ্রাম ধারণ করে?",
                    new String[]{"০.৫ মোল","০.২ মোল","০.৪ মোল","০.২৫ মোল"}, "০.৫ মোল","A",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("পলিথিন এর মনোমার হল...",
                    new String[]{"বিশেষ একধরনের প্লাস্টিক ক্লোরাইড","ইথিলিন","ইথাইল এলকোহল","উপরের কোনটি না"}, "ইথিলিন","B",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("সবচেয়ে নমনীয় ধাতু",
                    new String[]{"প্ল্যাটিনাম","রূপা","লোহা","স্বর্ণ"}, "স্বর্ণ","D",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("হিলিয়াম পরমাণুর এক অ্যাগাড্রো সংখ্যা ভর",
                    new String[]{"১.00 গ্রাম","৪.00 গ্রাম","৮.00 গ্রাম","৪ x ৬.০২ x ১০^২৩ গ্রাম"}, "৪ x ৬.০২ x ১০^২৩ গ্রাম","D",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("মানুষ দ্বারা ব্যবহৃত প্রথম ধাতু ছিল",
                    new String[]{"লোহা","তামা","স্বর্ণ","ব্রোঞ্জ"}, "তামা","B",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("হাইড্রোনিয়াম আয়ন হল ",
                    new String[]{"H++","Ho-","H2+","H3O++"}, "H3O++","D",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("লোহার আকরিক ম্যাগনেটাইট গঠিত হয়",
                    new String[]{"Fe2O3","Fe3OH4","FeCO3","3Fe2O3... 3H2O"}, "Fe2O3","A",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("বায়ু প্রধান উপাদান হল",
                    new String[]{"কার্বন-ডাই-অক্সাইড","নাইট্রোজেন","অক্সিজেন","হাইড্রোজেন"}, "নাইট্রোজেন","B",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("মাটির প্রধান রাসায়নিক উপাদান হল",
                    new String[]{"সিলিকন অক্সাইড","অ্যালুমিনিয়াম বোরোসিলিকেট","জেত্তলীট্স","অ্যালুমিনিয়াম সিলিকেট"}, "অ্যালুমিনিয়াম সিলিকেট","D",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("৬.০২ x ১০^২৪ CO অণুতে অক্সিজেনের জি-অণুর সংখ্যা",
                    new String[]{"অণুর ১ গ্রাম","0.৫ গ্রাম অণু","৫ গ্রাম অণু","১০ গ্রাম অণু"}, "৫ গ্রাম অণু","C",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("চা এবং কফি প্রধান সক্রিয় উপাদান হল",
                    new String[]{"নিকোটীন্","ক্লোরোফিল ।।","ক্যাফিন","এসপিরিন"}, "ক্যাফিন","C",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("কার্বন এর কঠিনতম ফর্ম হল",
                    new String[]{"কোক-কয়লা","গ্রাফাইট","হীরা","কাঠকয়লা"}, "কাঠকয়লা","D",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("অ্যালুমিনিয়াম সবচেয়ে গুরুত্বপূর্ণ আকরিক ",
                    new String[]{"বক্সাইট","ম্যাগনেটাইট","মূল্যবান্ আকরিক লৌহবিশেষ","মোনাজাইট"}, "বক্সাইট","A",""));
            cheBanDataBaseHelper.addInitialCheBanQuestion(new Question("মানুষের শরীরের অনুপাত  সর্বোচ্চ ৬৫% উপস্থিত উপাদান হল ",
                    new String[]{"কার্বন","হাইড্রোজেন","অক্সিজেন","নাইট্রোজেন"}, "অক্সিজেন","C",""));


            list = cheBanDataBaseHelper.getAllCheBanQuestionsList();//get list from database again

        }
    }
}
