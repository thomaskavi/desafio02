package com.thomaskavi.desafio02.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_activity")
public class Activity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private String description;

  @Column(nullable = false)
  private Double price;

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  @OneToMany(mappedBy = "activity")
  private Set<Block> blocks = new HashSet<>();

  @ManyToMany(mappedBy = "activities") // Referência ao campo "activities" de Participant
  private Set<Participant> participants = new HashSet<>();

  public Activity(Long id, String name, String description, Double price, Category category, Set<Block> blocks,
      Set<Participant> participants) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.category = category;
    this.blocks = blocks;
    this.participants = participants;
  }

  public Activity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Set<Block> getBlocks() {
    return blocks;
  }

  public Set<Participant> getParticipants() {
    return participants;
  }

  @Override
  public String toString() {
    return "Activity [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", category="
        + category + ", blocks=" + blocks + ", getBlocks()=" + getBlocks() + ", getCategory()=" + getCategory()
        + ", getDescription()=" + getDescription() + ", getId()=" + getId() + ", getName()=" + getName()
        + ", getPrice()=" + getPrice() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
        + super.toString() + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Activity other = (Activity) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (price == null) {
      if (other.price != null)
        return false;
    } else if (!price.equals(other.price))
      return false;
    if (category == null) {
      if (other.category != null)
        return false;
    } else if (!category.equals(other.category))
      return false;
    if (blocks == null) {
      if (other.blocks != null)
        return false;
    } else if (!blocks.equals(other.blocks))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((price == null) ? 0 : price.hashCode());
    result = prime * result + ((category == null) ? 0 : category.hashCode());
    result = prime * result + ((blocks == null) ? 0 : blocks.hashCode());
    return result;
  }
}
