package com.example.onlineshopping.models;

import com.google.gson.annotations.SerializedName;


    public class Post {
        private int id;
        private String name;
        private String price;

        @SerializedName("description")
        private String desc;

        public Post(String name, String price, String desc) {
            this.name = name;
            this.price = price;
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
