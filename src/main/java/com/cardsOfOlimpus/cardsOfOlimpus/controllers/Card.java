package com.cardsOfOlimpus.cardsOfOlimpus.controllers;

public class Card {
    private String name;
    private String img;
    private String type;
    private String descripcion;
    private int vida;
    private int dmg;
    private String detalle;

    // Constructor
    public Card(String name, String img, String type, String descripcion, int vida, int dmg, String detalle) {
        this.name = name;
        this.img = img;
        this.type = type;
        this.descripcion = descripcion;
        this.vida = vida;
        this.dmg = dmg;
        this.detalle = detalle;
    }

    // Getters and setters (optional, if you need them)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
