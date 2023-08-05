package by.hayel.shell.fake.api.payload.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class HealthCheckResponse implements Response {
  Status applicationHealthStatus;

  @RequiredArgsConstructor
  @Getter
  @FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
  public static class Status {
    String applicationName;
    String environment;
    String checkTime;
    String overallStatus;
    Object[] details;
  }
}
