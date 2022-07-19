package ru.netology.honeybadger;

public class Deal {
    private int width, length, cost;
    private boolean honesty;

    public Deal(int width, int length, int cost ) {
        this.width = width;
        this.length = length;
        this.cost = cost;
      }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getCost() {
        return cost;
    }

    public boolean isHonesty() {
        return honesty;
    }

    public void setHonesty(boolean honesty) {
        this.honesty = honesty;
    }

    @Override
    public String toString() {
        return String.format("Участок шириной=%s, длиной=%s, стоимостью=%s. Сделка является %s",
                width, length, cost, honesty ? "честной" : "не честной");
    }
}
