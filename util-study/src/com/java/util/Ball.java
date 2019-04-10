package com.java.util;

public class Ball  {
    private String name;
    private String chao;
    private Double dfeng;
    private Double lban;
    private Double cgong;

    public Ball(String name, String chao, Double dfeng, Double lban, Double cgong) {
        this.name = name;
        this.chao = chao;
        this.dfeng = dfeng;
        this.lban = lban;
        this.cgong = cgong;
    }
    public Ball(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChao() {
        return chao;
    }

    public void setChao(String chao) {
        this.chao = chao;
    }

    public Double getDfeng() {
        return dfeng;
    }

    public void setDfeng(Double dfeng) {
        this.dfeng = dfeng;
    }

    public Double getLban() {
        return lban;
    }

    public void setLban(Double lban) {
        this.lban = lban;
    }

    public Double getCgong() {
        return cgong;
    }

    public void setCgong(Double cgong) {
        this.cgong = cgong;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "name='" + name + '\'' +
                ", chao='" + chao + '\'' +
                ", dfeng=" + dfeng +
                ", lban=" + lban +
                ", cgong=" + cgong +
                '}';
    }
}

