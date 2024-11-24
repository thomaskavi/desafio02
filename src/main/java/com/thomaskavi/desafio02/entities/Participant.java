package com.thomaskavi.desafio02.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_participant")
public class Participant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @ManyToMany
  @JoinTable(name = "tb_participant_activity", // Nome da tabela de associação
      joinColumns = @JoinColumn(name = "participant_id"), // Coluna que faz referência à entidade Participant
      inverseJoinColumns = @JoinColumn(name = "activity_id") // Coluna que faz referência à entidade Activity
  )
  private Set<Activity> activities = new HashSet<>();
}
