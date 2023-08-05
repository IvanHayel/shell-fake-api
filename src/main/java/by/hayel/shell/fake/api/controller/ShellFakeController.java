package by.hayel.shell.fake.api.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import by.hayel.shell.fake.api.payload.request.TransactionsRequest;
import by.hayel.shell.fake.api.payload.response.Response;
import by.hayel.shell.fake.api.service.ShellFakeApiService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@RequestMapping("/api")
public class ShellFakeController {
  ShellFakeApiService fakeApiService;

  @GetMapping(value = "/v1/healthCheck", produces = APPLICATION_JSON_VALUE)
  public Response healthCheck() {
    return fakeApiService.getFakeHealthResponse();
  }

  @GetMapping(value = "/appStatus", produces = APPLICATION_JSON_VALUE)
  public Response appStatus() {
    return fakeApiService.getFakeAppStatus();
  }

  @PostMapping(value = "/v1/recent-transactions", produces = APPLICATION_JSON_VALUE)
  public Response recentTransactions(@RequestBody TransactionsRequest request) {
    return fakeApiService.getFakeRecentTransactions(request);
  }
}