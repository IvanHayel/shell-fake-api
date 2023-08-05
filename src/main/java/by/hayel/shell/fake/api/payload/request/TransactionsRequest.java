package by.hayel.shell.fake.api.payload.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class TransactionsRequest implements Request {
  String RequestID;
  String ColcoCountryCode;
  String FromSalesDateTime;
  String ToSalesDateTime;
}
