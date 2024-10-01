package com.niladri.Journalapp.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class UserModel {
    @Id
    private ObjectId userId;
    @Indexed(unique = true)
    @NotNull
    private String username;
    @NotNull
    private String password;
    private List<String> roles ;
    @DBRef
    private List<JournalModel> journalEntries = new ArrayList<>();
}
