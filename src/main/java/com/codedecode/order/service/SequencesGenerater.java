package com.codedecode.order.service;

import com.codedecode.order.entity.Sequence;  // Correct entity class import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequencesGenerater {

    @Autowired
    private MongoOperations mongoOperations;

    public int generateNextOrderId() {

        Sequence counter = mongoOperations.findAndModify(
                query(where("id").is("sequence")),   // Query for the document with id "sequence"
                new Update().inc("sequence", 1),     // Increment the sequence field by 1
                options().returnNew(true).upsert(true),  // Return the updated document and upsert if not exists
                Sequence.class);  // Specify the entity class

        return counter != null ? counter.getSequence() : 1;  // Return 1 if counter is null (i.e., no document found)
    }
}
