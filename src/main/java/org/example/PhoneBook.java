package org.example;

import java.util.HashMap;
import  java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    // Хранит фамилию (ключ) и список телефонов (значение)
    private Map<String, Set<String>> book = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        // Если фамилии еще нет в книге, создаем для нее новый список
        book.computeIfAbsent(surname, k -> new HashSet<>()).add(phoneNumber);
    }

    public Set<String> get(String surname) {
        return book.getOrDefault(surname, new HashSet<>());
    }
}