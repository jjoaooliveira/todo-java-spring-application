package com.jjoaooliveira.todoapplication.account.usecase.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jjoaooliveira.todoapplication.account.entity.Account;

@ExtendWith(MockitoExtension.class)
public class ReadAccountTest {
    
    @Mock
    private IReadAccountDataGateway mockAccountDataGateway;
    

    @Test
    @DisplayName("Given valid email when readAccount is called then AccountOutputData is returned")
    void givenValidEmail_whenReadAccount_thenAccountOutputDataIsReturned() {
        // Arrange
        String email = "user@email.com";
        String name = "John";

        when(mockAccountDataGateway.read(email))
                .thenReturn(new Account("John", email, "password"));

        // Act
        var actual = new ReadAccountImpl(mockAccountDataGateway).readAccount(email);

        // Assert
        assertNotNull(actual, "Account should not be null");
        assertEquals(name, actual.getName(), "Account name should match");
        assertEquals(email, actual.getEmail(), "Account email should match");
    }
}
