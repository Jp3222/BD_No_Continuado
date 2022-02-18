package com.jsql.database;

/**
 *
 * @author HP
 * @param <K>
 * @param <T>
 */
public class Nodo<K extends Comparable<K>, T extends Comparable<T>> {

    private K ID;
    private T[] items;
    private Nodo izq, der;

    public Nodo(K key, T[] items) {
        this.ID = key;
        this.items = items;
    }

    public K getID() {
        return ID;
    }

    public void setID(K ID) {
        this.ID = ID;
    }

    public T[] getItems() {
        return items;
    }

    public void setItems(T[] items) {
        this.items = items;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

}
