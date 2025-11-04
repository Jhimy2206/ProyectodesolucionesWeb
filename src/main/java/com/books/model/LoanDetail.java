package com.books.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LoanDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDetail;

    @ManyToOne
    @JoinColumn(name = "id_loan", nullable = false,
            foreignKey = @ForeignKey(name = "FK_DETAIL_LOAN"))
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "id_book", nullable = false,
            foreignKey = @ForeignKey(name = "FK_DETAIL_BOOK"))
    private Book book;

    @Column(nullable = false)
    private boolean returned = false;
}
