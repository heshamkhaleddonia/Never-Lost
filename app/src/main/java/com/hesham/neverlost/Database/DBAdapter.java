package com.hesham.neverlost.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * class description and Used for What
 *
 * @author Hesham Khaled , <h.khaled@yellow.com.eg> on 11/29/15.
 * @package com.hesham.neverlost.Database
 * @className DBAdapter
 **/

public class DBAdapter extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "neverlost";
    private static final int DATABASE_VERSION = 1;
    private Dao<Item, Integer> itemDao = null;
    private Dao<Category, Integer> categoryDao = null;

    public DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Item.class);
            TableUtils.createTable(connectionSource, Category.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void close() {
        super.close();
        setCategoryDao(null);
        setItemDao(null);
    }

    public Dao<Item, Integer> getItemDao() {
        if (itemDao == null) {
            try {
                itemDao = getDao(Item.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return itemDao;
    }

    public void setItemDao(Dao<Item, Integer> itemDao) {
        this.itemDao = itemDao;
    }

    public Dao<Category, Integer> getCategoryDao() {
        if (categoryDao == null) {
            try {
                categoryDao = getDao(Category.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return categoryDao;
    }

    public void setCategoryDao(Dao<Category, Integer> categoryDao) {
        this.categoryDao = categoryDao;
    }
}
