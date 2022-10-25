package com.example.phys8.Models;

import com.google.gson.Gson;

import java.util.List;

public class Categories {


    private List<Category> category;

    public static Categories objectFromData(String str) {

        return new Gson().fromJson(str, Categories.class);
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public static class Category {
        private String name;

        public static Category objectFromData(String str) {

            return new Gson().fromJson(str, Category.class);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
