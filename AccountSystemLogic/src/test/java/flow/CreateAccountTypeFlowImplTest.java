package flow;

import dto.AccountTypeDTO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.format.datetime.joda.LocalDateParser;
import za.ac.nwu.as.translater.AccountTypeTranslater;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslater translater;

    @InjectMocks
    private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
           //translater = Mockito.mock(AccountTypeTranslater.class);
           //flow = new CreateAccountTypeFlowImpl(translater);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {

        //doThrow(new RuntimeException()).when(translater).someMethod();

        try
        {
            flow.create(new AccountTypeDTO());
            Assert.fail("This should throw an exception!");
        }

        catch (Exception e)
        {

        }
        //erify(translater, times(1)).someMethod();
        //verify(translater, never()).create(any(AccountTypeDTO.class));

        //when(translater.create(any(AccountTypeDTO.class))).thenReturn(null);
        AccountTypeDTO accountTypeDTO = new AccountTypeDTO();
        //AccountTypeDTO accountTypeDTO = new AccountTypeDTO("mnemonic", "Sarah", LocalDate.parse("2020-08-31"));
        AccountTypeDTO accountTypeDTO2 = new AccountTypeDTO("mnemonic1", "Billy", LocalDate.parse("2021-07-22"));

        when(translater.create(any(AccountTypeDTO.class))).thenReturn(accountTypeDTO2);
        //when(translater.create(eq(accountTypeDTO))).thenReturn(accountTypeDTO2);
        AccountTypeDTO result = flow.create(accountTypeDTO);

        assertNull(result);
        //assertEquals(LocalDate.now(), result.getCreationDate());
        //assertNotNull(result);

        verify(translater, times(1)).create(any(AccountTypeDTO.class));
        //verify(translater, times(1)).create(eq(accountTypeDTO));
        verify(translater, times(2)).create(eq(accountTypeDTO2));
    }
}