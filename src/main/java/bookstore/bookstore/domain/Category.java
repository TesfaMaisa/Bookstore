package bookstore.bookstore.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
   public Long id;
   private String name;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
   private List<Book> book;

   public Category() {
   }

   public Category(String name) {
      super();
      this.name = name;
   }

   public Long getid() {
      return id;
   }

   public void secategorytId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "category [id=" + id + ", name=" + name + "]";
   }

}
