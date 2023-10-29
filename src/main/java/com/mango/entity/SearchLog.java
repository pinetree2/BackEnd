package com.mango.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name = "SearchLog")
public class SearchLog
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Member_Id")
    private User user;

    @Column(name = "Search_Log")
    private String searchLog;

}
