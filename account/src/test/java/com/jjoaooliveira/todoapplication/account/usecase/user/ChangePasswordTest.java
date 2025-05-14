package com.jjoaooliveira.todoapplication.account.usecase.user;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import com.jjoaooliveira.todoapplication.account.usecase.IPasswordEncoderAdapter;

@ExtendWith(MockitoExtension.class)
public class ChangePasswordTest {

    @Mock
    private IAccountDataGateway mockDataGateway;

    @Mock
    private IPasswordEncoderAdapter mockPasswordEncoder;

    @Test
    @DisplayName("Given data when changePassword is called then encode and saveAccount are called once")
    void givenData_whenChangePassword_thenEncodeAndSaveAccountAreCalledOnce() {
        //Arrange
        String email = "user@email.com";
        String newPassword = "newPassword";
        AccountInputData accountInputData = new AccountInputData(email, newPassword);
        ChangePasswordImpl changePassword = new ChangePasswordImpl(mockDataGateway, mockPasswordEncoder);

        when(mockDataGateway.getAccountByEmail(email))
            .thenReturn(
                Optional.of(new Account(null, null, email, "oldPassword", null, null))
            );

        when(mockPasswordEncoder.encode(newPassword))
            .thenReturn("encodedNewPassword");

        //Act
        changePassword.changePassword(accountInputData);

        //Assert
        verify(mockPasswordEncoder, times(1)).encode(accountInputData.getNewPassword());
        verify(mockDataGateway, times(1)).saveAccount(any(Account.class));
    }
}
