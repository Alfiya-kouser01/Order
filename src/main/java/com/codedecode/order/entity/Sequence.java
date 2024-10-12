package com.codedecode.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")  // Name of the MongoDB collection
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sequence {
    @Id
    private int id;   // Assuming id is an integer, but if it's a String, change accordingly
    private int sequence;  // Holds the current sequence value

    public int getSequence() {
        return sequence;
    }
}
