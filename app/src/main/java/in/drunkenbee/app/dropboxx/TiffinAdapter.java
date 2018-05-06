package in.drunkenbee.app.dropboxx;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ankit on 20/3/18.
 */

public class TiffinAdapter {
   private float vegWeeklyPrice;
   private float vegMonthlyPrice;
   private int WeeklyMealCount;
   private int MonthlyMealCount;
   private float nonvegWeeklyPrice;
   private float nonvegMonthlyPrice;
   private int vegTiffinId;
   private int nonvegTiffinId;
   private HashMap<String, ArrayList<String>> vegMeals = new HashMap<String, ArrayList<String>>();
   private HashMap<String, ArrayList<String>> nonvegMeals = new HashMap<String, ArrayList<String>>();

    public void setNonvegTiffinId(int nonvegTiffinId) {
        this.nonvegTiffinId = nonvegTiffinId;
    }

    public void setVegTiffinId(int vegTiffinId) {
        this.vegTiffinId = vegTiffinId;
    }

    public void setNonvegWeeklyPrice(float nonvegWeeklyPrice) {
        this.nonvegWeeklyPrice = nonvegWeeklyPrice;
    }

    public void setVegMonthlyPrice(float vegMonthlyPrice) {
        this.vegMonthlyPrice = vegMonthlyPrice;
    }

    public void setNonvegMonthlyPrice(float nonvegMonthlyPrice) {
        this.nonvegMonthlyPrice = nonvegMonthlyPrice;
    }

    public void setVegWeeklyPrice(float vegWeeklyPrice) {
        this.vegWeeklyPrice = vegWeeklyPrice;
    }

    public void setMonthlyMealCount(int monthlyMealCount) {
        MonthlyMealCount = monthlyMealCount;
    }

    public void setWeeklyMealCount(int weeklyMealCount) {
        WeeklyMealCount = weeklyMealCount;
    }

    public void setNonvegMeals(HashMap<String, ArrayList<String>> nonvegMeals) {
        this.nonvegMeals = nonvegMeals;
    }

    public void setVegMeals(HashMap<String, ArrayList<String>> vegMeals) {

        this.vegMeals = vegMeals;
        Log.e("INSIDE SET ADAPTER", String.valueOf(this.vegMeals.size()));
    }

    public HashMap<String, ArrayList<String>> getNonvegMeals() {
        return nonvegMeals;
    }

    public HashMap<String, ArrayList<String>> getVegMeals() {
        Log.e("INSIDE GET ADAPTER", String.valueOf(this.vegMeals.size()));
        return vegMeals;
    }

    public float getVegWeeklyPrice() {
        return vegWeeklyPrice;
    }

    public float getVegMonthlyPrice() {
        return vegMonthlyPrice;
    }

    public float getNonvegWeeklyPrice() {
        return nonvegWeeklyPrice;
    }

    public float getNonvegMonthlyPrice() {
        return nonvegMonthlyPrice;
    }

    public int getMonthlyMealCount() {
        return MonthlyMealCount;
    }

    public int getWeeklyMealCount() {
        return WeeklyMealCount;
    }

    public int getNonvegTiffinId() {
        return nonvegTiffinId;
    }

    public int getVegTiffinId() {
        return vegTiffinId;
    }
}
