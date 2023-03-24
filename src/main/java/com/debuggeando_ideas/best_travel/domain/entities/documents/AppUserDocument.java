package com.debuggeando_ideas.best_travel.domain.entities.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "app_users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AppUserDocument implements Serializable {

    @Id
    private String id;
    private String dni;
    private String username;
    private boolean enabled;
    private String password;
    private Role role;
}
