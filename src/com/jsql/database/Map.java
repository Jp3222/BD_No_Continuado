package com.jsql.database;

import java.util.logging.Logger;

/**
 *
 * @author HP
 * @param <K>
 * @param <T>
 */
public class Map<K extends Comparable<K>, T extends Comparable<T>> {

    private static final Logger LOG = Logger.getLogger(Map.class.getName());

    private Nodo<K, T> root;
    private int size;

    public Map() {
        this.root = null;
        this.size++;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean add(K key, T[] elems) {
        Nodo<K, T> aux = new Nodo<>(key, elems);
        if (isEmpty()) {
            root = aux;
            size++;
            return true;
        }
        return add(root, aux);
    }

    private boolean add(Nodo<K, T> root, Nodo<K, T> aux) {
        if (aux.getID().compareTo(root.getID()) < 0) {
            if (root.getIzq() == null) {
                root.setIzq(aux);
                size++;
                return true;
            } else {
                return add(root.getIzq(), aux);
            }
        } else if (aux.getID().compareTo(root.getID()) > 0) {
            if (root.getDer() == null) {
                root.setDer(aux);
                size++;
                return true;
            } else {
                return add(root.getDer(), aux);
            }
        }
        return false;
    }

    public Nodo<K, T> search(K key) {
        return search(root, key);
    }

    private Nodo<K, T> search(Nodo<K, T> root, K key) {
        if (root.getID().equals(key)) {
            return root;
        } else if (key.compareTo(root.getID()) < 0) {
            return search(root.getIzq(), key);
        } else if (key.compareTo(root.getID()) > 0) {
            return search(root.getDer(), key);
        }
        return null;
    }

    public int getSize() {
        return size;
    }

}
