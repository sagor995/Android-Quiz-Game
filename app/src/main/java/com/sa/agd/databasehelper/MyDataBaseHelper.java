package com.sa.agd.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sa.agd.gameofchoice.Scores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sagor Ahamed on 6/22/2017.
 */

public class MyDataBaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_QUESTION = "questionBanker2";
    // Current version of database
    private static final int DATABASE_VERSION = 1;
    // Database table name
    private static final String TABLE_PHYSICS_ENG_QUESTION = "PhysicsEnglish";
    private static final String TABLE_PHYSICS_BAN_QUESTION = "PhysicsBangla";
    private static final String TABLE_CHEMISTRY_ENG_QUESTION = "ChemistryEnglish";
    private static final String TABLE_CHEMISTRY_BAN_QUESTION = "ChemistryBangla";
    private static final String TABLE_MATH_ENG_QUESTION = "MathEnglish";
    private static final String TABLE_MATH_BAN_QUESTION = "MathBangla";
    private static final String TABLE_PROGRAMMING_ENG_QUESTION = "ProgrammingEnglish";
    private static final String TABLE_PROGRAMMING_BAN_QUESTION = "ProgrammingBangla";
    private static final String TABLE_RANDOM_ENG_QUESTION = "RandomEnglish";
    private static final String TABLE_RANDOM_BAN_QUESTION = "RandomBangla";

    private static final String TABLE_SCORE_ENGLISH="ScoresTableEnglish";
    private static final String TABLE_SCORE_BANGLA="ScoresTableBangla";
    // All fields used in database table
    private static final String KEY_ID = "ID";

    private static final String QUESTION_SET = "QUESTION";
    private static final String OPTION_A = "OPTIONA";
    private static final String OPTION_B = "OPTIONB";
    private static final String OPTION_C = "OPTIONC";
    private static final String OPTION_D = "OPTIOND";
    private static final String ANSWER_SET = "ANSWER";

    private static final String HALF_HELPLINE="HALF";
    private static final String HINT_HELPLINE="HINT";

    private static final String PLAYER_ID="playerID";
    public static final String KEY_NAME="playerName";
    public static final String KEY_SCORE="playerScore";
    public static final String KEY_CATEGORY="playerCategory";


    // Physics Question Table Create Query in this string
    private static final String CREATE_TABLE_PHYSICS_ENG_QUESTION = "CREATE TABLE "
            + TABLE_PHYSICS_ENG_QUESTION + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, OPTIONA TEXT, OPTIONB TEXT, OPTIONC TEXT, OPTIOND TEXT, ANSWER TEXT, HALF TEXT, HINT TEXT)";
    private static final String CREATE_TABLE_PHYSICS_BAN_QUESTION = "CREATE TABLE "
            + TABLE_PHYSICS_BAN_QUESTION + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, OPTIONA TEXT, OPTIONB TEXT, OPTIONC TEXT, OPTIOND TEXT, ANSWER TEXT, HALF TEXT, HINT TEXT)";

    //Chemistry Question Table Create Query in this string
    private static final String CREATE_TABLE_CHEMISTRY_ENG_QUESTION = "CREATE TABLE "
            + TABLE_CHEMISTRY_ENG_QUESTION + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, OPTIONA TEXT, OPTIONB TEXT, OPTIONC TEXT, OPTIOND TEXT, ANSWER TEXT, HALF TEXT, HINT TEXT)";
    private static final String CREATE_TABLE_CHEMISTRY_BAN_QUESTION = "CREATE TABLE "
            + TABLE_CHEMISTRY_BAN_QUESTION + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, OPTIONA TEXT, OPTIONB TEXT, OPTIONC TEXT, OPTIOND TEXT, ANSWER TEXT, HALF TEXT, HINT TEXT)";

    //Math Question Table Create Query in this string
    private static final String CREATE_TABLE_MATH_ENG_QUESTION = "CREATE TABLE "
            + TABLE_MATH_ENG_QUESTION + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, OPTIONA TEXT, OPTIONB TEXT, OPTIONC TEXT, OPTIOND TEXT, ANSWER TEXT, HALF TEXT, HINT TEXT)";
    private static final String CREATE_TABLE_MATH_BAN_QUESTION = "CREATE TABLE "
            + TABLE_MATH_BAN_QUESTION + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, OPTIONA TEXT, OPTIONB TEXT, OPTIONC TEXT, OPTIOND TEXT, ANSWER TEXT, HALF TEXT, HINT TEXT)";

    //Programming Question Table Create Query in this string
    private static final String CREATE_TABLE_PROGRAMMING_ENG_QUESTION = "CREATE TABLE "
            + TABLE_PROGRAMMING_ENG_QUESTION + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, OPTIONA TEXT, OPTIONB TEXT, OPTIONC TEXT, OPTIOND TEXT, ANSWER TEXT, HALF TEXT, HINT TEXT)";
    private static final String CREATE_TABLE_PROGRAMMING_BAN_QUESTION = "CREATE TABLE "
            + TABLE_PROGRAMMING_BAN_QUESTION + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, OPTIONA TEXT, OPTIONB TEXT, OPTIONC TEXT, OPTIOND TEXT, ANSWER TEXT, HALF TEXT, HINT TEXT)";

    private static final String CREATE_TABLE_RANDOM_ENG_QUESTION = "CREATE TABLE "
            + TABLE_RANDOM_ENG_QUESTION + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, OPTIONA TEXT, OPTIONB TEXT, OPTIONC TEXT, OPTIOND TEXT, ANSWER TEXT, HALF TEXT, HINT TEXT)";
    private static final String CREATE_TABLE_RANDOM_BAN_QUESTION = "CREATE TABLE "
            + TABLE_RANDOM_BAN_QUESTION + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, OPTIONA TEXT, OPTIONB TEXT, OPTIONC TEXT, OPTIOND TEXT, ANSWER TEXT, HALF TEXT, HINT TEXT)";

    private static final String CREATE_ENGLISH_SCORE_TABLE="CREATE TABLE "+TABLE_SCORE_ENGLISH+"(playerID INTEGER PRIMARY KEY AUTOINCREMENT not null,  playerName TEXT not null, playerScore TEXT not null, playerCategory TEXT not null)";
    private static final String CREATE_BANGLA_SCORE_TABLE="CREATE TABLE "+TABLE_SCORE_BANGLA+"(playerID INTEGER PRIMARY KEY AUTOINCREMENT not null,  playerName TEXT not null, playerScore TEXT not null, playerCategory TEXT not null)";

    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_QUESTION, null, DATABASE_VERSION);
    }

    /**
     * This method is called by system if the database is accessed but not yet
     * created.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_PHYSICS_ENG_QUESTION); // create question table
            db.execSQL(CREATE_TABLE_PHYSICS_BAN_QUESTION); // create question table
            db.execSQL(CREATE_TABLE_CHEMISTRY_ENG_QUESTION); // create question table
            db.execSQL(CREATE_TABLE_CHEMISTRY_BAN_QUESTION); // create question table
            db.execSQL(CREATE_TABLE_MATH_ENG_QUESTION); // create question table
            db.execSQL(CREATE_TABLE_MATH_BAN_QUESTION); // create question table
            db.execSQL(CREATE_TABLE_PROGRAMMING_ENG_QUESTION); // create question table
            db.execSQL(CREATE_TABLE_PROGRAMMING_BAN_QUESTION); // create question table
            db.execSQL(CREATE_TABLE_RANDOM_ENG_QUESTION); // create question table
            db.execSQL(CREATE_TABLE_RANDOM_BAN_QUESTION); // create question table
            db.execSQL(CREATE_ENGLISH_SCORE_TABLE);
            db.execSQL(CREATE_BANGLA_SCORE_TABLE);
        } catch (Exception e) {

        }

    }

    /**
     * This method is called when any modifications in database are done like
     * version is updated or database schema is changed
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PHYSICS_ENG_QUESTION); // drop table if exists
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PHYSICS_BAN_QUESTION); // drop table if exists
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHEMISTRY_ENG_QUESTION); // drop table if exists
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHEMISTRY_BAN_QUESTION); // drop table if exists
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATH_ENG_QUESTION); // drop table if exists
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATH_BAN_QUESTION); // drop table if exists
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROGRAMMING_ENG_QUESTION); // drop table if exists
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROGRAMMING_BAN_QUESTION); // drop table if exists
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RANDOM_ENG_QUESTION); // drop table if exists
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RANDOM_BAN_QUESTION); // drop table if exists

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE_ENGLISH);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE_BANGLA);
            onCreate(db);
        }catch (Exception e) {

        }


    }

    /**
     * This method is used to add question detail in question Table
     */
    public long addInitialPhyEngQuestion (Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values

            ContentValues values = new ContentValues();
            values.put(QUESTION_SET, question.getQuestion());
            values.put(OPTION_A, question.getChoice(0));
            values.put(OPTION_B, question.getChoice(1));
            values.put(OPTION_C, question.getChoice(2));
            values.put(OPTION_D, question.getChoice(3));
            values.put(ANSWER_SET, question.getAnswer());
            values.put(HALF_HELPLINE, question.getHalfHelpLine());
            values.put(HINT_HELPLINE, question.getHintHelpLine());
            // insert row in question table
            long insert = db.insert(TABLE_PHYSICS_ENG_QUESTION, null, values);
            return insert;

    }
    public long addInitialPhyBanQuestion (Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values

        ContentValues values = new ContentValues();
        values.put(QUESTION_SET, question.getQuestion());
        values.put(OPTION_A, question.getChoice(0));
        values.put(OPTION_B, question.getChoice(1));
        values.put(OPTION_C, question.getChoice(2));
        values.put(OPTION_D, question.getChoice(3));
        values.put(ANSWER_SET, question.getAnswer());
        values.put(HALF_HELPLINE, question.getHalfHelpLine());
        values.put(HINT_HELPLINE, question.getHintHelpLine());
        // insert row in question table
        long insert = db.insert(TABLE_PHYSICS_BAN_QUESTION, null, values);
        return insert;

    }

    /**
     * This method is used to add question detail in question Table
     */
    public long addInitialCheEngQuestion (Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values

        ContentValues values = new ContentValues();
        values.put(QUESTION_SET, question.getQuestion());
        values.put(OPTION_A, question.getChoice(0));
        values.put(OPTION_B, question.getChoice(1));
        values.put(OPTION_C, question.getChoice(2));
        values.put(OPTION_D, question.getChoice(3));
        values.put(ANSWER_SET, question.getAnswer());
        values.put(HALF_HELPLINE, question.getHalfHelpLine());
        values.put(HINT_HELPLINE, question.getHintHelpLine());
        // insert row in question table
        long insert = db.insert(TABLE_CHEMISTRY_ENG_QUESTION, null, values);
        return insert;

    }
    public long addInitialCheBanQuestion (Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values

        ContentValues values = new ContentValues();
        values.put(QUESTION_SET, question.getQuestion());
        values.put(OPTION_A, question.getChoice(0));
        values.put(OPTION_B, question.getChoice(1));
        values.put(OPTION_C, question.getChoice(2));
        values.put(OPTION_D, question.getChoice(3));
        values.put(ANSWER_SET, question.getAnswer());
        values.put(HALF_HELPLINE, question.getHalfHelpLine());
        values.put(HINT_HELPLINE, question.getHintHelpLine());
        // insert row in question table
        long insert = db.insert(TABLE_CHEMISTRY_BAN_QUESTION, null, values);
        return insert;

    }

    /**
     * This method is used to add question detail in question Table
     */
    public long addInitialMathEngQuestion (Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values

        ContentValues values = new ContentValues();
        values.put(QUESTION_SET, question.getQuestion());
        values.put(OPTION_A, question.getChoice(0));
        values.put(OPTION_B, question.getChoice(1));
        values.put(OPTION_C, question.getChoice(2));
        values.put(OPTION_D, question.getChoice(3));
        values.put(ANSWER_SET, question.getAnswer());
        values.put(HALF_HELPLINE, question.getHalfHelpLine());
        values.put(HINT_HELPLINE, question.getHintHelpLine());
        // insert row in question table
        long insert = db.insert(TABLE_MATH_ENG_QUESTION, null, values);
        return insert;

    }
    public long addInitialMathBanQuestion (Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values

        ContentValues values = new ContentValues();
        values.put(QUESTION_SET, question.getQuestion());
        values.put(OPTION_A, question.getChoice(0));
        values.put(OPTION_B, question.getChoice(1));
        values.put(OPTION_C, question.getChoice(2));
        values.put(OPTION_D, question.getChoice(3));
        values.put(ANSWER_SET, question.getAnswer());
        values.put(HALF_HELPLINE, question.getHalfHelpLine());
        values.put(HINT_HELPLINE, question.getHintHelpLine());
        // insert row in question table
        long insert = db.insert(TABLE_MATH_BAN_QUESTION, null, values);
        return insert;

    }

    /**
     * This method is used to add question detail in question Table
     */
    public long addInitialProgEngQuestion (Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values

        ContentValues values = new ContentValues();
        values.put(QUESTION_SET, question.getQuestion());
        values.put(OPTION_A, question.getChoice(0));
        values.put(OPTION_B, question.getChoice(1));
        values.put(OPTION_C, question.getChoice(2));
        values.put(OPTION_D, question.getChoice(3));
        values.put(ANSWER_SET, question.getAnswer());
        values.put(HALF_HELPLINE, question.getHalfHelpLine());
        values.put(HINT_HELPLINE, question.getHintHelpLine());
        // insert row in question table
        long insert = db.insert(TABLE_PROGRAMMING_ENG_QUESTION, null, values);
        return insert;

    }
    public long addInitialProgBanQuestion (Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values

        ContentValues values = new ContentValues();
        values.put(QUESTION_SET, question.getQuestion());
        values.put(OPTION_A, question.getChoice(0));
        values.put(OPTION_B, question.getChoice(1));
        values.put(OPTION_C, question.getChoice(2));
        values.put(OPTION_D, question.getChoice(3));
        values.put(ANSWER_SET, question.getAnswer());
        values.put(HALF_HELPLINE, question.getHalfHelpLine());
        values.put(HINT_HELPLINE, question.getHintHelpLine());
        // insert row in question table
        long insert = db.insert(TABLE_PROGRAMMING_BAN_QUESTION, null, values);
        return insert;

    }

    /**
     * This method is used to add question detail in question Table
     */
    public long addInitialRandEngQuestion (Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values

        ContentValues values = new ContentValues();
        values.put(QUESTION_SET, question.getQuestion());
        values.put(OPTION_A, question.getChoice(0));
        values.put(OPTION_B, question.getChoice(1));
        values.put(OPTION_C, question.getChoice(2));
        values.put(OPTION_D, question.getChoice(3));
        values.put(ANSWER_SET, question.getAnswer());
        values.put(HALF_HELPLINE, question.getHalfHelpLine());
        values.put(HINT_HELPLINE, question.getHintHelpLine());
        // insert row in question table
        long insert = db.insert(TABLE_RANDOM_ENG_QUESTION, null, values);
        return insert;

    }
    public long addInitialRandBanQuestion (Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values

        ContentValues values = new ContentValues();
        values.put(QUESTION_SET, question.getQuestion());
        values.put(OPTION_A, question.getChoice(0));
        values.put(OPTION_B, question.getChoice(1));
        values.put(OPTION_C, question.getChoice(2));
        values.put(OPTION_D, question.getChoice(3));
        values.put(ANSWER_SET, question.getAnswer());
        values.put(HALF_HELPLINE, question.getHalfHelpLine());
        values.put(HINT_HELPLINE, question.getHintHelpLine());
        // insert row in question table
        long insert = db.insert(TABLE_RANDOM_BAN_QUESTION, null, values);
        return insert;

    }





    /**
     * To extract data from database and save it Arraylist of data type
     * Question
     */
    public List<Question> getAllPhyEngQuestionsList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionArrayList = new ArrayList<>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_PHYSICS_ENG_QUESTION;
            Cursor data = db.rawQuery(selectQuery, null);
            // looping through all records and adding to the list
            if (data.moveToFirst()) {
                do {
                    Question question = new Question();

                    question.setQuestion(data.getString(data.getColumnIndex(QUESTION_SET)));
                    question.setChoice(0, data.getString(data.getColumnIndex(OPTION_A)));
                    question.setChoice(1, data.getString(data.getColumnIndex(OPTION_B)));
                    question.setChoice(2, data.getString(data.getColumnIndex(OPTION_C)));
                    question.setChoice(3, data.getString(data.getColumnIndex(OPTION_D)));
                    question.setAnswer(data.getString(data.getColumnIndex(ANSWER_SET)));
                    question.setHalfHelpLine(data.getString(data.getColumnIndex(HALF_HELPLINE)));
                    question.setHintHelpLine(data.getString(data.getColumnIndex(HINT_HELPLINE)));
                    // adding to Questions list
                    questionArrayList.add(question);
                } while (data.moveToNext());
                Collections.shuffle(questionArrayList);
            }
            
        }catch (Exception e){

        }finally {
            db.close();
        }
        return questionArrayList;
    }

    public List<Question> getAllPhyBanQuestionsList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionArrayList = new ArrayList<>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_PHYSICS_BAN_QUESTION;
            Cursor data = db.rawQuery(selectQuery, null);
            // looping through all records and adding to the list
            if (data.moveToFirst()) {
                do {
                    Question question = new Question();

                    question.setQuestion(data.getString(data.getColumnIndex(QUESTION_SET)));
                    question.setChoice(0, data.getString(data.getColumnIndex(OPTION_A)));
                    question.setChoice(1, data.getString(data.getColumnIndex(OPTION_B)));
                    question.setChoice(2, data.getString(data.getColumnIndex(OPTION_C)));
                    question.setChoice(3, data.getString(data.getColumnIndex(OPTION_D)));
                    question.setAnswer(data.getString(data.getColumnIndex(ANSWER_SET)));
                    question.setHalfHelpLine(data.getString(data.getColumnIndex(HALF_HELPLINE)));
                    question.setHintHelpLine(data.getString(data.getColumnIndex(HINT_HELPLINE)));
                    // adding to Questions list
                    questionArrayList.add(question);
                } while (data.moveToNext());
                Collections.shuffle(questionArrayList);
            }

        }catch (Exception e){

        }finally {
            db.close();
        }
        return questionArrayList;
    }


    /**
     * To extract data from database and save it Arraylist of data type
     * Question
     */
    public List<Question> getAllCheEngQuestionsList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionArrayList = new ArrayList<>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_CHEMISTRY_ENG_QUESTION;
            Cursor data = db.rawQuery(selectQuery, null);
            // looping through all records and adding to the list
            if (data.moveToFirst()) {
                do {
                    Question question = new Question();

                    question.setQuestion(data.getString(data.getColumnIndex(QUESTION_SET)));
                    question.setChoice(0, data.getString(data.getColumnIndex(OPTION_A)));
                    question.setChoice(1, data.getString(data.getColumnIndex(OPTION_B)));
                    question.setChoice(2, data.getString(data.getColumnIndex(OPTION_C)));
                    question.setChoice(3, data.getString(data.getColumnIndex(OPTION_D)));
                    question.setAnswer(data.getString(data.getColumnIndex(ANSWER_SET)));
                    question.setHalfHelpLine(data.getString(data.getColumnIndex(HALF_HELPLINE)));
                    question.setHintHelpLine(data.getString(data.getColumnIndex(HINT_HELPLINE)));
                    // adding to Questions list
                    questionArrayList.add(question);
                } while (data.moveToNext());
                Collections.shuffle(questionArrayList);
            }

        }catch (Exception e){

        }finally {
            db.close();
        }
        return questionArrayList;
    }

    public List<Question> getAllCheBanQuestionsList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionArrayList = new ArrayList<>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_CHEMISTRY_BAN_QUESTION;
            Cursor data = db.rawQuery(selectQuery, null);
            // looping through all records and adding to the list
            if (data.moveToFirst()) {
                do {
                    Question question = new Question();

                    question.setQuestion(data.getString(data.getColumnIndex(QUESTION_SET)));
                    question.setChoice(0, data.getString(data.getColumnIndex(OPTION_A)));
                    question.setChoice(1, data.getString(data.getColumnIndex(OPTION_B)));
                    question.setChoice(2, data.getString(data.getColumnIndex(OPTION_C)));
                    question.setChoice(3, data.getString(data.getColumnIndex(OPTION_D)));
                    question.setAnswer(data.getString(data.getColumnIndex(ANSWER_SET)));
                    question.setHalfHelpLine(data.getString(data.getColumnIndex(HALF_HELPLINE)));
                    question.setHintHelpLine(data.getString(data.getColumnIndex(HINT_HELPLINE)));
                    // adding to Questions list
                    questionArrayList.add(question);
                } while (data.moveToNext());
                Collections.shuffle(questionArrayList);
            }

        }catch (Exception e){

        }finally {
            db.close();
        }
        return questionArrayList;
    }


    /**
     * To extract data from database and save it Arraylist of data type
     * Question
     */
    public List<Question> getAllMathEngQuestionsList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionArrayList = new ArrayList<>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_MATH_ENG_QUESTION;
            Cursor data = db.rawQuery(selectQuery, null);
            // looping through all records and adding to the list
            if (data.moveToFirst()) {
                do {
                    Question question = new Question();

                    question.setQuestion(data.getString(data.getColumnIndex(QUESTION_SET)));
                    question.setChoice(0, data.getString(data.getColumnIndex(OPTION_A)));
                    question.setChoice(1, data.getString(data.getColumnIndex(OPTION_B)));
                    question.setChoice(2, data.getString(data.getColumnIndex(OPTION_C)));
                    question.setChoice(3, data.getString(data.getColumnIndex(OPTION_D)));
                    question.setAnswer(data.getString(data.getColumnIndex(ANSWER_SET)));
                    question.setHalfHelpLine(data.getString(data.getColumnIndex(HALF_HELPLINE)));
                    question.setHintHelpLine(data.getString(data.getColumnIndex(HINT_HELPLINE)));
                    // adding to Questions list
                    questionArrayList.add(question);
                } while (data.moveToNext());
                Collections.shuffle(questionArrayList);
            }

        }catch (Exception e){

        }finally {
            db.close();
        }
        return questionArrayList;
    }

    public List<Question> getAllMathBanQuestionsList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionArrayList = new ArrayList<>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_MATH_BAN_QUESTION;
            Cursor data = db.rawQuery(selectQuery, null);
            // looping through all records and adding to the list
            if (data.moveToFirst()) {
                do {
                    Question question = new Question();

                    question.setQuestion(data.getString(data.getColumnIndex(QUESTION_SET)));
                    question.setChoice(0, data.getString(data.getColumnIndex(OPTION_A)));
                    question.setChoice(1, data.getString(data.getColumnIndex(OPTION_B)));
                    question.setChoice(2, data.getString(data.getColumnIndex(OPTION_C)));
                    question.setChoice(3, data.getString(data.getColumnIndex(OPTION_D)));
                    question.setAnswer(data.getString(data.getColumnIndex(ANSWER_SET)));
                    question.setHalfHelpLine(data.getString(data.getColumnIndex(HALF_HELPLINE)));
                    question.setHintHelpLine(data.getString(data.getColumnIndex(HINT_HELPLINE)));
                    // adding to Questions list
                    questionArrayList.add(question);
                } while (data.moveToNext());
                Collections.shuffle(questionArrayList);
            }

        }catch (Exception e){

        }finally {
            db.close();
        }
        return questionArrayList;
    }



    /**
     * To extract data from database and save it Arraylist of data type
     * Question
     */
    public List<Question> getAllProgEngQuestionsList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionArrayList = new ArrayList<>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_PROGRAMMING_ENG_QUESTION;
            Cursor data = db.rawQuery(selectQuery, null);
            // looping through all records and adding to the list
            if (data.moveToFirst()) {
                do {
                    Question question = new Question();

                    question.setQuestion(data.getString(data.getColumnIndex(QUESTION_SET)));
                    question.setChoice(0, data.getString(data.getColumnIndex(OPTION_A)));
                    question.setChoice(1, data.getString(data.getColumnIndex(OPTION_B)));
                    question.setChoice(2, data.getString(data.getColumnIndex(OPTION_C)));
                    question.setChoice(3, data.getString(data.getColumnIndex(OPTION_D)));
                    question.setAnswer(data.getString(data.getColumnIndex(ANSWER_SET)));
                    question.setHalfHelpLine(data.getString(data.getColumnIndex(HALF_HELPLINE)));
                    question.setHintHelpLine(data.getString(data.getColumnIndex(HINT_HELPLINE)));
                    // adding to Questions list
                    questionArrayList.add(question);
                } while (data.moveToNext());
                Collections.shuffle(questionArrayList);
            }

        }catch (Exception e){

        }finally {
            db.close();
        }
        return questionArrayList;
    }

    public List<Question> getAllProgBanQuestionsList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionArrayList = new ArrayList<>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_PROGRAMMING_BAN_QUESTION;
            Cursor data = db.rawQuery(selectQuery, null);
            // looping through all records and adding to the list
            if (data.moveToFirst()) {
                do {
                    Question question = new Question();

                    question.setQuestion(data.getString(data.getColumnIndex(QUESTION_SET)));
                    question.setChoice(0, data.getString(data.getColumnIndex(OPTION_A)));
                    question.setChoice(1, data.getString(data.getColumnIndex(OPTION_B)));
                    question.setChoice(2, data.getString(data.getColumnIndex(OPTION_C)));
                    question.setChoice(3, data.getString(data.getColumnIndex(OPTION_D)));
                    question.setAnswer(data.getString(data.getColumnIndex(ANSWER_SET)));
                    question.setHalfHelpLine(data.getString(data.getColumnIndex(HALF_HELPLINE)));
                    question.setHintHelpLine(data.getString(data.getColumnIndex(HINT_HELPLINE)));
                    // adding to Questions list
                    questionArrayList.add(question);
                } while (data.moveToNext());
                Collections.shuffle(questionArrayList);
            }

        }catch (Exception e){

        }finally {
            db.close();
        }
        return questionArrayList;
    }


    /**
     * To extract data from database and save it Arraylist of data type
     * Question
     */
    public List<Question> getAllRandEngQuestionsList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionArrayList = new ArrayList<>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_RANDOM_ENG_QUESTION;
            Cursor data = db.rawQuery(selectQuery, null);
            // looping through all records and adding to the list
            if (data.moveToFirst()) {
                do {
                    Question question = new Question();

                    question.setQuestion(data.getString(data.getColumnIndex(QUESTION_SET)));
                    question.setChoice(0, data.getString(data.getColumnIndex(OPTION_A)));
                    question.setChoice(1, data.getString(data.getColumnIndex(OPTION_B)));
                    question.setChoice(2, data.getString(data.getColumnIndex(OPTION_C)));
                    question.setChoice(3, data.getString(data.getColumnIndex(OPTION_D)));
                    question.setAnswer(data.getString(data.getColumnIndex(ANSWER_SET)));
                    question.setHalfHelpLine(data.getString(data.getColumnIndex(HALF_HELPLINE)));
                    question.setHintHelpLine(data.getString(data.getColumnIndex(HINT_HELPLINE)));
                    // adding to Questions list
                    questionArrayList.add(question);
                } while (data.moveToNext());
                Collections.shuffle(questionArrayList);
            }

        }catch (Exception e){

        }finally {
            db.close();
        }
        return questionArrayList;
    }

    public List<Question> getAllRandBanQuestionsList() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Question> questionArrayList = new ArrayList<>();

        try {
            String selectQuery = "SELECT  * FROM " + TABLE_RANDOM_BAN_QUESTION;
            Cursor data = db.rawQuery(selectQuery, null);
            // looping through all records and adding to the list
            if (data.moveToFirst()) {
                do {
                    Question question = new Question();

                    question.setQuestion(data.getString(data.getColumnIndex(QUESTION_SET)));
                    question.setChoice(0, data.getString(data.getColumnIndex(OPTION_A)));
                    question.setChoice(1, data.getString(data.getColumnIndex(OPTION_B)));
                    question.setChoice(2, data.getString(data.getColumnIndex(OPTION_C)));
                    question.setChoice(3, data.getString(data.getColumnIndex(OPTION_D)));
                    question.setAnswer(data.getString(data.getColumnIndex(ANSWER_SET)));
                    question.setHalfHelpLine(data.getString(data.getColumnIndex(HALF_HELPLINE)));
                    question.setHintHelpLine(data.getString(data.getColumnIndex(HINT_HELPLINE)));
                    // adding to Questions list
                    questionArrayList.add(question);
                } while (data.moveToNext());
                Collections.shuffle(questionArrayList);
            }

        }catch (Exception e){

        }finally {
            db.close();
        }
        return questionArrayList;
    }


    
    //Score
    public void insertEngData(Scores scores){

        SQLiteDatabase db =this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_NAME, scores.getName());
            contentValues.put(KEY_SCORE, scores.getScore());
            contentValues.put(KEY_CATEGORY,scores.getCategory());
            db.insert(TABLE_SCORE_ENGLISH, null, contentValues);
        }catch (Exception e){

        }finally {
            db.close();
        }
    }

    public void insertBanData(Scores scores){

        SQLiteDatabase db =this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_NAME, scores.getName());
            contentValues.put(KEY_SCORE, scores.getScore());
            contentValues.put(KEY_CATEGORY,scores.getCategory());
            db.insert(TABLE_SCORE_BANGLA, null, contentValues);
        }catch (Exception e){

        }finally {
            db.close();
        }
    }

