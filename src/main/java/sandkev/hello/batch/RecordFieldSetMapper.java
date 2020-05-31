package sandkev.hello.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RecordFieldSetMapper implements FieldSetMapper<Transaction> {

    private final DateTimeFormatter formatter;

    public RecordFieldSetMapper() {
        formatter = DateTimeFormatter.ofPattern("d/M/yyy");
    }

    public Transaction mapFieldSet(FieldSet fieldSet) throws BindException {

        //Transaction.TransactionBuilder builder = Transaction.builder();
        Transaction transaction = new Transaction();
        // you can either use the indices or custom names
        // I personally prefer the custom names easy for debugging and
        // validating the pipelines
        transaction.setUsername(fieldSet.readString("username"));
        transaction.setUserId(fieldSet.readInt("userid"));
        transaction.setAmount(fieldSet.readDouble(3));
        transaction.setTransactionDate(
                //Converting the date
                LocalDate.parse(fieldSet.readString(2), formatter).atStartOfDay()
        );

        return transaction;

    }

}
