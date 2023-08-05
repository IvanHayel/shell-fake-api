package by.hayel.shell.fake.api.payload.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TransactionsResponse implements Response {

  String requestId;
  String colcoCountryCode;
  String status;
  Integer recordCount;
  Transaction[] data;

  @Getter
  @Setter
  @FieldDefaults(level = lombok.AccessLevel.PRIVATE)
  public static class Transaction {

    String pan;
    Integer quantity;
    String salesDateTime;
    String productCode;
    String incomingProductDescription;
    String incomingSiteNumber;
    String incomingSiteDescription;
    String siteCurrency;
    String transactionId;
    String delcoSiteRetailValueTotalGross;
    String delcoSiteRetailPriceUnitGross;
    String vehicleRegistrationNumber;
    String transactionCountry;
    String purchasedInCountry;
    String transactionType;
    String gfnCardID;
    String initialCardOpenedDate;
    String cardTypeDesc;
    String cardGroupID;
    String customerERPNumber;
    String customerLOB;
    String topLevelCustomerERPNumber;
    String productId;
    String productDescription;
    String siteID;
    String siteDescription;
    String checkSum;
    String inGFNIsTransactionInUnbilled;
  }
}
