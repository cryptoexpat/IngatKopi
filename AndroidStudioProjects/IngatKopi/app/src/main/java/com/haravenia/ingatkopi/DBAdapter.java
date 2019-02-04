package com.haravenia.ingatkopi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Databaseに関連するクラス
 * DBAdapter
 */
public class DBAdapter {

    private final static String DB_NAME = "ingatkopi.db";      // DB名
    private final static String DB_TABLE_EVALUATION = "evaluation";       // DBのテーブル名
    private final static String DB_TABLE_BP = "bp";
    private final static String DB_TABLE_BEAN = "bean";
    private final static String DB_TABLE_EVALUATION_PLACE = "evaluation_place";
    private final static String DB_TABLE_BEAN_ORIGIN = "bean_origin";
    private final static String DB_TABLE_BEAN_TYPE = "bean_type";
    private final static String DB_TABLE_GRIND_SIZE = "grind_size";
    private final static String DB_TABLE_ROAST = "roast";
    private final static String DB_TABLE_BEAN_AREA = "bean_area";
    private final static String DB_TABLE_COUNTRY = "country"
    private final static int DB_VERSION = 1;                // DBのバージョン

    /**
     * DBのカラム名
     */
    // Evaluationテーブル
    public final static String COL_EVALUATION_ID = "evaluation_id";             // id
    public final static String COL_ACIDITY = "acidity";      // 酸味
    public final static String COL_BODY = "body";      // ボディ
    public final static String COL_BITTERNESS = "bitterness";        // 苦味
    public final static String COL_TOTAL_EVALUATION = "total_evaluation"; // 評価
    public final static String COL_APPENDIX = "appendix";

    // Beanテーブル
    public final static String COL_BEAN_ID = "bean_id";
    public final static String COL_BEAN_NAME = "bean_name";

    // Bean_typeテーブル
    public final static String COL_BEAN_TYPE_ID = "bean_type_id";
    public final static String COL_BEAN_TYPE_NAME = "bean_type_name";

    // Bean_originテーブル
    public final static String COL_ORIGIN_ID = "origin_id";
    public final static String COL_ORIGIN_NAME = "origin_name";

    // Bean_areaテーブル
    public final static String COL_BEAN_AREA_ID = "bean_area_id";
    public final static String COL_BEAN_AREA_NAME = "bean_area_name";

    // BPテーブル
    public final static String COL_BP_ID = "bp_id";
    public final static String COL_BP_NAME = "bp_name";

    // Grind_sizeテーブル
    public final static String COL_GRIND_SIZE_ID = "grind_size_id";
    public final static String COL_GRIND_SIZE_NAME = "grind_size_name";

    // Roastテーブル
    public final static String COL_ROAST_ID = "roast_id";
    public final static String COL_ROAST_NAME = "roast_name";

    // Evaluation_placeテーブル
    public final static String COL_EVALUATION_PLACE_ID = "evaluation_place_id";
    public final static String COL_EVALUATION_PLACE_NAME = "evaluation_place_name";
    public final static String COL_GEOLOCATION = "geo_location";

    // Countryテーブル
    public final static String COL_COUNTRY_ID = "country_id";
    public final static String COL_COUNTRY_NAME = "country_name";

    // システム共通
    public final static String COL_UPDATED_AT = "updated_at";    // 実行日時
    public final static String COL_CREATED_AT = "created_at" // 登録日

    private SQLiteDatabase db = null;           // SQLiteDatabase
    private DBHelper dbHelper = null;           // DBHepler
    protected Context context;                  // Context

    // コンストラクタ
    public DBAdapter(Context context) {
        this.context = context;
        dbHelper = new DBHelper(this.context);
    }

    /**
     * DBの読み書き
     * openDB()
     *
     * @return this 自身のオブジェクト
     */
    public DBAdapter openDB() {
        db = dbHelper.getWritableDatabase();        // DBの読み書き
        return this;
    }

    /**
     * DBの読み込み 今回は未使用
     * readDB()
     *
     * @return this 自身のオブジェクト
     */
    public DBAdapter readDB() {
        db = dbHelper.getReadableDatabase();        // DBの読み込み
        return this;
    }

    /**
     * DBを閉じる
     * closeDB()
     */
    public void closeDB() {
        db.close();     // DBを閉じる
        db = null;
    }




    /**
     * データベースの生成やアップグレードを管理するSQLiteOpenHelperを継承したクラス
     * DBHelper
     */
    private static class DBHelper extends SQLiteOpenHelper {

        // コンストラクタ
        public DBHelper(Context context) {
            //第1引数：コンテキスト
            //第2引数：DB名
            //第3引数：factory nullでよい
            //第4引数：DBのバージョン
            super(context, DB_NAME, null, DB_VERSION);
        }

