/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardsOfOlimpus.cardsOfOlimpus.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gonza
 */

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/recuperar")
    public List<Card> recuperar() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cards");
             ResultSet rs = stmt.executeQuery()) {
            
            List<Card> cards = new ArrayList<>();
            while (rs.next()) {
                Card card = new Card(
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getString("type"),
                        rs.getString("descripcion"),
                        rs.getInt("vida"),
                        rs.getInt("dmg"),
                        rs.getString("detalle")
                );
                cards.add(card);
            }
            return cards;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @PostMapping("/crear")
    public String crear(@RequestBody Card card) {
        String sql = "INSERT INTO cards (name, img, type, descripcion, vida, dmg, detalle) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, card.getName());
            stmt.setString(2, card.getImg());
            stmt.setString(3, card.getType());
            stmt.setString(4, card.getDescripcion());
            stmt.setInt(5, card.getVida());
            stmt.setInt(6, card.getDmg());
            stmt.setString(7, card.getDetalle());
            
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return "Card created successfully!";
            } else {
                return "Failed to create card.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }
}