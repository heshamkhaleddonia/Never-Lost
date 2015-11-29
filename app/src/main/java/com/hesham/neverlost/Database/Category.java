package com.hesham.neverlost.Database;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * class description and Used for What
 *
 * @author Hesham Khaled , <h.khaled@yellow.com.eg> on 11/29/15.
 * @package com.hesham.neverlost.Database
 * @className Category
 **/

@DatabaseTable(tableName = "Category")
public class Category {

    public static final String Category_ID = "ID";
    public static final String Category_Name = "Name";
    public static final String Category_Items = "Items";


    public Category() {

    }

    @DatabaseField(generatedId = true, columnName = Category_ID)
    private int mId;

    @DatabaseField(columnName = Category_Name)
    private String mCategoryName;

    @ForeignCollectionField(eager = true, columnName = Category_Items)
    private ForeignCollection<Item> items;


    public int getId() {
        return mId;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String mCategoryName) {
        this.mCategoryName = mCategoryName;
    }

    public ForeignCollection<Item> getItems() {
        return items;
    }

    public void setItems(ForeignCollection<Item> items) {
        this.items = items;
    }
}