        /**
         * DB生成時に呼ばれる
         * onCreate()
         *
         * @param db SQLiteDatabase
         */
        @Override
        public void onCreate(SQLiteDatabase db) {

            //テーブルを作成するSQL文の定義 ※スペースに気を付ける
            List<String> createTbl = new ArrayList<>();
            //Evaluationテーブル
            createTbl.add("CREATE TABLE " + DB_TABLE_EVALUATION + " ("
                    + COL_EVALUATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_BODY + " INTEGER NOT NULL,"
                    + COL_ACIDITY + " INTEGER NOT NULL,"
                    + COL_BITTERNESS + " INTEGER NOT NULL,"
                    + COL_TOTAL_EVALUATION + " INTEGER NOT NULL"
                    + COL_APPENDIX + " TEXT"
                    + COL_BEAN_ID + " INTEGER NOT NULL"
                    + COL_BP_ID + " INTEGER NOT NULL"
                    + COL_GRIND_SIZE_ID + " INTEGER NOT NULL"
                    + COL_ROAST_ID + " INTEGER NOT NULL"
                    + COL_EVALUATION_PLACE_ID + " INTEGER NOT NULL"
                    + COL_CREATED_AT + " TEXT NOT NULL"
                    + COL_UPDATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL"
                    + ");"
            );

            //BPテーブル
            createTbl.add("CREATE TABLE " + DB_TABLE_EVALUATION + " ("
                    + COL_BP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_BP_NAME + " TEXT NOT NULL,"
                    + COL_CREATED_AT + " TEXT NOT NULL"
                    + COL_UPDATED_AT + " TEXT NOT NULL"
                    + ");"
            );

            //Beanテーブル
            createTbl.add("CREATE TABLE " + DB_TABLE_BEAN + " ("
                    + COL_BEAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_BEAN_NAME + " TEXT NOT NULL,"
                    + COL_ORIGIN_ID + " INTEGER NOT NULL,"
                    + COL_BEAN_TYPE_ID + " INTEGER NOT NULL,"
                    + COL_CREATED_AT + " TEXT NOT NULL"
                    + COL_UPDATED_AT + " TEXT NOT NULL"
                    + ");"
            );

            //Evaluation_Placeテーブル
            createTbl.add("CREATE TABLE " + DB_TABLE_EVALUATION_PLACE + " ("
                    + COL_EVALUATION_PLACE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_EVALUATION_PLACE_NAME + " TEXT NOT NULL,"
                    + COL_GEOLOCATION + " REAL NOT NULL,"
                    + COL_COUNTRY_ID + " INTEGER NOT NULL,"
                    + COL_CREATED_AT + " TEXT NOT NULL"
                    + COL_UPDATED_AT + " TEXT NOT NULL"
                    + ");"
            );

            //Bean_originテーブル
            createTbl.add("CREATE TABLE " + DB_TABLE_BEAN_ORIGIN + " ("
                    + COL_ORIGIN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_ORIGIN_NAME + " TEXT NOT NULL,"
                    + COL_BEAN_AREA_ID + " INTEGER NOT NULL,"
                    + COL_CREATED_AT + " TEXT NOT NULL"
                    + COL_UPDATED_AT + " TEXT NOT NULL"
                    + ");"
            );

            //Bean_typeテーブル
            createTbl.add("CREATE TABLE " + DB_TABLE_BEAN_TYPE + " ("
                    + COL_BEAN_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_BEAN_TYPE_NAME + " TEXT NOT NULL,"
                    + COL_CREATED_AT + " TEXT NOT NULL"
                    + COL_UPDATED_AT + " TEXT NOT NULL"
                    + ");"
            );

            //Grind_sizeテーブル
            createTbl.add("CREATE TABLE " + DB_TABLE_GRIND_SIZE + " ("
                    + COL_GRIND_SIZE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_GRIND_SIZE_NAME + " TEXT NOT NULL,"
                    + COL_CREATED_AT + " TEXT NOT NULL"
                    + COL_UPDATED_AT + " TEXT NOT NULL"
                    + ");"
            );

            //Roastテーブル
            createTbl.add("CREATE TABLE " + DB_TABLE_ROAST + " ("
                    + COL_ROAST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_ROAST_NAME + " TEXT NOT NULL,"
                    + COL_CREATED_AT + " TEXT NOT NULL"
                    + COL_UPDATED_AT + " TEXT NOT NULL"
                    + ");"
            );

            //Bean_areaテーブル
            createTbl.add("CREATE TABLE " + DB_TABLE_BEAN_AREA + " ("
                    + COL_BEAN_AREA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_BEAN_AREA_NAME + " TEXT NOT NULL,"
                    + COL_COUNTRY_ID + " INTEGER NOT NULL,"
                    + COL_CREATED_AT + " TEXT NOT NULL"
                    + COL_UPDATED_AT + " TEXT NOT NULL"
                    + ");"
            );

            //Countryテーブル
            createTbl.add("CREATE TABLE " + DB_TABLE_COUNTRY + " ("
                    + COL_COUNTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_COUNTRY_NAME + " TEXT NOT NULL,"
                    + COL_CREATED_AT + " TEXT NOT NULL"
                    + COL_UPDATED_AT + " TEXT NOT NULL"
                    + ");"
            );

            // API Level24以上であればforEach、ラムダ式で簡潔に書いたいところ
            for (String s : createTbl) {
                db.execSQL(s);
            }
        }

