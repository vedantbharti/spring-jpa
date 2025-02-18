package com.example.springJpa.dao.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Table(name = "user")
//@Table(name = "user", schema = "xyz") : if you want to use a table inside some schema
//@Table(name = "user", uniqueConstraints = {
//        @UniqueConstraint(columnNames = "email"), //single column unique constraint
//        @UniqueConstraint(columnNames = {"email","password"}) //composite column unique constraint
//}) : if you want to add unique constraints(basically a column or a group of columns(composite columns) together must have every value unique
//@Table(name = "user", indexes = {
//        @Index(name = "mobile_index", columnList = "mobile"), //index on single column
//        @Index(name = "name_email_index", columnList = "firstname,email") //index on composite column
//}): we can create indexes for certain columns or group of columns to perform quicker search in the table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    //To create a composite key you can use @Embeddable and EmbeddedId or @IdClass and @Id
    //Some rules to follow:
    //1. You need to create a separate public class for the columns considered as composite primary key
    //2. The class must implement Serializable
    //3. The class must have a NoArgsConstructor
    //4. The class must override the equals and hashCode method
    //for more clarity, search for implementation on web or chatgpt

    @Id //used to mark a column as primary key
    @Column(name = "email")
//    @Column(name = "email", unique = true, nullable = false, length = 255): we can mark a column as unique here too
    //if we don't want to use uniqueConstraints at the table level. Also, we can ensure the nullability of a column

    //GeneratedValue is used to define the generation startegy of the primary key
    //by default primary key columns are not autofill
    //It works with @Id annotation(only for single primary key, not for composite key)
    //GenerationType.SEQUENCE is used by many companies: used to generate unique numbers, speeds up the efficiency when we cache sequence values
    //It provides more control than GenerationType.IDENTITY
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unique_user_seq")
//    @SequenceGenerator(name = "unique_user_seq", sequenceName = "db_seq_name", initialValue = 100, allocationSize = 5)
    private String email;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "mobile")
    private String contact;
    @Column(name = "password")
    private String password;


    //advantages of sequence over identity
    //1. Custom logic(start point, increment, etc)
    //2. Sequence generation logic is independent of table, so multiple tables can use it
    //3. Range of IDs can be cached, so we can avoid hitting database each time a new id is required
    //(with identity, while insertion, internally DB is auto generating the next ID, which require additional DB call)
    //4. Better portability, means identity is very DB specific and different DB might have different implementation
    //while sequence can provide more consistent behaviour across multiple DBs
}
