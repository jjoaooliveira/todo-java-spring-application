package com.jjoaooliveira.todoapplication.account.usecase.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jjoaooliveira.todoapplication.account.entity.Account;
import com.jjoaooliveira.todoapplication.account.usecase.AccountInputData;
import com.jjoaooliveira.todoapplication.account.usecase.IAccountDataGateway;
import com.jjoaooliveira.todoapplication.account.usecase.IPasswordEncoderAdapter;

/**
 * Unit test for {@link CreateAccountImpl}.
 */
@ExtendWith(MockitoExtension.class)
public class CreateAccountTest {

    @Mock
    private IAccountDataGateway mockAccountDataGateway;

    @Mock
    private IPasswordEncoderAdapter mockPasswordEncoder;

    @Test
    @DisplayName("Given valid data when createAccount is called then account is created")
    void givenValidData_whenCreateAccount_thenAccountIsCreated() {
        // Arrange
        String name = "John Doe";
        String email = "jd@email.com";
        String password = "dafafFAfADFAH1231adasdaSADadDD#sdSdad";
        ICreateAccount createAccount = new CreateAccountImpl(mockAccountDataGateway, mockPasswordEncoder);
        AccountInputData accountInputData = new AccountInputData(name, email, password);
        
        when(mockPasswordEncoder.encode(anyString())).thenReturn(password);
        when(mockAccountDataGateway.saveAccount(any(Account.class)))
                .thenReturn(new Account(name, email, password));

        // Act
        var actual = createAccount.createAccount(accountInputData);

        // Assert
        assertNotNull(actual, "Account should not be null");
        assertEquals(name, actual.getName(), "Account name should match");
        assertEquals(email, actual.getEmail(), "Account email should match");
   }
}