/*    public Cursor predefinedDataShow() throws Exception{

        SQLiteDatabase db =this.getReadableDatabase();

            String query = "SELECT * FROM " + TABLE_SCORE_ENGLISH;

            Cursor cursor = db.rawQuery(query, null);
            return cursor;

    }*/

    public ArrayList<Scores> getAllEngScoreDatas(){
        SQLiteDatabase db =this.getWritableDatabase();
        ArrayList<Scores> list=new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_SCORE_ENGLISH;
        Cursor cursor=db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do{

                Scores scores=new Scores(cursor.getString(cursor.getColumnIndex(KEY_NAME)),
                        cursor.getInt(cursor.getColumnIndex(KEY_SCORE)),cursor.getString(cursor.getColumnIndex(KEY_CATEGORY)));

                list.add(scores);

            }while (cursor.moveToNext());


        }
        //Collections.reverse(list);

        return list;
    }

    public ArrayList<Scores> getAllBanScoreDatas(){
        SQLiteDatabase db =this.getWritableDatabase();
        ArrayList<Scores> list=new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_SCORE_BANGLA;
        Cursor cursor=db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do{

                Scores scores=new Scores(cursor.getString(cursor.getColumnIndex(KEY_NAME)),
                        cursor.getInt(cursor.getColumnIndex(KEY_SCORE)),cursor.getString(cursor.getColumnIndex(KEY_CATEGORY)));

                list.add(scores);

            }while (cursor.moveToNext());


        }
        //Collections.reverse(list);

        return list;
    }



    public void clearEngScores(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SCORE_ENGLISH,null,null);
        db.close();
    }

    public void clearBanScores(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SCORE_BANGLA,null,null);
        db.close();
    }

}
