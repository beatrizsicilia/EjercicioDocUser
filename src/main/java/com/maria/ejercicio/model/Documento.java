package com.maria.ejercicio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("DOCUMENTS")
public class Documento{
    @Id
    private @Column("DOC_ID") Long id;
    private @Column("DOC") String doc;
    private @Column("USER_ID") Long user_id;
}

