package com.jjoaooliveira.todoapplication.account.usecase.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jjoaooliveira.todoapplication.account.entity.Account;
import com.jjoaooliveira.todoapplication.account.usecase.AccountInputData;
import com.jjoaooliveira.todoapplication.account.usecase.IAccountDataGateway;

@ExtendWith(MockitoExtension.class)
public class ReadAccountTest {
    
    @Mock
    private IAccountDataGateway mockAccountDataGateway;
    

    @Test
    @DisplayName("Given valid email when readAccount is called then AccountOutputData is returned")
    void givenValidEmail_whenReadAccount_thenAccountOutputDataIsReturned() {
        // Arrange
        String email = "user@email.com";
        String name = "John";
        AccountInputData accountInputData = new AccountInputData(email, name);

        when(mockAccountDataGateway.getAccountByEmail(accountInputData.getEmail()))
                .thenReturn(Optional.of(new Account(email, name, "password")));

        // Act
        var actual = new ReadAccountImpl(mockAccountDataGateway).readAccount(accountInputData);

        // Assert
        assertNotNull(actual, "Account should not be null");
        assertEquals(name, actual.getName(), "Account name should match");
        assertEquals(email, actual.getEmail(), "Account email should match");
    }
}
