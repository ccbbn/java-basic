package chap07.practice.no4;

import chap08.Basic.Parent;

import java.security.PublicKey;

public interface Order {

    int bookType = 1;
    int foodType = 2;
    int electType = 3;


    public void add();

    public void insert();

    public void change(String findName, String change);

    public void delete(String deleteName);

    public void find(String findName);

    public void allList();

    public void discount(String findName, int rate);





}

