/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package regsosek.dao;

import java.util.List;

/**
 *
 * @author zein
 */
public interface Dao<T> {
    T get(long id);
    List<T> getWhere(String attr, Object param);
    List<T> getLike(String attr, Object param);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(long id);
}
