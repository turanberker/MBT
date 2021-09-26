package organization.common.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(path = "/unit")
public interface UnitFeignClient {

}
