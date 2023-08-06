package by.hayel.shell.fake.api.service;

import by.hayel.shell.fake.api.payload.request.TransactionsRequest;
import by.hayel.shell.fake.api.payload.response.AppStatusResponse;
import by.hayel.shell.fake.api.payload.response.HealthCheckResponse;
import by.hayel.shell.fake.api.payload.response.Response;
import by.hayel.shell.fake.api.payload.response.TransactionsResponse;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class ShellFakeApiServiceImpl implements ShellFakeApiService {
  private static final Faker FAKER = new Faker();

  @Override
  public Response getFakeHealthResponse() {
    var applicationName = FAKER.app().name();
    var checkTime = LocalDateTime.now().toString();
    var details = new Object[0];
    var healthStatus = new HealthCheckResponse.Status(applicationName, "qa", checkTime, "healthy", details);
    return new HealthCheckResponse(healthStatus);
  }

  @Override
  public Response getFakeAppStatus() {
    return new AppStatusResponse("fake api healthy");
  }

  @Override
  public Response getFakeRecentTransactions(TransactionsRequest request) {
    var response = new TransactionsResponse();
    response.setRequestId(request.getRequestId());
    response.setColcoCountryCode(request.getCountryCode());
    response.setStatus("Success");
    response.setRecordCount(FAKER.number().numberBetween(0, 100));
    var transactions = new TransactionsResponse.Transaction[response.getRecordCount()];
    generateTransactions(transactions);
    response.setData(transactions);
    return response;
  }

  private static void generateTransactions(TransactionsResponse.Transaction[] transactions) {
    for(int i = 0; i < transactions.length; ++i) {
      var transaction = new TransactionsResponse.Transaction();
      transaction.setPan(FAKER.business().creditCardNumber());
      transaction.setQuantity(FAKER.number().numberBetween(1, 100));
      transaction.setSalesDateTime(FAKER.date().past(48, TimeUnit.HOURS).toLocalDateTime().toString());
      transaction.setProductCode(FAKER.code().ean8());
      transaction.setIncomingProductDescription(FAKER.commerce().productName());
      transaction.setIncomingSiteNumber(FAKER.number().digits(10));
      transaction.setIncomingSiteDescription(FAKER.company().name());
      transaction.setSiteCurrency(FAKER.currency().code());
      transaction.setTransactionId(FAKER.number().digits(10));
      transaction.setDelcoSiteRetailValueTotalGross(FAKER.commerce().price(100, 1000));
      transaction.setDelcoSiteRetailPriceUnitGross(FAKER.commerce().price(10, 100));
      transaction.setVehicleRegistrationNumber(FAKER.number().digits(10));
      transaction.setTransactionCountry(FAKER.address().country());
      transaction.setPurchasedInCountry(FAKER.address().country());
      transaction.setTransactionType(FAKER.commerce().department());
      transaction.setGfnCardID(FAKER.number().digits(10));
      transaction.setInitialCardOpenedDate(FAKER.date().past(100, TimeUnit.DAYS).toLocalDateTime().toString());
      transaction.setCardTypeDesc(FAKER.company().name());
      transaction.setCardGroupID(FAKER.number().digits(10));
      transaction.setCustomerERPNumber(FAKER.number().digits(10));
      transaction.setCustomerLOB(FAKER.address().countryCode());
      transaction.setTopLevelCustomerERPNumber(FAKER.number().digits(10));
      transaction.setProductId(FAKER.number().digits(10));
      transaction.setProductDescription(FAKER.commerce().productName());
      transaction.setSiteID(FAKER.number().digits(10));
      transaction.setSiteDescription(FAKER.company().name());
      transaction.setCheckSum(FAKER.number().digits(10));
      transaction.setInGFNIsTransactionInUnbilled(FAKER.bool().bool() ? "Y" : "N");
      transactions[i] = transaction;
    }
  }
}
