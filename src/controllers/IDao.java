/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controllers; 

/**
 *
 * @author crist
 */
public interface IDao {
    public boolean insertDaoObject();
    public Object listDaoObject();
    public boolean updateDaoObject();
    public boolean deleteDaoObject();
}
