package by.hayel.shell.fake.api.service;

import by.hayel.shell.fake.api.payload.request.TransactionsRequest;
import by.hayel.shell.fake.api.payload.response.Response;

public interface ShellFakeApiService {
  Response getFakeHealthResponse();

  Response getFakeAppStatus();

  Response getFakeRecentTransactions(TransactionsRequest request);
}