        /**
         * DBアップグレード(バージョンアップ)時に呼ばれる
         *
         * @param db         SQLiteDatabase
         * @param oldVersion int 古いバージョン
         * @param newVersion int 新しいバージョン
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // DBからテーブル削除
            db.execSQL("DROP TABLE IF EXISTS" + DB_TABLE_EVALUATION);
            // テーブル生成
            onCreate(db);
        }
    }



    /**
     * 以下、各テーブルへのレコード操作
     * */

    /**
     * Evaluationテーブルのレコードへ登録
     * saveDB_evaluation()
     *
     * @param body ボディ
     * @param acidity  酸味
     * @param bitterness  苦味
     * @param total_evaluation   評価
     */
    public void saveDB_evaluation(int body, int acidity, int bitterness, int total_evaluation) {

        db.beginTransaction();          // トランザクション開始

        try {
            ContentValues values = new ContentValues();     // ContentValuesでデータを設定していく
            values.put(COL_BODY, body);
            values.put(COL_ACIDITY, acidity);
            values.put(COL_BITTERNESS, bitterness);
            values.put(COL_TOTAL_EVALUATION, total_evaluation);

            // insertメソッド データ登録
            // 第1引数：DBのテーブル名
            // 第2引数：更新する条件式
            // 第3引数：ContentValues
            db.insert(DB_TABLE_EVALUATION, null, values);      // レコードへ登録

            db.setTransactionSuccessful();      // トランザクションへコミット
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();                // トランザクションの終了
        }
    }

    /**
     * Evaluationテーブルのデータを取得
     * getDB_evaluation()
     *
     * @param columns String[] 取得するカラム名 nullの場合は全カラムを取得
     * @return DBのデータ
     */
    public Cursor getDB_evaluation(String[] columns) {

        // queryメソッド DBのデータを取得
        // 第1引数：DBのテーブル名
        // 第2引数：取得するカラム名
        // 第3引数：選択条件(WHERE句)
        // 第4引数：第3引数のWHERE句において?を使用した場合に使用
        // 第5引数：集計条件(GROUP BY句)
        // 第6引数：選択条件(HAVING句)
        // 第7引数：ソート条件(ODERBY句)
        return db.query(DB_TABLE_EVALUATION, columns, null, null, null, null, null);
    }

    /**
     * Evaluationテーブルの検索したデータを取得
     * searchDB_evaluation()
     *
     * @param columns String[] 取得するカラム名 nullの場合は全カラムを取得
     * @param column  String 選択条件に使うカラム名
     * @param name    String[]
     * @return DBの検索したデータ
     */
    public Cursor searchDB_evaluation(String[] columns, String column, String[] name) {
        return db.query(DB_TABLE_EVALUATION, columns, column + " like ?", name, null, null, null);
    }

    /**
     * Evaluationテーブルのレコードを全削除
     * allDelete_evaluation()
     */
    public void allDelete_evaluation() {

        db.beginTransaction();                      // トランザクション開始
        try {
            // deleteメソッド DBのレコードを削除
            // 第1引数：テーブル名
            // 第2引数：削除する条件式 nullの場合は全レコードを削除
            // 第3引数：第2引数で?を使用した場合に使用
            db.delete(DB_TABLE_EVALUATION, null, null);        // DBのレコードを全削除
            db.setTransactionSuccessful();          // トランザクションへコミット
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();                    // トランザクションの終了
        }
    }

    /**
     * Evaluationテーブルのレコードの単一削除
     * selectDelete_evaluation()
     *
     * @param position String
     */
    public void selectDelete_evaluation(String position) {

        db.beginTransaction();                      // トランザクション開始
        try {
            db.delete(DB_TABLE_EVALUATION, COL_EVALUATION_ID + "=?", new String[]{position});
            db.setTransactionSuccessful();          // トランザクションへコミット
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();                    // トランザクションの終了
        }
    }


}