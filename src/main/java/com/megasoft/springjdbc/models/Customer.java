package com.megasoft.springjdbc.models;

import org.springframework.data.annotation.Id;

public record Customer(@Id Long id, String name) {
}
