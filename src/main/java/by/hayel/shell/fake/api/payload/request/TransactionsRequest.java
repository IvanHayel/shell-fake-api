package by.hayel.shell.fake.api.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionsRequest implements Request {
  @JsonProperty("RequestID") String requestId;
  @JsonProperty("ColcoCountryCode") String countryCode;
  @JsonProperty("FromSalesDateTime") String fromSalesDateTime;
  @JsonProperty("ToSalesDateTime") String toSalesDateTime;
}
