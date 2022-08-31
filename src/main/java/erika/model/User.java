/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erika.model;

import lombok.Data;

/**
 *
 * @author Erika
 */

@Data
public class User {
    private long id;
    private String fullName;
    private String email;
    private String password;
    private boolean Admin;
    private double balance;
}
