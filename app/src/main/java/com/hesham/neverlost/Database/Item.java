package com.hesham.neverlost.Database;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * class description and Used for What
 *
 * @author Hesham Khaled , <h.khaled@yellow.com.eg> on 11/29/15.
 * @package com.hesham.neverlost.Database
 * @className Item
 **/

@DatabaseTable(tableName = "Item")
public class Item {

    public static final String Item_ID = "ID";
    public static final String Item_Name = "Name";
    public static final String Item_Place = "Place";
    public static final String Item_Photo = "Photo";
    public static final String Item_Category_Id = "Category_Id";

    public Item() {

    }


    public Item(String name, String place, byte[] photo, Category category) {
        setItemName(name);
        setItemPlace(place);
        setItemCategory(category);
        setItemPhoto(photo);
    }

    @DatabaseField(generatedId = true, columnName = Item_ID)
    private int mId;

    @DatabaseField(columnName = Item_Name)
    private String mItemName;

    @DatabaseField(columnName = Item_Place)
    private String mItemPlace;

    @DatabaseField(dataType = DataType.BYTE_ARRAY, columnName = Item_Photo)
    private byte[] mItemPhoto;

    @DatabaseField(columnName = Item_Category_Id, foreign = true, foreignAutoRefresh = true, index = true)
    private Category mItemCategory;


    public int getId() {
        return mId;
    }

    public String getItemName() {
        return mItemName;
    }

    public void setItemName(String mItemName) {
        this.mItemName = mItemName;
    }

    public String getItemPlace() {
        return mItemPlace;
    }

    public void setItemPlace(String mItemPlace) {
        this.mItemPlace = mItemPlace;
    }

    public byte[] getItemPhoto() {
        return mItemPhoto;
    }

    public void setItemPhoto(byte[] mItemPhoto) {
        this.mItemPhoto = mItemPhoto;
    }

    public Category getItemCategory() {
        return mItemCategory;
    }

    public void setItemCategory(Category mItemCategory) {
        this.mItemCategory = mItemCategory;
    }
}
