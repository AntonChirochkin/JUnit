package ru.skypro.unittesting;

import org.apache.commons.lang3.StringUtils;

public class GreetingsService {

    public String generateGreetings() {
        return generateGreetings(null);
    }

    public String generateGreetings(String name) {
        if (name == null || name.isBlank()) {
            return "Greeting, stranger!";
        }
        if (!StringUtils.isAlpha(name)) {
            throw new IllegalArgumentException("Name contains invalid chars: " + name);
        }
        return "Greeting, " + StringUtils.capitalize(name.toLowerCase()) + "!";
    }
}
